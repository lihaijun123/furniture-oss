/*
 * Copyright 2010 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 审核状态
 * *
 * @author lihaijun
 *
 */
public class AuditStatusConst implements NumberConst {
	/**新加入-1*/
	public static final String NEW_JOIN = ONE;
	/**已确认-2*/
	public static final String ALREADY_AFFIRM = TWO;
	/**审核通过-3*/
	public static final String AUDIT_PASS = THREE;
	/**审核拒绝-4*/
	public static final String AUDIT_REFUSE = FOUR;
	/**返回修改-5*/
	public static final String RETURN_MODIFY = FIVE;
	/**已修改-6*/
	public static final String ALREADY_MODIFY = SIX;
	/**已暂停-7*/
	public static final String ALREADY_SUSPEND = SEVEN;
	/**已冻结-8*/
	public static final String ALREADY_FREEZE = EIGHT;
	/**已删除-9*/
	public static final String ALREADY_DELETE = NINE;
}
