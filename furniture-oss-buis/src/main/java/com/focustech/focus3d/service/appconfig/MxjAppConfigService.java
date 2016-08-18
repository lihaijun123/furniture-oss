package com.focustech.focus3d.service.appconfig;

import java.util.List;

import com.focustech.focus3d.model.appconfig.MxjAppConfig;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MxjAppConfigService<T extends MxjAppConfig> extends BaseEntityService<T> {

	public void copyConfig(T newObj, Long targetSn);

	public List<T> getList();

}
