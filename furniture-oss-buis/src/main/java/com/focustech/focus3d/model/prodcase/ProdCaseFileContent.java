package com.focustech.focus3d.model.prodcase;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "biz_prod_case_file_content")
public class ProdCaseFileContent extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private Integer type;
	private Long contentFileSn;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PROD_CASE_FILE_SN")
	private ProdCaseFile prodCaseFile;
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
	public ProdCaseFile getProdCaseFile() {
		return prodCaseFile;
	}
	public void setProdCaseFile(ProdCaseFile prodCaseFile) {
		this.prodCaseFile = prodCaseFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContentFileSn() {
		return contentFileSn;
	}
	public void setContentFileSn(Long contentFileSn) {
		this.contentFileSn = contentFileSn;
	}
}
