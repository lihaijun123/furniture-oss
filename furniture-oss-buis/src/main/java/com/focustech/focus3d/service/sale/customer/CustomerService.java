package com.focustech.focus3d.service.sale.customer;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface CustomerService<T> extends BaseEntityService<T> {

	void insert(T t);

	void update(T t);

	public T selectAll(Long id);

	public T creat();

	public T updateStatus(Long id,Integer status);

	public T updateDelete(Long id);

	public T getCheckInfo(T t);

}
