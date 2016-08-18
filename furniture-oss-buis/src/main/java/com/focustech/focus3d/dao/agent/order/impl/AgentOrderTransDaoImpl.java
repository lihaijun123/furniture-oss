package com.focustech.focus3d.dao.agent.order.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.order.AgentOrderTransDao;
import com.focustech.focus3d.model.agent.order.AgentOrderTrans;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentOrderTransDaoImpl extends OssHibernateDaoSupport<AgentOrderTrans> implements AgentOrderTransDao<AgentOrderTrans> {

	@Override
	public AgentOrderTrans getByOrderId(String orderId) {
		Criteria criteria = getCurrentSession().createCriteria(AgentOrderTrans.class);
		criteria.add(Restrictions.eq("orderId", orderId));
		return (AgentOrderTrans) criteria.uniqueResult();
	}

}
