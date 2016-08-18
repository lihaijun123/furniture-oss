package com.focustech.focus3d.service.agent.auth;

import java.util.List;

import com.focustech.focus3d.model.agent.auth.AgentUserRole;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentUserRoleService<T extends AgentUserRole> extends BaseEntityService<T> {
	void deleteByUserSn(long userSn);

	List<T> selectByUserSn(Long userSn);
}
