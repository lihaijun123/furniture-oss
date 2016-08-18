package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 会议厅相关常量定义
 * 
 * @author liuxuan
 */
public class MeetingConst implements NumberConst {
    /** 主题 */
    public static final String MEETING_EMAIL_TITLE = "中国数字展览馆会议通知";
    /** 已预订 */
    public static final String MEETING_STATUS_1 = "1";
    /** 已取消 */
    public static final String MEETING_STATUS_2 = "2";
    /** 已开始 */
    public static final String MEETING_STATUS_3 = "3";
    /** 已结束 */
    public static final String MEETING_STATUS_4 = "4";
    /** 已暂停 */
    public static final String MEETING_STATUS_5 = "5";

    /** 未发言 */
    public static final String SPEECH_STATUS_1 = "1";
    /** 待发言 */
    public static final String SPEECH_STATUS_2 = "2";
    /** 发言中 */
    public static final String SPEECH_STATUS_3 = "3";

    /** 未出席 */
    public static final String ATTEND_STATUS_1 = "1";
    /** 出席 */
    public static final String ATTEND_STATUS_2 = "2";
    /** 退出 */
    public static final String ATTEND_STATUS_3 = "3";

    /** 可以参加会议的最大人数 */
    public static final String MAX_ATTENDER = TEN;

    /** cookie用户名 */
    public static final String COOKIE_LOGON_NAME = "ln";
    /** cookie密码 */
    public static final String COOKIE_LOGON_PASSWORD = "pd";
    /** cookie从oss登录监视 */
    public static final String COOKIE_FROM_OSS = "fromoss";
    /** cookie中存的是从oss哪里登录的：会议室 */
    public static final String COOKIE_FROM_OSS_MEETING = "ossmeeting";
    /** cookie中存的是从oss哪里登录的：直播室 */
    public static final String COOKIE_FROM_OSS_STUDIO = "ossstudio";
    /** 加密算法 */
    public static final String ENCRYPT_ALGORITHM = "PBEWithMD5AndDES";
    public static final String COOKIE_PATH = "COOKIE_PATH";
    public static final String COOKIE_DOMAIN = "COOKIE_DOMAIN";
}
