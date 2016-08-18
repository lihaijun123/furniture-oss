package com.focustech.focus3d.service.app;

import com.focustech.focus3d.model.app.AppProd;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AppProdService<T> extends BaseEntityService<T> {
	/**
	 *
	 * *
	 * @param prod
	 */
	public void addVrAr(AppProd prod);
}
