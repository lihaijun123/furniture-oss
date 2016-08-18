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
@Table(name = "biz_agent_resource")
public class AgentResource extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String resourceName;
	private Long resourceParentId;
	private Integer resourceType;
	private String resourceInterface;
	private String resourceDisplay;
	private Integer active;
	private Integer resourceOrder;
	private String attachment;
	private String description;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Long getResourceParentId() {
		return resourceParentId;
	}
	public void setResourceParentId(Long resourceParentId) {
		this.resourceParentId = resourceParentId;
	}
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourceInterface() {
		return resourceInterface;
	}
	public void setResourceInterface(String resourceInterface) {
		this.resourceInterface = resourceInterface;
	}
	public String getResourceDisplay() {
		return resourceDisplay;
	}
	public void setResourceDisplay(String resourceDisplay) {
		this.resourceDisplay = resourceDisplay;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Integer getResourceOrder() {
		return resourceOrder;
	}
	public void setResourceOrder(Integer resourceOrder) {
		this.resourceOrder = resourceOrder;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
