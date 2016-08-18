package com.focustech.focus3d.model.agent.order;

import java.util.Date;

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
@Table(name = "biz_agent_order_trans")
public class AgentOrderTrans extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String orderId;
	private String bankCode;
	private String bankName;
	private Date transDate;
	private String transType;
	private Integer transPlatformType;
	private String transAccount;
	private Float transMoney;
	private String merId;
	private String currencyId;
	private String transStatus;
	private String transId;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Integer getTransPlatformType() {
		return transPlatformType;
	}
	public void setTransPlatformType(Integer transPlatformType) {
		this.transPlatformType = transPlatformType;
	}
	public String getTransAccount() {
		return transAccount;
	}
	public void setTransAccount(String transAccount) {
		this.transAccount = transAccount;
	}
	public Float getTransMoney() {
		return transMoney;
	}
	public void setTransMoney(Float transMoney) {
		this.transMoney = transMoney;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
}
