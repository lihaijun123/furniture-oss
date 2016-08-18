package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 订单相关
 *
 * @author xulijiao
 */
public class OrderConst implements NumberConst {
    /** 订单状态-未完成 */
    public static final String UNFINISHED = ONE;
    /** 订单状态-新加入 */
    public static final String NEW_JOIN = TWO;
    /** 订单状态-已支付 */
    public static final String ALREADY_PAYMENT = THREE;
    /** 订单状态-审核通过 */
    public static final String AUDIT_PASS = FOUR;
    /** 订单状态-返回修改 */
    public static final String RETURN_MODIFY = FIVE;
    /** 订单状态-已修改 */
    public static final String ALREADY_MODIFY = SIX;
    /** 订单状态-用户已删除 */
    public static final String USER_DELETE = SEVEN;
    /** 订单状态-运营人员删除 */
    public static final String OPERATOR_DELETE = EIGHT;

    /** 支付状态-付款成功 */
    public static final String PAYMENT_YES = ONE;
    /** 支付状态-待付款 */
    public static final String PAYMENT_NO = TWO;

    /** 支付方式[1]-易宝 */
    public static final String PAY_WAY1 = ONE;
    /** 支付方式[2]-银联 */
    public static final String PAY_WAY2 = TWO;

    /** 过期状态 */
    public static final String ALREADY_EXPIRED = ZERO;

    /** 支付失败 */
    public static final String FAILURE_FLAG_PAY = ZERO;
    /** 支付 成功 */
    public static final String SUCC_FLAG_PAY = ONE;
    /** 删除 成功 */
    public static final String SUCC_FLAG_DELETE = TWO;
    /** 删除失败 */
    public static final String FAILURE_FLAG_DELETE = THREE;

    /** 未执行-0 */
    public static final String EXECUTION_STATUS_0 = ZERO;
    /** 已执行-1 */
    public static final String EXECUTION_STATUS_1 = ONE;
    /** 服务类型-推荐服务 */
    public static final String SERVICE_TYPE_RECOMMEND = "recommend";
    /** 服务类型-广告服务 */
    public static final String SERVICE_TYPE_AD = "ad";
    /** 服务类型-常用服务 */
    public static final String SERVICE_TYPE_COMMON = "common";
    /** 服务类型-认证服务 */
    public static final String SERVICE_TYPE_CERTIFICATION = "certification";
    /** 支付方式 */
    public static final String PAY_WAY = "PAY_WAY";
    /** 支付状态 */
    public static final String PAY_STATUS = "PAY_STATUS";
    /** 有效/无效标识 */
    public static final String VALID_FLAG = "VALID_FLAG";
    /** 营业执照的状态类型 */
    public static final String BL_COPY_STATUS = "BL_COPY_STATUS";

    /** 推荐服务type参数 */
    public static final String EXB_BOOTH_TYPE = "EXB_BOOTH_TYPE";
    /** 认证服务type参数 */
    public static final String AUTHEN_SERVICE_LEVEL = "AUTHEN_SERVICE_LEVEL";
    /** 广告服务type参数 */
    public static final String AD_KIND = "AD_KIND";
    /** 常用服务type参数 */
    public static final String COMMON_SERVICE_TYPE = "COMMON_SERVICE_TYPE";
    /** 常用服务name参数 */
    public static final String COMMON_SERVICE_NAME = "COMMON_SERVICE_NAME";

    public static final String EXECU_STATUS_0 = "未发布";
    public static final String EXECU_STATUS_1 = "已发布";

}
