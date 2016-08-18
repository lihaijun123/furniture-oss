/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 会员constant
 * 
 * @author wangliang
 */
public class MemberConst implements NumberConst {
	/** 该邮箱已经注册过会员 */
	public static final String EMAIL_HAS_REGISTERED = "EMAIL_HAS_REGISTERED";

	/** 会员级别-注册参观会员-1 */
	public static final String GRADE_REGISTER_VISIT_MEMBER = ONE;
	/** 会员级别-完善参观会员-2 */
	public static final String GRADE_CONSUMMATE_VISIT_MEMBER = TWO;
	/** 会员级别-实名参观会员-3 */
	public static final String GRADE_REALNAME_VISIT_MEMBER = THREE;
	/** 会员级别-认证参观会员-4 */
	public static final String GRADE_IDENTIFY_VISIT_MEMBER = FOUR;
	/** 会员级别-参展会员 -5 */
	public static final String GRADE_EXHIBIT_MEMBER = FIVE;
    /** 会员级别-准参展会员（虚拟级别） -6 */
    public static final String VIR_GRADE_EXB = SIX;
    /** 会员级别-准实名参观会员（虚拟级别） -7 */
    public static final String VIR_GRADE_RN = SEVEN;

    /** 会员状态(1:新加入,2:已确认,3:审核通过,4.审核拒绝,5:返回修改,6:已修改,7:已暂停,8:已冻结,9.已删除) */
    /** 审核状态-新加入-1 */
    public static final String AUDIT_STATUS_NEW = ONE;
    /** 审核状态-已确认-2 */
    public static final String AUDIT_STATUS_CONFIRM = TWO;
    /** 审核状态-审核通过 -3 */
    public static final String AUDIT_STATUS_PASS = THREE;
    /** 审核状态-审核拒绝-4 */
    public static final String AUDIT_STATUS_REFUSE = FOUR;
    /** 审核状态-返回修改 -5 */
    public static final String AUDIT_STATUS_RETURN_MODIFY = FIVE;
    /** 审核状态-已修改 -6 */
    public static final String AUDIT_STATUS_MODIFIED = SIX;
    /** 审核状态-已暂停-7 */
    public static final String AUDIT_STATUS_PAUSED = SEVEN;
    /** 审核状态-已冻结-8 */
    public static final String AUDIT_STATUS_FREEZED = EIGHT;
    /** 审核状态-已删除 -9 */
    public static final String AUDIT_STATUS_DELETED = NINE;
    /** 审核状态-运营删除 -10 */
    public static final String AUDIT_STATUS_OSS_DELETED = TEN;

	/** 管理员标志-管理员-0 */
	public static final String ADMIN_SIGN_ADMIN = ZERO;
	/** 管理员标志-子账户 -1 */
	public static final String ADMIN_SIGN_SUB_ACCOUNT = ONE;

	/** 您已经成功修改会员信息 */
	public static final String MEMBER_INFO_MODIFY_SUCCESS = "MEMBER_INFO_MODIFY_SUCCESS";
    /** 中国代码-142 */
    public static final String COUNTRY_CODE_CHINA = "142";

    /** oss 添加会员默认的密码值-123456 */
    public static final String PWD_DEFAULT_VAL = "cief1234";
}
