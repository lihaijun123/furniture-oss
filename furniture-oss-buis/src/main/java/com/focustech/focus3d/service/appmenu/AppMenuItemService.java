package com.focustech.focus3d.service.appmenu;

import java.util.List;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AppMenuItemService<T> extends BaseEntityService<T> {
	public List<T> getList();
}
