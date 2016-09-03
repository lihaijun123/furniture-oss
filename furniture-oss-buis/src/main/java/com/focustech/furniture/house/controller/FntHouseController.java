package com.focustech.furniture.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.extend.spring.argresolver.RedirectAttributes;
import com.focustech.furniture.house.service.FntHouseService;
import com.focustech.furniture.model.FntHouse;
import com.focustech.oss2008.web.AbstractController;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/fnt/house.do")
public class FntHouseController extends AbstractController{
	@Autowired
	private FntHouseService<FntHouse> fntHouseService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		modelMap.addAttribute("fntHouse", new FntHouse());
		return "/fnt/house/new";
	}
	/**
	 *
	 * *
	 * @param fntProduct
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(FntHouse fntHouse, ModelMap modelMap, RedirectAttributes redirectAttributes){
		fntHouse.setStatus(1);
		fntHouseService.insertOrUpdate(fntHouse);
        modelMap.addAttribute("fntHouse", fntHouse);
        redirectAttributes.addFlashAttribute("创建成功");
        return redirectTo("/fnt/house.do?method=edit&sn=" + fntHouse.getSn());
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
		FntHouse fntHouse = fntHouseService.select(sn);
		modelMap.addAttribute("fntHouse", fntHouse);
		return "/fnt/house/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(FntHouse fntHouse, ModelMap modelMap){
		fntHouseService.insertOrUpdate(fntHouse);
        modelMap.addAttribute("fntHouse", fntHouse);
        modelMap.addAttribute("message", "修改成功");
        return "/fnt/house/edit";
	}
}
