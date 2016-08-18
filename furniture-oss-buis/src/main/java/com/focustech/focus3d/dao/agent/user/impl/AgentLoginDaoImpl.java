package com.focustech.focus3d.dao.agent.user.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.user.AgentLoginDao;
import com.focustech.focus3d.model.agent.user.AgentLogin;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentLoginDaoImpl extends OssHibernateDaoSupport<AgentLogin> implements AgentLoginDao<AgentLogin> {

	@Override
	public AgentLogin getByUserId(long userId) {
		Criteria criteria = getCurrentSession().createCriteria(AgentLogin.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (AgentLogin)criteria.uniqueResult();
	}

}
