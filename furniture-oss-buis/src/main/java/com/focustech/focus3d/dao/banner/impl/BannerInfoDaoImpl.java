package com.focustech.focus3d.dao.banner.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.banner.BannerInfoDao;
import com.focustech.focus3d.model.banner.BannerInfo;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class BannerInfoDaoImpl extends OssHibernateDaoSupport<BannerInfo> implements BannerInfoDao<BannerInfo> {

}
