package com.focustech.focus3d.dao.agent.product.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.product.AgentProductUserDao;
import com.focustech.focus3d.model.agent.product.AgentProductUser;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentProductUserDaoImpl extends OssHibernateDaoSupport<AgentProductUser> implements AgentProductUserDao<AgentProductUser> {

	@Override
	public void deleteByUserId(long userId) {
		String hql = " delete from " + AgentProductUser.class.getName() + " where userId=?";
		getCurrentSession().createQuery(hql).setLong(0, userId).executeUpdate();

	}

	@Override
	public List<AgentProductUser> getListByUserId(long userId) {
		Criteria criteria = getCurrentSession().createCriteria(AgentProductUser.class);
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}

}
