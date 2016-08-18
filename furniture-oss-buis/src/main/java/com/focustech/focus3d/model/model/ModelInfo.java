package com.focustech.focus3d.model.model;

import com.focustech.model.common.BaseEntity;
import com.focustech.oss2008.model.AutoArrayList;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "biz_model_store_info")
public class ModelInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    private String name;
    private Integer type;
    private Long fileSn;
    private Double price;
    private Long imageFileSn;
    private Long priority;
    private Long validFlag;
    private String summary;

    @OneToMany(mappedBy = "modelInfo",cascade = CascadeType.ALL)
    private List<ModelContentInfo> modelContentInfoList = new AutoArrayList<ModelContentInfo>(ModelContentInfo.class);

    public List<ModelContentInfo> getModelContentInfoList() {
        return modelContentInfoList;
    }

    public void setModelContentInfoList(List<ModelContentInfo> modelContentInfoList) {
        this.modelContentInfoList = modelContentInfoList;
    }

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getFileSn() {
        return fileSn;
    }

    public void setFileSn(Long fileSn) {
        this.fileSn = fileSn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getImageFileSn() {
        return imageFileSn;
    }

    public void setImageFileSn(Long imageFileSn) {
        this.imageFileSn = imageFileSn;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Long validFlag) {
        this.validFlag = validFlag;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
