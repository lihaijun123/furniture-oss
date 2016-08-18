package com.focustech.focus3d.dao.model.impl;

import com.focustech.focus3d.dao.model.ModelContentInfoDao;
import com.focustech.focus3d.model.model.ModelContentInfo;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ModelContentInfoDaoImpl extends OssHibernateDaoSupport<ModelContentInfo> implements ModelContentInfoDao<ModelContentInfo> {

}
