package com.focustech.focus3d.service.app;

import java.util.List;

import com.focustech.focus3d.model.app.AppFrame;
import com.focustech.oss2008.service.BaseEntityService;


/**
 *
 * *
 * @author lihaijun
 *
 */
public interface AppFrameService<T> extends BaseEntityService<T>{
	/**
	 *
	 * *
	 * @param appFrameSn
	 */
	public void audit(AppFrame appFrame);
	/**
	 *
	 * *
	 * @param status
	 * @return
	 */
	public List<AppFrame> list(Integer status);
}
