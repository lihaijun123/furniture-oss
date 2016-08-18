/*
 * Copyright 2010 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 系统广播
 * *
 * @author lihaijun
 *
 */
public class SysBroadcastConst implements NumberConst {
	/**类型[1]-高峰论坛;[2-新品展示;[3]-商业活动;[4]-展会预告;[5]-系统功能*/
	/**高峰论坛-1*/
	public static final String TYPE_CODE_FORUM = ONE;
	/**新品展示-2*/
	public static final String TYPE_CODE_SHOW = TWO;
	/**商业活动-3*/
	public static final String TYPE_CODE_ACTIVITY = THREE;
	/**展会预告-4*/
	public static final String TYPE_CODE_FORESHOW = FOUR;
	/**系统功能-5*/
	public static final String TYPE_CODE_SYS = FIVE;
	/**其他-6*/
	public static final String TYPE_CODE_OTHER = SIX;

	/**[1]-购买;[2]-赠送;[3]-加强推广 */
	/**购买-1*/
	public static final String GET_WAY_BUY = ONE;
	/**赠送-2*/
	public static final String GET_WAY_PRESENT = TWO;
	/**加强推广-3*/
	public static final String GET_WAY_ACTIVITY = THREE;

	/**所属公司、会议厅、演播厅、3D展厅、咖啡厅、无、其他 */
	/**所属公司-1*/
	public static final String LINK_ADDRESS_COM = ONE;
	/**会议厅-2*/
	public static final String LINK_ADDRESS_BOARDROOM = TWO;
	/**演播厅-3*/
	public static final String LINK_ADDRESS_STUDIO = THREE;
	/**3D展厅-4*/
	public static final String LINK_ADDRESS_3DSHOW = FOUR;
	/**咖啡厅-5*/
	public static final String LINK_ADDRESS_COFFEEHOUSE = FIVE;
	/**无-6*/
	public static final String LINK_ADDRESS_NULL = SIX;
	/**其他-7*/
	public static final String LINK_ADDRESS_OTHER = SEVEN;
}
