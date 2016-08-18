package com.focustech.focus3d.service.agent.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.auth.AgentRoleDao;
import com.focustech.focus3d.model.agent.auth.AgentRole;
import com.focustech.focus3d.service.agent.auth.AgentRoleService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentRoleServiceImpl extends BaseEntityServiceImpl<AgentRole> implements AgentRoleService<AgentRole> {
	@Autowired
	private AgentRoleDao<AgentRole> agentRoleDao;
	@Override
	public BaseHibernateDao<AgentRole> getEntityDao() {
		return agentRoleDao;
	}
	@Override
	public List<AgentRole> selectByActive(int active) {
		return agentRoleDao.selectByActive(active);
	}

}
