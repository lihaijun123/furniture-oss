package com.focustech.focus3d.model.agent.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.model.common.BaseEntity;
import com.focustech.oss2008.model.AutoArrayList;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_agent_user")
public class AgentUser extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String partnerId;//合作编号',
	private String mobilePhone;
	private String userName;
	private Integer agentGrade;//代理级别',
	private Integer totalSales;//'累计销量',
	private Double taskProgress;//'任务进度',
	private String province;
	private String city;
	private String street;
	private Long idCardFileSn;//'身份证复印件',
	private String companyName;//'公司名称',
	private Long kbisFileSn;//'营业执照',
	private Integer status;//'状态 1-审核通过 2-审核拒绝',
	private String remark;
	private Date validStartDate;
	private Date validEndDate;
	private Long contractFileSn;
	private String idCard;
	private String wxId;
	private Integer partnerType;
	private Integer regChannelType;
	@Transient
	private List<AgentProduct> productList = new AutoArrayList<AgentProduct>(AgentProduct.class);
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAgentGrade() {
		return agentGrade;
	}
	public void setAgentGrade(Integer agentGrade) {
		this.agentGrade = agentGrade;
	}
	public Integer getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(Integer totalSales) {
		this.totalSales = totalSales;
	}
	public Double getTaskProgress() {
		return taskProgress;
	}
	public void setTaskProgress(Double taskProgress) {
		this.taskProgress = taskProgress;
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
	public Long getIdCardFileSn() {
		return idCardFileSn;
	}
	public void setIdCardFileSn(Long idCardFileSn) {
		this.idCardFileSn = idCardFileSn;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getKbisFileSn() {
		return kbisFileSn;
	}
	public void setKbisFileSn(Long kbisFileSn) {
		this.kbisFileSn = kbisFileSn;
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
	public List<AgentProduct> getProductList() {
		return productList;
	}
	public void setProductList(List<AgentProduct> productList) {
		this.productList = productList;
	}
	public Date getValidStartDate() {
		return validStartDate;
	}
	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}
	public Date getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}
	public Long getContractFileSn() {
		return contractFileSn;
	}
	public void setContractFileSn(Long contractFileSn) {
		this.contractFileSn = contractFileSn;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public Integer getPartnerType() {
		return partnerType;
	}
	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}
	public Integer getRegChannelType() {
		return regChannelType;
	}
	public void setRegChannelType(Integer regChannelType) {
		this.regChannelType = regChannelType;
	}
}
