package com.focustech.focus3d.model.companyinfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.focustech.model.common.AuditEntity;
import com.focustech.model.common.BaseEntity;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_company_info")
public class CompanyInfo extends BaseEntity implements AuditEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private String type;
	private Long iconFileSn;
	private Long videoFileSn;
	private Long videoPicFileSn;
	private String summary;
	private String address;
	private String url;
	private Long imageFileSn;
	private Integer status;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getIconFileSn() {
		return iconFileSn;
	}
	public void setIconFileSn(Long iconFileSn) {
		this.iconFileSn = iconFileSn;
	}
	public Long getVideoFileSn() {
		return videoFileSn;
	}
	public void setVideoFileSn(Long videoFileSn) {
		this.videoFileSn = videoFileSn;
	}
	public Long getVideoPicFileSn() {
		return videoPicFileSn;
	}
	public void setVideoPicFileSn(Long videoPicFileSn) {
		this.videoPicFileSn = videoPicFileSn;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getImageFileSn() {
		return imageFileSn;
	}
	public void setImageFileSn(Long imageFileSn) {
		this.imageFileSn = imageFileSn;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

}
