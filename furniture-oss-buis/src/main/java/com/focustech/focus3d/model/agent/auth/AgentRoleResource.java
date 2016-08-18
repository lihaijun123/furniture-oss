package com.focustech.focus3d.model.agent.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_agent_role_resource")
public class AgentRoleResource extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Long roleSn;
	private Long resourceSn;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getRoleSn() {
		return roleSn;
	}
	public void setRoleSn(Long roleSn) {
		this.roleSn = roleSn;
	}
	public Long getResourceSn() {
		return resourceSn;
	}
	public void setResourceSn(Long resourceSn) {
		this.resourceSn = resourceSn;
	}


}
