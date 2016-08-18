package com.focustech.focus3d.model.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.focustech.model.common.BaseEntity;

@Entity
@Table(name = "biz_model_store_content")
public class ModelContentInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    private String name;
    private Integer type;
    private Long fileSn;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MODEL_STORE_INFO_SN")
    private ModelInfo modelInfo;

    public ModelInfo getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(ModelInfo modelInfo) {
        this.modelInfo = modelInfo;
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
}
