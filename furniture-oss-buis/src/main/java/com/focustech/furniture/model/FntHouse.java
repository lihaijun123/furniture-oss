package com.focustech.furniture.model;

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
@Table(name = "fnt_house")
public class FntHouse extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
	private String name;
	private String buildingName;
	private String province;
	private String city;
	private String street;
	private String buildingNo;
	private Integer type;
	private String area;
	private Long picFileSn;
	private String modelName;
	private Long modelFileSn;
	private Integer roomNum;
	private Integer livingRoomNum;
	private Integer status;
	private String remark;
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
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Long getPicFileSn() {
		return picFileSn;
	}
	public void setPicFileSn(Long picFileSn) {
		this.picFileSn = picFileSn;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getLivingRoomNum() {
		return livingRoomNum;
	}
	public void setLivingRoomNum(Integer livingRoomNum) {
		this.livingRoomNum = livingRoomNum;
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
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Long getModelFileSn() {
		return modelFileSn;
	}
	public void setModelFileSn(Long modelFileSn) {
		this.modelFileSn = modelFileSn;
	}
	
}
