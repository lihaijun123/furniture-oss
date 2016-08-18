package com.focustech.focus3d.dao.agent.auth.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.auth.AgentRoleDao;
import com.focustech.focus3d.model.agent.auth.AgentRole;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentRoleDaoImpl extends OssHibernateDaoSupport<AgentRole> implements AgentRoleDao<AgentRole> {

	@Override
	public List<AgentRole> selectByActive(int active) {
		Criteria criteria = getCurrentSession().createCriteria(AgentRole.class);
		criteria.add(Restrictions.eq("active", active));
		return criteria.list();
	}

}
