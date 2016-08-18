package com.focustech.focus3d.model.mxjad;

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
@Table(name = "biz_mxj_ad")
public class MxjAd extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sn;
	private String name;
	private Integer type;
	private String linkUrl;
	private Long phonePicFileSn;
	private Long padPicFileSn;
	private Integer priority;
	private Integer status;
	private String remark;
	public long getSn() {
		return sn;
	}
	public void setSn(long sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Long getPhonePicFileSn() {
		return phonePicFileSn;
	}
	public void setPhonePicFileSn(Long phonePicFileSn) {
		this.phonePicFileSn = phonePicFileSn;
	}
	public Long getPadPicFileSn() {
		return padPicFileSn;
	}
	public void setPadPicFileSn(Long padPicFileSn) {
		this.padPicFileSn = padPicFileSn;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
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
}
