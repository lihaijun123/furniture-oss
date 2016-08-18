package com.focustech.focus3d.dao.agent.product;

import java.util.List;

import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentProductDao<T> extends BaseHibernateDao<T> {

	List<AgentProduct> getListByStatus(Integer status);


}
