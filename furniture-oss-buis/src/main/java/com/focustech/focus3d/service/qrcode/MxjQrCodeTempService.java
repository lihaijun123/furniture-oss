package com.focustech.focus3d.service.qrcode;

import java.util.List;

import com.focustech.focus3d.model.qrcode.MxjQrCodeTemp;
import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 *
 * *
 * @author lihaijun
 *
 */
public interface MxjQrCodeTempService<T extends MxjQrCodeTemp> extends BaseEntityService<T> {
	/**
	 * *
	 * @param lines
	 * @param type
	 */
	public List<MxjQrCodeTemp> selectByFactorySn(Long factorySn);

	public void deleteByFactorySn(Long factorySn);



}
