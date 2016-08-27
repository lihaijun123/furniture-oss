package com.focustech.furniture.product.dao.impl;

import org.springframework.stereotype.Repository;

import com.focustech.furniture.model.FntProduct;
import com.focustech.furniture.product.dao.FntProductDao;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Repository
public class FntProductDaoImpl extends OssHibernateDaoSupport<FntProduct> implements FntProductDao<FntProduct> {

}
