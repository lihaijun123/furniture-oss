package com.focustech.focus3d.dao.sale.customer.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.sale.customer.TagDao;
import com.focustech.focus3d.model.sale.customer.Tag;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;

/**
*
* *
* @author yangrongrong
*
*/
@Repository
public class TagDaoImpl extends OssHibernateDaoSupport<Tag> implements TagDao<Tag> {

	@Override
	public void deleteBySn(Long sn) {
		String hql = " delete from " + Tag.class.getName() + " where sn=" + sn;
		getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Tag> getListByTagSn(Long tagSn) {
		String hql = " from " + Tag.class.getName() + " where SN=" + tagSn;
		return getCurrentSession().createQuery(hql).list();
	}
}
