package com.focustech.focus3d.dao.agent.product;

import java.util.List;

import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentProductUserDao<T> extends BaseHibernateDao<T> {

	public void deleteByUserId(long userId);

	public List<T> getListByUserId(long userId);
}
