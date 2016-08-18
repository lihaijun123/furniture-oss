package com.focustech.focus3d.web.controller.appmenu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.model.appmenu.AppMenuData;
import com.focustech.focus3d.model.appmenu.AppMenuItem;
import com.focustech.focus3d.service.appmenu.AppMenuDataService;
import com.focustech.focus3d.service.appmenu.AppMenuItemService;
import com.focustech.oss2008.web.AbstractController;

/**
 * 识别图3D模型
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/appmenudata.do")
public class AppMenuDataController extends AbstractController{
	@Autowired
	private AppMenuDataService<AppMenuData> appMenuDataService;
	@Autowired
	private AppMenuItemService<AppMenuItem> appMenuItemService;

	@ModelAttribute("appMenuItemList")
	public List<AppMenuItem> setAppMenuItemList(){
		return appMenuItemService.getList();
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		AppMenuData appMenuData = new AppMenuData();
		appMenuData.setAndroidVersionNum(1);
		appMenuData.setIosVersionNum(1);
		modelMap.addAttribute("appMenuData", appMenuData);
		return "/focus3d/appmenudata/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(AppMenuData appMenuData, BindingResult result,ModelMap modelMap){
		appMenuDataService.insertOrUpdate(appMenuData);
		modelMap.addAttribute("appMenuData", appMenuData);
		modelMap.addAttribute("message", "添加成功");
		return "/focus3d/appmenudata/edit";
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
		AppMenuData appMenuData = appMenuDataService.select(sn);
		modelMap.addAttribute("appMenuData", appMenuData);
		return "/focus3d/appmenudata/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AppMenuData appMenuData, BindingResult result,ModelMap modelMap){
		AppMenuData dbObj = appMenuDataService.select(appMenuData.getSn());
		if(dbObj.getAndroidFileSn() != null && !dbObj.getAndroidFileSn().equals(appMenuData.getAndroidFileSn())){
			Integer androidVersionNum = appMenuData.getAndroidVersionNum();
			appMenuData.setAndroidVersionNum(++ androidVersionNum);
		}
		if(dbObj.getIosFileSn() != null && !dbObj.getIosFileSn().equals(appMenuData.getIosFileSn())){
			Integer iosVersionNum = appMenuData.getIosVersionNum();
			appMenuData.setIosVersionNum(++ iosVersionNum);
		}
		appMenuDataService.update(appMenuData);
		modelMap.addAttribute("appMenuData", appMenuData);
		modelMap.addAttribute("message", "修改成功");
		return "/focus3d/appmenudata/edit";
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
		appMenuDataService.delete(sn);
		return redirectTo("/uitoolList.ui?funcID=1080331");
	}
}
