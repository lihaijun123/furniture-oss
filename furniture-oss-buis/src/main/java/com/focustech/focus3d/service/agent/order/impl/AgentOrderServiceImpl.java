package com.focustech.focus3d.service.agent.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.order.AgentOrderDao;
import com.focustech.focus3d.model.agent.order.AgentOrder;
import com.focustech.focus3d.service.agent.order.AgentOrderService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentOrderServiceImpl extends BaseEntityServiceImpl<AgentOrder> implements AgentOrderService<AgentOrder> {
	@Autowired
	private AgentOrderDao<AgentOrder> agentOrderDao;
	@Override
	public BaseHibernateDao<AgentOrder> getEntityDao() {
		return agentOrderDao;
	}

}
