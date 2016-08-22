package com.focustech.focus3d.dao.sale.customer;

import java.util.List;

import com.focustech.oss2008.dao.BaseHibernateDao;

public interface TagDao<T> extends BaseHibernateDao<T> {
	/**
	 *
	 * *
	 * @param sn
	 */
	void deleteBySn(Long sn);

	/**
	 *
	 * *
	 * @param sn
	 */
	List<T> getListByTagSn(Long sn);
}