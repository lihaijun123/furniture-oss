package com.focustech.focus3d.web.validator.banner;

import org.springframework.validation.Errors;

import com.focustech.common.utils.StringUtils;
import com.focustech.focus3d.model.banner.BannerInfo;
import com.focustech.oss2008.web.AbstractValidator;
/**
 *
 * *
 * @author lihaijun
 *
 */
public class BannerInfoValidator extends AbstractValidator {

	public BannerInfoValidator(Object form, Errors error) {
		super(form, error);
	}

	 public void validate() {

	        BannerInfo bannerInfo = (BannerInfo) getForm();
	        Errors err = getError();
	        if (StringUtils.isEmpty(bannerInfo.getName())) {
	            err.rejectValue("name", ERROR_CODE_REQUIRED, "请填写名称。");
	        }
	        if (bannerInfo.getImageFileSn() == null) {
	            err.rejectValue("imageFileSn", ERROR_CODE_REQUIRED, "请上传图片。");
	        }
	        if (StringUtils.isEmpty(bannerInfo.getLinkUrl())) {
	            err.rejectValue("linkUrl", ERROR_CODE_REQUIRED, "请填写链接地址。");
	        }
	    }
}
