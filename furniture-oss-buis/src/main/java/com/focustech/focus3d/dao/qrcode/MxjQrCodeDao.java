package com.focustech.focus3d.dao.qrcode;

import java.util.List;
import java.util.Map;

import com.focustech.focus3d.model.qrcode.MxjQrCode;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MxjQrCodeDao<T> extends BaseHibernateDao<T> {

	void delteByFactorySn(long factorySn);

	MxjQrCode selectByQrId(String qrId);

	MxjQrCode selectByQrContent(String qrContent);

	List<Map<String, String>> selectList(Long qrSn);
}
