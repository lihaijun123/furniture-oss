package com.focustech.focus3d.web.validator.prodcase;

import org.springframework.validation.Errors;

import com.focustech.common.utils.StringUtils;
import com.focustech.focus3d.model.prodcase.ProdCase;
import com.focustech.focus3d.model.prodcase.ProdCaseFile;
import com.focustech.oss2008.web.AbstractValidator;
/***
 *
 * *
 * @author lihaijun
 *
 */
public class ProdCaseValidator extends AbstractValidator {

	public ProdCaseValidator(Object form, Errors error) {
		super(form, error);
	}

	public void validate() {
		ProdCase prodCase = (ProdCase)getForm();
		Errors err = getError();
		if(StringUtils.isEmpty(prodCase.getName())){
			err.rejectValue("name", ERROR_CODE_REQUIRED, "请填写案例名称。");
		}
		if(prodCase.getImageFileSn() == null){
			err.rejectValue("imageFileSn", ERROR_CODE_REQUIRED, "请填选择封面图片。");
		}
		/*if(StringUtils.isEmpty(prodCase.getCompanyName())){
			err.rejectValue("companyName", ERROR_CODE_REQUIRED, "请填写公司名称。");
		}
		if(StringUtils.isEmpty(prodCase.getMainProduct())){
			err.rejectValue("mainProduct", ERROR_CODE_REQUIRED, "请填写主营产品。");
		}
		if(StringUtils.isEmpty(prodCase.getUrl())){
			err.rejectValue("url", ERROR_CODE_REQUIRED, "请填写网址。");
		}*/
		if(prodCase.getPriority() == null){
			err.rejectValue("priority", ERROR_CODE_REQUIRED, "请填写权重。");
		}
		ProdCaseFile caseFile = prodCase.getCaseFile();
		if(StringUtils.isEmpty(caseFile.getFileName())){
			err.rejectValue("caseFile.fileName", ERROR_CODE_REQUIRED, "请填写案例文件名称。");
		}
		/*if(StringUtils.isEmpty(caseFile.getFileVersion())){
			err.rejectValue("caseFile.fileVersion", ERROR_CODE_REQUIRED, "请填写案例文件版本。");
		}*/
		if(caseFile.getFileSn() == null){
			err.rejectValue("caseFile.fileSn", ERROR_CODE_REQUIRED, "请上传案例文件。");
		}
	}

}
