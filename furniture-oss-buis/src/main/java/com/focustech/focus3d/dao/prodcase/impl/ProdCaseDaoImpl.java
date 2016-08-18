package com.focustech.focus3d.dao.prodcase.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.prodcase.ProdCaseDao;
import com.focustech.focus3d.model.prodcase.ProdCase;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 * *
 * @author lihaijun
 *
 */
@Repository
public class ProdCaseDaoImpl extends OssHibernateDaoSupport<ProdCase> implements ProdCaseDao<ProdCase> {

}
