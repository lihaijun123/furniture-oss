/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 广告模块常量定义
 *
 * @author xulijiao
 */
public class AdParam {

    // 广告种类标识
    public final static String AD_KIND_WEB = "2D";
    public final static String AD_KIND_MODEL = "3D";

    // 模型广告类型
    public final static String AD_TYPE_LIGHT_BOX = "灯箱广告";
    public final static String AD_TYPE_STAND_PILLAR = "立柱广告";
    public final static String AD_TYPE_ELEC_SCREEN = "电子屏广告";
    public final static String AD_TYPE_FLOAT_BALLOON = "漂浮热气球";
    public final static String AD_TYPE_LEAFLETS = "宣传单";
    public final static String AD_TYPE_HUMAN_ANIMATION = "人物模拟动画";
    public final static String AD_TYPE_VEHICLE_ANIMATION = "交通工具动画";
    public final static String AD_TYPE_MODEL_BANNER = "横幅广告";
    public final static String AD_TYPE_WALL_POSTER = "墙面海报";

    // web广告类型
    public final static String AD_TYPE_WEB_BANNER = "通栏广告";
    public final static String AD_TYPE_SHOWCASE = "橱窗广告";
    public final static String AD_TYPE_VERNIER = "游标广告";
    public final static String AD_TYPE_EXHIBITION_BOOTH = "展台广告";
    public final static String AD_TYPE_POP_WINDOW = "弹出窗口";
    public final static String AD_TYPE_BOUTIQUE_RECOMMEND = "精品推荐";

    // 模型广告展现形式
    public final static String AD_SHOW_PICTURE = "图片";
    public final static String AD_SHOW_PASTE_ANIMATION = "贴图动画";
    public final static String AD_SHOW_VIDEO = "视频";
    public final static String AD_SHOW_PANORAMA = "360度全景";
    public final static String AD_SHOW_PATH_PANORAMA = "轨迹动画";

    // 广告显示模式
    public final static String AD_MODE_FIXED = "固定";
    public final static String AD_MODE_CAROUSEL = "轮播";
    public final static String AD_MODE_RANDOM = "随机";

    // 页面标识
    public final static String PAGE_PREVIOUS_EXHIBITION = "历届展会";
    public final static String PAGE_LOGON = "登录页面";
    public final static String PAGE_MEMBER_CENTER = "会员中心";
    public final static String HOME_PAGE = "展馆首页";

    // 场景类型
    public final static String SCENE_ENTRANCE_NAME = "场景入口";
    public final static String SCENE_INTERIOR_NAME = "场景内景";
    public final static String SCENE_ROAD_NAME = "场景道路";

    // 场景位置
    public final static String BUILDING_HALL = "展馆";
    public final static String BUILDING_METTING = "会议厅";
    public final static String BUILDING_STUDIO = "演播厅";
    public final static String BUILDING_CAFE = "咖啡厅";
    public final static String BUILDING_SERVICE_CENTER = "服务中心";
    public final static String BUILDING_3D_HALL = "3D展厅";
    public final static String BUILDING_HALL_A = "A馆";
    public final static String BUILDING_HALL_B = "B馆";
    public final static String BUILDING_HALL_C = "C馆";
    public final static String BUILDING_HALL_D = "D馆";
    public final static String BUILDING_HALL_E = "E馆";
    public final static String BUILDING_HALL_F = "F馆";
    public final static String BUILDING_HALL_G = "G馆";
    public final static String BUILDING_HALL_H = "H馆";
    public final static String BUILDING_HALL_I = "I馆";
    public final static String BUILDING_HALL_J = "J馆";
    public final static String BUILDING_HALL_K = "K馆";
    public final static String BUILDING_HALL_L = "L馆";
    public final static String BUILDING_HALL_M = "M馆";
    public final static String BUILDING_HALL_N = "N馆";
    public final static String BUILDING_HALL_O = "O馆";
    public final static String BUILDING_HALL_P = "P馆";
    public final static String BUILDING_HALL_Q = "Q馆";
    public final static String BUILDING_HALL_R = "R馆";
    public final static String BUILDING_HALL_S = "S馆";
    public final static String BUILDING_HALL_T = "T馆";
    public final static String SCENE_PATH_1 = "1号道路";
    public final static String SCENE_PATH_2 = "2号道路";
    public final static String SCENE_PATH_3 = "3号道路";
    public final static String SCENE_PATH_4 = "4号道路";
    public final static String SCENE_PATH_5 = "5号道路";
    public final static String SCENE_PATH_6 = "6号道路";
    public final static String SCENE_PATH_7 = "7号道路";
    public final static String SCENE_PATH_8 = "8号道路";
    public final static String SCENE_PATH_9 = "9号道路";
    public final static String SCENE_PATH_10 = "10号道路";
    public final static String SCENE_PATH_11 = "11号道路";
    public final static String SCENE_PATH_12 = "12号道路";
    public final static String SCENE_PATH_13 = "13号道路";
    public final static String SCENE_PATH_14 = "14号道路";
    public final static String SCENE_PATH_15 = "15号道路";
    public final static String SCENE_PATH_16 = "16号道路";
    public final static String SCENE_PATH_17 = "17号道路";
    public final static String SCENE_PATH_18 = "18号道路";
    public final static String SCENE_PATH_19 = "19号道路";
    public final static String SCENE_PATH_20 = "20号道路";

