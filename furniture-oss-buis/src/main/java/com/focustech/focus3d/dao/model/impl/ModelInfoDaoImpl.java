package com.focustech.focus3d.dao.model.impl;

import com.focustech.focus3d.dao.model.ModelInfoDao;
import com.focustech.focus3d.model.model.ModelInfo;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ModelInfoDaoImpl extends OssHibernateDaoSupport<ModelInfo> implements ModelInfoDao<ModelInfo> {

}
