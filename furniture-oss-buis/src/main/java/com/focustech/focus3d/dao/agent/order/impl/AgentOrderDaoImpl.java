package com.focustech.focus3d.dao.agent.order.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.order.AgentOrderDao;
import com.focustech.focus3d.model.agent.order.AgentOrder;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 */
@Repository
public class AgentOrderDaoImpl extends OssHibernateDaoSupport<AgentOrder> implements AgentOrderDao<AgentOrder> {

}
