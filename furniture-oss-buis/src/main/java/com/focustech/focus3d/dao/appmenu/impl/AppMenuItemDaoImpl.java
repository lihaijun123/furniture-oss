package com.focustech.focus3d.dao.appmenu.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.appmenu.AppMenuItemDao;
import com.focustech.focus3d.model.appmenu.AppMenuItem;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AppMenuItemDaoImpl extends OssHibernateDaoSupport<AppMenuItem> implements AppMenuItemDao<AppMenuItem> {

	@Override
	public List<AppMenuItem> getList() {
		Criteria c = getCurrentSession().createCriteria(AppMenuItem.class);
		c.add(Restrictions.ne("keyValue", "UI"));
		c.addOrder(Order.asc("type"));
		return c.list();
	}

}
