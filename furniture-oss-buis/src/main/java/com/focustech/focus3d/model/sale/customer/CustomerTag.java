package com.focustech.focus3d.model.sale.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.focustech.model.common.BaseEntity;

/**
*
* *
* @author yangrongrong
*
*/
@Entity
@Table(name = "sl_customer_tag")
public class CustomerTag extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private Long tagSn;
	private Long customerSn;

	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getTagSn() {
		return tagSn;
	}
	public void setTagSn(Long tagSn) {
		this.tagSn = tagSn;
	}
	public Long getCustomerSn() {
		return customerSn;
	}
	public void setCustomerSn(Long customerSn) {
		this.customerSn = customerSn;
	}

}
