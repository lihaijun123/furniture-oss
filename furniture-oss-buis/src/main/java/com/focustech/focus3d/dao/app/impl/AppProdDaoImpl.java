package com.focustech.focus3d.dao.app.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.app.AppProdDao;
import com.focustech.focus3d.model.app.AppProd;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AppProdDaoImpl extends OssHibernateDaoSupport<AppProd> implements AppProdDao<AppProd> {

}
