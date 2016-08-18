/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

/**
 * 场景事件枚举定义
 *
 * @author xulijiao
 */
public enum X3dConfigEventEnum {

    /** 门楣 */
    EVENT_MM("[ModelCiefType=mm]", "0", "ObjectClicked", "addPanel", "companyDetail;; ;; ;; ;; ;;"),

    /** 产品库 */
    EVENT_CPK("[ModelCiefType=cpk]", "0", "ObjectClicked", "addPanel", "products;; ;; ;; ;; ;;"),

    /** 视频库billboard */
    EVENT_SPK("[ModelCiefType=spk]", "0", "ObjectClicked", "addPanel", "videos;; ;; ;; ;; ;;"),

    /** 3D产品模型 */
    EVENT_CP("[ModelCiefType=cp]", "0", "ObjectClicked", "changeURLToModel", ""),

    /** 3D模型库 */
    EVENT_CPMXK("[ModelCiefType=cpmxk]", "0", "ObjectClicked", "addPanel", "models;; ;; ;; ;; ;;"),

    /** 易拉宝 */
    EVENT_YLB("[ModelCiefType=ylb]", "0", "ObjectClicked", "addPanel", "productDetail;; ;; ;; ;; ;;"),

    /** 海报 */
    EVENT_HB("[ModelCiefType=hb]", "0", "ObjectClicked", "addPanel", "productDetail;; ;; ;; ;; ;;"),

    /** 灯箱 */
    EVENT_DX("[ModelCiefType=dx]", "0", "ObjectClicked", "addPanel", "productDetail;; ;; ;; ;; ;;"),

    /** 360全景图 */
    EVENT_360("[ModelCiefType=360]", "0", "ObjectClicked", "addPanel", "p360k;; ;; ;; ;; ;;"),

    /** 上一个 */
    EVENT_SYJZST("[ModelCiefType=syjzst]", "0", "ObjectClicked", "preBooth", ""),

    /** 下一个 */
    EVENT_XYJZST("[ModelCiefType=xyjzst]", "0", "ObjectClicked", "nextBooth", ""),

    /** 发联系信 */
    EVENT_FLXX("[ModelCiefType=flxx]", "0", "ObjectClicked", "addPanel", "stationMsg;; ;; ;; ;; ;;"),

    /** 即时通讯 */
    EVENT_JSTX("[ModelCiefType=jstx]", "0", "ObjectClicked", "addPanel", "singleChat;; ;; ;; ;; ;;"),

    /** 交换名片 */
    EVENT_JHMP("[ModelCiefType=jhmp]", "0", "ObjectClicked", "addPanel", "changeCard;; ;; ;; ;; ;;"),

    /** 留下名片 */
    EVENT_LXMP("[ModelCiefType=lxmp]", "0", "ObjectClicked", "addPanel", "leaveCard;; ;; ;; ;; ;;"),

    /** 获取名片 */
    EVENT_HQMP("[ModelCiefType=hqmp]", "0", "ObjectClicked", "addPanel", "getCard;; ;; ;; ;; ;;"),

    /** 分享 */
    EVENT_FX("[ModelCiefType=fx]", "0", "ObjectClicked", "addPanel", "share;; ;; ;; ;; ;;"),

    /** 收藏 */
    EVENT_SC("[ModelCiefType=sc]", "0", "ObjectClicked", "addPanel", "favorite;; ;; ;; ;; ;;"),

    /** 图册 */
    EVENT_TC("[ModelCiefType=tc]", "0", "ObjectClicked", "addPanel", "atlas;; ;; ;; ;; ;;"),

    /** 电视 */
    EVENT_DS("[ModelCiefType=ds]", "0", "ObjectClicked", "addPanel", "videos;; ;; ;; ;; ;;"),

    /** 展台包围盒 */
    EVENT_BWH("[ModelCiefType=bwh]", "0", "ObjectClicked", "changeURLToBooth", ""),

    /** 进入产品展示厅(展台) */
    EVENT_JRZST("[ModelCiefType=jrzst]", "0", "ObjectClicked", "changeURLToBooth", ""),

    /** 离开展示厅 */
    EVENT_LKZST("[ModelCiefType=lkzst]", "0", "ObjectClicked", "leaveBooth", ""),

    /** 离开子展馆 */
    EVENT_LKZZG("[ModelCiefType=lkzzg]", "0", "ObjectClicked", "", ""),

    /** 参展人员NPC */
    EVENT_CZSNPC("[ModelCiefType=czsnpc]", "0", "ObjectClicked", "talkToBoothNPC", ""),

