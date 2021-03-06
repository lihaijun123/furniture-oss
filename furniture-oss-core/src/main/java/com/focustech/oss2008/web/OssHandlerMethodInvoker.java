package com.focustech.oss2008.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.Conventions;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.support.HandlerMethodInvoker;
import org.springframework.web.bind.annotation.support.HandlerMethodResolver;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartRequest;

/**
 * <li></li>
 *
 * @author yangpeng 2009-2-13 下午03:19:51
 */
public class OssHandlerMethodInvoker {
    /**
     * We'll create a lot of these objects, so we don't want a new logger every time.
     */
    private static final Log logger = LogFactory.getLog(HandlerMethodInvoker.class);
    private final HandlerMethodResolver methodResolver;
    private final List<WebBindingInitializer> bindingInitializers;
    private final SessionAttributeStore sessionAttributeStore;
    private final ParameterNameDiscoverer parameterNameDiscoverer;
    private final WebArgumentResolver[] customArgumentResolvers;
    private final SimpleSessionStatus sessionStatus = new SimpleSessionStatus();

    public OssHandlerMethodInvoker(HandlerMethodResolver methodResolver) {
        this(methodResolver, null);
    }

    public OssHandlerMethodInvoker(HandlerMethodResolver methodResolver, List<WebBindingInitializer> bindingInitializers) {
        this(methodResolver, bindingInitializers, new DefaultSessionAttributeStore(), null);
    }

    public OssHandlerMethodInvoker(HandlerMethodResolver methodResolver,
            List<WebBindingInitializer> bindingInitializers, SessionAttributeStore sessionAttributeStore,
            ParameterNameDiscoverer parameterNameDiscoverer, WebArgumentResolver... customArgumentResolvers) {
        this.methodResolver = methodResolver;
        this.bindingInitializers = bindingInitializers;
        this.sessionAttributeStore = sessionAttributeStore;
        this.parameterNameDiscoverer = parameterNameDiscoverer;
        this.customArgumentResolvers = customArgumentResolvers;
    }

    public final Object invokeHandlerMethod(Method handlerMethod, Object handler, NativeWebRequest webRequest,
            ExtendedModelMap implicitModel) throws Exception {
        boolean debug = logger.isDebugEnabled();
        for (Method attributeMethod : this.methodResolver.getModelAttributeMethods()) {
            Object[] args = resolveArguments(attributeMethod, handler, webRequest, implicitModel);
            if (debug) {
                logger.debug("Invoking model attribute method: " + attributeMethod);
            }
            Object attrValue = doInvokeMethod(attributeMethod, handler, args);
            String attrName = AnnotationUtils.findAnnotation(attributeMethod, ModelAttribute.class).value();
            if ("".equals(attrName)) {
                Class resolvedType = GenericTypeResolver.resolveReturnType(attributeMethod, handler.getClass());
                attrName = Conventions.getVariableNameForReturnType(attributeMethod, resolvedType, attrValue);
            }
            implicitModel.addAttribute(attrName, attrValue);
        }
        Object[] args = resolveArguments(handlerMethod, handler, webRequest, implicitModel);
        if (debug) {
            logger.debug("Invoking request handler method: " + handlerMethod);
        }
        return doInvokeMethod(handlerMethod, handler, args);
    }

