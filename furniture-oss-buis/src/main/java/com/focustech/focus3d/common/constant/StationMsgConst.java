/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * StationMsgConst.java
 *
 * @author xulijiao
 */
public class StationMsgConst implements NumberConst {

    /** 未发送-0 */
    public static final String SEND_FLAG_NO = ZERO;
    /** 已发送-1 */
    public static final String SEND_FLAG_YES = ONE;
    /** 未分配-0 */
    public static final String ASSIGN_FLAG_NO = ZERO;
    /** 已分配-1 */
    public static final String ASSIGN_FLAG_YE = ONE;
    /** 未读-0 */
    public static final String READ_FLAG_NO = ZERO;
    /** 已读-1 */
    public static final String READ_FLAG_YES = ONE;

    /** 正常-1 */
    public static final String STATUS_NORMAL = ONE;
    /** 可疑敏感词-2 */
    public static final String STATUS_SENSITIVE_DUBIOUS = TWO;
    /** 禁止敏感词-3 */
    public static final String STATUS_SENSITIVE_STOP = THREE;
    /** 系统黑名单-4 */
    public static final String STATUS_BLACK_SYSTEM = FOUR;
    /** 用户黑名单-5 */
    public static final String STATUS_BLACK_MEMBER = FIVE;

    /** 管理员-0 */
    public static final String MANAGER_FLAG = MemberConst.ADMIN_SIGN_ADMIN;
    /** 参展人员-1 */
    public static final String SUB_FLAG = MemberConst.ADMIN_SIGN_SUB_ACCOUNT;
    /** 游客-2 */
    public static final String TOURIST_FLAG = TWO;

    /** 先生 */
    public static final String SEX_MR = "先生";
    /** 女士 */
    public static final String SEX_MS = "女士";
    /** 先生/女士 */
    public static final String SEX_UNKNOWN = "先生/女士";

    /** 游客序列号默认值-[-1] */
    public static final Long NON_MEMBER_SN = -1L;
    /** 游客序列号等级-[0] */
    public static final String NON_MEMBER_GRADE = ZERO;

    /** ****************** 邮件模板Id ************************ */
    /** 联系信提醒邮件模板 */
    public static final String MAIL_REMIND_STATION = "stationMsgMailRemind";
    /** 会议提醒模板 */
    public static final String MAIL_REMIND_MEETING = "meetingMailRemind";

    /** 审核成功-1 */
    public static final String SUCC_FLAG_AUDIT = ONE;
}

