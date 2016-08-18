/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 *  RealNameAuthConst.java
 *
 * @author liushuyan
 */
public class RealNameAuthConst implements NumberConst {

	/** 实名认证状态(1:未提交,2:新加入,3:已修改,4.审核通过,5:已更新,6:审核未通过) */
	/** 状态-未提交-1 */
	public static final String STATUS_UNCOMMITTED = ONE;
	/** 状态-新加入-2 */
	public static final String STATUS_NEW = TWO;
	/** 状态-已修改-3 */
	public static final String STATUS_MODIFIED = THREE;
	/** 状态-审核通过-4 */
	public static final String STATUS_PASS = FOUR;
	/** 状态-已更新-5 （弃用） */
	public static final String STATUS_UPDATE = FIVE;
	/** 状态-返回修改-6 */
	public static final String STATUS_FAIL = SIX;
	/** 状态-审核未通过-7 */
	public static final String STATUS_NO = SEVEN;

	/** 状态-审核通过-4 */
	public static final String STATUS_PASS_NAME = "审核通过";
	/** 状态-审核未通过-7 */
	public static final String STATUS_NO_NAME = "未审核通过";

	/** 是否发送邮件-不发送邮件通知-0 */
	public static final String SEND_EMAIL_NO = ZERO;

	/** 是否发送邮件-发送邮件通知-1 */
	public static final String SEND_EMAIL_YES = ONE;

	/**实名认证即将过期检测时间-10前*/
	public static final Integer WILL_EXPIRE = 10;
	/** 审核未通过服务必须重新购买-34天  */
	public static final Integer RN_NOT_PASS_REMINDING_SECOND = -34;


}
