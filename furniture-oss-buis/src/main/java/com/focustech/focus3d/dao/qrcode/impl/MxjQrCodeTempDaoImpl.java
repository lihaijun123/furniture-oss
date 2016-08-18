package com.focustech.focus3d.dao.qrcode.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.qrcode.MxjQrCodeTempDao;
import com.focustech.focus3d.model.qrcode.MxjQrCodeTemp;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class MxjQrCodeTempDaoImpl extends OssHibernateDaoSupport<MxjQrCodeTemp> implements MxjQrCodeTempDao<MxjQrCodeTemp> {

	@Override
	public List<MxjQrCodeTemp> selectByFactorySn(Long factorySn) {
		Criteria c = getCurrentSession().createCriteria(MxjQrCodeTemp.class);
		c.add(Restrictions.eq("qrCodeFactorySn", factorySn));
		return c.list();
	}

	@Override
	public void deleteByFactorySn(Long factorySn) {
		String hql = "delete from " + MxjQrCodeTemp.class.getName() + " where qrCodeFactorySn=?";
		getCurrentSession().createQuery(hql).setLong(0, factorySn).executeUpdate();
	}

}
