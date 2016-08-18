package com.focustech.focus3d.common.excel;

import java.util.ArrayList;

import com.focustech.focus3d.common.constant.AdConst;
import com.focustech.focus3d.common.constant.ExhibitionConst;

/**
 *
 *
 * *
 * @author lihaijun
 *
 */
public class ExcelTemplateUtil {
    /** 数据 */
    public final static String DATA = "data";
    /** 类型名称 */
    public final static String TYPE_NAME = "typeName";
    /** 开始编号 */
    public final static String START_ID = "startId";
    /** 结束编号 */
    public final static String END_ID = "endId";
    /** 坐标轴 */
    public final static String COORDINATE = "coordinate";

    /**
     * 模型广告坐标导入 *
     * 
     * @return
     */
	public static String[] getAdCoordinateImportCode() {
		ArrayList<String> headerList = new ArrayList<String>();
        headerList.add(AdConst.AD_TYPE); // 广告类型
        headerList.add(AdConst.POSITION_ID); // 位置编号
        headerList.add(AdConst.LOCATION_X); // x轴坐标
        headerList.add(AdConst.LOCATION_Y); // y轴坐标
        headerList.add(AdConst.LOCATION_Z); // z轴坐标
        headerList.add(AdConst.ANGLE_Z); // z轴角度
		return headerList.toArray(new String[headerList.size()]);
	}

	public static String[] getBoothCoordinateImportCode() {
		ArrayList<String> headerList = new ArrayList<String>();
        headerList.add(AdConst.POSITION_ID); // 位置编号
        headerList.add(ExhibitionConst.BOOTH_TYPE); // 展位类型
        headerList.add(AdConst.LOCATION_X); // x轴坐标
        headerList.add(AdConst.LOCATION_Y); // y轴坐标
        headerList.add(AdConst.LOCATION_Z); // z轴坐标
        headerList.add(AdConst.ANGLE_Z); // z轴角度
		return headerList.toArray(new String[headerList.size()]);
	}

}

