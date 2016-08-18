package com.focustech.focus3d.service.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.app.AppProdVrArDao;
import com.focustech.focus3d.model.app.AppProdVrAr;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppProdVrArServiceImpl extends BaseEntityServiceImpl<AppProdVrAr> {
	@Autowired
	private AppProdVrArDao<AppProdVrAr> prodVrArDao;

	@Override
	public BaseHibernateDao<AppProdVrAr> getEntityDao() {
		return prodVrArDao;
	}

}
