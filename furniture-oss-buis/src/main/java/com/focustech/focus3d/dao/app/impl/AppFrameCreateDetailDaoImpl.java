package com.focustech.focus3d.dao.app.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.app.AppFrameCreateDetailDao;
import com.focustech.focus3d.model.app.AppFrameCreateDetail;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AppFrameCreateDetailDaoImpl extends OssHibernateDaoSupport<AppFrameCreateDetail> implements AppFrameCreateDetailDao<AppFrameCreateDetail>{
	/**
	 *
	 * *
	 */
	@Override
	public List<AppFrameCreateDetail> list(Long appFrameSn) {
		Criteria criteria = getCurrentSession().createCriteria(AppFrameCreateDetail.class);
		criteria.add(Restrictions.eq("app.sn", appFrameSn));
		return criteria.list();
	}

}
