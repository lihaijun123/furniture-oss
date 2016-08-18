package com.focustech.focus3d.service.agent.product;



import java.util.List;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentProductService<T> extends BaseEntityService<T> {


	public List<T> getListByStatus(Integer status);

	public List<T> getListByUserId(long userId);
}
