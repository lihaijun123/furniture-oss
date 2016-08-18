/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 编号生成器
 * 
 * @author xulijiao
 */
public class AdProductNumberGenerator {
    /**
     * 根据广告种类获取广告方案编号
     * 
     * @param adKind 广告种类（枚举类型key代号）
     * @return
     */
    public static String getAdProductNumber(String adKind) {
        StringBuffer sb = new StringBuffer();
        sb.append(null == adKind ? "" : adKind.toString());
        String dateStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSSS");
        sb.append(dateStr);
        sb.append("AD");
        // sb.append(String.valueOf((int) (Math.random() * 100000)));
        return sb.toString();
    }

}
