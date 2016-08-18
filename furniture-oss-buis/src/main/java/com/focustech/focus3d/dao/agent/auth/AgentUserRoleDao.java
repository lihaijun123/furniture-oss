package com.focustech.focus3d.dao.agent.auth;

import java.util.List;

import com.focustech.focus3d.model.agent.auth.AgentUserRole;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 */

public interface AgentUserRoleDao<T extends AgentUserRole> extends BaseHibernateDao<T> {

	void deleteByUserSn(long userSn);

	List<T> selectByUserSn(Long userSn);

}
