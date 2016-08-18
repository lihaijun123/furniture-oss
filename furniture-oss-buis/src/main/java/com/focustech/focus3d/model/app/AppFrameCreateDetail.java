package com.focustech.focus3d.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_app_frame_create_detail")
public class AppFrameCreateDetail extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	@ManyToOne
	@JoinColumn(name = "APP_FRAME_SN")
	private AppFrame app;
	private Integer systemType;
	private Integer status;
	private String versionNum;
	private Long qrFileSn;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public AppFrame getApp() {
		return app;
	}
	public void setApp(AppFrame app) {
		this.app = app;
	}
	public Integer getSystemType() {
		return systemType;
	}
	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}
	public Long getQrFileSn() {
		return qrFileSn;
	}
	public void setQrFileSn(Long qrFileSn) {
		this.qrFileSn = qrFileSn;
	}
}
