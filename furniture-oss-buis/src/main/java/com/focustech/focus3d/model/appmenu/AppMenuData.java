package com.focustech.focus3d.model.appmenu;

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
@Table(name = "biz_mxj_app_menu_data")
public class AppMenuData extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String keyValue;
	private Long androidFileSn;
	private Long iosFileSn;
	private Integer androidVersionNum;
	private Integer iosVersionNum;
	private Integer type;
	private String name;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public Long getAndroidFileSn() {
		return androidFileSn;
	}
	public void setAndroidFileSn(Long androidFileSn) {
		this.androidFileSn = androidFileSn;
	}
	public Long getIosFileSn() {
		return iosFileSn;
	}
	public void setIosFileSn(Long iosFileSn) {
		this.iosFileSn = iosFileSn;
	}
	public Integer getAndroidVersionNum() {
		return androidVersionNum;
	}
	public void setAndroidVersionNum(Integer androidVersionNum) {
		this.androidVersionNum = androidVersionNum;
	}
	public Integer getIosVersionNum() {
		return iosVersionNum;
	}
	public void setIosVersionNum(Integer iosVersionNum) {
		this.iosVersionNum = iosVersionNum;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
