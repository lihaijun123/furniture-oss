package com.focustech.focus3d.service.prodcase;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface ProdCaseService<T> extends BaseEntityService<T> {

	void insertOrUpdate(T t);
}
