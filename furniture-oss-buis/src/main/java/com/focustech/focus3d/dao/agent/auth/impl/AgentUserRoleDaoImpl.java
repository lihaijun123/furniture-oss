package com.focustech.focus3d.dao.agent.auth.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.auth.AgentUserRoleDao;
import com.focustech.focus3d.model.agent.auth.AgentUserRole;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentUserRoleDaoImpl extends OssHibernateDaoSupport<AgentUserRole> implements AgentUserRoleDao<AgentUserRole> {

	@Override
	public void deleteByUserSn(long userSn) {
		String hql = " delete from " + AgentUserRole.class.getName() + " _a_u_r where _a_u_r.userSn=?";
		getCurrentSession().createQuery(hql).setLong(0, userSn).executeUpdate();
	}

	@Override
	public List<AgentUserRole> selectByUserSn(Long userSn) {
		Criteria criteria = getCurrentSession().createCriteria(AgentUserRole.class);
		criteria.add(Restrictions.eq("userSn", userSn));
		return criteria.list();
	}

}
