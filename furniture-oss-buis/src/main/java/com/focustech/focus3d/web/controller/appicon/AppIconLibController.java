package com.focustech.focus3d.web.controller.appicon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.common.constant.AppWorkspaceConst;
import com.focustech.focus3d.model.appicon.AppIconLib;
import com.focustech.focus3d.service.appicon.AppIconService;
import com.focustech.focus3d.web.validator.appicon.AppIconLibValidator;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/appiconlib.do")
public class AppIconLibController {
	@Autowired
	private AppIconService<AppIconLib> appIconService;

	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		AppIconLib appIconLib = new AppIconLib();
		appIconLib.setDeviceType(AppWorkspaceConst.DEVICE_TYPE_1);
		modelMap.addAttribute("appIconLib", appIconLib);
		return "/focus3d/appiconlib/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(AppIconLib AppIconLib, BindingResult result,ModelMap modelMap){
	   new AppIconLibValidator(AppIconLib, result).validate();
       if (result.hasErrors()) {
       	return "/focus3d/appiconlib/new";
       }
       appIconService.insertOrUpdate(AppIconLib);
       modelMap.addAttribute("appIconLib", AppIconLib);
       return "/focus3d/appiconlib/edit";
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
		AppIconLib appIconLib = appIconService.select(sn);
		modelMap.addAttribute("appIconLib", appIconLib);
		return "/focus3d/appiconlib/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AppIconLib appIconLib, BindingResult result,ModelMap modelMap){
		new AppIconLibValidator(appIconLib, result).validate();
       if (result.hasErrors()) {
       	return "/focus3d/appiconlib/edit";
       }
       appIconService.insertOrUpdate(appIconLib);
       modelMap.addAttribute("appIconLib", appIconLib);
       return "/focus3d/appiconlib/edit";
	}
}
