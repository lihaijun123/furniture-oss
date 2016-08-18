package com.focustech.focus3d.model.app;

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
@Table(name = "biz_app_frame_style")
public class AppFrameStyle extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Integer setupType;
	private Long imageFileSn;
	private Long videoFileSn;
	private Long videoPicFileSn;
	private Long contactFileSn;
	private String color;
	private String industy;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Integer getSetupType() {
		return setupType;
	}
	public void setSetupType(Integer setupType) {
		this.setupType = setupType;
	}
	public Long getImageFileSn() {
		return imageFileSn;
	}
	public void setImageFileSn(Long imageFileSn) {
		this.imageFileSn = imageFileSn;
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
	public Long getContactFileSn() {
		return contactFileSn;
	}
	public void setContactFileSn(Long contactFileSn) {
		this.contactFileSn = contactFileSn;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIndusty() {
		return industy;
	}
	public void setIndusty(String industy) {
		this.industy = industy;
	}

	}
