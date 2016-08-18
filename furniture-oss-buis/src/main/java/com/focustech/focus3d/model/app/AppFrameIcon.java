package com.focustech.focus3d.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;
/**
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_app_frame_icon")
public class AppFrameIcon extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Long imageFileSn;
	private Integer iconSetupType;
	private Long iconBgImgFileSn;
	private Integer iconFtType;
	private Long iconFtImgFileSn;
	private String iconFtFont;
	private Long logoFileSn;
	private Long cusIconFileSn;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getImageFileSn() {
		return imageFileSn;
	}
	public void setImageFileSn(Long imageFileSn) {
		this.imageFileSn = imageFileSn;
	}
	public Integer getIconSetupType() {
		return iconSetupType;
	}
	public void setIconSetupType(Integer iconSetupType) {
		this.iconSetupType = iconSetupType;
	}
	public Long getIconBgImgFileSn() {
		return iconBgImgFileSn;
	}
	public void setIconBgImgFileSn(Long iconBgImgFileSn) {
		this.iconBgImgFileSn = iconBgImgFileSn;
	}
	public Integer getIconFtType() {
		return iconFtType;
	}
	public void setIconFtType(Integer iconFtType) {
		this.iconFtType = iconFtType;
	}
	public Long getIconFtImgFileSn() {
		return iconFtImgFileSn;
	}
	public void setIconFtImgFileSn(Long iconFtImgFileSn) {
		this.iconFtImgFileSn = iconFtImgFileSn;
	}
	public String getIconFtFont() {
		return iconFtFont;
	}
	public void setIconFtFont(String iconFtFont) {
		this.iconFtFont = iconFtFont;
	}
	public Long getLogoFileSn() {
		return logoFileSn;
	}
	public void setLogoFileSn(Long logoFileSn) {
		this.logoFileSn = logoFileSn;
	}
	public Long getCusIconFileSn() {
		return cusIconFileSn;
	}
	public void setCusIconFileSn(Long cusIconFileSn) {
		this.cusIconFileSn = cusIconFileSn;
	}

}
