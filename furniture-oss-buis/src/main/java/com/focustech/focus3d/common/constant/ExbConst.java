/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;
import com.focustech.common.utils.TCUtil;


/**
 * 展会、展馆、展区、展台相关
 *
 * @author xulijiao
 */
public class ExbConst implements NumberConst {

    // 展会
    /** 新加入-1 */
    public static final String NEW_JOIN = ONE;
    /** 已确认-2 */
    public static final String ALREADY_AFFIRM = TWO;
    /** 预发布-3 */
    public static final String PRE_RELEASE = THREE;
    /** 已发布-4 */
    public static final String HAS_BEEN_RELEASE = FOUR;
    /** 已归-5 */
    public static final String ARCHIVED = FIVE;
    /** 已删除-6 */
    public static final String ALREADY_DELETE = SIX;
    /** 已暂停-7 */
    public static final String ALREADY_SUSPEND = SEVEN;

    // 展馆
    /** 展馆状态-开馆中 */
    public static final String EXB_HALL_OPEN = ONE;
    /** 展馆状态-已闭馆 */
    public static final String EXB_HALL_CLOSE = TWO;
    /** 展馆状态-已删除 */
    public static final String EXB_HALL_DELETE = THREE;

    // 展区
    /** 展区状态-正常 */
    public static final String EXB_AREA_NORMAL = ONE;
    /** 展区状态-删除 */
    public static final String EXB_AREA_DELETE = TWO;

    // 模型库
    /** 展馆模型-子展馆 */
    public static final String MODEL_SUB_EXB_HALL = "Display_Exb_302";
    /** 会议大厅模型 */
    public static final String MODEL_METTING_HALL = "MODELLIB_METTING_HALL";
    /** 会议室模型 */
    public static final String MODEL_METTING_ROOM = "MODELLIB_METTING_ROOM";
    /** 演播大厅模型 */
    public static final String MODEL_STUDIO_HALL = "MODELLIB_STUDIO_HALL";
    /** 点播室模型 */
    public static final String MODEL_DEMAND_ROOM = "MODELLIB_STUDIO_DEMAND";
    /** 直播室模型 */
    public static final String MODEL_LIVE_ROOM = "MODELLIB_STUDIO_LIVE";
    /** 一级场景模型 */
    public static final String MODEL_LEVEL_ONE_SCENE = "MODELLIB_SCENE_ONE_1";

	/**
	 * 产品体验区模型
	 */
	public static final String MODEL_PROD_EXP = "PROD_EXPERIENCE_1";

	/**
	 * 精装站台
	 */
	public static final String BOOTH = "BOOTH_";

    // 展位
    /** 展位状态-空闲 */
    public static final String EXB_BOOTH_IDLE = ONE;
    /** 展位状态-已销售 */
    public static final String EXB_BOOTH_SOLD = THREE;

    /** 展位类型：标装-1 */
    public static final String STANDARD = ONE;
    /** 展位类型：精装-2 */
    public static final String HARDBACK = TWO;
    /** 展位类型：豪装-3 */
    public static final String LUXURY = THREE;

    /** 展位每页显示格式：20 */
    public static final String LIST_PER_PAGE_INT = TWENTY;

    /**
     * 展会与展馆关系类型，暂定为99
     */
    public static final Integer TYPE_99 = 99;

    /** 添加成功 */
    public final static String SUCCESS_ADD = "a1";
    /** 添加失败 */
    public final static String FAILURE_ADD = "a0";
    /** 修改成功 */
    public final static String SUCCESS_EDIT = "e1";
    /** 修改失败 */
    public final static String FAILURE_EDIT = "e0";

