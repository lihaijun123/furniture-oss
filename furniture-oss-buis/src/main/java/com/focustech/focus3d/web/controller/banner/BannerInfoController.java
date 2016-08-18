package com.focustech.focus3d.web.controller.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.model.banner.BannerInfo;
import com.focustech.focus3d.service.banner.BannerInfoService;
import com.focustech.focus3d.web.validator.banner.BannerInfoValidator;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/bannerInfo.do")
public class BannerInfoController {

	@Autowired
	private BannerInfoService<BannerInfo> bannerInfoService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		modelMap.addAttribute("bannerInfo", new BannerInfo());
		return "/focus3d/banner/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(BannerInfo bannerInfo, BindingResult result,ModelMap modelMap){
		new BannerInfoValidator(bannerInfo, result).validate();
        if (result.hasErrors()) {
        	return "/focus3d/banner/new";
        }
        bannerInfoService.insertOrUpdate(bannerInfo);
        modelMap.addAttribute("bannerInfo", bannerInfo);
        return "/focus3d/banner/edit";
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
		BannerInfo bannerInfo = bannerInfoService.select(sn);
		modelMap.addAttribute("bannerInfo", bannerInfo);
		return "/focus3d/banner/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(BannerInfo bannerInfo, BindingResult result,ModelMap modelMap){
		new BannerInfoValidator(bannerInfo, result).validate();
        if (result.hasErrors()) {
        	return "/focus3d/banner/edit";
        }
        bannerInfoService.insertOrUpdate(bannerInfo);
        modelMap.addAttribute("bannerInfo", bannerInfo);
        return "/focus3d/banner/edit";
	}

}
