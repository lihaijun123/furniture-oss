package com.focustech.focus3d.dao.appconfig.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.appconfig.MxjAppConfigDao;
import com.focustech.focus3d.model.appconfig.MxjAppConfig;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class MxjAppConfigDaoImpl extends OssHibernateDaoSupport<MxjAppConfig> implements MxjAppConfigDao<MxjAppConfig> {

	@Override
	public List<MxjAppConfig> getList() {
		Criteria c = getCurrentSession().createCriteria(MxjAppConfig.class);
		return c.list();
	}

}
