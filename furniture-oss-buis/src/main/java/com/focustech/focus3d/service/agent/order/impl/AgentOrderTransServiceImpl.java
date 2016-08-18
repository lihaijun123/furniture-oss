package com.focustech.focus3d.service.agent.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.order.AgentOrderTransDao;
import com.focustech.focus3d.model.agent.order.AgentOrderTrans;
import com.focustech.focus3d.service.agent.order.AgentOrderTransService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentOrderTransServiceImpl extends BaseEntityServiceImpl<AgentOrderTrans> implements AgentOrderTransService<AgentOrderTrans> {
	@Autowired
	private AgentOrderTransDao<AgentOrderTrans> agentOrderTransDao;
	@Override
	public BaseHibernateDao<AgentOrderTrans> getEntityDao() {
		return agentOrderTransDao;
	}
	@Override
	public AgentOrderTrans getByOrderId(String orderId) {
		return agentOrderTransDao.getByOrderId(orderId);
	}

}
