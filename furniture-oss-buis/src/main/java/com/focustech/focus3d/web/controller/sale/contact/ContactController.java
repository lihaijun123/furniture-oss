package com.focustech.focus3d.web.controller.sale.contact;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.model.sale.contact.Contact;
import com.focustech.focus3d.model.sale.customer.Customer;
import com.focustech.focus3d.service.sale.contact.ContactService;
import com.focustech.focus3d.service.sale.customer.CustomerService;
import com.focustech.focus3d.web.validator.sale.contact.ContactValidator;

@Controller
@RequestMapping(value = "/sale/contact.do")
public class ContactController {
	@Autowired
	private ContactService<Contact> contactService;

	@Autowired
	private CustomerService<Customer> customerService;

	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(Long customerSn,ModelMap modelMap){
		Contact contact = contactService.creat(customerSn);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("method", "create");
		return "/focus3d/sale/contact/new";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create",method = RequestMethod.POST)
	public String create(Contact contact,BindingResult result,ModelMap modelMap){
		new ContactValidator(contact,result).validate();
		if(result.hasErrors()){
			return "/focus3d/sale/contact/new";
		}
		contactService.insert(contact);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("close", "reload");
		modelMap.addAttribute("message", "提交成功!");
		return "/focus3d/sale/contact/edit";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit",method = RequestMethod.GET)
	public String edit(Long sn, ModelMap modelMap){
		Contact contact = contactService.select(sn);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("method", "edit");
		return "/focus3d/sale/contact/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit",method = RequestMethod.POST)
	public String edit(Contact contact,BindingResult result,ModelMap modelMap){
		new ContactValidator(contact,result).validate();
		if(result.hasErrors()){
			return "/focus3d/sale/contact/edit";
		}
		contactService.insert(contact);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("close", "reload");
		modelMap.addAttribute("method", "edit");
		modelMap.addAttribute("message", "提交成功!");
		return "/focus3d/sale/contact/edit";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=list",method = RequestMethod.GET)
	public String list(Long customerSn,ModelMap modelMap){
		List<Contact> contactList = contactService.getContactList(customerSn);
		Customer customer = customerService.select(customerSn);
		modelMap.addAttribute("contactList", contactList);
		modelMap.addAttribute("customerName", customer.getName());
		modelMap.addAttribute("customerSn", customerSn);
		return "/focus3d/sale/contact/list";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=planlist",method = RequestMethod.GET)
	public String planList(ModelMap modelMap){
		List<Contact> contactPlanList = contactService.getContactPlanList();
		modelMap.addAttribute("contactPlanList", contactPlanList);
		return "/focus3d/sale/contact/saleHomePage";
	}

	@RequestMapping(params = "method=doplan", method = RequestMethod.GET)
	public String doplan(Long sn,Long customerSn,ModelMap modelMap){
		Contact contact = contactService.creat(customerSn);
		contact.setParentContactSn(sn);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("method", "createplan");
		return "/focus3d/sale/contact/new";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=createplan",method = RequestMethod.POST)
	public String createplan(Contact contact,BindingResult result,ModelMap modelMap){
		new ContactValidator(contact,result).validate();
		if(result.hasErrors()){
			return "/focus3d/sale/contact/new";
		}
		contactService.insertPlan(contact);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("close", "close");
		return "/focus3d/sale/contact/edit";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=editplan",method = RequestMethod.GET)
	public String editPlan(Long sn, ModelMap modelMap){
		Contact contact = contactService.select(sn);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("method", "editplan");
		return "/focus3d/sale/contact/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=editplan",method = RequestMethod.POST)
	public String editPlan(Contact contact,BindingResult result,ModelMap modelMap){
		new ContactValidator(contact,result).validate();
		if(result.hasErrors()){
			return "/focus3d/sale/contact/edit";
		}
		contactService.insert(contact);
		modelMap.addAttribute("contact", contact);
		modelMap.addAttribute("close", "reload");
		return "/focus3d/sale/contact/edit";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=planlistAll",method = RequestMethod.GET)
	public String planlistAll(ModelMap modelMap){
		List<Contact> contactPlanList = contactService.getContactPlanList();
		modelMap.addAttribute("contactPlanList", contactPlanList);
		return "/focus3d/sale/contact/planlistall";
	}

}
