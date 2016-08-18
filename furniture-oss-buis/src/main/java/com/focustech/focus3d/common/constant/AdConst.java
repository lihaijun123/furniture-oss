/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.utils.TCUtil;


/**
 * Const.java
 *
 * @author xulijiao
 */
public interface AdConst {
    // 广告属性类型begin
    /** 广告种类标识 */
    public final static String AD_KIND = "AD_KIND";
    /** 广告位置 */
    public final static String AD_POSITION = "AD_POSITION";
    /** 广告类型,包括web与模型广告类型 */
    public final static String AD_TYPE = "AD_TYPE";
    /** web广告类型 */
    public final static String AD_TYPE_WEB = "AD_TYPE_WEB";
    /** 模型广告类型 */
    public final static String AD_TYPE_MODEL = "AD_TYPE_MODEL";
    /** 广告显示模式 */
    public final static String AD_MODE = "AD_MODE";
    /** 模型广告展现形式 */
    public final static String AD_SHOW = "AD_SHOW";
    /** 页面标识 */
    public final static String AD_PAGE_POS = "AD_PAGE_POS";
    /** 场景方位标识 */
    public final static String AD_SCENE_POS = "AD_SCENE_POS";
    /** 营销类型 */
    public final static String AD_MARKET_TYPE = "AD_MARKET_TYPE";

    /** 广告显示宽度 */
    public final static String AD_SIZE_WIDTH = "AD_SIZE_WIDTH";
    /** 广告显示高度 */
    public final static String AD_SIZE_HEIGHT = "AD_SIZE_HEIGHT";
    /** 广告显示时长 */
    public final static String AD_SIZE_LENGTH = "AD_SIZE_LENGTH";

    /** 建筑名标识 */
    public final static String BUILDING_NAME = "BUILDING_NAME";
    /** 道路名标识 */
    public final static String PATH_NAME = "PATH_NAME";
    /** 场景名标识,场景包括建筑与道路 */
    public final static String SCENE_NAME = "SCENE_NAME";

    /** 预售数量 */
    public final static String SALE_QUANTITY = "SALE_QUANTITY";
    /** 显示天数 */
    public final static String SHOW_DAYS = "SHOW_DAYS";

    /** 开始时间 */
    public final static String BEGIN_TIME = "BEGIN_TIME";
    /** 结束时间 */
    public final static String END_TIME = "END_TIME";

    // 广告属性类型 end

    // 广告属性名称 begin

    /** 2D名称 */
    public final static String WEB = "WEB";
    /** 3D名称 */
    public final static String MODEL = "MODEL";

    /** 通栏 */
    public final static String BANNER2 = "BANNER2";
    /** 橱窗 */
    public final static String SHOWCASE = "SHOWCASE";
    /** 游标 */
    public final static String VERNIER = "VERNIER";
    /** 展台 */
    public final static String EXB_BOOTH = "EXB_BOOTH";
    /** 弹出窗口 */
    public final static String POP_UP_WIN = "POP_UP_WIN";
    /** 精品推荐 */
    public final static String BOUTIQUE_RECOMMEND = "BOUTIQUE_RECOMMEND";

    /** 横幅 */
    public final static String BANNER3 = "BANNER3";
    /** 灯箱 */
    public final static String LAMP = "LAMP";
    /** 立柱 */
    public final static String COLUMN = "COLUMN";
    /** 电子屏 */
    public final static String ELEC_SCREEN = "ELEC_SCREEN";
    /** 漂浮热气球 */
    public final static String FLOAT_BALLOON = "FLOAT_BALLOON";
    /** 宣传单 */
    public final static String LEAFLETS = "LEAFLETS";
    /** 人模动画 */
    public final static String HUMAN_ANIMATION = "HUMAN_ANIMATION";
    /** 交通工具动画 */
    public final static String VEHICLE_ANIMATION = "VEHICLE_ANIMATION";
    /** 墙面海报 */
    public final static String WALL_POSTER = "WALL_POSTER";

    /** 固定 */
    public final static String FIXED = "FIXED";
    /** 轮播 */
    public final static String CAROUSEL = "CAROUSEL";
    /** 随机 */
    public final static String RANDOM = "RANDOM";

    /** 图片 */
    public final static String PICTURE = "PICTURE";
    /** 贴图动画 */
    public final static String PASTE_ANIMATION = "PASTE_ANIMATION";
    /** 视频 */
    public final static String VIDEO = "VIDEO";
    /** 360全景图 */
    public final static String PANORAMA = "PANORAMA";
    /** 路径/轨迹动画 */
    public final static String PATH_PANORAMA = "PATH_PANORAMA";

    /** 历届展厅 */
    public final static String PREVIOUS_EXB = "PREVIOUS_EXB";
    /** 登录界面 */
    public final static String LOGIN_PAGE = "LOGIN_PAGE";
    /** 会员中心 */
    public final static String MEMBER_CENTER = "MEMBER_CENTER";
    /** 首页*/
    public final static String HOME_PAGE = "HOME_PAGE";

