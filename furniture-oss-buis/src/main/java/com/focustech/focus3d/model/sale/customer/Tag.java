package com.focustech.focus3d.model.sale.customer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.focustech.model.common.BaseEntity;

/**
*
* *
* @author yangrongrong
*
*/
@Entity
@Table(name = "sl_tag")
public class Tag extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String sellerSn;
	private String name;

	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getSellerSn() {
		return sellerSn;
	}
	public void setSellerSn(String sellerSn) {
		this.sellerSn = sellerSn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}




}
