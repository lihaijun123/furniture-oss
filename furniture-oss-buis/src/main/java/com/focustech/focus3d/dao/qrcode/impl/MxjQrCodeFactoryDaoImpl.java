package com.focustech.focus3d.dao.qrcode.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.qrcode.MxjQrCodeFactoryDao;
import com.focustech.focus3d.model.qrcode.MxjQrCodeFactory;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * @author lihaijun
 *
 */
@Repository
public class MxjQrCodeFactoryDaoImpl extends OssHibernateDaoSupport<MxjQrCodeFactory> implements MxjQrCodeFactoryDao<MxjQrCodeFactory> {

	@Override
	public List<MxjQrCodeFactory> getList() {
		Criteria criteria = getCurrentSession().createCriteria(MxjQrCodeFactory.class);
		criteria.addOrder(Order.desc("addTime"));
		return criteria.list();
	}

	@Override
	public int getCount(int type, int dataComplete, String yearMonth, Long factorySn) {
		String sql = "SELECT COUNT(sn) FROM `biz_mxj_qr_code_factory` WHERE TYPE = ? AND data_complete = ? AND DATE_FORMAT(add_time, '%Y-%m') = ? AND sn != ?";
		Object uniqueResult = getCurrentSession().createSQLQuery(sql).setInteger(0, type).setInteger(1, dataComplete).setString(2, yearMonth).setLong(3, factorySn).uniqueResult();
		if(uniqueResult != null){
			return TCUtil.iv(uniqueResult);
		}
		return 0;
	}

}
