/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.utils.StringUtils;


/**
 * 附件后缀名与MIME类型映射关系
 * 
 * @author xulijiao
 */
public enum AttachTypeConst {
    ATTACH_TYPE_PDF("pdf", "application/pdf"), ATTACH_TYPE_DOC("doc", "application/msword"), ATTACH_TYPE_XLS("xls",
            "application/vnd.ms-excel"), ATTACH_TYPE_JPG("jpg", "image/jpeg"), ATTACH_TYPE_JPEG("jpeg", "image/jpeg"),
    ATTACH_TYPE_GIF("gif", "image/gif"), ATTACH_TYPE_DOCX("docx",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document"), ATTACH_TYPE_XLSX("xlsx",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    private String value;
    private String type;

    private AttachTypeConst(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    /**
     * 根据附件格式类型获取类型
     * 
     * @param extType 附件格式类型
     * @return 附件类型
     */
    public static String getAttachType(String extType) {
        if (ATTACH_TYPE_PDF.getValue().equals(extType)) {
            return ATTACH_TYPE_PDF.getType();
        }
        else if (ATTACH_TYPE_DOC.getValue().equals(extType)) {
            return ATTACH_TYPE_DOC.getType();
        }
        else if (ATTACH_TYPE_XLS.getValue().equals(extType)) {
            return ATTACH_TYPE_XLS.getType();
        }
        else if (ATTACH_TYPE_JPG.getValue().equals(extType)) {
            return ATTACH_TYPE_JPG.getType();
        }
        else if (ATTACH_TYPE_JPEG.getValue().equals(extType)) {
            return ATTACH_TYPE_JPEG.getType();
        }
        else if (ATTACH_TYPE_GIF.getValue().equals(extType)) {
            return ATTACH_TYPE_GIF.getType();
        }
        else if (ATTACH_TYPE_XLSX.getValue().equals(extType)) {
            return ATTACH_TYPE_XLSX.getType();
        }
        else if (ATTACH_TYPE_DOCX.getValue().equals(extType)) {
            return ATTACH_TYPE_DOCX.getType();
        }
        else {
            return StringUtils.EMPTY;
        }
    }

}

