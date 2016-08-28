package com.focustech.furniture.common.service;

import java.util.List;

import com.focustech.furniture.model.common.Param;

/**
 * 产品目录
 * *
 * @author lihaijun
 *
 */
public interface CoreCategoryService {
	/** 页面展示总级数 */
    public static final int TOTAL_LEVEL = 3;

    /** 一级目录 */
    public static final int CAT_LEVEL_ONE = 1;
    /** 二级目录 */
    public static final int CAT_LEVEL_TWO = 2;
    /** 三级目录 */
    public static final int CAT_LEVEL_THREE = 3;
	/**
     * 获取第一层数据及第一个元素的所有子目录，即初始出现的时候要初始化的数据。列表中总共返回三个元素，没有对应数据的，用空队列返回。
     *
     * @param curLevel 当前第几层
     * @return
     */
	public List<List<Param>> getFirstLevelCn(String curLevel);

	/**
     * 根据指定的目录码获取该目录码的所有子目录
     *
     * @param curLevel 当前层数。如果当前层数超过总定义层数，则不处理超出部分的空值问题！
     * @param parentCode 父目录码
     * @return
     */
	public List<List<Param>> getCateByParentCn(String curLevel, String parentCode);
	 /**
     * 根据目录码编号获取对应的目录码信息。
     *
     * @param codes 目录码，如果有多个请用“,”分割。如果为空，则返回new ArrayList()。
     * @return
     */
	public List<Param> getCateByCode(String codes);
	/**
     * 通过二级/三级目录找到一级目录
     *
     * @param code 目录
     * @return
     */
	public String getFirstCatLevelByCode(String code);

}
