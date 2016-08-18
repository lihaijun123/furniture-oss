package com.focustech.focus3d.service.prodcase.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.cief.filemanage.common.utils.FileManageUtil;
import com.focustech.cief.filemanage.core.FileInfo;
import com.focustech.cief.filemanage.core.FileManageFactory;
import com.focustech.cief.filemanage.core.IFileManageClient;
import com.focustech.common.qrcodes.QrGeneratorUtil;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.prodcase.ProdCaseDao;
import com.focustech.focus3d.dao.prodcase.ProdCaseFileContentDao;
import com.focustech.focus3d.model.prodcase.ProdCase;
import com.focustech.focus3d.model.prodcase.ProdCaseFile;
import com.focustech.focus3d.model.prodcase.ProdCaseFileContent;
import com.focustech.focus3d.service.mq.ProdCasePublish;
import com.focustech.focus3d.service.prodcase.ProdCaseService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class ProdCaseServiceImpl extends BaseEntityServiceImpl<ProdCase> implements ProdCaseService<ProdCase> {

	@Autowired
	private ProdCaseDao<ProdCase> prodCaseDao;

	@Autowired
	private ProdCaseFileContentDao<ProdCaseFileContent> prodCaseFileContentDao;
	@Autowired
	private ProdCasePublish prodCasePublish;
	@Override
	public BaseHibernateDao<ProdCase> getEntityDao() {
		return prodCaseDao;
	}

	@Override
	public void insertOrUpdate(ProdCase prodCase) {
		ProdCaseFile caseFile = prodCase.getCaseFile();
        if(caseFile != null){
        	setNewInfo(caseFile);
        	setUpdateInfo(caseFile);
        	caseFile.setProdCase(prodCase);
        	List<ProdCaseFileContent> contents = caseFile.getContents();
        	List<ProdCaseFileContent> contentsCopy = new ArrayList<ProdCaseFileContent>();
        	List<ProdCaseFileContent> contentsRemove = new ArrayList<ProdCaseFileContent>();
        	if(!contents.isEmpty()){
        		for (ProdCaseFileContent prodCaseFileContent : contents) {
        			String contentName = prodCaseFileContent.getName();
        			Long contentFileSn = prodCaseFileContent.getContentFileSn();
        			if(contentFileSn != null && StringUtils.isNotEmpty(contentName)){
        				setNewInfo(prodCaseFileContent);
        				setUpdateInfo(prodCaseFileContent);
        				prodCaseFileContent.setProdCaseFile(caseFile);
        				contentsCopy.add(prodCaseFileContent);
        			}
        			if(prodCaseFileContent.getSn() != null && StringUtils.isEmpty(contentName)){
        				contentsRemove.add(prodCaseFileContent);
        			}
				}
        		if(!contentsRemove.isEmpty()){
        			for (ProdCaseFileContent rm : contentsRemove) {
        				prodCaseFileContentDao.deleteBySn(rm.getSn());
        			}
        		}
        		caseFile.setContents(contentsCopy);
        	}
        }
		prodCaseDao.insertOrUpdate(prodCase);
        Long fileSn = caseFile.getFileSn();
        if(fileSn != null){
    		Long qrFileSn = getQrFileSn(FileManageUtil.getFileName(fileSn) + "-二维码", FileManageUtil.getFileURL(fileSn));
    		caseFile.setQrFileSn(qrFileSn);
        }
        publishToJms();
	}
	/**
	 *
	 * *
	 */
	public void publishToJms(){
		prodCasePublish.publish("1");
	}
	/**
	 * 获取二维码sn
	 * *
	 * @param productInfo
	 * @return
	 */
	public long getQrFileSn(String name, String content){
		long qrFileSn = 0;
		try {
			FileInfo fileUploadObject = new FileInfo();
			fileUploadObject.setName(name + ".jpg");
			fileUploadObject.setBytes(QrGeneratorUtil.generate(content));
			IFileManageClient fileManageClient = FileManageFactory.getFileManageClient(fileUploadObject);
			fileManageClient.upload();
			qrFileSn = TCUtil.lv(fileManageClient.getFileId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrFileSn;
	}
}
