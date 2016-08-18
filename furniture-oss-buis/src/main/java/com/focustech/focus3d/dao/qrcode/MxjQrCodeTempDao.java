package com.focustech.focus3d.dao.qrcode;

import java.util.List;

import com.focustech.focus3d.model.qrcode.MxjQrCodeTemp;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MxjQrCodeTempDao<T extends MxjQrCodeTemp> extends BaseHibernateDao<T> {

	public List<MxjQrCodeTemp> selectByFactorySn(Long factorySn);

	void deleteByFactorySn(Long factorySn);

}
