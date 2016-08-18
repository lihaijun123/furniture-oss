package com.focustech.focus3d.model.userinfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.focustech.focus3d.model.companyinfo.CompanyInfo;
import com.focustech.model.common.AuditEntity;
import com.focustech.model.common.BaseEntity;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_user_info")
public class UserInfo extends BaseEntity implements AuditEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private Long iconFileSn;
	private String nick;
	private Integer sex;
	private String contact;
	private String province;
	private String city;
	private String motto;
	@ManyToOne
	@JoinColumn(name = "COMPANY_INFO_SN")
	private CompanyInfo companyInfoModel = new CompanyInfo();
	private Integer status;
	private String auditRemark;
	private Long auditorSn;
	private String auditorName;
	private Date auditTime;
	@OneToOne(mappedBy = "userInfo")
	private LoginInfo loginInfo;
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
	public Long getIconFileSn() {
		return iconFileSn;
	}
	public void setIconFileSn(Long iconFileSn) {
		this.iconFileSn = iconFileSn;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}

	public CompanyInfo getCompanyInfoModel() {
		return companyInfoModel;
	}
	public void setCompanyInfoModel(CompanyInfo companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	public Long getAuditorSn() {
		return auditorSn;
	}
	public void setAuditorSn(Long auditorSn) {
		this.auditorSn = auditorSn;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

}
