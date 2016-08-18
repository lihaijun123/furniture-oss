package com.focustech.focus3d.model.sale.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

import com.focustech.common.utils.DateUtils;
import com.focustech.model.common.BaseEntity;

@Entity
@Table(name ="sl_contact")
public class Contact extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Long customerSn;
	private Date contactTime;
	private String contactContent;
	private Date planTime;
	private String planContent;
	private String remark;
	private String sellerSn;
	private Integer isPlanDone;
	private Long planContactSn;

	@Transient
	private String sellerName;
	@Transient
	private String customerName;
	@Transient
	private String list;
	@Transient
	private Long parentContactSn;

	public Long getParentContactSn() {
		return parentContactSn;
	}
	public void setParentContactSn(Long parentContactSn) {
		this.parentContactSn = parentContactSn;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getCustomerSn() {
		return customerSn;
	}
	public void setCustomerSn(Long customerSn) {
		this.customerSn = customerSn;
	}
	public Date getContactTime() {
		return contactTime;
	}
	public void setContactTime(Date contactTime) {
		this.contactTime = contactTime;
	}
	public String getContactContent() {
		return contactContent;
	}
	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}
	public Date getPlanTime() {
		return planTime;
	}
	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSellerSn() {
		return sellerSn;
	}
	public void setSellerSn(String sellerSn) {
		this.sellerSn = sellerSn;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getIsPlanDone() {
		return isPlanDone;
	}
	public void setIsPlanDone(Integer isPlanDone) {
		this.isPlanDone = isPlanDone;
	}
	public Long getPlanContactSn() {
		return planContactSn;
	}
	public void setPlanContactSn(Long planContactSn) {
		this.planContactSn = planContactSn;
	}
}
