package com.focustech.focus3d.dao.userinfo.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.userinfo.UserInfoDao;
import com.focustech.focus3d.model.userinfo.UserInfo;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class UserInfoDaoImpl extends OssHibernateDaoSupport<UserInfo> implements UserInfoDao<UserInfo> {

}
