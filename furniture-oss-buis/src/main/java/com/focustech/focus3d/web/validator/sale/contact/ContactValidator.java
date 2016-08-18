package com.focustech.focus3d.web.validator.sale.contact;

import java.util.Date;

import org.springframework.validation.Errors;

import com.focustech.common.utils.DateUtils;
import com.focustech.focus3d.model.sale.contact.Contact;
import com.focustech.oss2008.web.AbstractValidator;

public class ContactValidator extends AbstractValidator {

	public ContactValidator(Object form,Errors error){
		super(form,error);
	}
	public void validate() {
		Contact contact = (Contact)getForm();
		Errors err = getError();

		//联系内容
		super.checkStringLengthMax("contactContent",500);
		//计划内容
		super.checkStringLengthMax("planContent",500);
		//备注
		super.checkStringLengthMax("remark",500);

		if(contact.getContactTime()!=null){
			contact.setContactTime(forMateDate(contact.getContactTime()));
		}
		if(contact.getPlanTime()!=null){
			contact.setPlanTime(forMateDate(contact.getPlanTime()));
		}
	}
	public Date forMateDate(Date date){
		date = java.sql.Date.valueOf(DateUtils.formateDate("yyyy-MM-dd",date));
		return date;
	}
}
