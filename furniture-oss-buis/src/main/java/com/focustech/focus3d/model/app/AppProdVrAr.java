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
@Table(name = "biz_app_prod_vr_ar")
public class AppProdVrAr extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Long modelFileSn;
	private Long iosModelFileSn;
	private Long modelMakePackFileSn;
	private Long arPackFileSn;
	private Long sceneFileSn;
	private String summary;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getModelFileSn() {
		return modelFileSn;
	}
	public void setModelFileSn(Long modelFileSn) {
		this.modelFileSn = modelFileSn;
	}
	public Long getModelMakePackFileSn() {
		return modelMakePackFileSn;
	}
	public void setModelMakePackFileSn(Long modelMakePackFileSn) {
		this.modelMakePackFileSn = modelMakePackFileSn;
	}
	public Long getArPackFileSn() {
		return arPackFileSn;
	}
	public void setArPackFileSn(Long arPackFileSn) {
		this.arPackFileSn = arPackFileSn;
	}
	public Long getSceneFileSn() {
		return sceneFileSn;
	}
	public void setSceneFileSn(Long sceneFileSn) {
		this.sceneFileSn = sceneFileSn;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Long getIosModelFileSn() {
		return iosModelFileSn;
	}
	public void setIosModelFileSn(Long iosModelFileSn) {
		this.iosModelFileSn = iosModelFileSn;
	}
}
