package com.focustech.focus3d.service.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.DateUtils;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.app.core.AppInfo;
import com.focustech.focus3d.app.core.IAppManageClient;
import com.focustech.focus3d.common.constant.AppWorkspaceConst;
import com.focustech.focus3d.dao.app.AppFrameDao;
import com.focustech.focus3d.dao.app.AppProdVrArDao;
import com.focustech.focus3d.model.app.AppFrame;
import com.focustech.focus3d.model.app.AppFrameBoot;
import com.focustech.focus3d.model.app.AppFrameCreateDetail;
import com.focustech.focus3d.model.app.AppProd;
import com.focustech.focus3d.model.app.AppProdVrAr;
import com.focustech.focus3d.model.message.MessageNotice;
import com.focustech.focus3d.service.app.AppFrameService;
import com.focustech.focus3d.service.message.MessageNoticeService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AppFrameServiceImpl extends BaseEntityServiceImpl<AppFrame> implements AppFrameService<AppFrame> {

	@Autowired
	private AppFrameDao<AppFrame> appFrameDao;
	@Autowired
	private IAppManageClient appcClient;
	@Autowired
	private MessageNoticeService<MessageNotice> messageNoticeService;
	@Autowired
	private AppProdVrArDao<AppProdVrAr> prodVrArDao;
	@Override
	public BaseHibernateDao<AppFrame> getEntityDao() {
		return appFrameDao;
	}


	@Override
	public void audit(AppFrame appFrame) {
		//更新产品vrar模型数据
		List<AppProd> prods = appFrame.getProds();
		for (AppProd appProd : prods) {
			AppProdVrAr vrAr = appProd.getVrAr();
			Long vrArSn = vrAr.getSn();
			Long modelFileSn = vrAr.getModelFileSn();
			AppProdVrAr dbVrAr = null;
			if(vrArSn != null && modelFileSn != null){
				dbVrAr = prodVrArDao.select(vrArSn);
				if(dbVrAr != null){
					Long dbModelFileSn = dbVrAr.getModelFileSn();
					if(!modelFileSn.equals(dbModelFileSn)){
						dbVrAr.setModelFileSn(modelFileSn);
					}
				}
			}
			Long iosModelFileSn = vrAr.getIosModelFileSn();
			if(vrArSn != null && iosModelFileSn != null){
				if(dbVrAr == null){
					dbVrAr = prodVrArDao.select(vrArSn);
				}
				if(dbVrAr != null){
					Long dbIosModelFileSn = dbVrAr.getIosModelFileSn();
					if(!iosModelFileSn.equals(dbIosModelFileSn)){
						dbVrAr.setIosModelFileSn(iosModelFileSn);
					}
				}
			}
		}
		//审核状态
		String auditRemark = appFrame.getAuditRemark();
		int newStatus = appFrame.getStatus();
		appFrame = select(appFrame.getSn());
		int preStatus = appFrame.getStatus();
		if(StringUtils.isNotEmpty(auditRemark)){
			appFrame.setAuditRemark(auditRemark);
		}
		appFrame.setStatus(newStatus);
		update(appFrame);
		if(preStatus == AppWorkspaceConst.APP_STATUS_2 && preStatus != newStatus && newStatus == AppWorkspaceConst.APP_STATUS_3){
			//向app制作服务器发请求
			List<AppFrameCreateDetail> createDetail = appFrame.getCreateDetail();
			for (AppFrameCreateDetail appFrameCreateDetail : createDetail) {
				AppInfo appInfo = new AppInfo();
				appInfo.setAppName(appFrame.getName());
				appInfo.setAppTempInfo_sn(appFrame.getTempSn());
				appInfo.setComId(appFrameCreateDetail.getSn());
				appInfo.setAppLogoFileSn(appFrame.getIcon().getImageFileSn());
				appInfo.setLanguageType(appFrame.getLanguageType());
				appInfo.setVersionNum(appFrameCreateDetail.getVersionNum());
				AppFrameBoot boot = appFrame.getBoot();
				Long bootFileSn = 0L;
				String bootText = "";
				String bootCopyright = boot.getCopyrightText();
				if(boot.getSetupType() == 1){
					bootFileSn = boot.getDefaultImageFileSn();
					bootText = boot.getName();
				} else {
					bootFileSn = boot.getImageFileSn();
				}
				appInfo.setAppBootFileSn(bootFileSn);
				appInfo.setBootCopyrightText(bootCopyright);
				appInfo.setBootText(bootText);
				appInfo.setSystemType(appFrameCreateDetail.getSystemType());
				appInfo.setDeviceType(appFrame.getDeviceType());
				appInfo.setRemark(DateUtils.getCurDate(DateUtils.DATE_TIME_FORMAT) + " 向app制作服务器发出请求！");
				StringBuffer msg = new StringBuffer();
				if(StringUtils.isEmpty(appInfo.getAppName())){
					msg.append("ERROR_11:app名称不能为空");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getAppTempInfo_sn()))){
					msg.append("ERROR_12:app模板编号不能为空");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getComId()))){
					msg.append("ERROR_12:app公司编号不能为空");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getAppLogoFileSn()))){
					msg.append("ERROR_12:app logo图片不能为空");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getAppBootFileSn()))){
					msg.append("ERROR_12:app 启动页不能为空");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getSystemType()))){
					msg.append("ERROR_12:app 系统类型不能为空1-android 2-ios");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getDeviceType()))){
					msg.append("ERROR_12:app 设备类型不能为空1-phone 2-pad");
				}
				if(StringUtils.isEmpty(TCUtil.sv(appInfo.getLanguageType()))){
					msg.append("ERROR_12:app 语言版本不能为空1-中文 2-英文");
				}
				if(StringUtils.isEmpty(msg.toString())){
					try {
						appcClient.createAppInfo(appInfo);
					} catch (Exception e) {
						throw new RuntimeException(e.getMessage());
					}
				} else {
					throw new RuntimeException(msg.toString());
				}
			}
			//向客户发送消息
			messageNoticeService.sendNewNotic(appFrame.getObjectSn(), "Focus3D-App[" + appFrame.getName() + "]审核通过！", "尊敬的，您好！App[" + appFrame.getName() + "]内容已经审核通过，请耐心等待App自动创建！");
		}
	}

	@Override
	public List<AppFrame> list(Integer status) {
		return appFrameDao.list(status);
	}
}
