package com.focustech.focus3d.dao.prodcase.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.prodcase.ProdCaseFileDao;
import com.focustech.focus3d.model.prodcase.ProdCaseFile;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class ProdCaseFileDaoImpl extends OssHibernateDaoSupport<ProdCaseFile> implements ProdCaseFileDao<ProdCaseFile> {

}
