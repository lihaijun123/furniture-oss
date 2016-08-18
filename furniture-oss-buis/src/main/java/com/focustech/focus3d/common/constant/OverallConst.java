/*
 * Copyright 2010 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 全局常量定义
 * 如果模块里面的常量出现重复则提取到此类中
 * 格式：
 * 加注释
 * public static final XX VV = VV;
 * *
 * @author lihaijun
 *
 */
public class OverallConst implements NumberConst{
	/**删除标志-未删除-0*/
	public static final String IS_DELETE_0 = ZERO;
	/**删除标志-已经删除-1*/
	public static final String IS_DELETE_1 = ONE;
	/**历史状态-1*/
	public static final String HISTORY_FLAG_1 = ONE;
	/**历史状态-2*/
	public static final String HISTORY_FLAG_2 = TWO;
    /** 无效-0 */
    public static final String INVALID = ZERO;
    /**有效-1*/
	public static final String EFFECTIVE = ONE;
    /** 下划线 */
    public final static String SYMBOL_UNDERSCORE = "_";
    /** 逗号，常用于字符串拼接 */
    public static final String SYMBOL_COMMA = ",";
    /** 点 */
    public final static String SYMBOL_POINT = ".";
    /** 单引号 */
    public final static String SYMBOL_SINGLE_QUOTATION = "'";
    /** 文件路径分隔符 */
    public final static String SYMBOL_URL = "/";
    /** 分号，常用于字符串拼接 */
    public static final String SYMBOL_SEMICOLON = ";";
    /** 连接号，常用于字符串拼接 */
    public static final String SYMBOL_CONNECTORSCORE = "-";
    /** 井号，常用于字符串拼接 */
    public static final String SYMBOL_WELL = "#";
    /** &连接号，常用于字符串拼接 */
    public static final String SYMBOL_AND = "&";
    /** 货币符号 */
    public static final String SYMBOL_CURRENCY = "￥";
    /** 曲线符号 */
    public static final String SYMBOL_CURVE = "~";

	public final static String SEP_SPACE = " ";
	public final static String SEP_EMPTY = "";

    /** 女-0 */
    public static final String FEMALE = ZERO;
    /** 男-1 */
    public static final String MALE = ONE;

    /**会员中心域名*/
    public static final String VO_DOMAIN = "VO_DOMAIN";
    /**3d中心域名*/
    public static final String AVATAR_DOMAIN = "AVATAR_DOMAIN";
    /** file服务器 **/
    public static final String FILE_SERVER_DOMAIN = "FILE_SERVER_DOMAIN";
    /** WEB服务器IP **/
	public static final String WEBSERVER_IP = "WEBSERVER_IP";
    /** 3d大场景文件固定路径 **/
    public static final String BIG_SCENE_PATH = "BIG_SCENE_PATH";

    /** 压缩包上传的-1 */
    public static final String MODEL_FROM_UPLOAD = ONE;
    /** 文件复制的-2 */
    public static final String MODEL_FROM_COPY = TWO;

    public static final String MODEL_FROM_SYSTEM = ONE;


    /** 审核未通过-UNPASS */
    public static final String UNPASS = "UNPASS";
    /** 审核通过-PASS */
    public static final String PASS = "PASS";
    /** 空sn */
    public static final String EMPTY_SN = ZERO;
    /** 请求的头部协议 */
    public static final String WEB_PROTOCOL_HTTP = "http://";
    /**
	 *#x3d url规则开关true-使用特殊规则，false-恢复原有规则
	 * *
	 */
	public static final String X3D_URL_RULE_SWITCH = "X3D_URL_RULE_SWITCH";
}
