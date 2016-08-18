package com.focustech.focus3d.dao.agent.order.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.order.AgentOrderItemDao;
import com.focustech.focus3d.model.agent.order.AgentOrderItem;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentOrderItemDaoImpl extends OssHibernateDaoSupport<AgentOrderItem> implements AgentOrderItemDao<AgentOrderItem> {

	@Override
	public List<AgentOrderItem> getByOrderId(long orderId) {
		Criteria criteria = getCurrentSession().createCriteria(AgentOrderItem.class);
		criteria.add(Restrictions.eq("orderId", orderId));
		return criteria.list();
	}

}
