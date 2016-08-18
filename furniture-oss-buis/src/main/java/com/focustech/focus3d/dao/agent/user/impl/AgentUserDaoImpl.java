package com.focustech.focus3d.dao.agent.user.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.user.AgentUserDao;
import com.focustech.focus3d.model.agent.user.AgentUser;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentUserDaoImpl extends OssHibernateDaoSupport<AgentUser> implements AgentUserDao<AgentUser> {

	@Override
	public AgentUser getByMobilePhone(String mobilePhone) {
		Criteria criteria = getCurrentSession().createCriteria(AgentUser.class);
		criteria.add(Restrictions.eq("mobilePhone", mobilePhone));
		return (AgentUser)criteria.uniqueResult();
	}

	@Override
	public AgentUser getByPartnerId(String partnerId) {
		Criteria criteria = getCurrentSession().createCriteria(AgentUser.class);
		criteria.add(Restrictions.eq("partnerId", partnerId));
		return (AgentUser)criteria.uniqueResult();
	}

}
