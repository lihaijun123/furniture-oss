package com.focustech.focus3d.dao.prodcase.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.prodcase.ProdCaseFileContentDao;
import com.focustech.focus3d.model.prodcase.ProdCaseFileContent;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class ProdCaseFileContentDaoImpl extends OssHibernateDaoSupport<ProdCaseFileContent> implements ProdCaseFileContentDao<ProdCaseFileContent> {

	@Override
	public List<ProdCaseFileContent> getListByCaseFile(Long caseFileSn) {
		String hql = " from " + ProdCaseFileContent.class.getName() + " where prodCaseFile.sn=" + caseFileSn;
		return getCurrentSession().createQuery(hql).list();
	}

	@Override
	public void deleteBySn(Long sn) {
		String hql = " delete from " + ProdCaseFileContent.class.getName() + " where sn=" + sn;
		getCurrentSession().createQuery(hql).executeUpdate();
	}

}
