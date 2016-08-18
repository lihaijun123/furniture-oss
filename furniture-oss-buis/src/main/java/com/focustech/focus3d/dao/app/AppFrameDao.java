package com.focustech.focus3d.dao.app;

import java.util.List;

import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AppFrameDao<T> extends BaseHibernateDao<T>  {
	/**
	 *
	 * *
	 * @param status
	 * @return
	 */
	public List<T> list(Integer status);
}
