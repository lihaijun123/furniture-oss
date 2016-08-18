package com.focustech.focus3d.model.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.focustech.model.common.AuditEntity;
import com.focustech.model.common.BaseEntity;
import com.focustech.oss2008.model.AutoArrayList;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_app_frame")
public class AppFrame extends BaseEntity implements AuditEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private Long objectSn;
	private Long tempSn;
	@ManyToOne
	@JoinColumn(name = "ICON_SN")
	private AppFrameIcon icon;
	@ManyToOne
	@JoinColumn(name = "BOOT_SN")
	private AppFrameBoot boot;
	@ManyToOne
	@JoinColumn(name = "GUID_SN")
	private AppFrameGuid guid;
	@ManyToOne
	@JoinColumn(name = "STYLE_SN")
	private AppFrameStyle style;
	@ManyToOne
	@JoinColumn(name = "CONTACT_SN")
	private AppFrameContact contact;
	private Integer status;
	private String remark;
	private Integer deviceType;
	private Integer languageType;
	@OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
	private List<AppProd> prods = new AutoArrayList<AppProd>(AppProd.class);
	@OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
	private List<AppFrameCreateDetail> createDetail = new ArrayList<AppFrameCreateDetail>();

	private String auditRemark;
	private Long auditorSn;
	private String auditorName;
	private Date auditTime;

	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getObjectSn() {
		return objectSn;
	}
	public void setObjectSn(Long objectSn) {
		this.objectSn = objectSn;
	}
	public AppFrameIcon getIcon() {
		return icon;
	}
	public void setIcon(AppFrameIcon icon) {
		this.icon = icon;
	}
	public AppFrameBoot getBoot() {
		return boot;
	}
	public void setBoot(AppFrameBoot boot) {
		this.boot = boot;
	}
	public AppFrameGuid getGuid() {
		return guid;
	}
	public void setGuid(AppFrameGuid guid) {
		this.guid = guid;
	}
	public AppFrameStyle getStyle() {
		return style;
	}
	public void setStyle(AppFrameStyle style) {
		this.style = style;
	}
	public AppFrameContact getContact() {
		return contact;
	}
	public void setContact(AppFrameContact contact) {
		this.contact = contact;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getLanguageType() {
		return languageType;
	}
	public void setLanguageType(Integer languageType) {
		this.languageType = languageType;
	}
	public List<AppProd> getProds() {
		return prods;
	}
	public void setProds(List<AppProd> prods) {
		this.prods = prods;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	public Long getAuditorSn() {
		return auditorSn;
	}
	public void setAuditorSn(Long auditorSn) {
		this.auditorSn = auditorSn;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public List<AppFrameCreateDetail> getCreateDetail() {
		return createDetail;
	}
	public void setCreateDetail(List<AppFrameCreateDetail> createDetail) {
		this.createDetail = createDetail;
	}
	public Long getTempSn() {
		return tempSn;
	}
	public void setTempSn(Long tempSn) {
		this.tempSn = tempSn;
	}

}
