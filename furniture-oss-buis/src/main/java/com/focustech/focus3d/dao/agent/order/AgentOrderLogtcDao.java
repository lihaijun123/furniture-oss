package com.focustech.focus3d.dao.agent.order;

import com.focustech.focus3d.model.agent.order.AgentOrderLogtc;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentOrderLogtcDao<T> extends BaseHibernateDao<T> {

	AgentOrderLogtc getByOrderId(long orderId);

}
