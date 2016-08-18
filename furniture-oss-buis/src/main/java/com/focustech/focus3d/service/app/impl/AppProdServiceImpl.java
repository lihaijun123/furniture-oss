package com.focustech.focus3d.service.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.app.AppProdDao;
import com.focustech.focus3d.dao.app.AppProdVrArDao;
import com.focustech.focus3d.model.app.AppProd;
import com.focustech.focus3d.model.app.AppProdVrAr;
import com.focustech.focus3d.service.app.AppProdService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppProdServiceImpl extends BaseEntityServiceImpl<AppProd> implements AppProdService<AppProd> {

	@Autowired
	private AppProdDao<AppProd> prodDao;

	@Autowired
	private AppProdVrArDao<AppProdVrAr> prodVrArDao;

	@Override
	public BaseHibernateDao<AppProd> getEntityDao() {
		return prodDao;
	}
	@Override
	public void addVrAr(AppProd prod) {
		Long prodSn = prod.getSn();
		if(prodSn != null){
			AppProdVrAr vrAr = prod.getVrAr();
			boolean isNew = (vrAr.getSn() == null);
			prodVrArDao.insertOrUpdate(vrAr);
			if(isNew){
				prod = prodDao.select(prodSn);
				prod.setVrAr(vrAr);
			}
		}
	}

}
