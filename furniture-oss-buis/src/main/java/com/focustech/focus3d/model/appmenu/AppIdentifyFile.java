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
@Table(name = "biz_mxj_app_identify_file")
public class AppIdentifyFile extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private Long datFileSn;
	private Long xmlFileSn;
	private Integer versionNum;
	private Integer type;
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
	public Long getDatFileSn() {
		return datFileSn;
	}
	public void setDatFileSn(Long datFileSn) {
		this.datFileSn = datFileSn;
	}
	public Long getXmlFileSn() {
		return xmlFileSn;
	}
	public void setXmlFileSn(Long xmlFileSn) {
		this.xmlFileSn = xmlFileSn;
	}
	public Integer getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
