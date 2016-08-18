package com.focustech.focus3d.dao.appmenu.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.appmenu.AppIdentifyFileDao;
import com.focustech.focus3d.model.appmenu.AppIdentifyFile;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class AppIdentifyFileDaoImpl extends OssHibernateDaoSupport<AppIdentifyFile> implements AppIdentifyFileDao<AppIdentifyFile> {

}
