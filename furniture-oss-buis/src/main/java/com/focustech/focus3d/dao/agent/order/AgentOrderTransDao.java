package com.focustech.focus3d.dao.agent.order;

import com.focustech.focus3d.model.agent.order.AgentOrderTrans;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentOrderTransDao<T> extends BaseHibernateDao<T> {

	AgentOrderTrans getByOrderId(String orderId);

}
