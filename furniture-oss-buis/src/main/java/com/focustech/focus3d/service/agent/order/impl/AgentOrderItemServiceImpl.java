package com.focustech.focus3d.service.agent.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.order.AgentOrderItemDao;
import com.focustech.focus3d.model.agent.order.AgentOrderItem;
import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.focus3d.service.agent.order.AgentOrderItemService;
import com.focustech.focus3d.service.agent.product.AgentProductService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentOrderItemServiceImpl extends BaseEntityServiceImpl<AgentOrderItem> implements AgentOrderItemService<AgentOrderItem> {
	@Autowired
	private AgentOrderItemDao<AgentOrderItem> agentOrderItemDao;
	@Autowired
	private AgentProductService<AgentProduct> agentProductService;
	@Override
	public BaseHibernateDao<AgentOrderItem> getEntityDao() {
		return agentOrderItemDao;
	}
	@Override
	public List<AgentOrderItem> getByOrderId(long orderId) {
		List<AgentOrderItem> orderItems = agentOrderItemDao.getByOrderId(orderId);
		for (AgentOrderItem agentOrderItem : orderItems) {
			Long productId = agentOrderItem.getProductId();
			if(productId != null){
				AgentProduct product = agentProductService.select(productId);
				agentOrderItem.setAgentProduct(product);
			}
		}
		return orderItems;
	}

}
