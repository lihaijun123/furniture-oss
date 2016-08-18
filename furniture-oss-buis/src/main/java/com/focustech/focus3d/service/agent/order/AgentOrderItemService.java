package com.focustech.focus3d.service.agent.order;

import java.util.List;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentOrderItemService<T> extends BaseEntityService<T> {

	public List<T> getByOrderId(long orderId);
}
