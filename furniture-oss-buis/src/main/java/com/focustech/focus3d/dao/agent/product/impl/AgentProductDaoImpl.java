package com.focustech.focus3d.dao.agent.product.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.agent.product.AgentProductDao;
import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AgentProductDaoImpl extends OssHibernateDaoSupport<AgentProduct> implements AgentProductDao<AgentProduct> {

	@Override
	public List<AgentProduct> getListByStatus(Integer status) {
		Criteria criteria = getCurrentSession().createCriteria(AgentProduct.class);
		if(status != null){
			criteria.add(Restrictions.eq("status", status));
		}
		return criteria.list();
	}
}
