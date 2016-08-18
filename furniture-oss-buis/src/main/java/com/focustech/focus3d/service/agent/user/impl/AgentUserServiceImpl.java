package com.focustech.focus3d.service.agent.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.MD5Util;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.agent.auth.AgentUserRoleDao;
import com.focustech.focus3d.dao.agent.product.AgentProductUserDao;
import com.focustech.focus3d.dao.agent.user.AgentLoginDao;
import com.focustech.focus3d.dao.agent.user.AgentUserDao;
import com.focustech.focus3d.model.agent.auth.AgentUserRole;
import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.focus3d.model.agent.product.AgentProductUser;
import com.focustech.focus3d.model.agent.user.AgentLogin;
import com.focustech.focus3d.model.agent.user.AgentUser;
import com.focustech.focus3d.service.agent.user.AgentUserService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class AgentUserServiceImpl extends BaseEntityServiceImpl<AgentUser> implements AgentUserService<AgentUser> {
	@Autowired
	private AgentUserDao<AgentUser> agentUserDao;
	@Autowired
	private AgentLoginDao<AgentLogin> agentLoginDao;
	@Autowired
	private AgentProductUserDao<AgentProductUser> agentProductUserDao;
	@Autowired
	private AgentUserRoleDao<AgentUserRole> agentUserRoleDao;
	@Override
	public BaseHibernateDao<AgentUser> getEntityDao() {
		return agentUserDao;
	}
	@Override
	public AgentUser getByMobilePhone(String mobilePhone) {
		return agentUserDao.getByMobilePhone(mobilePhone);
	}
	@Override
	public void save(AgentUser t) {
		Long sn = t.getSn();
		if(sn == null){
			agentUserDao.insertOrUpdate(t);
		} else {
			agentUserDao.update(t);
		}
		if(sn != null){
			Integer status = t.getStatus();
			if(status == 3){
				//审核通过，创建登录用户
				//检查是否存在用户
				AgentLogin agentLogin = agentLoginDao.getByUserId(sn);
				if(agentLogin == null){
					//创建登录用户
					agentLogin = new AgentLogin();
					agentLogin.setUserId(sn);
					agentLogin.setLoginName(t.getMobilePhone());
					String password = MD5Util.MD5Encode(t.getPartnerId(), "");
					agentLogin.setPassword(password);
					agentLogin.setStatus(1);
					agentLoginDao.insertOrUpdate(agentLogin);
				} else {
					//更改登录状态
					agentLogin.setStatus(1);
					//同步登录账号（手机号）
					agentLogin.setLoginName(t.getMobilePhone());
					agentLoginDao.insertOrUpdate(agentLogin);
				}
				//创建用户产品权限
				//先删除用户产品权限数据
				agentProductUserDao.deleteByUserId(sn);
				List<AgentProduct> productList = t.getProductList();
				for (AgentProduct agentProduct : productList) {
					Long prodSn = agentProduct.getSn();
					if(prodSn != null && prodSn > 0){
						AgentProductUser productUser = new AgentProductUser();
						productUser.setUserId(sn);
						productUser.setProductId(prodSn);
						agentProductUserDao.insertOrUpdate(productUser);
					}
				}
				//绑定角色信息
				//先删除
				agentUserRoleDao.deleteByUserSn(sn);
				//再保存
				AgentUserRole agentUserRole = new AgentUserRole();
				agentUserRole.setUserSn(sn);
				agentUserRole.setRoleSn(TCUtil.lv(t.getAgentGrade()));
				agentUserRoleDao.insertOrUpdate(agentUserRole);
			} else  if(status == 4){
				//审核拒绝
				AgentLogin agentLogin = agentLoginDao.getByUserId(sn);
				if(agentLogin != null){
					//创建登录用户
					agentLogin.setStatus(2);
					agentLoginDao.insertOrUpdate(agentLogin);
				}
			}
		}

	}
	@Override
	public AgentUser getByPartnerId(String partnerId) {
		return agentUserDao.getByPartnerId(partnerId);
	}

}
