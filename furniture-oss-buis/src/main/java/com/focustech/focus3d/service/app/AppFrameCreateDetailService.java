package com.focustech.focus3d.service.app;

import java.util.List;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AppFrameCreateDetailService<T> extends BaseEntityService<T> {
	/**
	 *
	 * *
	 * @param appFrameSn
	 * @return
	 */
	public List<T> list(Long appFrameSn);
}
