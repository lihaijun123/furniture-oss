package com.focustech.focus3d.service.agent.order;

import com.focustech.oss2008.service.BaseEntityService;

public interface AgentOrderTransService<T> extends BaseEntityService<T> {
	/**
	 *
	 * *
	 * @param orderId
	 * @return
	 */
	T getByOrderId(String orderId);
}
