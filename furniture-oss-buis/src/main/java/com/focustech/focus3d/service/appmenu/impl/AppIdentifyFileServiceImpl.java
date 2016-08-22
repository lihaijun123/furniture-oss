package com.focustech.focus3d.service.appmenu.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.StringUtils;
import com.focustech.focus3d.common.constant.MxjQrCodeType;
import com.focustech.focus3d.dao.appmenu.AppIdentifyFileDao;
import com.focustech.focus3d.model.appmenu.AppIdentifyFile;
import com.focustech.focus3d.service.appmenu.AppIdentifyFileService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppIdentifyFileServiceImpl extends BaseEntityServiceImpl<AppIdentifyFile> implements AppIdentifyFileService<AppIdentifyFile> {
	@Autowired
	private AppIdentifyFileDao<AppIdentifyFile> appIdentifyFileDao;
	public static final String SERVICE_KEYS = "focus3d.mxj.appmenu.identify.get";
	@Override
	public BaseHibernateDao<AppIdentifyFile> getEntityDao() {
		return appIdentifyFileDao;
	}
	@Override
	public void update(AppIdentifyFile t) {
		setNameDefaultValue(t);
		super.update(t);
	}
	@Override
	public void insertOrUpdate(AppIdentifyFile t) {
		setNameDefaultValue(t);
		super.insertOrUpdate(t);
	}
	private void setNameDefaultValue(AppIdentifyFile t) {
		String name = t.getName();
		if(StringUtils.isEmpty(name)){
			t.setName(MxjQrCodeType.getName(t.getType()));
		}
	}
}
