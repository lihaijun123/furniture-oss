package com.focustech.furniture.common.dao;

import java.util.List;

import com.focustech.furniture.model.common.CoreCategory;
import com.focustech.oss2008.dao.BaseHibernateDao;

/**
 * 产品目录
 * *
 * @author lihaijun
 *
 */
public interface CoreCategoryDao<T> extends BaseHibernateDao<T>{
	/**
	 *获取所有一级目录
	 * *
	 * @return
	 */
	public List<CoreCategory> selectFirstLevelCates();

	/**
	 * 根据父目录码获取其所有直属下级目录码
	 * *
	 * @param parenCatcode 父目录码
	 * @return
	 */
	public List<CoreCategory> getRelatedCates(String parenCatcode);

	/**
	 * 根据目录码编号获取对应的目录码信息
	 * *
	 * @param codes 目录码，如果有多个请用“,”分割。如果为空，则返回new ArrayList()
	 * @return
	 */
	public List<CoreCategory> selectCatesByCodes(String codes);

	/**
	 * 根据目录码编号获取对应的目录码信息(一条记录)
	 *
	 * @param catCode
	 * @return
	 */
	public CoreCategory selectCategoryByCatCode(String catCode);
	/**
	 * *
	 * @param level
	 * @return
	 */
	public List<CoreCategory> getListByLevel(int level);
	/**
	 * 
	 * *
	 * @param level
	 * @param parentCode
	 * @return
	 */
	public int getCateCodeIndex(Long parentCode);
	/**
	 * 
	 * *
	 * @param parentCode
	 * @return
	 */
	public List<CoreCategory> getListByParentCode(Long parentCode);
	/**
	 * 
	 * *
	 * @param code
	 * @return
	 */
	public CoreCategory getByCateCode(Long code);
}
