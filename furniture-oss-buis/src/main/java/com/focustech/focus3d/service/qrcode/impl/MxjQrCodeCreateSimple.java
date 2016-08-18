package com.focustech.focus3d.service.qrcode.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.focustech.cief.filemanage.core.FileManageClient;

/**
 *
 * *
 *
 * @author lihaijun
 *
 */
public class MxjQrCodeCreateSimple extends MxjQrCodeCreateStrategy {

	public MxjQrCodeCreateSimple(FileManageClient fileManageClient, String targetPath) {
		super(fileManageClient, targetPath);
	}

	@Override
	public void create() {
		byte[] fileData = getData();
		// 写入应用本地
		try {
			FileOutputStream fos = new FileOutputStream(getTargetFile());
			try {
				fos.write(fileData);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
