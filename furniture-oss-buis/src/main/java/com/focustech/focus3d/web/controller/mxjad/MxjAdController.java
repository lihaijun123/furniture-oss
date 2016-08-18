package com.focustech.focus3d.web.controller.mxjad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.extend.spring.argresolver.RedirectAttributes;
import com.focustech.focus3d.model.mxjad.MxjAd;
import com.focustech.focus3d.service.mxjad.MxjAdService;
import com.focustech.oss2008.web.AbstractController;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/mxjad.do")
public class MxjAdController extends AbstractController{

	@Autowired
	private MxjAdService<MxjAd> mxjAdService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap, HttpServletRequest req){
		modelMap.addAttribute("mxjad", new MxjAd());
		return "/focus3d/mxjad/new";
	}
	/**
	 *
	 * *
	 * @param mxjad
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(MxjAd mxjad, BindingResult result, ModelMap modelMap, RedirectAttributes redirectAttributes){
        mxjAdService.insertOrUpdate(mxjad);
        modelMap.addAttribute("mxjad", mxjad);
        redirectAttributes.addFlashAttribute("创建成功");
        return redirectTo("/mxjad.do?method=edit&sn=" + mxjad.getSn());
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Long sn, ModelMap modelMap, HttpServletRequest req, RedirectAttributes redirectAttributes){
		MxjAd mxjad = mxjAdService.select(sn);
		modelMap.addAttribute("mxjad", mxjad);
		return "/focus3d/mxjad/edit";
	}
	/**
	 *
	 * *
	 * @param mxjad
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(MxjAd mxjad, BindingResult result,ModelMap modelMap){
        mxjAdService.insertOrUpdate(mxjad);
        modelMap.addAttribute("mxjad", mxjad);
        modelMap.addAttribute("message", "修改成功");
        return "/focus3d/mxjad/edit";
	}
}
