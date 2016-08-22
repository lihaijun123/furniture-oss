package com.focustech.focus3d.service.banner.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.banner.BannerInfoDao;
import com.focustech.focus3d.model.banner.BannerInfo;
import com.focustech.focus3d.service.banner.BannerInfoService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class BannerInfoServiceImpl extends BaseEntityServiceImpl<BannerInfo> implements BannerInfoService<BannerInfo> {
	@Autowired
	private BannerInfoDao<BannerInfo> bannerInfoDao;

	@Override
	public BaseHibernateDao<BannerInfo> getEntityDao() {
		return bannerInfoDao;
	}

	@Override
	public void insertOrUpdate(BannerInfo t) {
		bannerInfoDao.insertOrUpdate(t);
		publishToJms();
	}

	public void publishToJms(){
	}
}
