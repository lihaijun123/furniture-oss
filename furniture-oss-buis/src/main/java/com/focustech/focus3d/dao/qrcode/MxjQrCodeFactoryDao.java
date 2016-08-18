package com.focustech.focus3d.dao.qrcode;

import java.util.List;

import com.focustech.focus3d.model.qrcode.MxjQrCodeFactory;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MxjQrCodeFactoryDao<T extends MxjQrCodeFactory> extends BaseHibernateDao<T> {

	List<MxjQrCodeFactory> getList();

	int getCount(int type, int dataComplete, String yearMonth, Long factorySn);
}
