package com.focustech.focus3d.web.controller.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.model.appconfig.AppConfigKeyValue;
import com.focustech.focus3d.model.appconfig.MxjAppConfig;
import com.focustech.focus3d.service.appconfig.MxjAppConfigService;
import com.focustech.oss2008.web.AbstractController;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/appconfig.do")
public class MxjAppConfigController extends AbstractController{
	@Autowired
	private MxjAppConfigService<MxjAppConfig> appConfigService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(String copyConfigSn, ModelMap modelMap){
		MxjAppConfig appConfig = new MxjAppConfig();
		appConfig.setIsValid(1);
		if(StringUtils.isNotEmpty(copyConfigSn)){
			appConfigService.copyConfig(appConfig, TCUtil.lv(copyConfigSn));
		} else {
			appConfig.getLocalValues().add(new AppConfigKeyValue());
			appConfig.getCloudValues().add(new AppConfigKeyValue());
		}
	 	modelMap.addAttribute("appConfig", appConfig);
	 	modelMap.addAttribute("appConfigList", appConfigService.getList());
	 	modelMap.addAttribute("copyConfigSn", copyConfigSn);
		return "/focus3d/appconfig/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(MxjAppConfig mxjAppConfig, BindingResult result,ModelMap modelMap){
		String view = "/focus3d/appconfig/edit";
		String keyName = mxjAppConfig.getKeyName();
		String msg = getMessage("添加成功!", true);
		if(StringUtils.isNotEmpty(keyName)){
			appConfigService.insertOrUpdate(mxjAppConfig);
			mxjAppConfig = appConfigService.select(mxjAppConfig.getSn());
		} else {
			msg = getMessage("添加失败，版本名称不能为空。", false);
			view = "/focus3d/appconfig/new";
		}
		modelMap.addAttribute("appConfig", mxjAppConfig);
		modelMap.addAttribute("message", msg);
		return view;
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Long sn, ModelMap modelMap){
		MxjAppConfig appConfig = appConfigService.select(sn);
		modelMap.addAttribute("appConfig", appConfig);
		return "/focus3d/appconfig/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(MxjAppConfig appConfig, BindingResult result,ModelMap modelMap){
	   appConfigService.update(appConfig);
       modelMap.addAttribute("appConfig", appConfigService.select(appConfig.getSn()));
       modelMap.addAttribute("message", getMessage("修改成功!", true));
       return "/focus3d/appconfig/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=delete", method = RequestMethod.GET)
	public String delete(Long sn, ModelMap modelMap){
		appConfigService.delete(sn);
		return redirectTo("/uitoolList.ui?funcID=1080337");
	}
}
