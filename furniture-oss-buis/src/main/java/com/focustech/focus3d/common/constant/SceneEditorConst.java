/*
 * Copyright 2013 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;
/**
 *  SceneEditorConst.java
 *
 * @author liushuyan
 */
public interface SceneEditorConst {
    /**
     * 编辑的场景类型
     */
    public static String SCENE_EDITOR_TYPE = "SCENE_EDITOR_TYPE";
    /**
     * 模型资源类型
     */
    public static String SCENE_OBJECT_RESOURCE_TYPE = "SCENE_OBJECT_RESOURCE_TYPE";

    public static String SCENE_OBJECT_RESOURCE_TYPE_OTHER = "其他";
    /**
     * 模型资源摆放位置类型
     */
    public static String SCENE_OBJECT_RESOURCE_POSITION_TYPE = "SCENE_OBJECT_RESOURCE_POSITION_TYPE";

    public enum ResTypeToName {
        DEF("服务台"), DEM("会议桌"), DES("演讲台"), ORN("装饰点缀物件"), DEA("装饰用的桌子、柜子等"), LAP("照明灯具"), ELE("电器"), ACS("装饰植物(小)"),
        ACM("装饰植物(中)"), ACL("装饰植物(大)"), ZT("场馆"), DM("地面"), DEE("产品展示架"), CP("产品"), LBS("灯箱"), BLS("海报"), PDS("易拉宝"),
        TVS("电视机"), CNS("门楣"), LZ("立柱"), SCR("360展示台"), CLS("图册展示架"), EEA("进入退出箭头"), NPC("NPC模型"), DOLL_FRAME("玩具展厅-包围盒");

        private String typeName;

        public String getTypeName() {
            return typeName;
        }

        private ResTypeToName(String typeName) {
            this.typeName = typeName;
        }
    }

    /**
     * 场景数据保存的文件类型-txt
     */
    public static String SCENE_FILE_TYPE = "txt";

    /**
     * 场景模板数据来自于vo
     */
    public static Integer SCENE_TEMP_MODEL_FROM_VO = 2;
    /**
     * 场景模板数据来自于oss
     */
    public static Integer SCENE_TEMP_MODEL_FROM_OSS = 1;
}
