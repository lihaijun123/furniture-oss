package com.focustech.focus3d.web.validator.model;

import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.model.model.ModelContentInfo;
import com.focustech.focus3d.model.model.ModelInfo;
import com.focustech.oss2008.web.AbstractValidator;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangyifan
 * @version 1.0
 * @datetime 2015/2/5 11:05
 */
public class ModelInfoValidator extends AbstractValidator {

    public ModelInfoValidator(Object form, Errors error) {
        super(form, error);
    }

    public void validate() {

        ModelInfo modelInfo = (ModelInfo) getForm();
        Errors err = getError();
        if (StringUtils.isEmpty(modelInfo.getName())) {
            err.rejectValue("name", ERROR_CODE_REQUIRED, "请填写名称。");
        }
        if (modelInfo.getType() == null || modelInfo.getType() == -1) {
            err.rejectValue("type", ERROR_CODE_REQUIRED, "请选择类型。");
        }
        if (modelInfo.getPrice() == null) {
            err.rejectValue("price", ERROR_CODE_REQUIRED, "请填写价格。");
        }
        if (modelInfo.getFileSn() == null) {
            err.rejectValue("fileSn", ERROR_CODE_REQUIRED, "请上传模型。");
        }
        if (modelInfo.getImageFileSn() == null) {
            err.rejectValue("imageFileSn", ERROR_CODE_REQUIRED, "请上传图片。");
        }
        if (modelInfo.getPriority() == null) {
            err.rejectValue("priority", ERROR_CODE_REQUIRED, "请填写优先级。");
        }
    }
}
