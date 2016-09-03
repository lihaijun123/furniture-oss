package com.focustech.furniture.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.furniture.house.dao.FntHouseDao;
import com.focustech.furniture.house.service.FntHouseService;
import com.focustech.furniture.model.FntHouse;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
public class FntHouseServiceImpl extends BaseEntityServiceImpl<FntHouse> implements FntHouseService<FntHouse> {
	@Autowired
	private FntHouseDao<FntHouse> houseDao;
	@Override
	public BaseHibernateDao<FntHouse> getEntityDao() {
		return houseDao;
	}

}
