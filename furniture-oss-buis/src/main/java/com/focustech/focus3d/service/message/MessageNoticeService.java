package com.focustech.focus3d.service.message;

import com.focustech.oss2008.service.BaseEntityService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface MessageNoticeService<T> extends BaseEntityService<T> {
	/**
	 *
	 * *
	 * @param receiverId 接收者Id
	 * @param subject 主题
	 * @param content 内容
	 */
	public void sendNewNotic(Long receiverId, String subject, String content);
}
