package com.focustech.focus3d.service.companyinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focustech.focus3d.dao.companyinfo.CompanyInfoDao;
import com.focustech.focus3d.model.companyinfo.CompanyInfo;
import com.focustech.focus3d.service.companyinfo.CompanyInfoService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class CompanyInfoServiceImpl extends BaseEntityServiceImpl<CompanyInfo> implements CompanyInfoService<CompanyInfo> {
	@Autowired
	private CompanyInfoDao<CompanyInfo> companyInfoDao;

	@Override
	public BaseHibernateDao<CompanyInfo> getEntityDao() {
		return companyInfoDao;
	}


}