    @SuppressWarnings("unchecked")
    private Object[] resolveArguments(Method handlerMethod, Object handler, NativeWebRequest webRequest,
            ExtendedModelMap implicitModel) throws Exception {
        Class[] paramTypes = handlerMethod.getParameterTypes();
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < args.length; i++) {
            MethodParameter param = new MethodParameter(handlerMethod, i);
            param.initParameterNameDiscovery(this.parameterNameDiscoverer);
            GenericTypeResolver.resolveParameterType(param, handler.getClass());
            boolean isParam = false;
            String paramName = "";
            boolean paramRequired = false;
            String attrName = null;
            Object[] paramAnns = param.getParameterAnnotations();
            for (int j = 0; j < paramAnns.length; j++) {
                Object paramAnn = paramAnns[j];
                if (RequestParam.class.isInstance(paramAnn)) {
                    RequestParam requestParam = (RequestParam) paramAnn;
                    isParam = true;
                    paramName = requestParam.value();
                    paramRequired = requestParam.required();
                    break;
                }
                else if (ModelAttribute.class.isInstance(paramAnn)) {
                    ModelAttribute attr = (ModelAttribute) paramAnn;
                    attrName = attr.value();
                }
            }
            if (isParam && attrName != null) {
                throw new IllegalStateException("@RequestParam and @ModelAttribute are an exclusive choice -"
                        + "do not specify both on the same parameter: " + handlerMethod);
            }
            Class paramType = param.getParameterType();
            if (!isParam && attrName == null) {
                Object argValue = resolveCommonArgument(param, webRequest);
                if (argValue != WebArgumentResolver.UNRESOLVED) {
                    args[i] = argValue;
                }
                else {
                    if (Model.class.isAssignableFrom(paramType) || Map.class.isAssignableFrom(paramType)) {
                        args[i] = implicitModel;
                    }
                    else if (SessionStatus.class.isAssignableFrom(paramType)) {
                        args[i] = this.sessionStatus;
                    }
                    else if (BeanUtils.isSimpleProperty(paramType)) {
                        isParam = true;
                    }
                    else {
                        attrName = "";
                    }
                }
            }
            if (isParam) {
                // Request parameter value...
                if ("".equals(paramName)) {
                    paramName = param.getParameterName();
                    if (paramName == null) {
                        throw new IllegalStateException("No parameter specified for @RequestParam argument of type ["
                                + paramType.getName()
                                + "], and no parameter name information found in class file either.");
                    }
                }
                Object paramValue = null;
                if (webRequest.getNativeRequest() instanceof MultipartRequest) {
                    paramValue = ((MultipartRequest) webRequest.getNativeRequest()).getFile(paramName);
                }
                if (paramValue == null) {
                    String[] paramValues = webRequest.getParameterValues(paramName);
                    if (paramValues != null) {
                        paramValue = (paramValues.length == 1 ? paramValues[0] : paramValues);
                    }
                }
                if (paramValue == null) {
                    if (paramRequired) {
                        raiseMissingParameterException(paramName, paramType);
                    }
                    if (paramType.isPrimitive()) {
                        throw new IllegalStateException(
                                "Optional "
                                        + paramType
                                        + " parameter '"
                                        + paramName
                                        + "' is not present but cannot be translated into a null value due to being declared as a "
                                        + "primitive type. Consider declaring it as object wrapper for the corresponding primitive type.");
                    }
                }
                WebDataBinder binder = createBinder(webRequest, null, paramName);
                initBinder(handler, paramName, binder, webRequest);
                args[i] = binder.convertIfNecessary(paramValue, paramType, param);
            }
            else if (attrName != null) {
                // Bind request parameter onto object...
                if ("".equals(attrName)) {
                    attrName = Conventions.getVariableNameForParameter(param);
                }
                if (!implicitModel.containsKey(attrName) && this.methodResolver.isSessionAttribute(attrName, paramType)) {
                    Object sessionAttr = this.sessionAttributeStore.retrieveAttribute(webRequest, attrName);
                    if (sessionAttr == null) {
                        raiseSessionRequiredException("Session attribute '" + attrName
                                + "' required - not found in session");
                    }
                    implicitModel.addAttribute(attrName, sessionAttr);
                }
                Object bindObject = implicitModel.get(attrName);
                if (bindObject == null) {
                    bindObject = BeanUtils.instantiateClass(paramType);
                }
                WebDataBinder binder = createBinder(webRequest, bindObject, attrName);
                initBinder(handler, attrName, binder, webRequest);
                args[i] = bindObject;
                implicitModel.putAll(binder.getBindingResult().getModel());
                if (args.length > i + 1 && Errors.class.isAssignableFrom(paramTypes[i + 1])) {
                    args[i + 1] = binder.getBindingResult();
                    i++;
                    doBind(webRequest, binder, false);
                }
                else {
                    doBind(webRequest, binder, true);
                }
            }
        }
        return args;
    }

    private void initBinder(Object handler, String attrName, WebDataBinder binder, NativeWebRequest webRequest)
            throws Exception {
        if (this.bindingInitializers != null) {
            for (WebBindingInitializer webBindingInitializer : bindingInitializers) {
                webBindingInitializer.initBinder(binder, webRequest);
            }
        }
        Set<Method> initBinderMethods = this.methodResolver.getInitBinderMethods();
        if (!initBinderMethods.isEmpty()) {
            boolean debug = logger.isDebugEnabled();
            for (Method initBinderMethod : initBinderMethods) {
                String[] targetNames = AnnotationUtils.findAnnotation(initBinderMethod, InitBinder.class).value();
                if (targetNames.length == 0 || Arrays.asList(targetNames).contains(attrName)) {
                    Class[] initBinderParams = initBinderMethod.getParameterTypes();
                    Object[] initBinderArgs = new Object[initBinderParams.length];
                    for (int j = 0; j < initBinderArgs.length; j++) {
                        Object argValue = resolveCommonArgument(new MethodParameter(initBinderMethod, j), webRequest);
                        if (argValue != WebArgumentResolver.UNRESOLVED) {
                            initBinderArgs[j] = argValue;
                        }
                        else {
                            Class paramType = initBinderParams[j];
                            if (paramType.isInstance(binder)) {
                                initBinderArgs[j] = binder;
                            }
                            else {
                                throw new IllegalStateException("Unsupported argument [" + paramType.getName()
                                        + "] for InitBinder method: " + initBinderMethod);
                            }
                        }
                    }
                    if (debug) {
                        logger.debug("Invoking init-binder method: " + initBinderMethod);
                    }
                    Object returnValue = doInvokeMethod(initBinderMethod, handler, initBinderArgs);
                    if (returnValue != null) {
                        throw new IllegalStateException("InitBinder methods must not have a return value: "
                                + initBinderMethod);
                    }
                }
            }
        }
    }

    private static Object doInvokeMethod(Method method, Object target, Object[] args) throws Exception {
        ReflectionUtils.makeAccessible(method);
        try {
            return method.invoke(target, args);
        }
        catch (InvocationTargetException ex) {
            ReflectionUtils.rethrowException(ex.getTargetException());
        }
        throw new IllegalStateException("Should never get here");
    }

    @SuppressWarnings("unchecked")
    public final void updateSessionAttributes(Object handler, Map mavModel, ExtendedModelMap implicitModel,
            NativeWebRequest webRequest) throws Exception {
        if (this.methodResolver.hasSessionAttributes()) {
            if (this.sessionStatus.isComplete()) {
                for (String attrName : this.methodResolver.getActualSessionAttributeNames()) {
                    this.sessionAttributeStore.cleanupAttribute(webRequest, attrName);
                }
            }
            // Expose model attributes as session attributes, if required.
            Map<String, Object> model = (mavModel != null ? mavModel : implicitModel);
            for (Map.Entry entry : new HashSet<Map.Entry>(model.entrySet())) {
                String attrName = (String) entry.getKey();
                Object attrValue = entry.getValue();
                if (this.methodResolver.isSessionAttribute(attrName, (attrValue != null ? attrValue.getClass() : null))) {
                    if (!this.sessionStatus.isComplete()) {
                        this.sessionAttributeStore.storeAttribute(webRequest, attrName, attrValue);
                    }
                    String bindingResultKey = BindingResult.MODEL_KEY_PREFIX + attrName;
                    if (mavModel != null && !model.containsKey(bindingResultKey)) {
                        WebDataBinder binder = createBinder(webRequest, attrValue, attrName);
                        initBinder(handler, attrName, binder, webRequest);
                        mavModel.put(bindingResultKey, binder.getBindingResult());
                    }
                }
            }
        }
    }

    protected void raiseMissingParameterException(String paramName, Class paramType) throws Exception {
        throw new IllegalStateException("Missing parameter '" + paramName + "' of type [" + paramType.getName() + "]");
    }

    protected void raiseSessionRequiredException(String message) throws Exception {
        throw new IllegalStateException(message);
    }

    protected WebDataBinder createBinder(NativeWebRequest webRequest, Object target, String objectName)
            throws Exception {
        return new WebRequestDataBinder(target, objectName);
    }

    protected void doBind(NativeWebRequest webRequest, WebDataBinder binder, boolean failOnErrors) throws Exception {
        WebRequestDataBinder requestBinder = (WebRequestDataBinder) binder;
        requestBinder.bind(webRequest);
        if (failOnErrors) {
            requestBinder.closeNoCatch();
        }
    }

    protected Object resolveCommonArgument(MethodParameter methodParameter, NativeWebRequest webRequest)
            throws Exception {
        if (this.customArgumentResolvers != null) {
            for (WebArgumentResolver argumentResolver : this.customArgumentResolvers) {
                Object value = argumentResolver.resolveArgument(methodParameter, webRequest);
                if (value != WebArgumentResolver.UNRESOLVED) {
                    return value;
                }
            }
        }
        return resolveStandardArgument(methodParameter.getParameterType(), webRequest);
    }

    protected Object resolveStandardArgument(Class parameterType, NativeWebRequest webRequest) throws Exception {
        if (WebRequest.class.isAssignableFrom(parameterType)) {
            return webRequest;
        }
        return WebArgumentResolver.UNRESOLVED;
    }
}
