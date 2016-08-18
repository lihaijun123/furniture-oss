/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 模型库相关
 *
 * @author xulijiao
 */
public class ModelLibConst implements NumberConst {
	 /**
     * 新加入
     */
	public static final long STATUS_1 = 1;
    /** 一级type */
    public static final String MODELLIB_LEVEL_ONE = "MODELLIB_LEVEL_ONE";
    /** 二级type */
    public static final String MODELLIB_LEVEL_TWO = "MODELLIB_LEVEL_TWO";

    // ================================模型库后缀名类型================================================
    /** x3dm-1 */
    public static final String EXT_X3DM = ONE;
    /** x3dscene-2 */
    public static final String EXT_X3DSCENE = TWO;
    /** xml-3 */
    public static final String EXT_XML = THREE;

    // ================================模型库一级菜单================================================

    /** 标准展台 */
    public static final String MODELLIB_EXB_BOOTH = "MODELLIB_1";
    /** 展台框架 */
    public static final String MODELLIB_EXB_FRAME = "MODELLIB_2";
    /** 展馆模型 */
    public static final String MODELLIB_EXB_HALL = "MODELLIB_3";
    /** 装修展具 */
    public static final String MODELLIB_DECORATION_TOOLS = "MODELLIB_4";
    /** NPC人物 */
    public static final String MODELLIB_NPC_PEOPLE = "MODELLIB_5";
    /** 漫游人物 */
    public static final String MODELLIB_WANDER_PEOPLE = "MODELLIB_6";
    /** 广告模型 */
    public static final String MODELLIB_AD = "MODELLIB_7";
    /** 会议厅模型 */
    public static final String MODELLIB_METTING = "MODELLIB_METTING";
    /** 演播厅模型 */
    public static final String MODELLIB_STUDIO = "MODELLIB_STUDIO";
    /** 一级场景模型 */
    public static final String MODELLIB_LEVEL_ONE_SCENE = "MODELLIB_SCENE_ONE";

	public static final String PRDU_EXPERIENCE = "PROD_EXPERIENCE";

    // ================================模型库一级菜单资源id================================================

    /** 标准展台 */
    public static final String RESOURCE_ID_EXB_BOOTH = "108021";
    /** 展台框架 */
    public static final String RESOURCE_ID_EXB_FRAME = "108022";
    /** 展馆模型 */
    public static final String RESOURCE_ID_EXB_HALL = "108023";
    /** 装修展具 */
    public static final String RESOURCE_ID_DECORATION_TOOLS = "108024";
    /** NPC人物 */
    public static final String RESOURCE_ID_NPC_PEOPLE = "108025";
    /** 漫游人物 */
    public static final String RESOURCE_ID_WANDER_PEOPLE = "108026";
    /** 广告模型 */
    public static final String RESOURCE_ID_AD = "108027";
    /** 会议厅模型 */
    public static final String RESOURCE_ID_METTING = "108028";
    /** 演播厅模型 */
    public static final String RESOURCE_ID_STUDIO = "108029";
    /** 一级场景模型 */
    public static final String RESOURCE_ID_LEVEL_ONE_SCENE = "108020";

	public static final String RESOURCE_PRDU_EXPERIENCE = "1080211";

    /**
     * 根据资源id获取模型库一级菜单类型
     *
     * @param resourceId 资源id（库表中资源id）
     * @return 模型库一级菜单类型
     * @author xulijiao
     */
    public static String getModelFirstLevel(String resourceId) {
        String type = "";
        if (RESOURCE_ID_EXB_BOOTH.equals(resourceId)) {
            type = MODELLIB_EXB_BOOTH;
        }
        else if (RESOURCE_ID_EXB_FRAME.equals(resourceId)) {
            type = MODELLIB_EXB_FRAME;
        }
        else if (RESOURCE_ID_EXB_HALL.equals(resourceId)) {
            type = MODELLIB_EXB_HALL;
        }
        else if (RESOURCE_ID_DECORATION_TOOLS.equals(resourceId)) {
            type = MODELLIB_DECORATION_TOOLS;
        }
        else if (RESOURCE_ID_NPC_PEOPLE.equals(resourceId)) {
            type = MODELLIB_NPC_PEOPLE;
        }
        else if (RESOURCE_ID_WANDER_PEOPLE.equals(resourceId)) {
            type = MODELLIB_WANDER_PEOPLE;
        }
        else if (RESOURCE_ID_AD.equals(resourceId)) {
            type = MODELLIB_AD;
        }
        else if (RESOURCE_ID_METTING.equals(resourceId)) {
            type = MODELLIB_METTING;
        }
        else if (RESOURCE_ID_STUDIO.equals(resourceId)) {
            type = MODELLIB_STUDIO;
        }
        else if (RESOURCE_ID_LEVEL_ONE_SCENE.equals(resourceId)) {
            type = MODELLIB_LEVEL_ONE_SCENE;
		} else if (RESOURCE_PRDU_EXPERIENCE.equals(resourceId)) {
			type = PRDU_EXPERIENCE;
        }
        return type;
    }

    public static final String STUTAS_PASS = THREE;

    // ================================人模相关常量================================================

    /** 男性NPC */
    public static final String CHARACTER_NPC_MALE = "CHARACTER_NPC_MALE";
    /** 女性NPC */
    public static final String CHARACTER_NPC_FEMALE = "CHARACTER_NPC_FEMALE";

    /** 男性人模 */
    public static final String CHARACTER_ROAM_MALE = "CHARACTER_ROAM_MALE";
    /** 女性人模 */
    public static final String CHARACTER_ROAM_FEMALE = "CHARACTER_ROAM_FEMALE";

    /**
     * 根据人模类型获取人模性别
     *
     * @param type 人模类型
     * @return 人模性别（对应x3d_standaravatar表中性别代号）
     * @author xulijiao
     */
    public static String getSex(String type) {
        String sex = "";
        if (CHARACTER_ROAM_MALE.equals(type) || CHARACTER_NPC_MALE.equals(type)) {
            sex = ONE;
        }
        else if (CHARACTER_ROAM_FEMALE.equals(type) || CHARACTER_NPC_FEMALE.equals(type)) {
            sex = ZERO;
        }
        else {
            sex = null;
        }
        return sex;
    }

    public static final String PERSON_EQUIP_TYPE = "PERSON_EQUIP_TYPE";//换装部件类型
    public static final String W_HAIR = "W_HAIR";//女发型
    public static final String W_COAT = "W_COAT";//女上装
    public static final String W_TROUSER = "W_TROUSER";//女下装
    public static final String W_SHOE = "W_SHOE";//女鞋
    public static final String M_HAIR = "M_HAIR";//男发型
    public static final String M_COAT = "M_COAT";//男上装
    public static final String M_TROUSER = "M_TROUSER";//男下装
    public static final String M_SHOE = "M_SHOE";//男鞋

    public static final int HAVA_DOWN = 1;
    public static final int NOT_HAVA_DOWN = 0;
    public static final int DEFAULT = 1;
    public static final int NOT_DEFAULT = 0;
    public static final int DISPLAY = 1;
    public static final int NOT_DISPLAY = 0;

    public static final String HUMAN_MODEL_SUFFIX_ZIP = ".zip";
    public static final String HUMAN_MODEL_SUFFIX_UNITY3D = ".unity3d";
    public static final String FILE_NAME_DELIMITER = ".";

}

