package com.focustech.focus3d.dao.companyinfo.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.companyinfo.CompanyInfoDao;
import com.focustech.focus3d.model.companyinfo.CompanyInfo;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class CompanyInfoDaoImpl extends OssHibernateDaoSupport<CompanyInfo> implements CompanyInfoDao<CompanyInfo> {

}
