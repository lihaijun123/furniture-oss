package com.focustech.focus3d.web.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.model.app.AppFrame;
import com.focustech.focus3d.model.app.AppProd;
import com.focustech.focus3d.model.userinfo.UserInfo;
import com.focustech.focus3d.service.app.AppFrameService;
import com.focustech.focus3d.service.app.AppProdService;
import com.focustech.focus3d.service.userinfo.UserInfoService;
import com.focustech.oss2008.web.AbstractController;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/app.do")
public class AppFrameController extends AbstractController{
	@Autowired
	private AppFrameService<AppFrame> appFrameService;
	@Autowired
	private UserInfoService<UserInfo> userInfoService;
	@Autowired
	private AppProdService<AppProd> prodService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=audit", method = RequestMethod.GET)
	public String audit(Long sn, ModelMap modelMap, HttpServletRequest req){
		AppFrame appFrame = appFrameService.select(sn);
		if(appFrame != null){
			Long objectSn = appFrame.getObjectSn();
			if(objectSn != null){
				UserInfo user = userInfoService.select(objectSn);
				modelMap.addAttribute("user", user);
			}
		}
		String msg = TCUtil.sv(req.getSession().getAttribute("msg"));
		modelMap.addAttribute("app", appFrame);
		modelMap.addAttribute("msg", msg);
		req.getSession().removeAttribute("msg");
		return "/focus3d/app/audit";
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=audit", method = RequestMethod.POST)
	public String doAudit(AppFrame app, ModelMap modelMap, HttpServletRequest req){
		appFrameService.audit(app);
		req.getSession().setAttribute("msg", "申请通过，App正在自动创建！");
		return redirectTo("/app.do?method=audit&sn=" + app.getSn());
	}
	/**
	 *
	 * *
	 * @param sn
	 * @param modelMap
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "method=addvrar", method = RequestMethod.GET)
	public String addVrAr(Long prodSn, ModelMap modelMap, HttpServletRequest req){
		if(prodSn != null){
			AppProd prod = prodService.select(prodSn);
			if(prod != null){
				modelMap.put("prod", prod);
			}
		}
		return "/focus3d/app/add_vrar";
	}
	/**
	 *
	 * *
	 * @param prodSn
	 * @param vrAr
	 * @param modelMap
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "method=addvrar", method = RequestMethod.POST)
	public String addVrAr(AppProd prod, ModelMap modelMap, HttpServletRequest req){
		prodService.addVrAr(prod);
		return redirectTo("/app.do?method=addvrar&prodSn=" + prod.getSn());
	}

}
