package com.focustech.focus3d.dao.sale.customer;

import java.util.List;

import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface CustomerDao<T> extends BaseHibernateDao<T> {
	/**
	 *
	 * *
	 * @param sn
	 */
	List<T> getListByCustomerName(String name);

	/**
	 *
	 * *
	 * @param sn
	 */
	List<T> getListByCustomerPhone(String phone);
}
