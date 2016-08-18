package com.focustech.focus3d.dao.sale.contact.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.sale.contact.ContactDao;
import com.focustech.focus3d.model.sale.contact.Contact;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;

@Repository
public class ContactDaoImpl extends OssHibernateDaoSupport<Contact> implements
		ContactDao<Contact> {

	@Override
	public List<Contact> getListByCustomerSn(Long customerSn) {
		String hql = " from " + Contact.class.getName() + " where CUSTOMER_SN ="+ customerSn +" order by SN desc";
		return getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Contact> getPlanListByCustomerSn(String sellerSn) {
		String hql = " from " + Contact.class.getName() + " where SELLER_SN ="+ sellerSn +" and PLAN_TIME is not null and IS_PLAN_DONE = 0";
		return getCurrentSession().createQuery(hql).list();
	}

	public int updatePlanBySn(Long sn, Long planContactSn) {
        String hql = "update  " + Contact.class.getName() + "  set IS_PLAN_DONE =1,PLAN_CONTACT_SN=? where SN =? ";
        return getCurrentSession().createQuery(hql).setLong(0, planContactSn).setLong(1, sn)
                .executeUpdate();
    }

	public void deleteByCustomerSn(Long customerSn) {
		String hql = " delete from " + Contact.class.getName() + " where CUSTOMER_SN=" + customerSn;
		getCurrentSession().createQuery(hql).executeUpdate();
    }
}
