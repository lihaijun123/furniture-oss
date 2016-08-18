package com.focustech.focus3d.service.mxjad.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.mxjad.MxjAdDao;
import com.focustech.focus3d.model.mxjad.MxjAd;
import com.focustech.focus3d.service.mxjad.MxjAdService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class MxjAdServiceImpl extends BaseEntityServiceImpl<MxjAd> implements MxjAdService<MxjAd> {
	@Autowired
	private MxjAdDao<MxjAd> mxjAdDao;
	@Override
	public BaseHibernateDao<MxjAd> getEntityDao() {
		return mxjAdDao;
	}

}
