package com.focustech.furniture.product.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.cief.filemanage.common.utils.FileManageUtil;
import com.focustech.common.utils.TCUtil;
import com.focustech.furniture.model.FntProduct;
import com.focustech.furniture.product.dao.FntProductDao;
import com.focustech.furniture.product.service.FntProductService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
public class FntProductServiceImpl extends BaseEntityServiceImpl<FntProduct> implements FntProductService<FntProduct> {
	@Autowired
	private FntProductDao<FntProduct> fntProductDao;
	@Override
	public BaseHibernateDao<FntProduct> getEntityDao() {
		return fntProductDao;
	}
	@Override
	public FntProduct select(Serializable id) {
		FntProduct select = super.select(id);
		if(select != null){
			Long modelFileSn = select.getModelFileSn();
			if(modelFileSn != null){
				select.setModelFileUrl(TCUtil.sv(FileManageUtil.getFileURL(modelFileSn)));
			}
		}
		return select;
	}
	

}
