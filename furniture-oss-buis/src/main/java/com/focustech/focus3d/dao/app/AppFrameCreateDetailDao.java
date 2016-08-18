package com.focustech.focus3d.dao.app;

import java.util.List;

import com.focustech.focus3d.model.app.AppFrameCreateDetail;
import com.focustech.oss2008.dao.BaseHibernateDao;

/**
 *
 * *
 * @author lihaijun
 *
 */
public interface AppFrameCreateDetailDao<T> extends BaseHibernateDao<T>{
	/**
	 *
	 * *
	 * @param appFrameSn
	 * @return
	 */
	public List<AppFrameCreateDetail> list(Long appFrameSn);
}
