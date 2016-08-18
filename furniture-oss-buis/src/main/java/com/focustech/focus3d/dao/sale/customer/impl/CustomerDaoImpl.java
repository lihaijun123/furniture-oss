package com.focustech.focus3d.dao.sale.customer.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.sale.customer.CustomerDao;
import com.focustech.focus3d.model.sale.customer.Customer;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author yangrongrong
 *
 */
@Repository
public class CustomerDaoImpl extends OssHibernateDaoSupport<Customer> implements CustomerDao<Customer> {
	@Override
	public List<Customer> getListByCustomerName(String customerName) {
		String hql = " from " + Customer.class.getName() + " where IS_DELETE = 0 and NAME like '" + customerName+"' or NAME like '%,"+ customerName+",%'"+" or NAME like '"+ customerName+",%'"+" or NAME like '%,"+ customerName+"'";
		return getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Customer> getListByCustomerPhone(String customerPhone) {
		String hql = " from " + Customer.class.getName() + " where IS_DELETE = 0 and TELEPHONE like '" + customerPhone+"-%' or TELEPHONE like '%,"+ customerPhone+"-%'";
		return getCurrentSession().createQuery(hql).list();
	}
}
