package com.focustech.focus3d.service.agent.order;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentOrderLogtcService<T> extends BaseEntityService<T> {
	public T getByOrderId(long orderId);
}
