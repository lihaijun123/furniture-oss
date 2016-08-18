package com.focustech.focus3d.model.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_app_frame_guid")
public class AppFrameGuid extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;

	private Integer effectType;
	private Integer setupType;
	@OneToMany(mappedBy = "guid")
	private List<AppFrameGuidDetail> detail = new ArrayList<AppFrameGuidDetail>();
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Integer getEffectType() {
		return effectType;
	}
	public void setEffectType(Integer effectType) {
		this.effectType = effectType;
	}
	public Integer getSetupType() {
		return setupType;
	}
	public void setSetupType(Integer setupType) {
		this.setupType = setupType;
	}
	public List<AppFrameGuidDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<AppFrameGuidDetail> detail) {
		this.detail = detail;
	}

}
