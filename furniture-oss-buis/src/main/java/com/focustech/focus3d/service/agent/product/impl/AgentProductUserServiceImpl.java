package com.focustech.focus3d.service.agent.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.product.AgentProductUserDao;
import com.focustech.focus3d.model.agent.product.AgentProductUser;
import com.focustech.focus3d.service.agent.product.AgentProductUserService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentProductUserServiceImpl extends BaseEntityServiceImpl<AgentProductUser> implements AgentProductUserService<AgentProductUser> {

	@Autowired
	private AgentProductUserDao<AgentProductUser> agentProductUserDao;
	@Override
	public BaseHibernateDao<AgentProductUser> getEntityDao() {
		return agentProductUserDao;
	}

}
