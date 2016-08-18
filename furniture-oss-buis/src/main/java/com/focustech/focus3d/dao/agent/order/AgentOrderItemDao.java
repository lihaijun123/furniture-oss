package com.focustech.focus3d.dao.agent.order;

import java.util.List;

import com.focustech.focus3d.model.agent.order.AgentOrderItem;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentOrderItemDao<T> extends BaseHibernateDao<T> {

	List<AgentOrderItem> getByOrderId(long orderId);

}
