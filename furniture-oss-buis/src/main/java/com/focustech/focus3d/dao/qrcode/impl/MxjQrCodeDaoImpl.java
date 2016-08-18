package com.focustech.focus3d.dao.qrcode.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.qrcode.MxjQrCodeDao;
import com.focustech.focus3d.model.qrcode.MxjQrCode;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class MxjQrCodeDaoImpl extends OssHibernateDaoSupport<MxjQrCode> implements MxjQrCodeDao<MxjQrCode> {

	@Override
	public void delteByFactorySn(long factorySn) {
		String hql = "delete from " + MxjQrCode.class.getName() + " where qrCodeFactorySn=?";
		getCurrentSession().createQuery(hql).setLong(0, factorySn).executeUpdate();
	}

	@Override
	public MxjQrCode selectByQrId(String qrId) {
		Criteria criteria = getCurrentSession().createCriteria(MxjQrCode.class);
		criteria.add(Restrictions.eq("qrId", qrId));
		return (MxjQrCode) criteria.uniqueResult();
	}

	@Override
	public MxjQrCode selectByQrContent(String qrContent) {
		Criteria criteria = getCurrentSession().createCriteria(MxjQrCode.class);
		criteria.add(Restrictions.eq("content", qrContent));
		return (MxjQrCode) criteria.uniqueResult();
	}

	@Override
	public List<Map<String, String>> selectList(Long qrSn) {
		String sql = " SELECT "
				   + " dv.ID, "
				   + " qr_dv_ath.ADD_TIME "
				   + " FROM biz_mxj_qr_device_auth qr_dv_ath, biz_mxj_install_device dv, biz_mxj_qr_code qr "
				   + " WHERE qr_dv_ath.QR_CODE_SN = qr.SN AND qr_dv_ath.INSTALL_DEVICE_SN = dv.SN "
				   + " AND qr.SN = ?";
		List list = getCurrentSession().createSQLQuery(sql).setLong(0, qrSn).list();
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		for(Object ob : list){
			if(ob instanceof Object[]){
				Object[] obAry = (Object[])ob;
				Map<String, String> dataMap = new TreeMap<String, String>();
				dataMap.put("adeviceId", TCUtil.sv(obAry[0]));
				dataMap.put("bAuthTime", TCUtil.sv(obAry[1]));
				mapList.add(dataMap);
			}
		}
		return mapList;
	}
}