    // 获得类型（购买、赠送、推广）
    public final static String MARKET_TYPE_BUY = "购买";
    public final static String MARKET_TYPE_GIFT = "赠送";
    public final static String MARKET_TYPE_PROMOTE = "加强推广";

    // 生效标识
    public final static String VALID_FLAG = "启用";
    public final static String INVALID_FLAG = "禁用";

    /** 下划线 */
    private final static String UNDER_LINE = "_";

    /**
     * 广告种类标识
     *
     * @author xulijiao
     */
    public enum AdKind implements AdConst {
        /**
         * 2D广告标识
         */
        WEB(AdConst.WALL_POSTER, AD_KIND_WEB),
        /**
         * 3D广告标识
         */
        MODEL(AdConst.MODEL, AD_KIND_MODEL);

        private String key;
        private String value;

        private AdKind(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 模型广告位置编号
     *
     * @author xulijiao
     */
    public enum AdPosition implements AdConst {
        /**
         * 入口位置编号
         */
        ENT(AdConst.SCENE_ENTRANCE, POS_ENT),
        /**
         * 内景位置编号
         */
        INT(AdConst.SCENE_INTERIOR, POS_INT),

        /**
         * 道路位置编号
         */
        PATH(AdConst.SCENE_ROAD, POS_PATH);

        private String key;
        private String value;

        private AdPosition(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 入口广告个数
     *
     * @author xulijiao
     */
    public enum AdEntCnt implements AdConst {
        /**
         * 灯箱广告
         */
        CNT_LAMP(AdConst.LAMP, ENT_LAMP_NUM),
        /**
         * 立柱广告
         */
        CNT_COLUMN(AdConst.COLUMN, ENT_COLUMN_NUM),
        /**
         * 电子屏广告
         */
        CNT_ELEC_SCREEN(AdConst.ELEC_SCREEN, ENT_ELEC_SCREEN_NUM),
        /**
         * 漂浮热气球
         */
        CNT_FLOAT_BALLOON(AdConst.FLOAT_BALLOON, ENT_FLOAT_BALLOON_NUM),
        /**
         * 宣传单
         */
        CNT_LEAFLETS(AdConst.LEAFLETS, ENT_LEAFLETS_NUM),
        /**
         * 人模动画
         */
        CNT_HUMAN_ANIMATION(AdConst.HUMAN_ANIMATION, ENT_HUMAN_ANIMATION_NUM),
        /**
         * 交通工具动画
         */
        CNT_VEHICLE_ANIMATION(AdConst.VEHICLE_ANIMATION, ENT_VEHICLE_ANIMATION_NUM);

        private String key;
        private Integer value;

        private AdEntCnt(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

    }

    /**
     * 入口广告个数
     *
     * @author xulijiao
     */
    public enum AdIntCnt implements AdConst {
        /**
         * 横幅广告
         */
        CNT_BANNER3(AdConst.BANNER3, INT_BANNER3_NUM),
        /**
         * 墙面海报
         */
        CNT_WALL_POSTER(AdConst.WALL_POSTER, INT_WALL_POSTER_NUM),
        /**
         * 电子屏
         */
        CNT_ELEC_SCREEN(AdConst.ELEC_SCREEN, INT_ELEC_SCREEN_NUM),
        /**
         * 人模动画
         */
        CNT_HUMAN_ANIMATION(AdConst.HUMAN_ANIMATION, INT_HUMAN_ANIMATION_NUM);

        private String key;
        private Integer value;

        private AdIntCnt(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

    }

    /**
     * 道路广告个数
     *
     * @author xulijiao
     */
    public enum AdPathCnt implements AdConst {
        /**
         * 灯箱
         */
        CNT_LAMP(AdConst.LAMP, PATH_LAMP_NUM);

        private String key;
        private Integer value;

        private AdPathCnt(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

    }

    /**
     * web广告类型
     *
     * @author xulijiao
     */
    public enum AdTypeWeb implements AdConst {
        /**
         * 通栏广告
         */
        BANNER(AdConst.BANNER2, AD_TYPE_WEB_BANNER),
        /**
         * 橱窗广告
         */
        SHOWCASE(AdConst.SHOWCASE, AD_TYPE_SHOWCASE),
        /**
         * 游标广告
         */
        VERNIER(AdConst.VERNIER, AD_TYPE_VERNIER),
        /**
         * 展台广告
         */
        EXHIBITION_BOOTH(AdConst.EXB_BOOTH, AD_TYPE_EXHIBITION_BOOTH),
        /**
         * 弹出窗口
         */
        POP_WINDOW(AdConst.POP_UP_WIN, AD_TYPE_POP_WINDOW),
        /**
         * 精品推荐
         */
        BOUTIQUE_RECOMMEND(AdConst.BOUTIQUE_RECOMMEND, AD_TYPE_BOUTIQUE_RECOMMEND);

        private String key;
        private String value;

        private AdTypeWeb(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 模型广告类型
     *
     * @author xulijiao
     */
    public enum AdTypeModel implements AdConst {
        /**
         * 灯箱广告
         */
        LIGHT_BOX(AdConst.LAMP, AD_TYPE_LIGHT_BOX),
        /**
         * 立柱广告
         */
        STAND_PILLAR(AdConst.COLUMN, AD_TYPE_STAND_PILLAR),
        /**
         * 电子屏广告
         */
        ELEC_SCREEN(AdConst.ELEC_SCREEN, AD_TYPE_ELEC_SCREEN),
        /**
         * 漂浮热气球
         */
        FLOAT_BALLOON(AdConst.FLOAT_BALLOON, AD_TYPE_FLOAT_BALLOON),
        /**
         * 宣传单
         */
        LEAFLETS(AdConst.LEAFLETS, AD_TYPE_LEAFLETS),
        /**
         * 人模动画
         */
        HUMAN_ANIMATION(AdConst.HUMAN_ANIMATION, AD_TYPE_HUMAN_ANIMATION),
        /**
         * 交通工具动画
         */
        VEHICLE_ANIMATION(AdConst.VEHICLE_ANIMATION, AD_TYPE_VEHICLE_ANIMATION),
        /**
         * 横幅广告
         */
        BANNER(AdConst.BANNER3, AD_TYPE_MODEL_BANNER),
        /**
         * 墙面海报
         */
        WALL_POSTER(AdConst.WALL_POSTER, AD_TYPE_WALL_POSTER);

        private String key;
        private String value;

        private AdTypeModel(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 广告显示模式
     *
     * @author xulijiao
     */
    public enum AdMode implements AdConst {
        /**
         * 固定
         */
        FIXED(AdConst.FIXED, AD_MODE_FIXED),
        /**
         * 轮播
         */
        CAROUSEL(AdConst.CAROUSEL, AD_MODE_CAROUSEL),
        /**
         * 随机
         */
        RANDOM(AdConst.RANDOM, AD_MODE_RANDOM);

        private String key;
        private String value;

        private AdMode(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 广告展现形式
     *
     * @author xulijiao
     */
    public enum AdShow implements AdConst {
        /**
         * 图片
         */
        PICTURE(AdConst.PICTURE, AD_SHOW_PICTURE),
        /**
         * 贴图动画
         */
        PASTE_ANIMATION(AdConst.PASTE_ANIMATION, AD_SHOW_PASTE_ANIMATION),
        /**
         * 视频
         */
        VIDEO(AdConst.VIDEO, AD_SHOW_VIDEO),
        /**
         * 360全景
         */
        PANORAMA(AdConst.PANORAMA, AD_SHOW_PANORAMA),
        /**
         * 轨迹动画
         */
        PATH_PANORAMA(AdConst.PATH_PANORAMA, AD_SHOW_PATH_PANORAMA);

        private String key;
        private String value;

        private AdShow(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 页面标识
     *
     * @author xulijiao
     */
    public enum PageType implements AdConst {
        /**
         * 历届展会
         */
        PREVIOUS_EXHIBITION(AdConst.PREVIOUS_EXB, PAGE_PREVIOUS_EXHIBITION),
        /**
         * 登录页面
         */
        LOGON(AdConst.LOGIN_PAGE, PAGE_LOGON),
        /**
         * 会员中心
         */
        MEMBER_CENTER(AdConst.MEMBER_CENTER, PAGE_MEMBER_CENTER),


        HOME_PAGE(AdConst.HOME_PAGE, AdParam.HOME_PAGE);


        private String key;
        private String value;

        private PageType(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 场景位置标识
     *
     * @author xulijiao
     */
    public enum ScenePos implements AdConst {
        /**
         * 场景入口
         */
        ENTRANCE(AdConst.SCENE_ENTRANCE, SCENE_ENTRANCE_NAME),
        /**
         * 场景内景
         */
        INTERIOR(AdConst.SCENE_INTERIOR, SCENE_INTERIOR_NAME),
        /**
         * 场景过道
         */
        AISLE(AdConst.SCENE_ROAD, SCENE_ROAD_NAME);

        private String key;
        private String value;

        private ScenePos(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 文件类型（后缀名）
     *
     * @author xulijiao
     */
    public enum FileType implements AdConst {
        JPG("1", "JPG"), JPEG("2", "JPEG"), PNG("3", "PNG"), GIF("4", "GIF"), SWF("5", "SWF"), WMV("6", "WMV"), AVI(
                "7", "AVI");

        private String key;
        private String value;

        private FileType(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 营销类型
     *
     * @author xulijiao
     */
    public enum MarketType implements AdConst {
        /**
         * 购买
         */
        BUY(AdConst.BUY, MARKET_TYPE_BUY),
        /**
         * 赠送
         */
        GIFT(AdConst.GIFT, MARKET_TYPE_GIFT),
        /**
         * 推广
         */
        PROMOTE(AdConst.PROMOTE, MARKET_TYPE_PROMOTE);

        private String key;
        private String value;

        private MarketType(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 有效、无效标识
     */
    public enum ValidFlag implements AdConst {
        /** 有效 */
        VALID(OverallConst.EFFECTIVE, VALID_FLAG),
        /** 无效 */
        INVALID(OverallConst.INVALID, INVALID_FLAG);
        private String key;
        private String value;

        private ValidFlag(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 模型广告类型与模式对应关系
     *
     * @author xulijiao
     */
    public enum ModelTypeModeMapping implements AdConst {
        /**
         * 场景入口 灯箱广告 模式
         */
        ENTRANCE_LIGHT_BOX_FIXED(ScenePos.ENTRANCE, AdTypeModel.LIGHT_BOX, AdMode.FIXED),

        ENTRANCE_LIGHT_BOX_RANDOM(ScenePos.ENTRANCE, AdTypeModel.LIGHT_BOX, AdMode.RANDOM),

        ENTRANCE_LIGHT_BOX_CAROUSEL(ScenePos.ENTRANCE, AdTypeModel.LIGHT_BOX, AdMode.CAROUSEL),
        /**
         * 场景入口 立柱广告 模式
         */
        ENTRANCE_STAND_PILLAR_FIXED(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdMode.FIXED),

        ENTRANCE_STAND_PILLAR_RANDOM(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdMode.RANDOM),

        ENTRANCE_STAND_PILLAR_CAROUSEL(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdMode.CAROUSEL),
        /**
         * 场景入口电子屏广告 模式
         */
        ENTRANCE_ELEC_SCREEN_FIXED(ScenePos.ENTRANCE, AdTypeModel.ELEC_SCREEN, AdMode.FIXED),

        ENTRANCE_ELEC_SCREEN_RANDOM(ScenePos.ENTRANCE, AdTypeModel.ELEC_SCREEN, AdMode.RANDOM),

        ENTRANCE_ELEC_SCREEN_CAROUSEL(ScenePos.ENTRANCE, AdTypeModel.ELEC_SCREEN, AdMode.CAROUSEL),
        /**
         * 场景入口 漂浮热气球广告 模式
         */
        ENTRANCE_FLOAT_BALLOON_FIXED(ScenePos.ENTRANCE, AdTypeModel.FLOAT_BALLOON, AdMode.FIXED),

        ENTRANCE_FLOAT_BALLOON_RANDOM(ScenePos.ENTRANCE, AdTypeModel.FLOAT_BALLOON, AdMode.RANDOM),

        ENTRANCE_FLOAT_BALLOON_CAROUSEL(ScenePos.ENTRANCE, AdTypeModel.FLOAT_BALLOON, AdMode.CAROUSEL),
        /**
         * 场景入口 宣传单广告 模式
         */
        ENTRANCE_LEAFLETS_FIXED(ScenePos.ENTRANCE, AdTypeModel.LEAFLETS, AdMode.FIXED),

        ENTRANCE_LEAFLETS_RANDOM(ScenePos.ENTRANCE, AdTypeModel.LEAFLETS, AdMode.RANDOM),
        /**
         * 场景入口 人模动画广告 模式
         */
        HUMAN_ANIMATION_FIXED(ScenePos.ENTRANCE, AdTypeModel.HUMAN_ANIMATION, AdMode.FIXED),

        ENTRANCE_HUMAN_ANIMATION_RANDOM(ScenePos.ENTRANCE, AdTypeModel.HUMAN_ANIMATION, AdMode.RANDOM),
        /**
         * 场景入口 交通工具广告 模式
         */
        ENTRANCE_VEHICLE_ANIMATION_FIXED(ScenePos.ENTRANCE, AdTypeModel.VEHICLE_ANIMATION, AdMode.FIXED),

        ENTRANCE_VEHICLE_ANIMATION_RANDOM(ScenePos.ENTRANCE, AdTypeModel.VEHICLE_ANIMATION, AdMode.RANDOM),
        /**
         * 场景内景横幅广告 模式
         */
        INTERIOR_BANNER_FIXED(ScenePos.INTERIOR, AdTypeModel.BANNER, AdMode.FIXED),
        /**
         * 场景内景墙面海报广告 模式
         */
        INTERIOR_WALL_POSTER_FIXED(ScenePos.INTERIOR, AdTypeModel.WALL_POSTER, AdMode.FIXED),

        INTERIOR_WALL_POSTER_RANDOM(ScenePos.INTERIOR, AdTypeModel.WALL_POSTER, AdMode.RANDOM),
        /**
         * 场景内景电子屏广告 模式
         */
        INTERIOR_ELEC_SCREEN_FIXED(ScenePos.INTERIOR, AdTypeModel.ELEC_SCREEN, AdMode.FIXED),

        INTERIOR_ELEC_SCREEN_RANDOM(ScenePos.INTERIOR, AdTypeModel.ELEC_SCREEN, AdMode.RANDOM),
        /**
         * 场景内景人模动画广告 模式
         */
        INTERIOR_HUMAN_ANIMATION_FIXED(ScenePos.INTERIOR, AdTypeModel.HUMAN_ANIMATION, AdMode.FIXED),

        INTERIOR_HUMAN_ANIMATION_RANDOM(ScenePos.INTERIOR, AdTypeModel.HUMAN_ANIMATION, AdMode.RANDOM),
        /**
         * 场景过道灯箱广告 模式
         */
        AISLE_LIGHT_BOX_FIXED(ScenePos.AISLE, AdTypeModel.LIGHT_BOX, AdMode.FIXED),

        AISLE_LIGHT_BOX_RANDOM(ScenePos.AISLE, AdTypeModel.LIGHT_BOX, AdMode.RANDOM);

        private ScenePos pos;
        private AdTypeModel key;
        private AdMode value;

        private ModelTypeModeMapping(ScenePos pos, AdTypeModel key, AdMode value) {
            this.pos = pos;
            this.key = key;
            this.value = value;
        }

        public ScenePos getPos() {
            return pos;
        }

        public AdTypeModel getKey() {
            return key;
        }

        public AdMode getValue() {
            return value;
        }

    }

    /**
     * Web广告类型与模式对应关系
     *
     * @author xulijiao
     */
    public enum WebTypeModeMapping implements AdConst {
        /**
         * 通栏广告模式
         */
        BANNER_FIXED(AdTypeWeb.BANNER, AdMode.FIXED),

        BANNER_RANDOM(AdTypeWeb.BANNER, AdMode.RANDOM),

        BANNER_CAROUSEL(AdTypeWeb.BANNER, AdMode.CAROUSEL),
        /**
         * 精品推荐广告模式
         */
        BOUTIQUE_RECOMMEND_FIXED(AdTypeWeb.BOUTIQUE_RECOMMEND, AdMode.FIXED),

        BOUTIQUE_RECOMMEND_RANDOM(AdTypeWeb.BOUTIQUE_RECOMMEND, AdMode.RANDOM),
        /**
         * 橱窗广告模式
         */
        SHOWCASE_FIXED(AdTypeWeb.SHOWCASE, AdMode.FIXED),

        SHOWCASE_RANDOM(AdTypeWeb.SHOWCASE, AdMode.RANDOM),

        SHOWCASE_CAROUSEL(AdTypeWeb.SHOWCASE, AdMode.CAROUSEL),
        /**
         * 展台广告模式
         */
        EXHIBITION_BOOTH_FIXED(AdTypeWeb.EXHIBITION_BOOTH, AdMode.FIXED),

        /**
         * 弹出窗口广告模式
         */
        POP_WINDOW_FIXED(AdTypeWeb.POP_WINDOW, AdMode.FIXED),

        POP_WINDOW_RANDOM(AdTypeWeb.POP_WINDOW, AdMode.RANDOM),
        /**
         * 游标广告模式
         */
        VERNIER_FIXED(AdTypeWeb.VERNIER, AdMode.FIXED),

        VERNIER_RANDOM(AdTypeWeb.VERNIER, AdMode.RANDOM);

        private AdTypeWeb key;
        private AdMode value;

        private WebTypeModeMapping(AdTypeWeb key, AdMode value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public AdTypeWeb getKey() {
            return key;
        }

        public AdMode getValue() {
            return value;
        }

    }

    /**
     * Web广告类型与文件类型对应关系
     *
     * @author xulijiao
     */
    public enum WebTypeFileMapping implements AdConst {
        /**
         * 通栏广告文件类型
         */
        // BANNER_GIF(AdTypeWeb.BANNER, FileType.GIF),

        BANNER_JPEG(AdTypeWeb.BANNER, FileType.JPEG),

        BANNER_JPG(AdTypeWeb.BANNER, FileType.JPG),

        BANNER_SWF(AdTypeWeb.BANNER, FileType.SWF),
        /**
         * 橱窗广告文件类型
         */
        SHOWCASE_JPG(AdTypeWeb.SHOWCASE, FileType.JPG),

        SHOWCASE_JPEG(AdTypeWeb.SHOWCASE, FileType.JPEG),
        /**
         * 精品推荐广告文件类型
         */
        BOUTIQUE_RECOMMEND_JPG(AdTypeWeb.BOUTIQUE_RECOMMEND, FileType.JPG),

        BOUTIQUE_RECOMMEND_JPEG(AdTypeWeb.BOUTIQUE_RECOMMEND, FileType.JPEG),
        /**
         * 展台广告文件类型
         */
        EXHIBITION_BOOTH_JPG(AdTypeWeb.EXHIBITION_BOOTH, FileType.JPG),

        EXHIBITION_BOOTH_JPEG(AdTypeWeb.EXHIBITION_BOOTH, FileType.JPEG),
        /**
         * 弹出窗口文件类型
         */
        // POP_WINDOW_GIF(AdTypeWeb.POP_WINDOW, FileType.GIF),

        POP_WINDOW_JPG(AdTypeWeb.POP_WINDOW, FileType.JPG),

        POP_WINDOW_JPEG(AdTypeWeb.POP_WINDOW, FileType.JPEG),

        POP_WINDOW_SWF(AdTypeWeb.POP_WINDOW, FileType.SWF),
        /**
         * 游标广告文件类型
         */
        VERNIER_JPEG(AdTypeWeb.VERNIER, FileType.JPEG),

        VERNIER_JPG(AdTypeWeb.VERNIER, FileType.JPG);

        private AdTypeWeb key;
        private FileType value;

        private WebTypeFileMapping(AdTypeWeb key, FileType value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public AdTypeWeb getKey() {
            return key;
        }

        public FileType getValue() {
            return value;
        }

    }

    /**
     * 模型广告类型与展现形式对应关系
     *
     * @author xulijiao
     */
    public enum ModelTypeShowMapping implements AdConst {
        /**
         * 场景入口 灯箱 广告展现形式
         */
        ENTRANCE_LIGHT_BOX_ANIMATION(ScenePos.ENTRANCE, AdTypeModel.LIGHT_BOX, AdShow.PASTE_ANIMATION),
        /**
         * 场景入口 立柱 广告展现形式
         */
        ENTRANCE_STAND_PILLAR_PICTURE(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdShow.PICTURE),

        ENTRANCE_STAND_PILLAR_VIDEO(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdShow.VIDEO),

        ENTRANCE_STAND_PILLAR_ANIMATION(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdShow.PASTE_ANIMATION),

        ENTRANCE_STAND_PILLAR_PANORAMA(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR, AdShow.PANORAMA),
        /**
         * 场景入口 电子屏 广告展现形式
         */
        ENTRANCE_ELEC_SCREEN_VIDEO(ScenePos.ENTRANCE, AdTypeModel.ELEC_SCREEN, AdShow.VIDEO),

        ENTRANCE_ELEC_SCREEN_PANORAMA(ScenePos.ENTRANCE, AdTypeModel.ELEC_SCREEN, AdShow.PANORAMA),
        /**
         * 场景入口 漂浮热气球 广告展现形式
         */
        ENTRANCE_FLOAT_BALLOON_PICTURE(ScenePos.ENTRANCE, AdTypeModel.FLOAT_BALLOON, AdShow.PICTURE),

        ENTRANCE_FLOAT_BALLOON_ANIMATION(ScenePos.ENTRANCE, AdTypeModel.FLOAT_BALLOON, AdShow.PATH_PANORAMA),
        /**
         * 场景入口 宣传单 广告展现形式
         */
        ENTRANCE_LEAFLETS_PICTURE(ScenePos.ENTRANCE, AdTypeModel.LEAFLETS, AdShow.PICTURE),
        /**
         * 场景入口 人模动画 广告展现形式
         */
        ENTRANCE_HUMAN_ANIMATION_PASTE_ANIMATION(ScenePos.ENTRANCE, AdTypeModel.HUMAN_ANIMATION, AdShow.PASTE_ANIMATION),
        /**
         * 场景入口 交通工具 广告展现形式
         */
        ENTRANCE_VEHICLE_ANIMATION_PICTURE(ScenePos.ENTRANCE, AdTypeModel.VEHICLE_ANIMATION, AdShow.PICTURE),

        ENTRANCE_VEHICLE_ANIMATION_PATH_PANORAMA(ScenePos.ENTRANCE, AdTypeModel.VEHICLE_ANIMATION, AdShow.PATH_PANORAMA),
        /**
         * 场景内景 横幅 广告展现形式
         */
        INTERIOR_BANNER_PASTE_ANIMATION(ScenePos.INTERIOR, AdTypeModel.BANNER, AdShow.PASTE_ANIMATION),
        /**
         * 场景内景 墙面海报 广告展现形式
         */
        INTERIOR_WALL_POSTER_PASTE_ANIMATION(ScenePos.INTERIOR, AdTypeModel.WALL_POSTER, AdShow.PASTE_ANIMATION),
        /**
         * 场景内景 电子屏 广告展现形式
         */
        INTERIOR_ELEC_SCREEN_VIDEO(ScenePos.INTERIOR, AdTypeModel.ELEC_SCREEN, AdShow.VIDEO),
        /**
         * 场景内景 人模动画 广告展现形式
         */
        INTERIOR_HUMAN_ANIMATION_PASTE_ANIMATION(ScenePos.INTERIOR, AdTypeModel.HUMAN_ANIMATION, AdShow.PASTE_ANIMATION),
        /**
         * 场景过道 灯箱 广告展现形式
         */
        AISLE_LIGHT_BOX_ANIMATION(ScenePos.AISLE, AdTypeModel.LIGHT_BOX, AdShow.PASTE_ANIMATION);

        private ScenePos pos;
        private AdTypeModel key;
        private AdShow value;

        private ModelTypeShowMapping(ScenePos pos, AdTypeModel key, AdShow value) {
            this.pos = pos;
            this.key = key;
            this.value = value;
        }

        public ScenePos getPos() {
            return pos;
        }

        public AdTypeModel getKey() {
            return key;
        }

        public AdShow getValue() {
            return value;
        }
    }

    /**
     * 模型广告展现形式与文件类型对应关系
     *
     * @author xulijiao
     */
    public enum ModelShowFileMapping implements AdConst {
        /**
         * 360全景文件类型
         */
        PANORAMA_JPG(AdShow.PANORAMA, FileType.SWF),
        /**
         * 贴图动画文件类型
         */
        PASTE_ANIMATION_JPG(AdShow.PASTE_ANIMATION, FileType.JPG),

        PASTE_ANIMATION_JPEG(AdShow.PASTE_ANIMATION, FileType.JPEG),

        /**
         * 轨迹动画文件类型
         */
        PATH_PANORAMA_JPG(AdShow.PATH_PANORAMA, FileType.JPG),

        PATH_PANORAMA_JPEG(AdShow.PATH_PANORAMA, FileType.JPEG),

        /**
         * 图片文件类型
         */
        PICTURE_JPG(AdShow.PICTURE, FileType.JPG),

        PICTURE_JPEG(AdShow.PICTURE, FileType.JPEG),

        /**
         * 视频文件类型
         */
        VIDEO_WMV(AdShow.VIDEO, FileType.WMV);

        private AdShow key;
        private FileType value;

        private ModelShowFileMapping(AdShow key, FileType value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public AdShow getKey() {
            return key;
        }

        public FileType getValue() {
            return value;
        }

    }

    /**
     * 模型场景方位与广告类型对应关系
     *
     * @author xulijiao
     */
    public enum ModelSceneTypeMapping implements AdConst {
        /**
         * 场景入口 灯箱广告
         */
        ENTRANCE_LIGHT_BOX(ScenePos.ENTRANCE, AdTypeModel.LIGHT_BOX),
        /**
         * 场景入口 立柱广告
         */
        ENTRANCE_STAND_PILLAR(ScenePos.ENTRANCE, AdTypeModel.STAND_PILLAR),
        /**
         * 场景入口电子屏广告
         */
        ENTRANCE_ELEC_SCREEN(ScenePos.ENTRANCE, AdTypeModel.ELEC_SCREEN),
        /**
         * 场景入口 漂浮热气球广告
         */
        ENTRANCE_FLOAT_BALLOON(ScenePos.ENTRANCE, AdTypeModel.FLOAT_BALLOON),
        /**
         * 场景入口 宣传单广告
         */
        ENTRANCE_LEAFLETS(ScenePos.ENTRANCE, AdTypeModel.LEAFLETS),
        /**
         * 场景入口 人模动画广告
         */
        ENTRANCE_HUMAN_ANIMATION(ScenePos.ENTRANCE, AdTypeModel.HUMAN_ANIMATION),
        /**
         * 场景入口 交通工具广告
         */
        ENTRANCE_VEHICLE_ANIMATION(ScenePos.ENTRANCE, AdTypeModel.VEHICLE_ANIMATION),
        /**
         * 场景内景横幅广告
         */
        INTERIOR_BANNER(ScenePos.INTERIOR, AdTypeModel.BANNER),
        /**
         * 场景内景墙面海报广告
         */
        INTERIOR_WALL_POSTER(ScenePos.INTERIOR, AdTypeModel.WALL_POSTER),
        /**
         * 场景内景电子屏广告
         */
        INTERIOR_ELEC_SCREEN(ScenePos.INTERIOR, AdTypeModel.ELEC_SCREEN),
        /**
         * 场景内景人模动画广告
         */
        INTERIOR_HUMAN_ANIMATION(ScenePos.INTERIOR, AdTypeModel.HUMAN_ANIMATION),
        /**
         * 场景过道灯箱广告
         */
        AISLE_LIGHT_BOX(ScenePos.AISLE, AdTypeModel.LIGHT_BOX);

        private ScenePos key;
        private AdTypeModel value;

        private ModelSceneTypeMapping(ScenePos key, AdTypeModel value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public ScenePos getKey() {
            return key;
        }

        public AdTypeModel getValue() {
            return value;
        }
    }

    /**
     * web页面标识与广告类型对应关系
     *
     * @author xulijiao
     */
    public enum WebPageTypeMapping implements AdConst {
        /**
         * 历届展会
         */
        PREVIOUS_EXHIBITION_BANNER(PageType.PREVIOUS_EXHIBITION, AdTypeWeb.BANNER),
        /**
         * 历届展会
         */
        PREVIOUS_EXHIBITION_SHOWCASE(PageType.PREVIOUS_EXHIBITION, AdTypeWeb.SHOWCASE),
        /**
         * 历届展会
         */
        PREVIOUS_EXHIBITION_VERNIER(PageType.PREVIOUS_EXHIBITION, AdTypeWeb.VERNIER),
        /**
         * 历届展会
         */
        PREVIOUS_EXHIBITION_EXB_BOOTH(PageType.PREVIOUS_EXHIBITION, AdTypeWeb.EXHIBITION_BOOTH),
        /**
         * 历届展会
         */
        PREVIOUS_EXHIBITION_POP_WINDOW(PageType.PREVIOUS_EXHIBITION, AdTypeWeb.POP_WINDOW),
        /**
         * 登录页面
         */
        LOGON_BOUTIQUE_RECOMMEND(PageType.LOGON, AdTypeWeb.BOUTIQUE_RECOMMEND),
        /**
         * 会员中心 通栏
         */
        MEMBER_CENTER_BANNER(PageType.MEMBER_CENTER, AdTypeWeb.BANNER),
        /**
         * 会员中心 橱窗
         */
        MEMBER_CENTER_SHOWCASE(PageType.MEMBER_CENTER, AdTypeWeb.SHOWCASE),
        /**
         * 会员中心 展台
         */
        MEMBER_CENTER_EXB_BOOTH(PageType.MEMBER_CENTER, AdTypeWeb.EXHIBITION_BOOTH),

        HOME_PAGE(PageType.HOME_PAGE, AdTypeWeb.BOUTIQUE_RECOMMEND);

        private PageType key;
        private AdTypeWeb value;

        private WebPageTypeMapping(PageType key, AdTypeWeb value) {
            this.key = key;
            this.value = value;
        }

        public String getPos() {
            return "";
        }

        public PageType getKey() {
            return key;
        }

        public AdTypeWeb getValue() {
            return value;
        }
    }

    /**
     * 根据value值获取枚举数组中对应枚举常量
     *
     * @param enums
     * @param value
     * @return 对应枚举常量
     */
    public static AdConst getEnumConstByValue(AdConst[] enums, String value) {
        AdConst obj = null;
        for (AdConst e : enums) {
            if (e.getValue().equals(value)) {
                obj = e;
                break;
            }
        }
        return obj;
    }

    /**
     * 根据key值获取枚举数组中对应枚举常量
     *
     * @param enums
     * @param key
     * @return 对应枚举常量
     */
    public static AdConst getEnumConstByKey(AdConst[] enums, String key) {
        AdConst obj = null;
        for (AdConst e : enums) {
            if (e.getKey().equals(key)) {
                obj = e;
                break;
            }
        }
        return obj;
    }

    /**
     * 将枚举数组转换成list存储模式
     *
     * @param enums
     * @return
     */
    public static List<AdConst> getEnumConstList(AdConst[] enums) {
        List<AdConst> list = new ArrayList<AdConst>();
        for (AdConst e : enums) {
            list.add(e);
        }
        return list;
    }

    /**
     * 将枚举数组存储于map容器中，key值为pos_key字符串
     *
     * @param enums
     * @return
     */
    public static Map<String, List<AdConst>> getMapping(AdConst[] enums) {
        String containsKey = "";
        Map<String, List<AdConst>> mapping = new HashMap<String, List<AdConst>>();
        for (AdConst e : enums) {
            containsKey = getKey(e);
            if (!mapping.containsKey(containsKey)) {
                mapping.put(containsKey, getAdConstList());
            }
            List<AdConst> list = mapping.get(containsKey);
            if ((e.getValue() instanceof AdConst) && !list.contains(e.getValue())) {
                list.add((AdConst) e.getValue());
            }
        }
        return mapping;
    }

    /**
     * 根据pos_key字符串获取对应枚举list，如果pos为null则根据_key获取对应枚举list
     *
     * @param enums
     * @param pos
     * @param key
     * @return
     */
    public static List<AdConst> getEnumConstList(AdConst[] enums, String pos, String key) {
        Map<String, List<AdConst>> mapping = getMapping(enums);
        String keyStr = getKey(pos, key);
        return mapping.containsKey(keyStr) ? mapping.get(keyStr) : getAdConstList();
    }

    /**
     * 创建存储广告模式的空list容器
     *
     * @return
     */
    private static List<AdConst> getAdConstList() {
        return new ArrayList<AdConst>();
    }

    /**
     * 构建map的key值
     *
     * @param e
     * @return
     */
    private static String getKey(AdConst e) {
        Object p = e.getPos();
        Object k = e.getKey();
        if (p instanceof AdConst) {
            p = ((AdConst) p).getKey();
        }
        if (k instanceof AdConst) {
            k = ((AdConst) k).getKey();
        }
        return null != e ? (p + UNDER_LINE + k) : "";
    }

    /**
     * 构建map的key值
     *
     * @param pos
     * @param key
     * @return
     */
    private static String getKey(String pos, String key) {
        return StringUtils.trimToEmpty(pos) + UNDER_LINE + StringUtils.trimToEmpty(key);
    }

    /**
     * 获取营销类型枚举数组
     *
     * @return
     */
    public static AdConst[] getMarketTypeConstArray() {
        return MarketType.values();
    }

    /**
     * 获取广告种类枚举数组
     *
     * @return
     */
    public static AdConst[] getAdKindConstArray() {
        return AdKind.values();
    }

    /**
     * 获取web广告类型枚举数组
     *
     * @return
     */
    public static AdConst[] getAdTypeWebConstArray() {
        return AdTypeWeb.values();
    }

    /**
     * 获取模型广告类型枚举数组
     *
     * @return
     */
    public static AdConst[] getAdTypeModelConstArray() {
        return AdTypeModel.values();
    }

    /**
     * 获取广告模式枚举数组
     *
     * @return
     */
    public static AdConst[] getAdModeConstArray() {
        return AdMode.values();
    }

    /**
     * 获取广告展现形式枚举数组
     *
     * @return
     */
    public static AdConst[] getAdShowConstArray() {
        return AdShow.values();
    }

    /**
     * 获取页面标识枚举数组
     *
     * @return
     */
    public static AdConst[] getPageTypeConstArray() {
        return PageType.values();
    }

    /**
     * 获取场景位置标识枚举数组
     *
     * @return
     */
    public static AdConst[] getScenePosConstArray() {
        return ScenePos.values();
    }

    /**
     * 获取文件类型标识枚举数组
     *
     * @return
     */
    public static AdConst[] getFileTypeConstArray() {
        return FileType.values();
    }

    /**
     * 获取模型广告类型与广告模式对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getModelTypeModeMappingConstArray() {
        return ModelTypeModeMapping.values();
    }

    /**
     * 获取Web广告类型与广告模式对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getWebTypeModeMappingConstArray() {
        return WebTypeModeMapping.values();
    }

    /**
     * 获取Web广告类型与广告模式对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getWebTypeFileMappingConstArray() {
        return WebTypeFileMapping.values();
    }

    /**
     * 获取模型广告类型与展现形式对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getModelTypeShowMappingConstArray() {
        return ModelTypeShowMapping.values();
    }

    /**
     * 获取模型广告展现形式与文件类型对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getModelShowFileMappingConstArray() {
        return ModelShowFileMapping.values();
    }

    /**
     * 获取模型场景方位与广告类型对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getModelSceneTypeMappingConstArray() {
        return ModelSceneTypeMapping.values();
    }

    /**
     * 获取页面标识与广告类型对应关系枚举数组
     *
     * @return
     */
    public static AdConst[] getWebPageTypeMappingConstArray() {
        return WebPageTypeMapping.values();
    }

    /**
     * 获取ValidFlag枚举数组
     *
     * @return
     */
    public static AdConst[] getValidFlagConstArray() {
        return ValidFlag.values();
    }

}
