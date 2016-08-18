package com.focustech.focus3d.dao.common;


import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.model.OssAdminUser;

public interface MediaInfoDao<T> extends BaseHibernateDao<T> {

	/**
	 *  更新媒体的状态
	 *
	 * @param exbSn
	 * @param memberSn
	 * @param fileSn
	 * @param type
	 * @param status
	 */
	public void updateMediaInfoStatusByFileSnAndType(Long fileSn, Long status, OssAdminUser loginUser);
}
