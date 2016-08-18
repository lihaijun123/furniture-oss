package com.focustech.focus3d.service.model;

import com.focustech.oss2008.service.BaseEntityService;

public interface ModelInfoService<T> extends BaseEntityService<T> {
    void createOrUpdateModel(T modelInfo);
}
