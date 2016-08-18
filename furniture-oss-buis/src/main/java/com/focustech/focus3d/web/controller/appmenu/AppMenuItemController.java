package com.focustech.focus3d.web.controller.appmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.common.constant.MxjQrCodeType;
import com.focustech.focus3d.model.appmenu.AppMenuItem;
import com.focustech.focus3d.service.appmenu.AppMenuItemService;
import com.focustech.oss2008.web.AbstractController;

/**
 * 菜单界面
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/appmenuitem.do")
public class AppMenuItemController extends AbstractController{
	@Autowired
	private AppMenuItemService<AppMenuItem> appMenuItemService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		AppMenuItem appMenuItem = new AppMenuItem();
		appMenuItem.setFileLength(0);
		appMenuItem.setFilePath("");
		appMenuItem.setCallBack("");
		appMenuItem.setProcessValue("");
		appMenuItem.setIsUnload(0);
		appMenuItem.setAndroidVersionNum(1);
		appMenuItem.setIosVersionNum(1);
		appMenuItem.setIosPadVersionNum(1);
		modelMap.addAttribute("appMenuItem", appMenuItem);
		return "/focus3d/appmenuitem/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(AppMenuItem appMenuItem, BindingResult result,ModelMap modelMap){
		updateType(appMenuItem);
		appMenuItemService.insertOrUpdate(appMenuItem);
		modelMap.addAttribute("appMenuItem", appMenuItem);
		modelMap.addAttribute("message", "添加成功");
		return "/focus3d/appmenuitem/edit";
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
		AppMenuItem appMenuItem = appMenuItemService.select(sn);
		modelMap.addAttribute("appMenuItem", appMenuItem);
		return "/focus3d/appmenuitem/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AppMenuItem appMenuItem, BindingResult result,ModelMap modelMap){
	   AppMenuItem dbObj = appMenuItemService.select(appMenuItem.getSn());
	   if(dbObj.getAndroidFileSn() != null && !dbObj.getAndroidFileSn().equals(appMenuItem.getAndroidFileSn())){
		   Integer androidVersionNum = TCUtil.iv(appMenuItem.getAndroidVersionNum());
		   appMenuItem.setAndroidVersionNum(++ androidVersionNum);
	   }
	   if(dbObj.getIosFileSn() != null && !dbObj.getIosFileSn().equals(appMenuItem.getIosFileSn())){
		   Integer iosVersionNum = TCUtil.iv(appMenuItem.getIosVersionNum());
		   appMenuItem.setIosVersionNum(++ iosVersionNum);
	   }
	   if(dbObj.getIosPadFileSn() != null && !dbObj.getIosPadFileSn().equals(appMenuItem.getIosPadFileSn())){
		   Integer iosPadVersionNum = TCUtil.iv(appMenuItem.getIosPadVersionNum());
		   appMenuItem.setIosPadVersionNum(++ iosPadVersionNum);
	   }
	   updateType(appMenuItem);
	   appMenuItemService.update(appMenuItem);
       modelMap.addAttribute("appMenuItem", appMenuItem);
       modelMap.addAttribute("message", "修改成功");
       return "/focus3d/appmenuitem/edit";
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
		appMenuItemService.delete(sn);
		return redirectTo("/uitoolList.ui?funcID=1080330");
	}
	/**
	 *
	 * *
	 * @param appMenuItem
	 * @param keyValue
	 */
	private void updateType(AppMenuItem appMenuItem) {
		String keyValue = appMenuItem.getKeyValue();
		if(StringUtils.isNotEmpty(keyValue)){
			appMenuItem.setName(keyValue);
			appMenuItem.setLevelName(keyValue);
			appMenuItem.setNameZh(MxjQrCodeType.getName(keyValue));
			appMenuItem.setType(MxjQrCodeType.getTypeByNameEn(keyValue));
		}
	}
}
