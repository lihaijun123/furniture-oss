package com.focustech.focus3d.web.controller.appmenu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.model.appmenu.AppIdentifyFile;
import com.focustech.focus3d.model.appmenu.AppMenuItem;
import com.focustech.focus3d.service.appmenu.AppIdentifyFileService;
import com.focustech.focus3d.service.appmenu.AppMenuItemService;
import com.focustech.oss2008.web.AbstractController;

/**
 * 高通识别文件
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/appidentify.do")
public class AppIdentifyFileController extends AbstractController{
	@Autowired
	private AppIdentifyFileService<AppIdentifyFile> appIdentifyFileService;
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
		AppIdentifyFile appIdentifyFile = new AppIdentifyFile();
		appIdentifyFile.setType(1);
		appIdentifyFile.setVersionNum(1);
		modelMap.addAttribute("appIdentifyFile", appIdentifyFile);
		return "/focus3d/appidentify/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(AppIdentifyFile appIdentifyFile, BindingResult result,ModelMap modelMap){
		appIdentifyFileService.insertOrUpdate(appIdentifyFile);
		modelMap.addAttribute("appIdentifyFile", appIdentifyFile);
		modelMap.addAttribute("message", "添加成功");
		return "/focus3d/appidentify/edit";
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
		AppIdentifyFile appIdentifyFile = appIdentifyFileService.select(sn);
		modelMap.addAttribute("appIdentifyFile", appIdentifyFile);
		return "/focus3d/appidentify/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AppIdentifyFile appIdentifyFile, BindingResult result,ModelMap modelMap){
		AppIdentifyFile dbObj = appIdentifyFileService.select(appIdentifyFile.getSn());
		boolean datIsModify = dbObj.getDatFileSn() != null && !dbObj.getDatFileSn().equals(appIdentifyFile.getDatFileSn());
		boolean xmlIsModify = dbObj.getXmlFileSn() != null && !dbObj.getXmlFileSn().equals(appIdentifyFile.getXmlFileSn());
		if(xmlIsModify || datIsModify){
			Integer androidVersionNum = appIdentifyFile.getVersionNum();
			appIdentifyFile.setVersionNum(++ androidVersionNum);
		}
		appIdentifyFileService.update(appIdentifyFile);
		modelMap.addAttribute("appIdentifyFile", appIdentifyFile);
		modelMap.addAttribute("message", "修改成功");
		return "/focus3d/appidentify/edit";
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
		appIdentifyFileService.delete(sn);
		return redirectTo("/uitoolList.ui?funcID=1080332");
	}
}
