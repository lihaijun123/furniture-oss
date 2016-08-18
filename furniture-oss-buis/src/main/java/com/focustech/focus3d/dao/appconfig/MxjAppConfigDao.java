package com.focustech.focus3d.dao.appconfig;

import java.util.List;

import com.focustech.focus3d.model.appconfig.MxjAppConfig;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MxjAppConfigDao<T extends MxjAppConfig> extends BaseHibernateDao<T>{

	List<MxjAppConfig> getList();

}
