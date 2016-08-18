package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 图册模块常量
 * *
 * @author lihaijun
 *
 */
public class AtlasInfoConst implements NumberConst{

	/**图册审核状态[1]-新加入;[2]-已修改;[3]-已下架;[4]-通过审核;[5]-返回修改;[6]-暂停;[7]-用户删除;[8]-运营删除*/
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

	/**显示状态:[0]-不显示;[1]-显示*/
	/**不显示-0*/
	public static final String NOT_SHOW = ZERO;
	/**显示-1*/
	public static final String SHOW = ONE;

	/**是否历史记录（是审核成功历史记录）（1.是2.否）*/
	/**-否 2*/
	public static final String HISTORY_FLAG_NOT = TWO;
	/**-是 1*/
	public static final String HISTORY_FLAG_YES = ONE;

	/**[1]-pdf[2]-world[3]excel[4]swf */
	/**-pdf 1*/
	public static final String ATLAS_FORMAT_PDF = ONE;
	/**-word 2*/
	public static final String ATLAS_FORMAT_WORD = TWO;
	/**-excel 3*/
	public static final String ATLAS_FORMAT_EXCEL = THREE;
	/**-swf 4*/
	public static final String ATLAS_FORMAT_SWF = FOUR;

	/**[1]-完整[2]-标准[3]-简约 */
	/**-完整 1*/
	public static final String ATLAS_TYPE_FULL = ONE;
	/**-标准 2*/
	public static final String ATLAS_TYPE_STANDARD = TWO;
	/**-简约 3*/
	public static final String ATLAS_TYPE_CONTRACTED = THREE;

	/**图册制作方式[1]-在线制作;[2]-本地上传 */
	/**-在线制作 1*/
	public static final String MAKE_FLAG_ONLINE = ONE;
	/**-本地上传 2*/
	public static final String MAKE_FLAG_UPLOAD = TWO;

	/**[0]-未删除;[1]-逻辑删除 */
	/**-未删除0*/
	public static final String DELETE_FLAG_NOT = ZERO;
	/**-逻辑删除1*/
	public static final String DELETE_FLAG_YES = ONE;
}