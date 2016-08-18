package com.focustech.focus3d.service.qrcode.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.qrcode.MxjQrCodeTempDao;
import com.focustech.focus3d.model.qrcode.MxjQrCodeTemp;
import com.focustech.focus3d.service.qrcode.MxjQrCodeTempService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class MxjQrCodeTempServiceImpl extends BaseEntityServiceImpl<MxjQrCodeTemp> implements MxjQrCodeTempService<MxjQrCodeTemp> {

	@Autowired
	private MxjQrCodeTempDao<MxjQrCodeTemp> qrCodeTempDao;

	@Override
	public BaseHibernateDao<MxjQrCodeTemp> getEntityDao() {
		return qrCodeTempDao;
	}

	@Override
	public List<MxjQrCodeTemp> selectByFactorySn(Long factorySn) {
		return qrCodeTempDao.selectByFactorySn(factorySn);
	}

	@Override
	public void deleteByFactorySn(Long factorySn) {
		qrCodeTempDao.deleteByFactorySn(factorySn);
	}
}
