package com.focustech.focus3d.common.constant;

import java.util.HashMap;
import java.util.Map;

import com.focustech.common.utils.TCUtil;


/**
 * 销售方案相关 *
 * 
 * @author lihaijun
 */
public class SalesSchemeConst {
    public static Map<String, Integer> map = new HashMap<String, Integer>();
    /** 推荐服务 */
    public static final String SERVICE_TYPE_RECOMMEND = "recommend";
    /** 广告服务 */
    public static final String SERVICE_TYPE_AD = "ad";
    /** 常用服务 */
    public static final String SERVICE_TYPE_COMMON = "common";
    /** 认证服务 */
    public static final String SERVICE_TYPE_CERTIFICATION = "certification";
    /** 套餐服务 */
    public static final String SERVICE_TYPE_PACKAGE = "package";

    /** 服务类型 */
    public static final String SERVICE_TYPE = "SERVICE_TYPE";
    /*
     * 服务库表标识值
     */
    /** 参展宝【标准版】 */
    public static final String STANDARD_EDITION = "TYPE_1";
    /** 参展宝【精装版】 */
    public static final String HARDBACK_EDITION = "TYPE_2";
    /** 参展宝【豪装版】 */
    public static final String LUXURY_EDITION = "TYPE_3";
    /** AS认证 */
    public static final String AS_EDITION = "TYPE_4";
    /** 实名认证 */
    public static final String REALNAME_EDITION = "REAL_NAME";
    /** 功能厅 */
    public static final String FUNCTION_HALL = "FUNCTION_HALL";
    /** 3d展示 */
    public static final String TD_SHOW = "3D_SHOW";
    /** 信息库 */
    public static final String INFORMATION_LIBRARY = "INFORMATION_LIBRARY";
    /** 炫展台 */
    public static final String HYUN_BOOTH = "HYUN_BOOTH";
    /** 2D名称 */
    public final static String AD_WEB = "WEB";
    /** 3D名称 */
    public final static String AD_MODEL = "MODEL";
    /** 3D产品模型 */
    public final static String PROD_MODEL = "3D_PROD_MODEL";
    /** 全景图 */
    public final static String PANORAMA = "360_PANORAMA";
    /** 产品视频 */
    public final static String PRODUCT_VIDEO = "PRODUCT_VIDEO";
    /** 企业视频 */
    public final static String CORPORATE_VIDEO = "CORPORATE_VIDEO";
    /** 易拉宝 */
    public final static String ROLL_UP = "ROLL_UP";
    /** 海报 */
    public final static String POSTER = "POSTER";
    /** 灯箱 */
    public final static String LIGHT_BOX = "LIGHT_BOX";
    /** 演播厅视频 */
    public final static String TV_VODEO = "TV_VODEO";

    /** 销售方案新增成功 */
    public static final String SALES_SCHEME_ADD_SUCCESS = "销售方案新增成功！";
    /** 销售方案修改成功 */
    public static final String SALES_SCHEME_UPDATE_SUCCESS = "销售方案修改成功！";
    /** 邮件模板新增成功 */
    public static final String EMAIL_TEMP_ADD_SUCCESS = "邮件模板新增成功！";
    /** 邮件模板修改成功 */
    public static final String EMAIL_TEMP_UPDATE_SUCCESS = "EMAIL_TEMP_UPDATE_SUCCESS";

    /** 展台模板未上传 */
    public static final String EXB_BOOTH_TEMP_NO_UPLOAD = "展台模板模型未上传！";

    /** 年 */
    public static final String YEAR = "Y";
    /** 年 */
    public static final String YEAR_CN = "年";
    /** 月 */
    public static final String MONTH = "M";
    /** 日 */
    public static final String DAY = "D";
    /** 周 */
    public static final String WEEK = "W";
    /** 0.5小时 */
    public static final String HALF_HOUR = "HH";
    /** 小时 */
    public static final String ONE_HOUR = "H";
    /** 50个 */
    public static final String A_50 = "FA";
    /** 100个 */
    public static final String A_100 = "HA";
    /** 500M */
    public static final String M_500 = "HG";
    /** 1G */
    public static final String G_1 = "G";

    /** 年 */
    public static final String Y = "Y";
    /** 月 */
    public static final String M = "M";
    /** 日 */
    public static final String D = "D";
    /** 周 */
    public static final String W = "W";
    /** 0.5小时 */
    public static final String HH = "HH";
    /** 小时 */
    public static final String H = "H";
    /** 50个 */
    public static final String FA = "FA";
    /** 100个 */
    public static final String HA = "HA";
    /** 500M */
    public static final String HG = "HG";
    /** 1G */
    public static final String G = "G";

    /** 总套餐项 */
    public final static String TOTLE_PACKAGE_INDEX = "1";
    /** 套餐项 */
    public final static String PACKAGE_INDEX = "0";
    static {
        map.put(ONE_HOUR, TCUtil.iv(2));
        map.put(HALF_HOUR, TCUtil.iv(1));
        map.put(A_50, TCUtil.iv(50));
        map.put(A_100, TCUtil.iv(100));
        map.put(M_500, TCUtil.iv(500 * 1024));
        map.put(G_1, TCUtil.iv(1024 * 1024));
        map.put("个", TCUtil.iv(1));
    }

    /**
     * 价格单位
     * 
     * @author liushuyan
     */
    public enum PriceUnit {
        MEETING_ROOM_HH("0.5小时"), MEETING_ROOM_H("小时"), PROD_CNT_FA("50个"), PROD_CNT_HA("100个"), MEDIA_CAP_HG("500M"),
        MEDIA_CAP_G("G"), REAL_NAME_Y("年"), REAL_NAME_M("月"), AS_Y("年"), AS_M("月"), OTHER("个");

        private String value;

        private PriceUnit(String value) {
            this.setValue(value);
        }

        /**
         * @param value the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }
    }
}
