package com.focustech.focus3d.service.qrcode.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import com.focustech.cief.filemanage.core.FileManageClient;
import com.focustech.uitool.framework.NLGlobal;
import com.focustech.uitool.framework.SystemTool;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class MxjQrCodeCreateMb1 extends MxjQrCodeCreateStrategy {

	public MxjQrCodeCreateMb1(FileManageClient fileManageClient, String targetPath){
		super(fileManageClient, targetPath);
	}
	@Override
	public void create() {
		String property = SystemTool.getProperty(NLGlobal.APP_REAL_PATH);
		String parentDir = property + File.separator + "qrcodecoat" + File.separator;
		byte[] fileData = getData();
		ByteArrayInputStream bis = new ByteArrayInputStream(fileData);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile());
			try {
				Thumbnails.of(parentDir + "mb.jpg")
				.size(1063, 709)
				.watermark(Positions.CENTER, ImageIO.read(bis), 1f)
				.outputQuality(1f)
				.toOutputStream(fileOutputStream);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fileOutputStream != null){
					fileOutputStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
