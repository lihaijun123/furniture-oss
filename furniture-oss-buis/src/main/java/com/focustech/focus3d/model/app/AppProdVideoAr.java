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
@Table(name = "biz_app_prod_video_ar")
public class AppProdVideoAr extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;

	private Long videoFileSn;
	private Long videoPicFileSn;
	private Long arPackFileSn;
	private String summary;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
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
	public Long getArPackFileSn() {
		return arPackFileSn;
	}
	public void setArPackFileSn(Long arPackFileSn) {
		this.arPackFileSn = arPackFileSn;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
