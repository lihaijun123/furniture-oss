package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 展会策划模块常量
 * *
 * @author lihaijun
 *
 */
public class ExhibitionConst implements NumberConst{
	/**新加入-1*/
	public static final String NEW_JOIN = ONE;
	/**已确认-2*/
	public static final String ALREADY_AFFIRM = TWO;
	/**预发布-3*/
	public static final String PRE_RELEASE = THREE;
	/**已发布-4*/
	public static final String HAS_BEEN_RELEASE = FOUR;
	/**已归-5*/
	public static final String ARCHIVED = FIVE;
	/**已删除-6*/
	public static final String ALREADY_DELETE = SIX;
	/**已暂停-7*/
	public static final String ALREADY_SUSPEND = SEVEN;

	//--- add by lsy start
	/**新建展馆模型的请求位置-展馆模型*/
	public static final String ADD_MODEL_POS_LOC = "modelLibrary";
	/**新建展馆模型的请求位置-展馆*/
	public static final String ADD_MODEL_POS_EXB = "exbHall";
    /** 展位类型 */
    public final static String BOOTH_TYPE = "BOOTH_TYPE";
    /** 展位坐标导入失败*/
	public final static String IMPORT_BOOTH_INFO_FAILURE = "展位坐标导入：excel导入失败！";
	 /** 文件导入格式错误 */
    public final static String IMPORT_FILE_FAILURE = "展位坐标导入：上传的excel文档格式不正确！";
    /**展区状态-启用-1*/
    public static final String AREA_STUTAS_ENABLE = ONE;
    /**展区状态-禁用-2*/
    public static final String AREA_STUTAS_FORBIDDEN = TWO;
    /**展区状态-未完成-3*/
    public static final String AREA_STUTAS_NO_COMPLETE = THREE;
	//--- add by lsy end

    /**1-一级场景 2-演播厅大厅 3-直播室 4-点播室 5-会议厅大厅 6-3D产品体验区 7-咖啡厅 8-展览馆 9-其他*/
	/**所属公司-1*/
	public static final String LINK_ADDRESS_COM = ONE;
	/**演播厅-2*/
	public static final String LINK_ADDRESS_STUDIO = TWO;
	/**直播室-3*/
	public static final String LINK_ADDRESS_LIVE = THREE;
	/**点播室-4*/
	public static final String LINK_ADDRESS_DEMAND = FOUR;
	/**会议厅-5*/
	public static final String LINK_ADDRESS_BOARDROOM = FIVE;
	/**3D产品体验区-6*/
	public static final String LINK_ADDRESS_3DSHOW = SIX;
	/**咖啡厅-7*/
	public static final String LINK_ADDRESS_COFFEEHOUSE = SEVEN;
	/**展览馆-8*/
	public static final String LINK_ADDRESS_HALL = EIGHT;
	/**其他-9*/
	public static final String LINK_ADDRESS_OTHER = NINE;
	/**展会和展馆的关系标志*/
    public static final String EXB_HALL_RELATION_TYPE = "99";
}
