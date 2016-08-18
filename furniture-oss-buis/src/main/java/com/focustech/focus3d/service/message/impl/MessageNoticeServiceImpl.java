package com.focustech.focus3d.service.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.message.MessageNoticeDao;
import com.focustech.focus3d.model.message.MessageNotice;
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
public class MessageNoticeServiceImpl extends BaseEntityServiceImpl<MessageNotice> implements MessageNoticeService<MessageNotice> {

	@Autowired
	private MessageNoticeDao<MessageNotice> messageNoticeDao;

	@Override
	public BaseHibernateDao<MessageNotice> getEntityDao() {
		return messageNoticeDao;
	}

	@Override
	public void sendNewNotic(Long receiverId, String subject, String content) {
		MessageNotice messageNotice = new MessageNotice();
		messageNotice.setUserInfoSn(receiverId);
		messageNotice.setSubject(subject);
		messageNotice.setContent(content);
		messageNotice.setFromType(1);
		messageNotice.setIsDelete(0);
		messageNotice.setIsRead(0);
		messageNotice.setMsgType(1);
		messageNoticeDao.insertOrUpdate(messageNotice);
	}

}
