package com.focustech.focus3d.dao.message.impl;

import org.springframework.stereotype.Repository;

import com.focustech.focus3d.dao.message.MessageNoticeDao;
import com.focustech.focus3d.model.message.MessageNotice;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class MessageNoticeDaoImpl extends OssHibernateDaoSupport<MessageNotice> implements MessageNoticeDao<MessageNotice> {


}
