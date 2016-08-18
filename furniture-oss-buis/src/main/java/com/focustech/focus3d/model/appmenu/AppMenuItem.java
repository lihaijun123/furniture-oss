package com.focustech.focus3d.model.appmenu;

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
@Table(name = "biz_mxj_app_menu_item")
public class AppMenuItem extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String keyValue;
	private String name;
	private String nameZh;
	private Integer type;
	private String levelName;
	private Long androidFileSn;
	private Long iosFileSn;
	private Long iosPadFileSn;
	private Integer fileLength;
	private String filePath;
	private String callBack;
	private String processValue;
	private Integer isUnload;
	private Integer androidVersionNum;
	private Integer iosVersionNum;
	private Integer iosPadVersionNum;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Long getAndroidFileSn() {
		return androidFileSn;
	}
	public void setAndroidFileSn(Long androidFileSn) {
		this.androidFileSn = androidFileSn;
	}
	public Long getIosFileSn() {
		return iosFileSn;
	}
	public void setIosFileSn(Long iosFileSn) {
		this.iosFileSn = iosFileSn;
	}
	public Integer getFileLength() {
		return fileLength;
	}
	public void setFileLength(Integer fileLength) {
		this.fileLength = fileLength;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCallBack() {
		return callBack;
	}
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}
	public String getProcessValue() {
		return processValue;
	}
	public void setProcessValue(String processValue) {
		this.processValue = processValue;
	}
	public Integer getIsUnload() {
		return isUnload;
	}
	public void setIsUnload(Integer isUnload) {
		this.isUnload = isUnload;
	}
	public Integer getAndroidVersionNum() {
		return androidVersionNum;
	}
	public void setAndroidVersionNum(Integer androidVersionNum) {
		this.androidVersionNum = androidVersionNum;
	}
	public Integer getIosVersionNum() {
		return iosVersionNum;
	}
	public void setIosVersionNum(Integer iosVersionNum) {
		this.iosVersionNum = iosVersionNum;
	}
	public Long getIosPadFileSn() {
		return iosPadFileSn;
	}
	public void setIosPadFileSn(Long iosPadFileSn) {
		this.iosPadFileSn = iosPadFileSn;
	}
	public Integer getIosPadVersionNum() {
		return iosPadVersionNum;
	}
	public void setIosPadVersionNum(Integer iosPadVersionNum) {
		this.iosPadVersionNum = iosPadVersionNum;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
