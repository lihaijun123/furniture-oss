package com.focustech.focus3d.dao.agent.order.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.order.AgentOrderLogtcDao;
import com.focustech.focus3d.model.agent.order.AgentOrderLogtc;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentOrderLogtcDaoImpl extends OssHibernateDaoSupport<AgentOrderLogtc> implements AgentOrderLogtcDao<AgentOrderLogtc> {

	@Override
	public AgentOrderLogtc getByOrderId(long orderId) {
		Criteria criteria = getCurrentSession().createCriteria(AgentOrderLogtc.class);
		criteria.add(Restrictions.eq("orderId", orderId));
		return (AgentOrderLogtc) criteria.uniqueResult();
	}

}
