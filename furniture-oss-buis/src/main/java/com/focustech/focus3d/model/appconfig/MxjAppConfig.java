package com.focustech.focus3d.model.appconfig;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.focustech.model.common.BaseEntity;
import com.focustech.oss2008.model.AutoArrayList;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "BIZ_MXJ_APP_CONFIG")
public class MxjAppConfig extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String keyName;
	private String keyValue;
	private String keyValueCloud;
	private Integer isValid;
	private Integer type;
	private Integer configGetType;
	private String remark;
	@Transient
	private List<AppConfigKeyValue> localValues = new AutoArrayList<AppConfigKeyValue>(AppConfigKeyValue.class);
	@Transient
	private List<AppConfigKeyValue> cloudValues = new AutoArrayList<AppConfigKeyValue>(AppConfigKeyValue.class);
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getKeyValueCloud() {
		return keyValueCloud;
	}
	public void setKeyValueCloud(String keyValueCloud) {
		this.keyValueCloud = keyValueCloud;
	}
	public Integer getConfigGetType() {
		return configGetType;
	}
	public void setConfigGetType(Integer configGetType) {
		this.configGetType = configGetType;
	}
	public List<AppConfigKeyValue> getLocalValues() {
		return localValues;
	}
	public void setLocalValues(List<AppConfigKeyValue> localValues) {
		this.localValues = localValues;
	}
	public List<AppConfigKeyValue> getCloudValues() {
		return cloudValues;
	}
	public void setCloudValues(List<AppConfigKeyValue> cloudValues) {
		this.cloudValues = cloudValues;
	}

}
