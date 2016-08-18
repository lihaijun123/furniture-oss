package com.focustech.focus3d.service.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.focus3d.dao.model.ModelInfoDao;
import com.focustech.focus3d.model.model.ModelContentInfo;
import com.focustech.focus3d.model.model.ModelInfo;
import com.focustech.focus3d.service.model.ModelInfoService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;

@Service
public class ModelInfoServiceImpl extends BaseEntityServiceImpl<ModelInfo> implements ModelInfoService<ModelInfo> {
    @Autowired
    private ModelInfoDao<ModelInfo> modelInfoDao;

    @Override
    public BaseHibernateDao<ModelInfo> getEntityDao() {
        return modelInfoDao;
    }

    @Override
    public void createOrUpdateModel(ModelInfo modelInfo) {
        //完善模型明细信息
        List<ModelContentInfo> list = modelInfo.getModelContentInfoList();
        List<ModelContentInfo> result = new ArrayList<ModelContentInfo>();
        for (ModelContentInfo info : list) {
            if (info.getFileSn() == null) continue;
            if (info.getType() == null) continue;
            if (info.getName() == null) continue;
            setNewInfo(info);
            setUpdateInfo(info);
            info.setModelInfo(modelInfo);
            result.add(info);
        }
        modelInfo.setModelContentInfoList(result);
        //保存
        getEntityDao().insertOrUpdate(modelInfo);
    }
}
