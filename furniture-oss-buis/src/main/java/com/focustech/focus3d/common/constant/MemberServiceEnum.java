/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;
/**
 * MemberServiceEnum.java
 *
 * @author xulijiao
 */
public class MemberServiceEnum {
    /** 标装展台套装服务 */
    public enum StandardServiceEnum implements MemberServiceConst {
        REALNAME_AUTH(MemberServiceConst.SERVICE_TYPE_REALNAME_AUTH, 1),

        PRODUCT_COUNT(MemberServiceConst.SERVICE_TYPE_PRODUCT_COUNT, 50),

        LIB_SIZE(MemberServiceConst.SERVICE_TYPE_LIB_SIZE, 512000),

        ATLAS(MemberServiceConst.SERVICE_TYPE_ATLAS, 4),

        // PRODUCT_VIDEO(MemberServiceConst.SERVICE_TYPE_PRODUCT_VIDEO, 1),
        //
        // CORPORATE_VIDEO(MemberServiceConst.SERVICE_TYPE_CORPORATE_VIDEO, 1),

        EXHIBITORS(MemberServiceConst.SERVICE_TYPE_EXHIBITORS, 4);

        // 以下服务与展台相关，暂时不使用注掉，以后需求可能用到
        // STANDARD_BOOTH(MemberServiceConst.SERVICE_TYPE_STANDARD, 1),
        //
        // POSTER(MemberServiceConst.SERVICE_TYPE_POSTER, 4),
        //
        // ROLL(MemberServiceConst.SERVICE_TYPE_ROLL, 1),
        //
        // LIGHT_BOX(MemberServiceConst.SERVICE_TYPE_LIGHT_BOX, 1);

        private String type;
        private Integer capacity;

        private StandardServiceEnum(String type, Integer capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public Integer getCapacity() {
            return capacity;
        }
    }

    /** 精装展台套装服务 */
    public enum HardbackServiceEnum implements MemberServiceConst {

        REALNAME_AUTH(MemberServiceConst.SERVICE_TYPE_REALNAME_AUTH, 1),

        PRODUCT_COUNT(MemberServiceConst.SERVICE_TYPE_PRODUCT_COUNT, 100),

        LIB_SIZE(MemberServiceConst.SERVICE_TYPE_LIB_SIZE, 1048576),

        ATLAS(MemberServiceConst.SERVICE_TYPE_ATLAS, 8),

        // PRODUCT_VIDEO(MemberServiceConst.SERVICE_TYPE_PRODUCT_VIDEO, 2),
        //
        // CORPORATE_VIDEO(MemberServiceConst.SERVICE_TYPE_CORPORATE_VIDEO, 2),
        //
        // STUDIO_VIDEO(MemberServiceConst.SERVICE_TYPE_STUDIO_VIDEO, 1),
        //
        // PRODUCT_3D(MemberServiceConst.SERVICE_TYPE_3D_PRODUCT, 1),
        //
        // PANORAMA_360(MemberServiceConst.SERVICE_TYPE_360_PANORAMA, 1),

        MEETING_ROOM(MemberServiceConst.SERVICE_TYPE_MEETING_ROOM, 4), // 单位0.5小时

        EXHIBITORS(MemberServiceConst.SERVICE_TYPE_EXHIBITORS, 6);

        // 以下服务与展台相关，暂时不使用注掉，以后需求可能用到
        // HARDBACK_EDITION(MemberServiceConst.SERVICE_TYPE_STANDARD, 1),
        //
        // POSTER(MemberServiceConst.SERVICE_TYPE_POSTER, 6),
        //
        // ROLL(MemberServiceConst.SERVICE_TYPE_ROLL, 2),
        //
        // LIGHT_BOX(MemberServiceConst.SERVICE_TYPE_LIGHT_BOX, 2);

        private String type;
        private Integer capacity;

        private HardbackServiceEnum(String type, Integer capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public Integer getCapacity() {
            return capacity;
        }
    }

    /** 豪装展台套装服务 */
    public enum LuxuryServiceEnum implements MemberServiceConst {

        REALNAME_AUTH(MemberServiceConst.SERVICE_TYPE_REALNAME_AUTH, 1),

        PRODUCT_COUNT(MemberServiceConst.SERVICE_TYPE_PRODUCT_COUNT, 150),

        LIB_SIZE(MemberServiceConst.SERVICE_TYPE_LIB_SIZE, 1572864),

        ATLAS(MemberServiceConst.SERVICE_TYPE_ATLAS, 12),

        // PRODUCT_VIDEO(MemberServiceConst.SERVICE_TYPE_PRODUCT_VIDEO, 4),
        //
        // CORPORATE_VIDEO(MemberServiceConst.SERVICE_TYPE_CORPORATE_VIDEO, 4),
        //
        // STUDIO_VIDEO(MemberServiceConst.SERVICE_TYPE_STUDIO_VIDEO, 2),
        //
        // PRODUCT_3D(MemberServiceConst.SERVICE_TYPE_3D_PRODUCT, 2),
        //
        // PANORAMA_360(MemberServiceConst.SERVICE_TYPE_360_PANORAMA, 2),

        MEETING_ROOM(MemberServiceConst.SERVICE_TYPE_MEETING_ROOM, 8), // 单位0.5小时

        EXHIBITORS(MemberServiceConst.SERVICE_TYPE_EXHIBITORS, 8);

        // 以下服务与展台相关，暂时不使用注掉，以后需求可能用到
        // LUXURY_EDITION(MemberServiceConst.SERVICE_TYPE_STANDARD, 1),
        //
        // POSTER(MemberServiceConst.SERVICE_TYPE_POSTER, 8),
        //
        // ROLL(MemberServiceConst.SERVICE_TYPE_ROLL, 4),
        //
        // LIGHT_BOX(MemberServiceConst.SERVICE_TYPE_LIGHT_BOX, 4);

        private String type;
        private Integer capacity;

        private LuxuryServiceEnum(String type, Integer capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public Integer getCapacity() {
            return capacity;
        }
    }
}

