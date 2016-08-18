package com.focustech.focus3d.service.userinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focustech.focus3d.dao.userinfo.UserInfoDao;
import com.focustech.focus3d.model.userinfo.UserInfo;
import com.focustech.focus3d.service.userinfo.UserInfoService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class UserInfoServiceImpl extends BaseEntityServiceImpl<UserInfo> implements UserInfoService<UserInfo> {

	@Autowired
	private UserInfoDao<UserInfo> userInfoDao;

	@Override
	public BaseHibernateDao<UserInfo> getEntityDao() {
		return userInfoDao;
	}

}
