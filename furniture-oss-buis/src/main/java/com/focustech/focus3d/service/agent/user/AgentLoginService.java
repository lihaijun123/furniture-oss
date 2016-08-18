package com.focustech.focus3d.service.agent.user;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentLoginService<T> extends BaseEntityService<T> {
	public T getByUserId(long userId);

	public boolean resetPwd(long userId);
}
