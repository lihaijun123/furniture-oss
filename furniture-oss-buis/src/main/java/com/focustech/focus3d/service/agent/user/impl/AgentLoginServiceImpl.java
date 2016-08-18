package com.focustech.focus3d.service.agent.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.MD5Util;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.agent.user.AgentLoginDao;
import com.focustech.focus3d.dao.agent.user.AgentUserDao;
import com.focustech.focus3d.model.agent.user.AgentLogin;
import com.focustech.focus3d.model.agent.user.AgentUser;
import com.focustech.focus3d.service.agent.user.AgentLoginService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentLoginServiceImpl extends BaseEntityServiceImpl<AgentLogin> implements AgentLoginService<AgentLogin> {
	@Autowired
	private AgentLoginDao<AgentLogin> agentLoginDao;
	@Autowired
	private AgentUserDao<AgentUser> agentUserDao;
	@Override
	public BaseHibernateDao<AgentLogin> getEntityDao() {
		return agentLoginDao;
	}
	@Override
	public AgentLogin getByUserId(long userId) {
		return agentLoginDao.getByUserId(userId);
	}
	@Override
	public boolean resetPwd(long userId) {
		AgentUser agentUser = agentUserDao.select(TCUtil.lv(userId));
		if(agentUser != null){
			String partnerId = agentUser.getPartnerId();
			AgentLogin agentLogin = agentLoginDao.getByUserId(TCUtil.lv(userId));
			if(agentLogin != null){
				String password = MD5Util.MD5Encode(partnerId, "");
				agentLogin.setPassword(password);
				agentLoginDao.update(agentLogin);
			}
		}
		return true;
	}
}
