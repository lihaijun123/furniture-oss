package com.focustech.focus3d.dao.prodcase;

import java.util.List;

import com.focustech.oss2008.dao.BaseHibernateDao;

/**
 *
 * *
 * @author lihaijun
 *
 */
public interface ProdCaseFileContentDao<T> extends BaseHibernateDao<T>{
	/**
	 *
	 * *
	 * @param caseFileSn
	 * @return
	 */
	List<T> getListByCaseFile(Long caseFileSn);
	/**
	 *
	 * *
	 * @param caseFileSn
	 */
	void deleteBySn(Long caseFileSn);

}
