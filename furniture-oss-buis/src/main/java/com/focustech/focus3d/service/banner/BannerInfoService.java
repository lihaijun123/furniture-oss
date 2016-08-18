package com.focustech.focus3d.service.banner;

import com.focustech.oss2008.service.BaseEntityService;

/**
 *
 * *
 * @author lihaijun
 *
 */
public interface BannerInfoService<T> extends BaseEntityService<T> {

	public void insertOrUpdate(T t);

}
