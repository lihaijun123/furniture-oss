package com.focustech.focus3d.dao.app.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.app.AppFrameDao;
import com.focustech.focus3d.model.app.AppFrame;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AppFrameDaoImpl extends OssHibernateDaoSupport<AppFrame> implements AppFrameDao<AppFrame>{

	@Override
	public List<AppFrame> list(Integer status) {
		Criteria criteria = getCurrentSession().createCriteria(AppFrame.class);
		criteria.add(Restrictions.eq("status", status));
		return criteria.list();
	}

}
