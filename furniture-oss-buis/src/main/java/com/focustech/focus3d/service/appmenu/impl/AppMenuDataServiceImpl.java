package com.focustech.focus3d.service.appmenu.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.appmenu.AppMenuDataDao;
import com.focustech.focus3d.model.appmenu.AppMenuData;
import com.focustech.focus3d.service.appmenu.AppMenuDataService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppMenuDataServiceImpl extends BaseEntityServiceImpl<AppMenuData> implements AppMenuDataService<AppMenuData> {
	@Autowired
	private AppMenuDataDao<AppMenuData> appMenuDataDao;

	public static final String SERVICE_KEYS = "focus3d.mxj.appmenu.data.get,focus3d.mxj.appmenu.data.list.get";
	@Override
	public BaseHibernateDao<AppMenuData> getEntityDao() {
		return appMenuDataDao;
	}

	@Override
	public void update(AppMenuData t) {
		super.update(t);
	}

	@Override
	public void insertOrUpdate(AppMenuData t) {
		super.insertOrUpdate(t);
	}
}
