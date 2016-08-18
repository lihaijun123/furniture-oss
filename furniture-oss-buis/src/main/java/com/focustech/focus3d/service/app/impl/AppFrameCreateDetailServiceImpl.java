package com.focustech.focus3d.service.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.app.AppFrameCreateDetailDao;
import com.focustech.focus3d.model.app.AppFrameCreateDetail;
import com.focustech.focus3d.service.app.AppFrameCreateDetailService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppFrameCreateDetailServiceImpl extends BaseEntityServiceImpl<AppFrameCreateDetail> implements AppFrameCreateDetailService<AppFrameCreateDetail>{
	@Autowired
	private AppFrameCreateDetailDao<AppFrameCreateDetail> appFrameCreateDetailDao;

	@Override
	public BaseHibernateDao<AppFrameCreateDetail> getEntityDao() {
		return appFrameCreateDetailDao;
	}

	@Override
	public List<AppFrameCreateDetail> list(Long appFrameSn) {
		return appFrameCreateDetailDao.list(appFrameSn);
	}

}
