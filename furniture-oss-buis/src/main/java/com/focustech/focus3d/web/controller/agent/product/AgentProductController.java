package com.focustech.focus3d.web.controller.agent.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.focus3d.service.agent.product.AgentProductService;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/agentProduct.do")
public class AgentProductController {
	@Autowired
	private AgentProductService<AgentProduct> agetnProductService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		AgentProduct agentProduct = new AgentProduct();
		modelMap.addAttribute("agentProduct", agentProduct);
		return "/focus3d/agent/product/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(AgentProduct agentProduct, BindingResult result,ModelMap modelMap){
		agetnProductService.insertOrUpdate(agentProduct);
		modelMap.addAttribute("agentProduct", agentProduct);
		modelMap.addAttribute("message", "添加成功");
		return "/focus3d/agent/product/edit";
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
		AgentProduct agentProduct = agetnProductService.select(sn);
		modelMap.addAttribute("agentProduct", agentProduct);
		return "/focus3d/agent/product/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AgentProduct agentProduct, BindingResult result,ModelMap modelMap){
	   agetnProductService.update(agentProduct);
       modelMap.addAttribute("agentProduct", agentProduct);
       modelMap.addAttribute("message", "修改成功");
       return "/focus3d/agent/product/edit";
	}

}
