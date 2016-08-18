package com.focustech.focus3d.model.agent.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "biz_agent_order")
public class AgentOrder extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String orderNum;
	private Date orderTime;
	private Integer status;// '订单状态[1]-未完成;[2]-新加入;[3]-已支付;[4]-取消订单',
	private Long receiveAddressId;//'收货地址编号',
	private Long userId;//'用户编号',
	private Double totalPrice;//'总金额',
	private Integer isInvoice;//'是否开发票 0-不开 1-开',
	private Integer invoiceType;//'发票类型 1-个人 2-企业',
	private String invoiceHead;//'发票抬头',
	private String invoiceCompanyName;//'单位名称',
	private String invoiceTaxpayerId;//'纳税人编号',
	private String invoiceAddress;//'地址',
	private String invoicePhone;//'电话',
	private String invoiceBankName;//'开户行名称',
	private String invoiceBankAccount;
	private Date payTime;//'付款时间',
	private String prepayId;
	private Long qrFileSn;
	@Transient
	private AgentReceiveAddress revAddress = new AgentReceiveAddress();
	@Transient
	private AgentOrderLogtc orderLogtc = new AgentOrderLogtc();
	@Transient
	private List<AgentOrderItem> items = new ArrayList<AgentOrderItem>();
	@Transient
	private AgentOrderTrans agentOrderTrans;

	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getReceiveAddressId() {
		return receiveAddressId;
	}
	public void setReceiveAddressId(Long receiveAddressId) {
		this.receiveAddressId = receiveAddressId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(Integer isInvoice) {
		this.isInvoice = isInvoice;
	}
	public Integer getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceHead() {
		return invoiceHead;
	}
	public void setInvoiceHead(String invoiceHead) {
		this.invoiceHead = invoiceHead;
	}
	public String getInvoiceCompanyName() {
		return invoiceCompanyName;
	}
	public void setInvoiceCompanyName(String invoiceCompanyName) {
		this.invoiceCompanyName = invoiceCompanyName;
	}
	public String getInvoiceTaxpayerId() {
		return invoiceTaxpayerId;
	}
	public void setInvoiceTaxpayerId(String invoiceTaxpayerId) {
		this.invoiceTaxpayerId = invoiceTaxpayerId;
	}
	public String getInvoiceAddress() {
		return invoiceAddress;
	}
	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}
	public String getInvoicePhone() {
		return invoicePhone;
	}
	public void setInvoicePhone(String invoicePhone) {
		this.invoicePhone = invoicePhone;
	}
	public String getInvoiceBankName() {
		return invoiceBankName;
	}
	public void setInvoiceBankName(String invoiceBankName) {
		this.invoiceBankName = invoiceBankName;
	}
	public String getInvoiceBankAccount() {
		return invoiceBankAccount;
	}
	public void setInvoiceBankAccount(String invoiceBankAccount) {
		this.invoiceBankAccount = invoiceBankAccount;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	public Long getQrFileSn() {
		return qrFileSn;
	}
	public void setQrFileSn(Long qrFileSn) {
		this.qrFileSn = qrFileSn;
	}
	public AgentReceiveAddress getRevAddress() {
		return revAddress;
	}
	public void setRevAddress(AgentReceiveAddress revAddress) {
		this.revAddress = revAddress;
	}
	public AgentOrderLogtc getOrderLogtc() {
		return orderLogtc;
	}
	public void setOrderLogtc(AgentOrderLogtc orderLogtc) {
		this.orderLogtc = orderLogtc;
	}
	public List<AgentOrderItem> getItems() {
		return items;
	}
	public void setItems(List<AgentOrderItem> items) {
		this.items = items;
	}
	public AgentOrderTrans getAgentOrderTrans() {
		return agentOrderTrans;
	}
	public void setAgentOrderTrans(AgentOrderTrans agentOrderTrans) {
		this.agentOrderTrans = agentOrderTrans;
	}
}
