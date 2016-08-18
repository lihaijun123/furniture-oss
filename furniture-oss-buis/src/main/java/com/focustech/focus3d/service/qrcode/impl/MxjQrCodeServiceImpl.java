package com.focustech.focus3d.service.qrcode.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.qrcode.MxjQrCodeDao;
import com.focustech.focus3d.model.qrcode.MxjQrCode;
import com.focustech.focus3d.service.qrcode.MxjQrCodeService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class MxjQrCodeServiceImpl extends BaseEntityServiceImpl<MxjQrCode> implements MxjQrCodeService<MxjQrCode>{
	@Autowired
	private MxjQrCodeDao<MxjQrCode> mxjQrCodeDao;
	@Override
	public BaseHibernateDao<MxjQrCode> getEntityDao() {
		return mxjQrCodeDao;
	}
	@Override
	public void delteByFactorySn(long factorySn) {
		mxjQrCodeDao.delteByFactorySn(factorySn);
	}
	@Override
	public MxjQrCode selectByQrId(String qrId) {

		return mxjQrCodeDao.selectByQrId(qrId);
	}
	@Override
	public MxjQrCode selectByQrContent(String qrContent) {
		return mxjQrCodeDao.selectByQrContent(qrContent);
	}
	@Override
	public List<Map<String, String>> selectList(Long qrSn) {
		return mxjQrCodeDao.selectList(qrSn);
	}

}
