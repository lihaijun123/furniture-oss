package com.focustech.focus3d.web.validator.appicon;

import org.springframework.validation.Errors;

import com.focustech.focus3d.model.appicon.AppIconLib;
import com.focustech.oss2008.web.AbstractValidator;
/**
 *
 * *
 * @author lihaijun
 *
 */
public class AppIconLibValidator extends AbstractValidator{

	public AppIconLibValidator(Object form, Errors error) {
		super(form, error);
	}

	 public void validate() {
	        AppIconLib appIconLib = (AppIconLib) getForm();
	        Errors err = getError();
	        /*if (StringUtils.isEmpty(appIconLib.getImageKey())) {
	            err.rejectValue("name", ERROR_CODE_REQUIRED, "请填写图片标示。");
	        }*/
	        if (appIconLib.getImageFileSn() == null) {
	            err.rejectValue("imageFileSn", ERROR_CODE_REQUIRED, "请上传图片。");
	        }
	    }
}
