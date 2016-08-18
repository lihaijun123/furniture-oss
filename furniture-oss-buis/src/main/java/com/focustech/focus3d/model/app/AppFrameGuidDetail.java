package com.focustech.focus3d.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_app_frame_guid_detail")
public class AppFrameGuidDetail extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	@ManyToOne
	@JoinColumn(name = "APP_FRAME_GUID_SN")
	private AppFrameGuid guid;
	private Long imageFileSn;
	private Long defaultImageFileSn;
	private Integer sort;
	private Integer validFlag;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public AppFrameGuid getGuid() {
		return guid;
	}
	public void setGuid(AppFrameGuid guid) {
		this.guid = guid;
	}
	public Long getImageFileSn() {
		return imageFileSn;
	}
	public void setImageFileSn(Long imageFileSn) {
		this.imageFileSn = imageFileSn;
	}
	public Long getDefaultImageFileSn() {
		return defaultImageFileSn;
	}
	public void setDefaultImageFileSn(Long defaultImageFileSn) {
		this.defaultImageFileSn = defaultImageFileSn;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}
}
