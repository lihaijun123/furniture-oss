package com.focustech.focus3d.service.agent.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.order.AgentOrderLogtcDao;
import com.focustech.focus3d.model.agent.order.AgentOrderLogtc;
import com.focustech.focus3d.service.agent.order.AgentOrderLogtcService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentOrderLogtcServiceImpl extends BaseEntityServiceImpl<AgentOrderLogtc> implements AgentOrderLogtcService<AgentOrderLogtc> {
	@Autowired
	private AgentOrderLogtcDao<AgentOrderLogtc> agentOrderLogtcDao;
	@Override
	public BaseHibernateDao<AgentOrderLogtc> getEntityDao() {
		return agentOrderLogtcDao;
	}
	@Override
	public AgentOrderLogtc getByOrderId(long orderId) {

		return agentOrderLogtcDao.getByOrderId(orderId);
	}

}
