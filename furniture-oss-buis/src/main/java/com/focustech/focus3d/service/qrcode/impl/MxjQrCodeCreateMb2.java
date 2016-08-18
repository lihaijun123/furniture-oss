package com.focustech.focus3d.service.qrcode.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;

import com.focustech.cief.filemanage.core.FileManageClient;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class MxjQrCodeCreateMb2 extends MxjQrCodeCreateStrategy {

	public MxjQrCodeCreateMb2(FileManageClient fileManageClient, String targetPath){
		super(fileManageClient, targetPath);
	}
	@Override
	public void create() {
		byte[] fileData = getData();
		ByteArrayInputStream bis = new ByteArrayInputStream(fileData);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile());
			try {
				decorateImg(fileData, fileOutputStream);
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

	public void decorateImg(byte[] data, OutputStream targetOut) throws Exception{
		InputStream is = null;
		try {
			is = new FileInputStream(getParentDir() + "mb2.jpg");
			//通过JPEG图象流创建JPEG数据流解码器
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			//解码当前JPEG数据流，返回BufferedImage对象
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			//得到画笔对象
			Graphics g = buffImg.getGraphics();
			//创建你要附加的图象。
			ImageIcon imgIcon = new ImageIcon(data);
			//得到Image对象。
			Image img = imgIcon.getImage();
			//将小图片绘到大图片上。
			g.drawImage(img, 0, 0, null);
			//设置颜色。
			g.setColor(Color.BLACK);
			//最后一个参数用来设置字体的大小
			Font f = new Font("黑体", Font.PLAIN, 20);
			g.setFont(f);
			g.drawString(getNamePrefix(), 75, 325);
			g.dispose();
			//创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(targetOut);
			en.encode(buffImg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(is != null){
				is.close();
			}
			if(targetOut != null){
				targetOut.close();
			}
		}
    }
}
