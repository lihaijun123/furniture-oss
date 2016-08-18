package com.focustech.focus3d.service.qrcode;

import java.util.List;
import java.util.Map;

import com.focustech.focus3d.model.qrcode.MxjQrCode;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 */
public interface MxjQrCodeService<T extends MxjQrCode> extends BaseEntityService<T> {
	/**
	 *
	 * *
	 * @param factorySn
	 */
	public void delteByFactorySn(long factorySn);
	/**
	 *
	 * *
	 * @param qrId
	 * @return
	 */
	public T selectByQrId(String qrId);
	/**
	 *
	 * *
	 * @param qrId
	 * @return
	 */
	public T selectByQrContent(String qrContent);

	public List<Map<String, String>> selectList(Long qrSn);
}
