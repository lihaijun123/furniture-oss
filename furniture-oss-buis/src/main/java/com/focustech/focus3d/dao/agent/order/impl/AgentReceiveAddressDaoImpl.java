package com.focustech.focus3d.dao.agent.order.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.order.AgentReceiveAddressDao;
import com.focustech.focus3d.model.agent.order.AgentReceiveAddress;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentReceiveAddressDaoImpl extends OssHibernateDaoSupport<AgentReceiveAddress> implements AgentReceiveAddressDao<AgentReceiveAddress> {

}
