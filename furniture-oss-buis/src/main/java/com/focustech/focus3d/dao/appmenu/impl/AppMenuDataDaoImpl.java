package com.focustech.focus3d.dao.appmenu.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.appmenu.AppMenuDataDao;
import com.focustech.focus3d.model.appmenu.AppMenuData;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AppMenuDataDaoImpl extends OssHibernateDaoSupport<AppMenuData> implements AppMenuDataDao<AppMenuData> {

}
