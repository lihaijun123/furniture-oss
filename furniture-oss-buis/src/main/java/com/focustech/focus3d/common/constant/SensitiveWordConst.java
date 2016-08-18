/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 敏感词常量
 *
 * @author xulijiao
 */
public class SensitiveWordConst implements NumberConst {
    /** 敏感词频道 */
    public final static String SENSITIVE_WORD_SOURCE_TYPE = "SENSITIVE_WORD_SOURCE_TYPE";
    /** 前台会员中心-1 */
    public static final String FRONT_MEMBER_CENTER = ONE;
    /** 后台会员中心/产品审核-2 */
    public static final String BACK_MEMBER_CENTER_AND_PRODUCT_AUDIT = TWO;
    /** 所有搜索-3 */
    public static final String ALL_SEARCH = THREE;
    /** 公司搜索-4 */
    public static final String COMPANY_SEARCH = FOUR;
    /** 产品搜索-5 */
    public static final String PRODUCT_SEARCH = FIVE;
    /** 联系信禁止-6 */
    public static final String SITE_MESSAGE_FORBID = SIX;
    /** 联系信可疑-7 */
    public static final String SITE_MESSAGE_DUBIOUS = SEVEN;
    /** 会议厅-8 */
    public static final String SENSITIVE_MEETING = EIGHT;

    /** 敏感词匹配类型 */
    public final static String SENSITIVE_WORD_MATCH_TYPE = "SENSITIVE_WORD_MATCH_TYPE";
    /** 精确匹配-1 */
    public static final String EXACT = ONE;
    /** 模糊匹配-2 */
    public static final String FUZZY = TWO;
    /** 排除-3 */
    public static final String EXCLUDE = THREE;

    /** 敏感词权重 */
    public final static String SENSITIVE_WORD_PRIORITY = "SENSITIVE_WORD_PRIORITY";
    /** 默认-0 */
    public static final String DEFAULT = ZERO;
    /** 品牌相关-10 */
    public static final String BRAND_RELATED = TEN;
    /** 限制级别-20 */
    public static final String LIMIT_LEVEL = TWENTY;
    /** 严令禁止-30 */
    public static final String STRICTLY_PROHIBITED = THIRTY;

    /** 数字敏感词的合法验证单位 */
    public static final String VALID_CHAR="0123456789零一二三四五六七八九壹貳叁肆伍陆柒捌玖　 -－";
	public static final String ZERO_CN="零";
	public static final String ONE_CN="一";
	public static final String TWO_CN="二";
	public static final String THREE_CN="三";
	public static final String FOUR_CN="四";
	public static final String FIVE_CN="五";
	public static final String SIX_CN="六";
	public static final String SEVEN_CN="七";
	public static final String EIGHT_CN="八";
	public static final String NINE_CN="九";
	public static final String ONE_TR_CN="壹";
	public static final String TWO_TR_CN="貳";
	public static final String THREE_TR_CN="叁";
	public static final String FOUR_TR_CN="肆";
	public static final String FIVE_TR_CN="伍";
	public static final String SIX_TR_CN="陆";
	public static final String SEVEN_TR_CN="柒";
	public static final String EIGHT_TR_CN="捌";
	public static final String NINE_TR_CN="玖";
	public static final String BLANK_SPACE_HALF=" ";
	public static final String BLANK_SPACE_ALL="　";
	public static final String IN_LINE_HALF="-";
	public static final String IN_LINE_SPACE_ALL="－";
	/** 开头规则 */
	public static final String START_ZERO="0";
	public static final String START_DOUBLE_ZERO="00";
	/** 手机开头规则 */
	public static final String MOBILE_PHONE_START_NUM_1="13";
	public static final String MOBILE_PHONE_START_NUM_2="15";
	public static final String MOBILE_PHONE_START_NUM_3="18";
	/** 手机号码长度（除了开头） */
	public static final String MOBILE_PHONE_LENGTH="9";
	/** 商业号码开头规则 */
	public static final String BUSS_PHONE_START_NUM_1="400";
	public static final String BUSS_PHONE_START_NUM_2="800";
	/** 商业号码长度（除了开头） */
	public static final String BUSS_PHONE_LENGTH="7";
	/** 普通电话号码长度（除了开头） */
	public static final String PHONE_LENGTH="7";


    /** 主营产品敏感词过滤 */
    public static final String SENSITIVE_MIAN_PRO = "sensitiveMainPro";
    /** 关键词敏感词过滤 */
    public static final String SENSITIVE_KEY_WORD = "sensitiveKeyWord";

}

