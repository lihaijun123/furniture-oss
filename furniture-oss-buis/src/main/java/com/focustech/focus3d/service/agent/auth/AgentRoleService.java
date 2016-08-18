package com.focustech.focus3d.service.agent.auth;

import java.util.List;

import com.focustech.focus3d.model.agent.auth.AgentRole;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentRoleService<T extends AgentRole> extends BaseEntityService<T> {
	/**
	 *
	 * *
	 * @param active
	 * @return
	 */
	public List<T> selectByActive(int active);
}
