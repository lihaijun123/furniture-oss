package com.focustech.focus3d.dao.appmenu;

import java.util.List;

import com.focustech.focus3d.model.appmenu.AppMenuItem;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AppMenuItemDao<T> extends BaseHibernateDao<T> {

	List<AppMenuItem> getList();

}
