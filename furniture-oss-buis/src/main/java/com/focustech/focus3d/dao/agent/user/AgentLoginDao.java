package com.focustech.focus3d.dao.agent.user;

import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentLoginDao<T> extends BaseHibernateDao<T> {

	public T getByUserId(long userId);
}
