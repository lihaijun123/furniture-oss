package com.focustech.focus3d.model.prodcase;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.focustech.model.common.BaseEntity;
import com.focustech.oss2008.model.AutoArrayList;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity(name = "biz_prod_case_file")
public class ProdCaseFile extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String fileName;
	private Long fileSn;
	private String fileVersion;
	private Integer type;
	private String summary;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROD_CASE_SN")
	private ProdCase prodCase;
	@OneToMany(mappedBy = "prodCaseFile", cascade = CascadeType.ALL)
	private List<ProdCaseFileContent> contents = new AutoArrayList<ProdCaseFileContent>(ProdCaseFileContent.class);
	private Long qrFileSn;
	private Long playPicFileSn;
	private Long bkPicFileSn;

	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSn() {
		return fileSn;
	}
	public void setFileSn(Long fileSn) {
		this.fileSn = fileSn;
	}
	public String getFileVersion() {
		return fileVersion;
	}
	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<ProdCaseFileContent> getContents() {
		return contents;
	}
	public void setContents(List<ProdCaseFileContent> contents) {
		this.contents = contents;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public ProdCase getProdCase() {
		return prodCase;
	}
	public void setProdCase(ProdCase prodCase) {
		this.prodCase = prodCase;
	}
	public Long getQrFileSn() {
		return qrFileSn;
	}
	public void setQrFileSn(Long qrFileSn) {
		this.qrFileSn = qrFileSn;
	}
	public Long getPlayPicFileSn() {
		return playPicFileSn;
	}
	public void setPlayPicFileSn(Long playPicFileSn) {
		this.playPicFileSn = playPicFileSn;
	}
	public Long getBkPicFileSn() {
		return bkPicFileSn;
	}
	public void setBkPicFileSn(Long bkPicFileSn) {
		this.bkPicFileSn = bkPicFileSn;
	}
}
