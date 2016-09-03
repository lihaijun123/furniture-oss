package com.focustech.furniture.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.focustech.furniture.house.dao.FntHouseDao;
import com.focustech.furniture.model.FntHouse;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Repository
public class FntHouseDaoImpl extends OssHibernateDaoSupport<FntHouse> implements FntHouseDao<FntHouse> {

}
