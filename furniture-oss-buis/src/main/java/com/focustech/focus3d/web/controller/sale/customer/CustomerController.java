package com.focustech.focus3d.web.controller.sale.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import com.focustech.focus3d.model.sale.contact.Contact;
import com.focustech.focus3d.model.sale.customer.Customer;
import com.focustech.focus3d.service.sale.contact.ContactService;
import com.focustech.focus3d.service.sale.customer.CustomerService;
import com.focustech.focus3d.web.validator.sale.customer.CustomerValidator;


/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/sale/customer.do")
public class CustomerController{

	@Autowired
	private CustomerService<Customer> customerService;

	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(String list,ModelMap modelMap){
		Customer customer = customerService.creat();
		customer.setList(list);
		modelMap.addAttribute("customer", customer);
		return "/focus3d/sale/customer/new";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create",method = RequestMethod.POST)
	public String create(Customer customer,BindingResult result,ModelMap modelMap){
		new CustomerValidator(customer,result).validate();
		if(result.hasErrors()){
			return "/focus3d/sale/customer/new";
		}
		String list = customer.getList();
		customer = customerService.getCheckInfo(customer);
		if(customer.getCheckInfoList().size()>0){
			modelMap.addAttribute("return", "return");
			return "/focus3d/sale/customer/checkInfo";
		}
		customerService.insert(customer);
		customer.setList(list);
		modelMap.addAttribute("customer", customer);
		modelMap.addAttribute("message", "提交成功!");
		return "/focus3d/sale/customer/edit";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit",method = RequestMethod.GET)
	public String edit(Long sn,String list, ModelMap modelMap){
		Customer customer = customerService.selectAll(sn);
		customer.setList(list);
		modelMap.addAttribute("customer", customer);
		return "/focus3d/sale/customer/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit",method = RequestMethod.POST)
	public String edit(Customer customer,BindingResult result,ModelMap modelMap){
		new CustomerValidator(customer,result).validate();
		if(result.hasErrors()){
			return "/focus3d/sale/customer/edit";
		}
		String list = customer.getList();
		customer = customerService.getCheckInfo(customer);
		if(customer.getCheckInfoList().size()>0){
			modelMap.addAttribute("return", "return");
			return "/focus3d/sale/customer/checkInfo";
		}
		customerService.update(customer);
		customer.setList(list);
		modelMap.addAttribute("customer", customer);
		modelMap.addAttribute("message", "提交成功!");
		return "/focus3d/sale/customer/edit";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=modify",method = RequestMethod.GET)
	public String modify(Long sn,String list, ModelMap modelMap){
		Customer customer = customerService.selectAll(sn);
		customer.setList(list);
		if(customer.getIsSeller().equals(1)&&customer.getStatus().equals(1)){
			modelMap.addAttribute("return", "return");
			modelMap.addAttribute("message", "对不起，您没有权限访问");
			return "/focus3d/sale/customer/message";
		}
		else if(customer.getIsSeller().equals(0)&&customer.getStatus().equals(1)){
			modelMap.addAttribute("customer", customer);
			return "/focus3d/sale/customer/edit";
		}
		else{
			modelMap.addAttribute("customer", customer);
			return "/focus3d/sale/customer/details";
		}

	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=open",method = RequestMethod.GET)
	public String modify(Long sn, Integer isopen,String list, ModelMap modelMap){
		Customer customer = customerService.updateStatus(sn,isopen);
		customer.setList(list);
		modelMap.addAttribute("customer", customer);
		if(isopen.equals(1)){
			modelMap.addAttribute("message", "客户置为私有成功");
			modelMap.addAttribute("customer", customer);
			return "/focus3d/sale/customer/edit";
		}else{
			modelMap.addAttribute("message", "客户置为公开成功");
			return "/focus3d/sale/customer/details";
		}
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=del",method = RequestMethod.GET)
	public String delete(Long sn,String list, ModelMap modelMap){
		Customer customer = customerService.updateDelete(sn);
		modelMap.addAttribute("message", "置为撞单成功");
		modelMap.addAttribute("return", list);
		return "/focus3d/sale/customer/message";

	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=check",method = RequestMethod.POST)
	public String check(Customer customer,BindingResult result,ModelMap modelMap){
		customer = customerService.getCheckInfo(customer);
		modelMap.addAttribute("customer", customer);
		modelMap.addAttribute("return", "close");
		return "/focus3d/sale/customer/checkInfo";
	}
}
