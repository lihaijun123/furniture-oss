/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;


/**
 * 公司constant
 *
 * @author wangyifan
 */
public class CompanyConst implements NumberConst {
    /** 公司状态(1:新加入,2:已确认,3:审核通过,4.审核拒绝,5:返回修改,6:已修改,7:已暂停,8:已冻结,9.已删除) */
    /**
     * 审核状态-新加入-1
     */
    public static final String AUDIT_STATUS_NEW = ONE;
    /**
     * 审核状态-已确认-2
     */
    public static final String AUDIT_STATUS_CONFIRM = TWO;
    /**
     * 审核状态-审核通过 -3
     */
    public static final String AUDIT_STATUS_PASS = THREE;
    /**
     * 审核状态-审核拒绝-4
     */
    public static final String AUDIT_STATUS_REFUSE = FOUR;
    /**
     * 审核状态-返回修改 -5
     */
    public static final String AUDIT_STATUS_RETURN_MODIFY = FIVE;
    /**
     * 审核状态-已修改 -6
     */
    public static final String AUDIT_STATUS_MODIFIED = SIX;
    /**
     * 审核状态-已暂停-7
     */
    public static final String AUDIT_STATUS_PAUSED = SEVEN;
    /**
     * 审核状态-已删除 -9
     */
    public static final String AUDIT_STATUS_DELETED = NINE;
    /**
     * 审核状态-运营删除 -10
     */
    public static final String AUDIT_STATUS_OSS_DELETED = TEN;

    /** 审核未通过-0 （对返回修改、暂停等审核未通过的统称） */
    public static final String AUDIT_UNPASS = ZERO;
}
