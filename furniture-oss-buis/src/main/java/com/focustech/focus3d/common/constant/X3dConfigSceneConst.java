/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 场景相关常量定义
 *
 * @author xulijiao
 */
public class X3dConfigSceneConst implements NumberConst {

    /** 默认场景坐标 */
    public static final String DEFAULT_LOCATION = "1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1";
    /** 默认父场景SN */
    public static final String DEFAULT_PID = "0";
    /** 默认级别 */
    public static final String DEFAULT_LEVEL = "1";
    /** 大场景-中文后缀 */
    public static final String BIG_SCENE_CN = "大场景";
    /** 小场景-中文后缀 */
    public static final String SMALL_SCENE_CN = "小场景";
    /** 不存在的场景SN */
    public static final Long EMPTY_SN = -1L;
	// ========================scene_type=============================================
	/** 大场景 */
	public static final String BIG_SCENE = "BIG_SCENE";
	/** 小场景 */
	public static final String SMALL_SCENE = "SMALL_SCENE";

    /** 大场景-展馆 */
    public static final String BIG_SCENE_EXB_HALL = "BIG_SCENE_EXB_HALL";
    /** 大场景-会议厅 */
    public static final String BIG_SCENE_MEETING_HALL = "BIG_SCENE_MEETING_HALL";
    /** 大场景-会议室 */
    public static final String BIG_SCENE_MEETING_ROOM = "BIG_SCENE_MEETING_ROOM";
    /** 大场景-演播厅 */
    public static final String BIG_SCENE_STUDIO_HALL = "BIG_SCENE_STUDIO_HALL";
    /** 大场景-点播室 */
    public static final String BIG_SCENE_DEMAND_ROOM = "BIG_SCENE_DEMAND_ROOM";
    /** 大场景-直播室 */
    public static final String BIG_SCENE_LIVE_ROOM = "BIG_SCENE_LIVE_ROOM";
	/** 大场景-展台 */
	public static final String BIG_SCENE_EXB_BOOTH = "BIG_SCENE_EXB_BOOTH";
	/** 大场景-展品 */
	public static final String BIG_SCENE_EXB_PROD = "BIG_SCENE_EXB_PROD";
	/** 大场景-其它 */
	public static final String BIG_SCENE_OTHERS = "BIG_SCENE_OTHERS";
    /** 大场景-一级场景 */
    public static final String BIG_SCENE_LEVEL_ONE_SCENE = "BIG_SCENE_LEVEL_ONE_SCENE";

    /** 小场景-展馆 */
    public static final String SMALL_SCENE_EXB_HALL = "SMALL_SCENE_EXB_HALL";
    /** 小场景-会议厅 */
    public static final String SMALL_SCENE_MEETING_HALL = "SMALL_SCENE_MEETING_HALL";
    /** 小场景-会议室 */
    public static final String SMALL_SCENE_MEETING_ROOM = "SMALL_SCENE_MEETING_ROOM";
    /** 小场景-演播厅 */
    public static final String SMALL_SCENE_STUDIO_HALL = "SMALL_SCENE_STUDIO_HALL";
    /** 小场景-点播室 */
    public static final String SMALL_SCENE_DEMAND_ROOM = "SMALL_SCENE_DEMAND_ROOM";
    /** 小场景-直播室 */
    public static final String SMALL_SCENE_LIVE_ROOM = "SMALL_SCENE_LIVE_ROOM";
	/** 小场景-展台框架 */
	public static final String SMALL_SCENE_BOOTH_FRAME = "SMALL_SCENE_BOOTH_FRAME";
	/** 小场景-展台展具 */
	public static final String SMALL_SCENE_BOOTH_TOOLS = "SMALL_SCENE_BOOTH_TOOLS";
	/** 小场景-展品 */
	public static final String SMALL_SCENE_EXB_PROD = "SMALL_SCENE_EXB_PROD";
	/** 小场景-其它 */
	public static final String SMALL_SCENE_OTHERS = "SMALL_SCENE_OTHERS";
	/** 小场景-子展馆内-展台 */
	public static final String SMALL_SCENE_HALL_BOOTH = "SMALL_SCENE_HALL_BOOTH";
	/** 小场景-展示厅内-展台 */
	public static final String SMALL_SCENE_ROOM_BOOTH = "SMALL_SCENE_ROOM_BOOTH";
    /** 小场景-一级场景 */
    public static final String SMALL_SCENE_LEVEL_ONE_SCENE = "SMALL_SCENE_LEVEL_ONE_SCENE";

    // ======================== scene url ==========================================
    /** 展会名称 */
    public static final String EXB_NAME = "exbName";
    /** 加密SN */
    public static final String ID = "id";
    /** url类型 */
    public static final String TYPE = "type";

    /** 二级url类型 */
    public static final String[] URL_TYPE_TWO = {"exbition", "conference", "cafe", "studio", "service", "product3d"};
    /** 三级url类型 */
    public static final String[] URL_TYPE_THREE = {"exbition", "conference", "cafe", "studio"};

    /** 一级场景url */
    public static final String SCENE_URL_HOME = "~!exbName!~.zhanhui.cief.com/main#index";
    /** 二级场景url */
    public static final String SCENE_URL_TWO = "~!exbName!~.zhanhui.cief.com/main#~!type!~";
    /** 三级场景url */
    public static final String SCENE_URL_THREE = "~!exbName!~.zhanhui.cief.com/main#~!type!~&~!id!~";
    /** 四级场景url(产品展示厅) */
    public static final String SCENE_URL_FOUR = "~!exbName!~.zhanhui.cief.com/main#~!id!~";

    /** 直播室标识 */
    public static final String STUDIO_LIVE = "live";
    /** 点播室标识 */
    public static final String STUDIO_DEMAND = "demand";

    // ======================== 产品 display标识=============================================
    /** 展台上显示 */
    public static final String PROD_DISPLAY_1 = ONE;
    /** 展台上不显示 */
    public static final String PROD_DISPLAY_0 = ZERO;

    // ======================== x3d xml 文件后缀名标识==========================================
    /** x3dscene 后缀名 */
    public static final String EXT_X3DSCENE = ".x3dscene";

    // ======================== 相关提示信息 ==========================================
    /** 子展馆小场景关系未新建 */
    public static final String EXB_HALL_SCENE_NO_EXIST = "[展馆大小场景关系未新建]！";
}