    /** 个性服务商店 */
    public final static String PERSONALIZED_SERVICE_SHOP = "PERSONALIZED_SERVICE_SHOP";

    /** 入口 */
    public final static String SCENE_ENTRANCE = "SCENE_ENTRANCE";
    /** 内景 */
    public final static String SCENE_INTERIOR = "SCENE_INTERIOR";
    /** 过道 */
    public final static String SCENE_ROAD = "SCENE_ROAD";

    /** 购买 */
    public final static String BUY = "BUY";
    /** 赠送 */
    public final static String GIFT = "GIFT";
    /** 推广 */
    public final static String PROMOTE = "PROMOTE";

    /** 展馆 */
    public final static String HALL = "HALL";
    /** 会议厅 */
    public final static String METTING = "METTING";
    /** 演播厅 */
    public final static String STUDIO = "STUDIO";
    /** 咖啡厅 */
    public final static String CAFE = "CAFE";
    /** 服务中心 */
    public final static String SERVICE_CENTER = "SERVICE_CENTER";
    /** 3D展厅 */
    public final static String HALL_3D = "HALL_3D";
    /** A馆 */
    public final static String HALL_A = "HALL_A";
    /** B馆 */
    public final static String HALL_B = "HALL_B";
    /** C馆 */
    public final static String HALL_C = "HALL_C";
    /** D馆 */
    public final static String HALL_D = "HALL_D";
    public final static String HALL_E = "HALL_E";
    public final static String HALL_F = "HALL_F";
    public final static String HALL_G = "HALL_G";
    public final static String HALL_H = "HALL_H";
    public final static String HALL_I = "HALL_I";
    public final static String HALL_J = "HALL_J";
    public final static String HALL_K = "HALL_K";
    public final static String HALL_L = "HALL_L";
    public final static String HALL_M = "HALL_M";
    public final static String HALL_N = "HALL_N";
    public final static String HALL_O = "HALL_O";
    public final static String HALL_P = "HALL_P";
    public final static String HALL_Q = "HALL_Q";
    public final static String HALL_R = "HALL_R";
    public final static String HALL_S = "HALL_S";
    public final static String HALL_T = "HALL_T";

    /** 1号道路 */
    public final static String PATH_1 = "PATH_1";
    /** 2号道路 */
    public final static String PATH_2 = "PATH_2";
    public final static String PATH_3 = "PATH_3";
    public final static String PATH_4 = "PATH_4";
    public final static String PATH_5 = "PATH_5";
    public final static String PATH_6 = "PATH_6";
    public final static String PATH_7 = "PATH_7";
    public final static String PATH_8 = "PATH_8";
    public final static String PATH_9 = "PATH_9";
    public final static String PATH_10 = "PATH_10";
    public final static String PATH_11 = "PATH_11";
    public final static String PATH_12 = "PATH_12";
    public final static String PATH_13 = "PATH_13";
    public final static String PATH_14 = "PATH_14";
    public final static String PATH_15 = "PATH_15";
    public final static String PATH_16 = "PATH_16";
    public final static String PATH_17 = "PATH_17";
    public final static String PATH_18 = "PATH_18";
    public final static String PATH_19 = "PATH_19";
    public final static String PATH_20 = "PATH_20";

    // 广告属性名称 end

    /** 文件类型 */
    public final static String F_TYPE = "F_TYPE";
    /** 显示尺寸 */
    public final static String F_SIZE = "F_SIZE";
    /** 方位类型 */
    public final static String POS_CATEGORY = "POS_CATEGORY";
    /** 方位编号 */
    public final static String POS_NO = "POS_NO";

    /** 站点-广告方案 */
    public final static String SITE_SCHEME = "scheme";
    /** 站点-广告信息 */
    public final static String SITE_INFO = "info";

    /** 视频最大时长限制，单位秒 */
    public final static Integer VIDEO_MAX_TIME = 10;
    /** 图片轮播时长限制，单位秒 */
    public final static Integer PIC_MAX_TIME = 5;

    /** 有效 */
    public final static Integer VALID = TCUtil.iv(OverallConst.EFFECTIVE);
    /** 无效 */
    public final static Integer INVALID = TCUtil.iv(OverallConst.INVALID);

    /** 属性关联-广告位类别 */
    public final static Integer LINK_AD_POS = TCUtil.iv(PropertyLinkTypeConst.ADVERTISING_CATEGORY);
    /** 属性关联-广告方案 */
    public final static Integer LINK_AD_SCHEME = TCUtil.iv(PropertyLinkTypeConst.ADVERTISING_PROGRAM);
    /** 属性关联-广告服务 */
    public final static Integer LINK_AD_INFO = TCUtil.iv(PropertyLinkTypeConst.ADVERTISING_INFO);

