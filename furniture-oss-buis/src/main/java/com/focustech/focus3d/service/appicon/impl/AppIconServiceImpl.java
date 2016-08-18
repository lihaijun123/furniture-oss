package com.focustech.focus3d.service.appicon.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.appicon.AppIconLibDao;
import com.focustech.focus3d.model.appicon.AppIconLib;
import com.focustech.focus3d.service.appicon.AppIconService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppIconServiceImpl extends BaseEntityServiceImpl<AppIconLib> implements AppIconService<AppIconLib> {

	@Autowired
	private AppIconLibDao<AppIconLib> appIconLibDao;

	@Override
	public BaseHibernateDao<AppIconLib> getEntityDao() {
		return appIconLibDao;
	}

}
