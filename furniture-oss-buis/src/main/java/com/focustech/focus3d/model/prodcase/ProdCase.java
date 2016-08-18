package com.focustech.focus3d.model.prodcase;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.focustech.model.common.BaseEntity;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity(name = "biz_prod_case")
public class ProdCase extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String name;
	private Integer type;
	private Long imageFileSn;
	private Long indexImageFileSn;
	private Long serviceImageFileSn;
	private Long ciefImageFileSn;
	private Long aboutImageFileSn;
	private Long caseImageFileSn;
	private String companyName;
	private String mainProduct;
	private String url;
	private Integer priority;
	private Integer validFlag;
	private String summary;
	@OneToOne(mappedBy = "prodCase", cascade = CascadeType.ALL)
	private ProdCaseFile caseFile = new ProdCaseFile();
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getImageFileSn() {
		return imageFileSn;
	}
	public void setImageFileSn(Long imageFileSn) {
		this.imageFileSn = imageFileSn;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMainProduct() {
		return mainProduct;
	}
	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ProdCaseFile getCaseFile() {
		return caseFile;
	}
	public void setCaseFile(ProdCaseFile caseFile) {
		this.caseFile = caseFile;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Long getIndexImageFileSn() {
		return indexImageFileSn;
	}
	public void setIndexImageFileSn(Long indexImageFileSn) {
		this.indexImageFileSn = indexImageFileSn;
	}
	public Long getServiceImageFileSn() {
		return serviceImageFileSn;
	}
	public void setServiceImageFileSn(Long serviceImageFileSn) {
		this.serviceImageFileSn = serviceImageFileSn;
	}
	public Long getCiefImageFileSn() {
		return ciefImageFileSn;
	}
	public void setCiefImageFileSn(Long ciefImageFileSn) {
		this.ciefImageFileSn = ciefImageFileSn;
	}
	public Long getAboutImageFileSn() {
		return aboutImageFileSn;
	}
	public void setAboutImageFileSn(Long aboutImageFileSn) {
		this.aboutImageFileSn = aboutImageFileSn;
	}
	public Long getCaseImageFileSn() {
		return caseImageFileSn;
	}
	public void setCaseImageFileSn(Long caseImageFileSn) {
		this.caseImageFileSn = caseImageFileSn;
	}
}
