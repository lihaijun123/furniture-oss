package com.focustech.focus3d.web.controller.qrcode;

import javax.servlet.http.HttpSession;

import com.focustech.common.utils.TCUtil;

/**
 * 打包进度
 * *
 * @author lihaijun
 *
 */
public class MxjQrCodePackageProcess {

	private static final ThreadLocal<HttpSession> processThreadLocal = new ThreadLocal<HttpSession>();
	private static final String KEY = "process";

	public static String getProcess() {
		return TCUtil.sv(processThreadLocal.get().getAttribute(KEY));
	}

	public static void putProcess(String value){
		processThreadLocal.get().setAttribute(KEY, value);
	}

	public static void putSession(HttpSession session){
		processThreadLocal.set(session);
	}
}
