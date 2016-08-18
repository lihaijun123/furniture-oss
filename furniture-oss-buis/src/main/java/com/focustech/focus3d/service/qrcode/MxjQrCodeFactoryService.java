package com.focustech.focus3d.service.qrcode;

import java.util.List;

import com.focustech.focus3d.model.qrcode.MxjQrCodeFactory;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MxjQrCodeFactoryService<T extends MxjQrCodeFactory> extends BaseEntityService<T> {
	public void doPackage(MxjQrCodeFactory mxjQrCodeFactory);

	public MxjQrCodeFactory generateData(MxjQrCodeFactory mxjQrCodeFactory);

	public List<T> getList();

	public T completeAll(T t);

	public void rollback(Long sn);

	public void delete(Long sn);
}
