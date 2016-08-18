package com.focustech.focus3d.service.agent.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.agent.product.AgentProductDao;
import com.focustech.focus3d.dao.agent.product.AgentProductUserDao;
import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.focus3d.model.agent.product.AgentProductUser;
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
public class AgentProductServiceImpl extends BaseEntityServiceImpl<AgentProduct> implements AgentProductService<AgentProduct> {
	@Autowired
	private AgentProductDao<AgentProduct> agentProductDao;
	@Autowired
	private AgentProductUserDao<AgentProductUser> agentProductUserDao;
	@Override
	public BaseHibernateDao<AgentProduct> getEntityDao() {
		return agentProductDao;
	}
	@Override
	public List<AgentProduct> getListByStatus(Integer status) {
		return agentProductDao.getListByStatus(status);
	}
	@Override
	public List<AgentProduct> getListByUserId(long userId) {
		List<AgentProduct> agentProducts = new ArrayList<AgentProduct>();
		List<AgentProductUser> agentProductUsers = agentProductUserDao.getListByUserId(userId);
		for (AgentProductUser agentProductUser : agentProductUsers) {
			Long productId = agentProductUser.getProductId();
			AgentProduct agentProduct = agentProductDao.select(productId);
			Integer status = agentProduct.getStatus();
			if(status == 1){
				agentProducts.add(agentProduct);
			}
		}
		return agentProducts;
	}

}
