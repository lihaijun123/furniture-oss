/*
 * Copyright 2010 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 产品审核状态
 * *
 * @author lihaijun
 *
 */
public class ProductAuditStatusConst implements NumberConst {
	/**新加入-1*/
	public static final String NEW_JOIN = ONE;
	/**已修改-2*/
	public static final String ALREADY_MODIFY = TWO;
	/**已下架-3*/
	public static final String HAS_THE_SHELF = THREE;
	/**审核通过-4*/
	public static final String AUDIT_PASS = FOUR;
	/**返回修改-5*/
	public static final String RETURN_MODIFY = FIVE;
	/**暂停-6*/
	public static final String SUSPEND = SIX;
	/**用户已删除-7*/
	public static final String USER_ALREADY_DELETE = SEVEN;
	/**运营删除-8*/
	public static final String OPERATIONS_DELETE = EIGHT;

    /** 审核未通过-0 （对返回修改、暂停等审核未通过的统称） */
    public static final String AUDIT_UNPASS = ZERO;
}
