/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

/**
 * 会员服务
 *
 * @author xulijiao
 */
public interface MemberServiceConst {
    /** 广告 */
    public static final String SERVICE_TYPE_ADVERTISING = "AD";
    /** 会议室 */
    public static final String SERVICE_TYPE_MEETING_ROOM = "MEETING_ROOM";
    /** 直播室 */
    public static final String SERVICE_TYPE_LIVE_ROOM = "LIVE_ROOM";
    /** 产品数量 */
    public static final String SERVICE_TYPE_PRODUCT_COUNT = "PROD_CNT";
    /** 媒体库容量(单位KB) */
    public static final String SERVICE_TYPE_LIB_SIZE = "MEDIA_CAP";
    /** 图册 */
    public static final String SERVICE_TYPE_ATLAS = "ATLAS_CNT";
    /** 标装展台 */
    public static final String SERVICE_TYPE_STANDARD = "BOOTH_STANDARD";
    /** 精装展台 */
    public static final String SERVICE_TYPE_HARDBACK = "BOOTH_HARDBACK";
    /** 豪装展台 */
    public static final String SERVICE_TYPE_LUXURY = "BOOTH_LUXURY";
    /** 海报 */
    public static final String SERVICE_TYPE_POSTER = "POSTER";
    /** 易拉宝 */
    public static final String SERVICE_TYPE_ROLL = "ROLL_UP";
    /** 灯箱 */
    public static final String SERVICE_TYPE_LIGHT_BOX = "LIGHT_BOX";
    /** 3D产品 */
    public static final String SERVICE_TYPE_3D_PRODUCT = "3D_PROD_MODEL";
    /** 实名认证 */
    public static final String SERVICE_TYPE_REALNAME_AUTH = "REALNAME_AUTH";
    /** 产品视频 */
    public static final String SERVICE_TYPE_PRODUCT_VIDEO = "PRODUCT_VIDEO";
    /** 企业视频 */
    public static final String SERVICE_TYPE_CORPORATE_VIDEO = "CORPORATE_VIDEO";
    /** 演播厅视频 */
    public static final String SERVICE_TYPE_STUDIO_VIDEO = "TV_VODEO";
    /** 360全景 */
    public static final String SERVICE_TYPE_360_PANORAMA = "360_PANORAMA";
    /** 参展人员 */
    public static final String SERVICE_TYPE_EXHIBITORS = "EXHIBITORS";

    /** 服务类型 */
    public String getType();

    /** 服务容量/数量 */
    public Integer getCapacity();
}