    /** 展馆内NPC */
    EVENT_CJXDNPC("[ModelCiefType=cjxdnpc]", "0", "ObjectClicked", "addPanel", "hallNpc;; ;; ;; ;; ;;"),

    // ==========================================会议厅/室==================================================================
    /** 会议厅中会议室的大门下面的箭头 */
    EVENT_HYS_LB("[ModelCiefType=hys_lb]", "0", "ObjectClicked", "enterConferenceRoom", ""),

    /** 会议厅中npc */
    EVENT_HYTNPC("[ModelCiefType=hytnpc]", "0", "ObjectClicked", "addPanel", "meetinghallnpc;; ;; ;; ;; ;;"),

    /** 会议厅中的会议室门牌 */
    EVENT_HYS_MP("[ModelCiefType^=hys_mp]", "0", "ObjectClicked", "addPanel", "meetingdata;; ;; ;; ;; ;;"),

    /** 会议室npc */
    EVENT_HYSNPC("[ModelCiefType=hysnpc]", "0", "ObjectClicked", "addPanel", "meetingroomnpc;; ;; ;; ;; ;;"),

    /** 会议室离开 */
    EVENT_HYS_LK("[ModelCiefType=hys_lk]", "0", "ObjectClicked", "leaveConferenceRoom", ""),

    // ==========================================演播厅/室==================================================================
    /** 直播室入口 */
    EVENT_YBT_ZBSRK("[ModelCiefType=ybt_zbsrk]", "0", "ObjectClicked", "changeURLToLiveRoom", ""),

    /** 点播室入口 */
    EVENT_YBT_DBSRK("[ModelCiefType=ybt_dbsrk]", "0", "ObjectClicked", "changeURLToVideoRoom", ""),

    /** 演播大厅 npc */
    EVENT_YBT_NPC("[ModelCiefType=ybt_npc]", "0", "ObjectClicked", "addPanel", "studiohallnpc;; ;; ;; ;; ;;"),

    /** 直播室出口 */
    EVENT_ZBS_CK("[ModelCiefType=zbs_ck]", "0", "ObjectClicked", "leaveLiveRoom", ""),

    /** 直播室npc */
    EVENT_ZBS_NPC("[ModelCiefType=zbs_npc]", "0", "ObjectClicked", "talkToLiveNPC", ""),

    /** 点播室出口 */
    EVENT_DBS_CK("[ModelCiefType=dbs_ck]", "0", "ObjectClicked", "leaveDemandRoom", ""),

    /** 点播室npc */
    EVENT_DBS_NPC("[ModelCiefType=dbs_npc]", "0", "ObjectClicked", "talkToDemandNPC", ""),

    // ==========================================外场景==================================================================
    /** 外场景-会议厅 */
    EVENT_WCJ_HYT("[ModelCiefType=wcj_hyt]", "0", "ObjectMouseOver", "mouseOverAddPanel", "wcj_hyt;; ;; ;; ;; ;;"),
    /** 外场景-演播大厅 */
    EVENT_WCJ_YBDT("[ModelCiefType=wcj_ybdt]", "0", "ObjectMouseOver", "mouseOverAddPanel", "wcj_ybdt;; ;; ;; ;; ;;"),
    /** 外场景-展览中心 */
    EVENT_WCJ_ZLZX("[ModelCiefType=wcj_zlzx]", "0", "ObjectMouseOver", "mouseOverAddPanel", "wcj_zlzx;; ;; ;; ;; ;;"),
    /** 外场景-咖啡厅 */
    EVENT_WCJ_KFT("[ModelCiefType=wcj_kft]", "0", "ObjectMouseOver", "mouseOverAddPanel", "wcj_kft;; ;; ;; ;; ;;"),
    /** 外场景-服务中心 */
    EVENT_WCJ_FWZX("[ModelCiefType=wcj_fwzx]", "0", "ObjectMouseOver", "mouseOverAddPanel", "wcj_fwzx;; ;; ;; ;; ;;");


    private String modelName;
    private String modelType;
    private String eventName;
    private String functionName;
    private String functionParams;

    private X3dConfigEventEnum(String modelName, String modelType, String eventName, String functionName,
            String functionParams) {
        this.modelName = modelName;
        this.modelType = modelType;
        this.eventName = eventName;
        this.functionName = functionName;
        this.functionParams = functionParams;
    }

    public String getModelName() {
        return modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public String getEventName() {
        return eventName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getFunctionParams() {
        return functionParams;
    }
}

