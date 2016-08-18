package com.focustech.focus3d.web.validator.sale.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.focustech.common.utils.StringUtils;

import com.focustech.oss2008.web.AbstractValidator;
import com.focustech.focus3d.model.sale.customer.Customer;

import java.util.List;
import java.util.regex.Matcher;

public class CustomerValidator extends AbstractValidator {

	public CustomerValidator(Object form,Errors error){
		super(form,error);
	}

	public void validate() {
		Customer customer = (Customer) getForm();
		Errors err = getError();

		//用户名称验证
		customer.concatName();
		if (StringUtils.isEmpty(customer.getName())) {
            err.rejectValue("name", ERROR_CODE_REQUIRED, "请输入名称。");
        }
		super.checkStringLengthMax("name",200);

		//标签验证
		super.checkStringLengthMax("tag.name",200);

		//电话验证
		customer.concatPhone();
		customer.splitPhone();
		boolean[] flag = {false,false,false,false};
		if(customer.getTelephone()!=""){
			for(int i = 0;i<customer.getPhoneInfoList().size();i++){
				if(!flag[0]){
					Matcher mArea = P_COUNTRY_NUM.matcher(customer.getPhoneInfoList().get(i).getPhoneAreaCode());
			        if (!mArea.matches()) {
			        	flag[0] = true;

			        	err.rejectValue("telephone", ERROR_CODE_REQUIRED, "国内区号必须为1~4位数字!");
			        }
		        }
				if(!flag[1]){
			        Matcher mPhone = P_TELEPHONE_NUM.matcher(customer.getPhoneInfoList().get(i).getPhoneCode());
			        Matcher mPhone1 = P_MOBILE_NUM.matcher(customer.getPhoneInfoList().get(i).getPhoneCode());
			        if (!mPhone.matches() && !mPhone1.matches()) {
			        	flag[1] = true;
			        	err.rejectValue("telephone", ERROR_CODE_REQUIRED, "电话或手机号码必须为7~9位或11位的数字!");
			        }
				}
				if(!flag[2]){
			        Matcher mExt = P_EXT_NUM.matcher(customer.getPhoneInfoList().get(i).getPhoneExt());
			        if (!mExt.matches()) {
			        	flag[2] = true;
			        	err.rejectValue("telephone", ERROR_CODE_REQUIRED, "分机号必须为6位以内的数字!");
			        }
				}
				if (!flag[3]) {
			        Matcher mLabel = P_REG.matcher(customer.getPhoneInfoList().get(i).getPhoneLabel());
			        if (mLabel.find()) {
			        	flag[3] = true;
			        	err.rejectValue("telephone", ERROR_CODE_REQUIRED, "备注中不可以含有‘,’和‘-’分隔符!");
			        }
				}
			}
		}
		//公司地址
		super.checkStringLengthMax("address",200);
		//公司主页
		customer.concatUrl();
		customer.splitUrl();
		if(customer.getUrl()!=""){
			for(int i = 0;i<customer.getUrlList().size();i++){
				Matcher mUrl = P_URL.matcher(customer.getUrlList().get(i));
		        if (!mUrl.matches()) {
		        	err.rejectValue("url", ERROR_CODE_REQUIRED, "公司主页格式不对!");
		        	break;
		        }
			}
		}
		//备注
		super.checkStringLengthMax("remark",500);
	}
}
