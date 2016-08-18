package com.focustech.focus3d.dao.sale.customer.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.sale.customer.CustomerTagDao;
import com.focustech.focus3d.model.sale.customer.CustomerTag;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;

/**
*
* *
* @author yangrongrong
*
*/
@Repository
public class CustomerTagDaoImpl extends OssHibernateDaoSupport<CustomerTag> implements
		CustomerTagDao<CustomerTag> {

	@Override
	public void deleteBySn(Long sn) {
		String hql = " delete from " + CustomerTag.class.getName() + " where sn=" + sn;
		getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<CustomerTag> getListByCustomerSn(Long customerSn) {
		String hql = " from " + CustomerTag.class.getName() + " where CUSTOMER_SN=" + customerSn;
		return getCurrentSession().createQuery(hql).list();
	}
}
