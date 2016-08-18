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
@Table(name = "biz_app_frame_contact")
public class AppFrameContact extends BaseEntity {

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
	private String telephone;
	private String fax;
	private String zipCode;
	private String email;
	private String nameEn;
	private String summaryEn;
	private String addressEn;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getSummaryEn() {
		return summaryEn;
	}
	public void setSummaryEn(String summaryEn) {
		this.summaryEn = summaryEn;
	}
	public String getAddressEn() {
		return addressEn;
	}
	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}
}