    /**
     * 根据参展宝服务类型获取展位类型
     *
     * @param serviceType 参展宝服务类型（库表中类型）
     * @return 展位类型
     * @author xulijiao
     */
    public static Integer getBoothType(String serviceType) {
        Integer type = -1;
        if (SalesSchemeConst.STANDARD_EDITION.equals(serviceType)) {
            type = TCUtil.iv(ExbConst.STANDARD);
        }
        else if (SalesSchemeConst.HARDBACK_EDITION.equals(serviceType)) {
            type = TCUtil.iv(ExbConst.HARDBACK);
        }
        else if (SalesSchemeConst.LUXURY_EDITION.equals(serviceType)) {
            type = TCUtil.iv(ExbConst.LUXURY);
        }
        return type;
    }

    /**
     * 根据展馆状态装备展馆名称
     *
     * @param name
     * @param status
     * @return
     */
    public static String invokeExbHallNameByStatus(String name, Integer status) {
        if (ExbConst.EXB_HALL_OPEN.equals(TCUtil.sv(status))) {
            return name + " (开馆中)";
        }
        else if (ExbConst.EXB_HALL_CLOSE.equals(TCUtil.sv(status))) {
            return name + " (空闲)";
        }
        else {
            return name + " (已删除)";
        }
    }

    // ========================展台编辑器XML文件自定义属性=========================================

    /** productsns,filesns,showimgs,fileurls,status */
    public static final String ATTR_PRODUCT_SNS = "productsns";
    public static final String ATTR_FILE_SNS = "filesns";
    public static final String ATTR_SHOWIMGS = "showimgs";
    public static final String ATTR_FILE_URLS = "fileurls";
    public static final String ATTR_STATUS = "status";
    public static final String ATTR_OLD_MT = "oldPicName";// 原模型贴图名称

    public static final String ATTR_PRODUCT_SN = "productid";
    public static final String ATTR_FILE_SN = "filesn";
    public static final String ATTR_SHOWIMG = "showimg";
    public static final String ATTR_FILE_URL = "TextureFilename";

    /** 模型类型-展台编辑器xml文件中模型类型 */
    public static final String CIEF_MODEL_TYPE_DX = "dx";// 灯箱
    public static final String CIEF_MODEL_TYPE_HB = "hb";// 海报
    public static final String CIEF_MODEL_TYPE_YLB = "ylb";// 易拉宝
    public static final String CIEF_MODEL_TYPE_360 = "360";// 360全景图
    public static final String CIEF_MODEL_TYPE_DS = "ds";// 视频
    public static final String CIEF_MODEL_TYPE_CPZST = "cpzst";// 产品展示架(台)

    /**
     * 已删除状态
     */
    public static final long EXBHALL_STATUS_3 = 3;

    /**
     * 2
     */
    public static final int NUM_TWO = 2;
    /**
     * 根据模型类型获取产品对应的媒体类型<br>
     * 注意：ct不是xml文件中模型类型，目前用于展台编辑器获取默认值，为保证以后不出现问题，以后自定义模型类型中不能为ct。
     *
     * @param type 模型类型(展台编辑器xml文件中模型类型)
     * @return 产品-媒体关系类型
     */
    public static String getProdMediaType(String type) {
        String mediaType = "";
        if (CIEF_MODEL_TYPE_DX.equals(type)) {
            mediaType = BaseRelationTypeConst.PRODUCT_POSTER;
        }
        else if (CIEF_MODEL_TYPE_HB.equals(type)) {
            mediaType = BaseRelationTypeConst.PRODUCT_POSTER;
        }
        else if (CIEF_MODEL_TYPE_YLB.equals(type)) {
            mediaType = BaseRelationTypeConst.PRODUCT_POSTER;
        }
        else if (CIEF_MODEL_TYPE_360.equals(type)) {
            mediaType = BaseRelationTypeConst.PRODUCT_360PANORAMA;
        }
        else if (CIEF_MODEL_TYPE_DS.equals(type)) {
            mediaType = BaseRelationTypeConst.PRODUCT_VIDEO;
        }
        else if (CIEF_MODEL_TYPE_CPZST.equals(type)) {
            mediaType = BaseRelationTypeConst.PRODUCT_3DMODEL;
        }
        return mediaType;
    }
}

