package com.focustech.focus3d.service.agent.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.order.AgentReceiveAddressDao;
import com.focustech.focus3d.model.agent.order.AgentReceiveAddress;
import com.focustech.focus3d.service.agent.order.AgentReceiveAddressService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentReceiveAddressServiceImpl extends BaseEntityServiceImpl<AgentReceiveAddress> implements AgentReceiveAddressService<AgentReceiveAddress> {
	@Autowired
	private AgentReceiveAddressDao<AgentReceiveAddress> agentReceiveAddressDao;
	@Override
	public BaseHibernateDao<AgentReceiveAddress> getEntityDao() {
		return agentReceiveAddressDao;
	}

}
