package com.focustech.oss2008.service.impl;

import java.io.Serializable;

import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.AbstractServiceSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
public abstract class BaseEntityServiceImpl<T> extends AbstractServiceSupport{

	public abstract BaseHibernateDao<T> getEntityDao();

	public void insert(T t) {
		getEntityDao().insert(t);
	}

	public void update(T t) {
		getEntityDao().update(t);
	}

	public void insertOrUpdate(T t) {
		getEntityDao().insertOrUpdate(t);
	}

	public void delete(Serializable id) {
		getEntityDao().delete(id);
	}

	public void delete(T t) {
		getEntityDao().delete(t);
	}

	public T select(Serializable id) {
		return getEntityDao().select(id);
	}
}
