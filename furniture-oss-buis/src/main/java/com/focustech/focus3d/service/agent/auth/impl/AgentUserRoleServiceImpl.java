package com.focustech.focus3d.service.agent.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.auth.AgentUserRoleDao;
import com.focustech.focus3d.model.agent.auth.AgentUserRole;
import com.focustech.focus3d.service.agent.auth.AgentUserRoleService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentUserRoleServiceImpl extends BaseEntityServiceImpl<AgentUserRole> implements AgentUserRoleService<AgentUserRole> {
	@Autowired
	private AgentUserRoleDao<AgentUserRole> agentUserRoleDao;
	@Override
	public BaseHibernateDao<AgentUserRole> getEntityDao() {
		return agentUserRoleDao;
	}
	@Override
	public void deleteByUserSn(long userSn) {
		agentUserRoleDao.deleteByUserSn(userSn);
	}
	@Override
	public List<AgentUserRole> selectByUserSn(Long userSn) {
		return agentUserRoleDao.selectByUserSn(userSn);
	}

}
