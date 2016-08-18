package com.focustech.focus3d.model.sale.customer;

import com.focustech.common.utils.StringUtils;


public class PhoneInfo {
	private String phoneAreaCode;
	private String phoneCode;
	private String phoneExt;
	private String phoneLabel;

	public String getPhoneAreaCode() {
		return phoneAreaCode;
	}
	public void setPhoneAreaCode(String phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	public String getPhoneExt() {
		return phoneExt;
	}
	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}
	public String getPhoneLabel() {
		return phoneLabel;
	}
	public void setPhoneLabel(String phoneLabel) {
		this.phoneLabel = phoneLabel;
	}

	/**
	 * 把城市区号,电话,分机号，备注拼成电话
	 */
	public String concatPhone() {
		String newPhone = "";
        String phoneAreaCode = getPhoneAreaCode();
        String phoneCode = getPhoneCode();
        String phoneExt = getPhoneExt();
        String phoneLabel = getPhoneLabel();
        if(StringUtils.isNotEmpty(phoneCode)){
        	newPhone= phoneAreaCode+"-"+phoneCode+"-"+phoneExt+"-"+phoneLabel;
        }
        return newPhone;
	}
	/**
	 * 把城市区号,电话拼成电话
	 */
	public String concatAreaAndPhone() {
		String newPhone = "";
        String phoneAreaCode = getPhoneAreaCode();
        String phoneCode = getPhoneCode();
        if(StringUtils.isNotEmpty(phoneCode)){
        	newPhone= phoneAreaCode+"-"+phoneCode;
        }
        return newPhone;
	}

	/**
	 * 把电话/传真拆成国家区号,城市区号,电话/传真
	 */
	public void splitPhone(String phone) {

        if (StringUtils.isNotEmpty(phone)) {
            String[] phoneArray = phone.split("-", -1);
            if (phoneArray.length >= 4) {
                setPhoneAreaCode(phoneArray[0]);
                setPhoneCode(phoneArray[1]);
                setPhoneExt(phoneArray[2]);
                setPhoneLabel(phoneArray[3]);
            }
        }
	}
}