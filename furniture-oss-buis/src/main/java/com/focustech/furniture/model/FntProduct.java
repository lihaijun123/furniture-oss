package com.focustech.furniture.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.focustech.model.common.BaseEntity;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "FNT_PRODUCT")
public class FntProduct extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
	private String productId;
	private String name;
	private String brand;
	private double price;
	private String materia;
	private String color;
	private String specName;
	private String specSize;
	private String parameter;
	private double grossWeight;
	private String categoryCode;
	private String categoryName;
	private String style;
	private String modelName;
	private Long modelFileSn;
	private Integer modelFileVersion;
	private String design;
	private Integer isWithCore;
	private String filler;
	private Integer status;
	private Date shelvesTime;
	private String remark;
	private Long picFileSn;
	private Integer type;
	@Transient
	private String modelFileUrl;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSpecSize() {
		return specSize;
	}
	public void setSpecSize(String specSize) {
		this.specSize = specSize;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
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
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public Integer getIsWithCore() {
		return isWithCore;
	}
	public void setIsWithCore(Integer isWithCore) {
		this.isWithCore = isWithCore;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(Date shelvesTime) {
		this.shelvesTime = shelvesTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getPicFileSn() {
		return picFileSn;
	}
	public void setPicFileSn(Long picFileSn) {
		this.picFileSn = picFileSn;
	}
	public String getModelFileUrl() {
		return modelFileUrl;
	}
	public void setModelFileUrl(String modelFileUrl) {
		this.modelFileUrl = modelFileUrl;
	}
	public Integer getModelFileVersion() {
		return modelFileVersion;
	}
	public void setModelFileVersion(Integer modelFileVersion) {
		this.modelFileVersion = modelFileVersion;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
