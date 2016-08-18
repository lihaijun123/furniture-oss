package com.focustech.focus3d.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_app_prod")
public class AppProd extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private String type;
	private String summary;
	private Long imageFileSn;
	private Integer imageShowType;
	private String adText;
	private Integer featureType;
	private Long featureFileSn;
	@ManyToOne
	@JoinColumn(name = "APP_FRAME_SN")
	private AppFrame app;
	@OneToOne
	@JoinColumn(name = "VR_AR_SN")
	private AppProdVrAr vrAr = new AppProdVrAr();
	@OneToOne
	@JoinColumn(name = "VIDEO_AR_SN")
	private AppProdVideoAr videoAr;
	private Integer isShow;
	private Integer sort;
	private Integer status;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Long getImageFileSn() {
		return imageFileSn;
	}
	public void setImageFileSn(Long imageFileSn) {
		this.imageFileSn = imageFileSn;
	}
	public Integer getImageShowType() {
		return imageShowType;
	}
	public void setImageShowType(Integer imageShowType) {
		this.imageShowType = imageShowType;
	}
	public String getAdText() {
		return adText;
	}
	public void setAdText(String adText) {
		this.adText = adText;
	}
	public Integer getFeatureType() {
		return featureType;
	}
	public void setFeatureType(Integer featureType) {
		this.featureType = featureType;
	}
	public Long getFeatureFileSn() {
		return featureFileSn;
	}
	public void setFeatureFileSn(Long featureFileSn) {
		this.featureFileSn = featureFileSn;
	}
	public AppFrame getApp() {
		return app;
	}
	public void setApp(AppFrame app) {
		this.app = app;
	}
	public AppProdVrAr getVrAr() {
		if(vrAr == null){
			this.vrAr = new AppProdVrAr();
		}
		return vrAr;
	}
	public void setVrAr(AppProdVrAr vrAr) {
		this.vrAr = vrAr;
	}
	public AppProdVideoAr getVideoAr() {
		return videoAr;
	}
	public void setVideoAr(AppProdVideoAr videoAr) {
		this.videoAr = videoAr;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}



}