    /** 成功标识 */
    public final static String SUCCESS = "1";
    /** 失败标识 */
    public final static String FAILURE = "0";

    /** 模型广告列表资源-10141 */
    public final static String AD_RES_10141 = "10141";
    /** 页面广告列表资源-10142 */
    public final static String AD_RES_10142 = "10142";

    /** 广告来源-1订单 */
    public final static String SOURCE_FROM_ORDER = "1";
    /** 广告来源-0新建 */
    public final static String SOURCE_FROM_NEW = "0";

    /** 添加成功 */
    public final static String SUCCESS_ADD = "a1";
    /** 添加失败 */
    public final static String FAILURE_ADD = "a0";
    /** 修改成功 */
    public final static String SUCCESS_EDIT = "e1";
    /** 修改失败 */
    public final static String FAILURE_EDIT = "e0";
    /** 广告位添加失败 */
    public final static String FAILURE_POS = "p0";

    /** 固定类型验证失败 */
    public final static String FIXED_MODE_FAILURE_INFO = "同一时间同一广告位只能显示一个固定类型广告！";
    /** 广告位不存在 */
    public final static String AD_POS_EXISTS_NO = "所选广告位不存在！";

    /** 表单成功提示信息 */
    public final static String FORM_SUCCESS_INFO = "添加产品成功！您的产品需要通过审核才能得到发布。";
    /** 表单提交失败提示信息 */
    public final static String FORM_FAILURE_INFO = "表单提交失败！";
    /** 修改成功提示信息 */
    public final static String EDIT_SUCCESS_INFO = "修改成功！";
    /** 修改失败提示信息 */
    public final static String EDIT_FAILURE_INFO = "修改失败！";

    // =======================================模型广告个数====================================================

    /** 场景入口灯箱广告个数 */
    public final static Integer ENT_LAMP_NUM = 6;
    /** 场景入口立柱广告个数 */
    public final static Integer ENT_COLUMN_NUM = 2;
    /** 场景入口电子屏广告个数 */
    public final static Integer ENT_ELEC_SCREEN_NUM = 1;
    /** 场景入口热气球广告个数 */
    public final static Integer ENT_FLOAT_BALLOON_NUM = 2;
    /** 场景入口宣传单广告个数 */
    public final static Integer ENT_LEAFLETS_NUM = 2;
    /** 场景入口人模广告个数 */
    public final static Integer ENT_HUMAN_ANIMATION_NUM = 1;
    /** 场景入口交通工具广告个数 */
    public final static Integer ENT_VEHICLE_ANIMATION_NUM = 2;
    /** 场景内景横幅广告个数 */
    public final static Integer INT_BANNER3_NUM = 20;
    /** 场景内景墙面广告个数 */
    public final static Integer INT_WALL_POSTER_NUM = 10;
    /** 场景内景电子屏广告个数 */
    public final static Integer INT_ELEC_SCREEN_NUM = 4;
    /** 场景内景人模广告个数 */
    public final static Integer INT_HUMAN_ANIMATION_NUM = 4;
    /** 场景道路灯箱广告个数 */
    public final static Integer PATH_LAMP_NUM = 24;

    // =======================================坐标轴名称====================================================

    /** 位置编号 */
    public final static String POSITION_ID = "POSITION_ID";
    /** x轴坐标 */
    public final static String LOCATION_X = "LOCATION_X";
    /** y轴坐标 */
    public final static String LOCATION_Y = "LOCATION_Y";
    /** z轴坐标 */
    public final static String LOCATION_Z = "LOCATION_Z";
    /** z轴角度 */
    public final static String ANGLE_Z = "ANGLE_Z";

    /** 入口代号 */
    public final static String POS_ENT = "ent";
    /** 内景 代号 */
    public final static String POS_INT = "int";
    /** 过道 代号 */
    public final static String POS_PATH = "path";

    /** 获取表头信息 */
    public final static String IMPORT_INFO_GET_HEAD = "广告布局管理坐标导入：获取表头字段！";
    /** 文件导入开始 */
    public final static String IMPORT_INFO_STAET = "广告布局管理坐标导入：开始导入excel文件！";
    /** 文件导入成功 */
    public final static String IMPORT_INFO_SUCCESS = "广告布局管理坐标导入：excel导入成功！";
    /** 文件导入失败 */
    public final static String IMPORT_INFO_FAILURE = "广告布局管理坐标导入：excel导入失败！";
    /** 文件导入格式错误 */
    public final static String IMPORT_FILE_FAILURE = "广告布局管理坐标导入：上传的excel文档格式不正确！";
    /** 文件导入结束 */
    public final static String IMPORT_INFO_END = "广告布局管理坐标导入：结束导入excel文件！";

    /**
     * 扩展标识
     *
     * @return
     */
    public Object getPos();

    /**
     * 存储于数据库表中值
     *
     * @return
     */
    public Object getKey();

    /**
     * 页面显示值
     *
     * @return
     */
    public Object getValue();
}
