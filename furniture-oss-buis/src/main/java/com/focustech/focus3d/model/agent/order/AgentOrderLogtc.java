package com.focustech.focus3d.model.agent.order;

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
@Table(name = "biz_agent_order_logtc")
public class AgentOrderLogtc extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String logtcId;//'物流编号',
	private String logtcName;//'物流名称',
	private Integer logicType;//'物流类型 1-快递 2-物流',
	private Integer isSend;//'是否发货 0-未发货 1-发货',
	private Integer isReceive;//'是否已经收到货 0-未收货 1-已收货',
	private Long orderId;//订单编号',
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getLogtcId() {
		return logtcId;
	}
	public void setLogtcId(String logtcId) {
		this.logtcId = logtcId;
	}
	public String getLogtcName() {
		return logtcName;
	}
	public void setLogtcName(String logtcName) {
		this.logtcName = logtcName;
	}

	public Integer getLogicType() {
		return logicType;
	}
	public void setLogicType(Integer logicType) {
		this.logicType = logicType;
	}
	public Integer getIsSend() {
		return isSend;
	}
	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}
	public Integer getIsReceive() {
		return isReceive;
	}
	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
