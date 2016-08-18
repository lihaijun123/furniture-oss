package com.focustech.focus3d.service.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.focustech.cief.filemanage.core.FileInfo;
import com.focustech.cief.filemanage.core.FileManageFactory;
import com.focustech.cief.filemanage.core.IFileManageClient;
import com.focustech.common.qrcodes.QrGeneratorUtil;
import com.focustech.common.utils.MessageUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.app.core.AppInfo;
import com.focustech.focus3d.app.core.IAppManageClient;
import com.focustech.focus3d.common.constant.AppWorkspaceConst;
import com.focustech.focus3d.model.app.AppFrame;
import com.focustech.focus3d.model.app.AppFrameCreateDetail;
import com.focustech.focus3d.model.message.MessageNotice;
import com.focustech.focus3d.service.app.AppFrameCreateDetailService;
import com.focustech.focus3d.service.app.AppFrameService;
import com.focustech.focus3d.service.message.MessageNoticeService;
import com.focustech.focus3d.utils.EncryptUtil;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class AppFrameSynJob {

	@Autowired
	private AppFrameService<AppFrame> appFrameService;
	@Autowired
	private AppFrameCreateDetailService<AppFrameCreateDetail> appFrameCreateDetailService;
	@Autowired
	private IAppManageClient appManageClient;
	@Autowired
	private MessageNoticeService<MessageNotice> messageNoticeService;
	/**
	 * 同步状态
	 * *
	 */
	public void synStatus(){
		List<AppFrame> list = appFrameService.list(AppWorkspaceConst.APP_STATUS_3);
		for (AppFrame appFrame : list) {
			List<AppFrameCreateDetail> createDetail = appFrameCreateDetailService.list(appFrame.getSn());
			for (AppFrameCreateDetail appFrameCreateDetail : createDetail) {
				Integer status = appFrameCreateDetail.getStatus();
				if(status != AppWorkspaceConst.APP_STATUS_8){
					Long AppcreateDetailSn = appFrameCreateDetail.getSn();
					AppInfo appInfo = appManageClient.listApp(AppcreateDetailSn);
					int appInfoStatus = TCUtil.iv(appInfo.getStatus());
					//创建成功
					if(appInfoStatus == 3){
						appFrameCreateDetail.setStatus(8);
						//生成二维码
						String content = MessageUtils.getInfoValue("FOCUS3D_DOMAIN") + "/case/" + EncryptUtil.encode(appFrame.getSn());
						Long qrFileSn = getQrFileSn("f" + appInfo.getAppId(), content);
						appFrameCreateDetail.setQrFileSn(qrFileSn);
						//向客户发送消息
						String systemName = "";
						if(appFrameCreateDetail.getSystemType() == AppWorkspaceConst.SYSTEM_TYPE_1){
							systemName = "安卓";
						} else {
							systemName = "IOS";
						}
						messageNoticeService.sendNewNotic(appFrame.getObjectSn(), "Focus3D-App[" + appFrame.getName() + "-" + systemName + "版]创建成功！", "尊敬的，您好！ App[" + appFrame.getName() + "-" + systemName + "版]已经成功创建！");
					}
					//创建失败
					if(appInfoStatus == 4){
						appFrameCreateDetail.setStatus(9);
					}
					//等待生成或正在生成
					if(appInfoStatus ==1 || appInfoStatus == 2){
						appFrameCreateDetail.setStatus(7);
					}
					appFrameCreateDetailService.insertOrUpdate(appFrameCreateDetail);
				}
			}
		}
	}
	/**
	 * 获取二维码sn
	 * *
	 * @param productInfo
	 * @return
	 */
	public long getQrFileSn(String name, String content){
		long qrFileSn = 0;
		try {
			FileInfo fileUploadObject = new FileInfo();
			fileUploadObject.setName(name + "-二维码.jpg");
			fileUploadObject.setBytes(QrGeneratorUtil.generate(content));
			IFileManageClient fileManageClient = FileManageFactory.getFileManageClient(fileUploadObject);
			fileManageClient.upload();
			qrFileSn = TCUtil.lv(fileManageClient.getFileId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrFileSn;
	}
}
