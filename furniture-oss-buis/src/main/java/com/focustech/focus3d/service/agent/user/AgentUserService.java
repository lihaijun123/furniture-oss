package com.focustech.focus3d.service.agent.user;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentUserService<T> extends BaseEntityService<T> {

	public T getByMobilePhone(String mobilePhone);

	public T getByPartnerId(String partnerId);

	public void save(T t);
}
