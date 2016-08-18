package com.focustech.focus3d.service.qrcode.impl;

import com.focustech.cief.filemanage.core.FileManageClient;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class MxjQrCodeCreateContext {
	private MxjQrCodeCreateStrategy strategy;

	public static final int SIMPLE = 1;

	public static final int MB_1 = 2;

	public  MxjQrCodeCreateContext(int i, FileManageClient fileManageClient, String targetPath){
		if(i <= 1){
			strategy = new MxjQrCodeCreateSimple(fileManageClient, targetPath);
		}
		if(i == 2){
			strategy = new MxjQrCodeCreateMb1(fileManageClient, targetPath);
		}
		if(i == 3){
			strategy = new MxjQrCodeCreateMb2(fileManageClient, targetPath);
		}
	}

	public void create(long qrFileSn){
		strategy.setQrFileSn(qrFileSn);
		strategy.create();
	}
}
