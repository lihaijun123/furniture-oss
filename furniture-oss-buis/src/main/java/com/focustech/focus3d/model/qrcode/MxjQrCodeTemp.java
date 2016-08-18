package com.focustech.focus3d.model.qrcode;

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
@Table(name = "biz_mxj_qr_code_temp")
public class MxjQrCodeTemp extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Integer type;
	private Long qrFileSn;
	private String content;
	private Long qrCodeFactorySn;
	private String qrId;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getQrFileSn() {
		return qrFileSn;
	}
	public void setQrFileSn(Long qrFileSn) {
		this.qrFileSn = qrFileSn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getQrCodeFactorySn() {
		return qrCodeFactorySn;
	}
	public void setQrCodeFactorySn(Long qrCodeFactorySn) {
		this.qrCodeFactorySn = qrCodeFactorySn;
	}
	public String getQrId() {
		return qrId;
	}
	public void setQrId(String qrId) {
		this.qrId = qrId;
	}

}
