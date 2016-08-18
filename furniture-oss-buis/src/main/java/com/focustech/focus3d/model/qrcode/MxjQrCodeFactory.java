package com.focustech.focus3d.model.qrcode;

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
@Table(name = "biz_mxj_qr_code_factory")
public class MxjQrCodeFactory extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;

	private Integer quantity;
	private Integer type;
	private Integer dataComplete;
	private Integer packageComplete;
	private Integer downloadComplete;
	private Integer publishComplete;
	private Integer printComplete;
	private Integer randomValue;
	private String packageName;
	private String packagePath;
	private String remark;
	@Transient
	private Integer strategyType;
	@Transient
	private String randomValueStr;

	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDataComplete() {
		return dataComplete;
	}
	public void setDataComplete(Integer dataComplete) {
		this.dataComplete = dataComplete;
	}
	public Integer getPackageComplete() {
		return packageComplete;
	}
	public void setPackageComplete(Integer packageComplete) {
		this.packageComplete = packageComplete;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackagePath() {
		return packagePath;
	}
	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}
	public Integer getDownloadComplete() {
		return downloadComplete;
	}
	public void setDownloadComplete(Integer downloadComplete) {
		this.downloadComplete = downloadComplete;
	}
	public Integer getPublishComplete() {
		return publishComplete;
	}
	public void setPublishComplete(Integer publishComplete) {
		this.publishComplete = publishComplete;
	}
	public Integer getRandomValue() {
		return randomValue;
	}
	public void setRandomValue(Integer randomValue) {
		this.randomValue = randomValue;
	}
	public Integer getPrintComplete() {
		return printComplete;
	}
	public void setPrintComplete(Integer printComplete) {
		this.printComplete = printComplete;
	}
	public Integer getStrategyType() {
		return strategyType;
	}
	public void setStrategyType(Integer strategyType) {
		this.strategyType = strategyType;
	}
	public String getRandomValueStr() {
		return randomValueStr;
	}
	public void setRandomValueStr(String randomValueStr) {
		this.randomValueStr = randomValueStr;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
