package com.focustech.focus3d.service.sale.contact;

import java.util.List;

import com.focustech.oss2008.service.BaseEntityService;

public interface ContactService<T> extends BaseEntityService<T> {

	public T creat(Long customerSn);

	void insert(T t);

	public List<T> getContactList(Long customerSn);

	public List<T> getContactPlanList();

	public T select(Long id);

	void insertPlan(T t);

}
