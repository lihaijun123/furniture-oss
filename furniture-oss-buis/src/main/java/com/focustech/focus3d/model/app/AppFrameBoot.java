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
@Table(name = "biz_app_frame_boot")
public class AppFrameBoot extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private Integer setupType;
	private Long imageFileSn;
	private Long defaultImageFileSn;
	private Integer isCopyright;
	private String copyrightText;
	private String warterText;
	private Integer validFlag;
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
	public Long getDefaultImageFileSn() {
		return defaultImageFileSn;
	}
	public void setDefaultImageFileSn(Long defaultImageFileSn) {
		this.defaultImageFileSn = defaultImageFileSn;
	}
	public Integer getIsCopyright() {
		return isCopyright;
	}
	public void setIsCopyright(Integer isCopyright) {
		this.isCopyright = isCopyright;
	}
	public String getCopyrightText() {
		return copyrightText;
	}
	public void setCopyrightText(String copyrightText) {
		this.copyrightText = copyrightText;
	}
	public String getWarterText() {
		return warterText;
	}
	public void setWarterText(String warterText) {
		this.warterText = warterText;
	}
	public Integer getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}
}
