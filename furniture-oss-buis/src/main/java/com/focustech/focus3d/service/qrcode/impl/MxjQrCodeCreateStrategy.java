package com.focustech.focus3d.service.qrcode.impl;

import java.io.File;
import java.util.Map;

import com.focustech.cief.filemanage.core.FileManage;
import com.focustech.cief.filemanage.core.FileManageClient;
import com.focustech.cief.filemanage.core.RegistryCenterException;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.uitool.framework.NLGlobal;
import com.focustech.uitool.framework.SystemTool;

/**
 *
 * *
 * @author lihaijun
 *
 */
public abstract class MxjQrCodeCreateStrategy {
	public void setQrFileSn(Long qrFileSn) {
		this.qrFileSn = qrFileSn;
	}

	private FileManageClient fileManageClient;
	private Long qrFileSn;
	private String targetPath;

	public MxjQrCodeCreateStrategy(FileManageClient fileManageClient, String targetPath){
		this.fileManageClient = fileManageClient;
		this.targetPath = targetPath;
	}
	public abstract void create();

	protected String fileName;

	public byte[] getData(){
		Map<String, String> fileInfo = fileManageClient.getFileInfo(TCUtil.iv(qrFileSn));
		fileName = TCUtil.sv(fileInfo, FileManage.NAME);
		String visitAddr = TCUtil.sv(fileInfo, FileManage.VISIT_ADDR);
		byte[] fileData = null;
		try {
			fileData = fileManageClient.fetchFile(visitAddr.substring(visitAddr.lastIndexOf("/") + 1, visitAddr.length()));
		} catch (RegistryCenterException e) {
			e.printStackTrace();
		}
		return fileData;
	}

	public File getTargetFile(){
		return new File(targetPath + File.separator + fileName);
	}

	public String getParentDir(){
		String property = SystemTool.getProperty(NLGlobal.APP_REAL_PATH);
		return property + File.separator + "qrcodecoat" + File.separator;
	}

	public String getNamePrefix(){
		if(StringUtils.isEmpty(this.fileName)){
			return "";
		}
		return fileName.substring(0, fileName.lastIndexOf("."));
	}
}
