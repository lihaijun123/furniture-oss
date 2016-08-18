package com.focustech.focus3d.dao.agent.user;

import com.focustech.focus3d.model.agent.user.AgentUser;
import com.focustech.oss2008.dao.BaseHibernateDao;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface AgentUserDao<T> extends BaseHibernateDao<T> {

	AgentUser getByMobilePhone(String mobilePhone);

	AgentUser getByPartnerId(String partnerId);
}
