package com.focustech.focus3d.service.appmenu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.appmenu.AppMenuItemDao;
import com.focustech.focus3d.model.appmenu.AppMenuItem;
import com.focustech.focus3d.service.appmenu.AppMenuItemService;
import com.focustech.focus3d.service.mq.AppMenuPublish;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppMenuItemServiceImpl extends BaseEntityServiceImpl<AppMenuItem> implements AppMenuItemService<AppMenuItem> {
	@Autowired
	private AppMenuItemDao<AppMenuItem> appMenuItemDao;
	@Autowired
	private AppMenuPublish appMenuPublish;

	public static final String SERVICE_KEYS = "focus3d.mxj.appmenu.item.list.get";

	@Override
	public BaseHibernateDao<AppMenuItem> getEntityDao() {
		return appMenuItemDao;
	}

	@Override
	public void update(AppMenuItem t) {
		super.update(t);
		appMenuPublish.publish(SERVICE_KEYS);
	}

	@Override
	public void insertOrUpdate(AppMenuItem t) {
		super.insertOrUpdate(t);
		appMenuPublish.publish(SERVICE_KEYS);
	}

	@Override
	public List<AppMenuItem> getList() {
		return appMenuItemDao.getList();
	}



}
