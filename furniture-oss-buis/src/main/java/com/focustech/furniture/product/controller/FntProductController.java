package com.focustech.furniture.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.extend.spring.argresolver.RedirectAttributes;
import com.focustech.furniture.model.FntProduct;
import com.focustech.furniture.product.service.FntProductService;
import com.focustech.oss2008.web.AbstractController;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/fnt/product.do")
public class FntProductController extends AbstractController {


	@Autowired
	private FntProductService<FntProduct> fntProductService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		modelMap.addAttribute("fntProduct", new FntProduct());
		return "/fnt/product/new";
	}
	/**
	 *
	 * *
	 * @param fntProduct
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(FntProduct fntProduct, ModelMap modelMap, RedirectAttributes redirectAttributes){
		fntProductService.insertOrUpdate(fntProduct);
        modelMap.addAttribute("fntProduct", fntProduct);
        redirectAttributes.addFlashAttribute("创建成功");
        return redirectTo("/fnt/product.do?method=edit&sn=" + fntProduct.getSn());
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
		FntProduct fntProduct = fntProductService.select(sn);
		modelMap.addAttribute("fntProduct", fntProduct);
		return "/fnt/product/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(FntProduct fntProduct, ModelMap modelMap){
		fntProductService.insertOrUpdate(fntProduct);
        modelMap.addAttribute("fntProduct", fntProduct);
        modelMap.addAttribute("message", "修改成功");
        return "/fnt/product/edit";
	}


}