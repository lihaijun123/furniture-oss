/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * ExbUserPermsConst.java 子账户权限参数类
 * 
 * @author chenyunlong
 */
public class ExbUserPermsConst implements NumberConst {
    // 权限类型 1操作权限 2产品分配 3 通讯分配
    /** 操作权限 */
    public static final String PERMISSION_OPERATION = ONE;
    public static final String PERMISSION_OPERATION_TYPE = "OPERATION_TYPE";
    /** 产品分配 */
    public static final String PERMISSION_PRODUCT = TWO;
    public static final String PERMISSION_PRODUCT_TYPE = "PERMISSION_PRODUCT";
    /** 地区分配 */
    public static final String PERMISSION_AREA = THREE;
    public static final String PERMISSION_AREA_TYPE = "AREA_LIST";
    /** 非产品信息分配 */
    public static final String PERMISSION_NON_PRODUCT = FOUR;
    public static final String PERMISSION_NON_PRODUCT_TYPE = "NON_PRODUCT";
    public static final String NON_PRODUCT_INFO = "NonProductInfor";

    // 管理员通讯规则(1:按产品进行分配（默认）、2：按地区进行分配)
    /** 按产品进行分配 */
    public static final String DISTRIBUTION_RULE_PRODUCT = ONE;
    /** 按地区进行分配 */
    public static final String DISTRIBUTION_RULE_AREA = TWO;
    /** 错误提示信息 */
    public static final String ERROR_MESSAGE = "提交失败，请修改！";
    /** 删除成功 */
    public static final String DELETE_SUCCESS = "删除成功！";
    /** 参展人员添加成功 */
    public static final String SUB_USER_ADD_SUCCESS = "参展人员添加成功！";
    /** 参展人员修改成功 */
    public static final String SUB_USER_UPDATE_SUCCESS = "参展人员修改成功！";
    /** 参展人员数量已满 */
    public static final String SUB_USER_COUNT_OVER = "你的子账户数量已满！";
    /** 所有产品 */
    public static final String PRODUCT_ALL = "allProduct";
    /** 未分配产品 */
    public static final String PRODUCT_NON = "nonProduct";
    /** 没有分组的产品(其他) */
    public static final String PRODUCT_OTHER = "others";

}
