package com.focustech.furniture.model.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 产品目录
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name="core_category")
public class CoreCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recId;
	/**唯一标示目录的编码，由十位数字组成，取值范围1000000000-9999999999*/
	private Long catCode;

	private Long parentCatCode;
	/**表示此目录为几级目录，目前可能的取值为1，2，3 */
	private Integer catLevel;

	private String catNameEn;

	private String catNameCn;

	/**0为实体目录，1为链接目录*/
	private String catType;

	/**如果此目录为链接目录则存放链接的目标目录码，如果此目录为实体目录则字段值为0*/
	private Long linkCatCode;

	/**说明了MIC2003目录体系对应的老目录码，新增加的目录此字段值为0*/
	private String oldCatCode;

	private Date lastUpdateTime;

	private Integer lastUpdaterNo;

	private String lastUpdaterName;

	/**在调整目录时新加的字段，表明当前目录状态，1为正常目录，2为转合（转移走了或合并走的）目录。转合目录实际上是已经无效的目录*/
	private String catStatus;

	/**如果目录状态为转合，那么此字段表明，转移或合并到的目标目录码，此字段主要用在链接静态化上  */
	private Long aimCatCode;

	/** 0为无属性，1为新增或修改名称的一级目录，此字段主要用在链接静态化上，此字段并不说明目录的有效性*/
	private String catProperty;

	/**暂未使用*/
	private String catDescription;

	private Date repTime;

	public Integer getRecId() {
		return recId;
	}
	public void setRecId(Integer recId) {
		this.recId = recId;
	}
	public Long getCatCode() {
		return catCode;
	}
	public void setCatCode(Long catCode) {
		this.catCode = catCode;
	}
	public Long getParentCatCode() {
		return parentCatCode;
	}
	public void setParentCatCode(Long parentCatCode) {
		this.parentCatCode = parentCatCode;
	}
	public Integer getCatLevel() {
		return catLevel;
	}
	public void setCatLevel(Integer catLevel) {
		this.catLevel = catLevel;
	}
	public String getCatNameEn() {
		return catNameEn;
	}
	public void setCatNameEn(String catNameEn) {
		this.catNameEn = catNameEn;
	}
	public String getCatNameCn() {
		return catNameCn;
	}
	public void setCatNameCn(String catNameCn) {
		this.catNameCn = catNameCn;
	}
	public String getCatType() {
		return catType;
	}
	public void setCatType(String catType) {
		this.catType = catType;
	}
	public Long getLinkCatCode() {
		return linkCatCode;
	}
	public void setLinkCatCode(Long linkCatCode) {
		this.linkCatCode = linkCatCode;
	}
	public String getOldCatCode() {
		return oldCatCode;
	}
	public void setOldCatCode(String oldCatCode) {
		this.oldCatCode = oldCatCode;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getLastUpdaterNo() {
		return lastUpdaterNo;
	}
	public void setLastUpdaterNo(Integer lastUpdaterNo) {
		this.lastUpdaterNo = lastUpdaterNo;
	}
	public String getLastUpdaterName() {
		return lastUpdaterName;
	}
	public void setLastUpdaterName(String lastUpdaterName) {
		this.lastUpdaterName = lastUpdaterName;
	}
	public String getCatStatus() {
		return catStatus;
	}
	public void setCatStatus(String catStatus) {
		this.catStatus = catStatus;
	}
	public Long getAimCatCode() {
		return aimCatCode;
	}
	public void setAimCatCode(Long aimCatCode) {
		this.aimCatCode = aimCatCode;
	}
	public String getCatProperty() {
		return catProperty;
	}
	public void setCatProperty(String catProperty) {
		this.catProperty = catProperty;
	}
	public String getCatDescription() {
		return catDescription;
	}
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	public Date getRepTime() {
		return repTime;
	}
	public void setRepTime(Date repTime) {
		this.repTime = repTime;
	}
}