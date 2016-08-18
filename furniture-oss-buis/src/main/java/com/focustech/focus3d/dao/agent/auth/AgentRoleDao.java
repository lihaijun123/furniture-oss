package com.focustech.focus3d.dao.agent.auth;

import java.util.List;

import com.focustech.focus3d.model.agent.auth.AgentRole;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentRoleDao<T extends AgentRole> extends BaseHibernateDao<T> {
	/**
	 *
	 * *
	 * @param status
	 * @return
	 */
	List<T> selectByActive(int active);
}
