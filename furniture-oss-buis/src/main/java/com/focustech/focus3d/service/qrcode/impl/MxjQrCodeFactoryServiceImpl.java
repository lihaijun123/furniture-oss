package com.focustech.focus3d.service.qrcode.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.cief.filemanage.core.FileInfo;
import com.focustech.cief.filemanage.core.FileManageClient;
import com.focustech.cief.filemanage.core.FileManageFactory;
import com.focustech.cief.filemanage.core.IFileManageClient;
import com.focustech.common.qrcodes.MatrixToImageWriter;
import com.focustech.common.utils.DateUtils;
import com.focustech.common.utils.MathUtils;
import com.focustech.common.utils.SHAUtil;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.common.utils.zip.ZipUtil;
import com.focustech.focus3d.common.constant.MxjQrCodeType;
import com.focustech.focus3d.dao.qrcode.MxjQrCodeDao;
import com.focustech.focus3d.dao.qrcode.MxjQrCodeFactoryDao;
import com.focustech.focus3d.dao.qrcode.MxjQrCodeTempDao;
import com.focustech.focus3d.model.qrcode.MxjQrCode;
import com.focustech.focus3d.model.qrcode.MxjQrCodeFactory;
import com.focustech.focus3d.model.qrcode.MxjQrCodeTemp;
import com.focustech.focus3d.service.qrcode.MxjQrCodeFactoryService;
import com.focustech.focus3d.web.controller.qrcode.MxjQrCodePackageProcess;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
import com.focustech.uitool.framework.NLGlobal;
import com.focustech.uitool.framework.SystemTool;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class MxjQrCodeFactoryServiceImpl extends BaseEntityServiceImpl<MxjQrCodeFactory> implements MxjQrCodeFactoryService<MxjQrCodeFactory> {
	@Autowired
	private MxjQrCodeFactoryDao<MxjQrCodeFactory> mxjQrCodeFactoryDao;
	@Autowired
	private MxjQrCodeTempDao<MxjQrCodeTemp> qrCodeTempDao;
	@Autowired
	private FileManageClient fileManageClient;
	@Autowired
	private MxjQrCodeDao<MxjQrCode> qrCodeDao;
	private static final String COMPANY_CODE_STR = "F3D";
	@Override
	public BaseHibernateDao<MxjQrCodeFactory> getEntityDao() {
		return mxjQrCodeFactoryDao;
	}
	/**
	 * 生成二维码数据
	 * *
	 */
	@Override
	public MxjQrCodeFactory generateData(MxjQrCodeFactory mxjQrCodeFactory) {
		Integer quantity = mxjQrCodeFactory.getQuantity();
		Integer type = mxjQrCodeFactory.getType();
		if(quantity != null && quantity > 0 && type != null && type > 0){
			MxjQrCodePackageProcess.putProcess(TCUtil.sv(0));
			//协议
			//二维码内容	二维码内容，协议：公司名 + 产品名 + 系列类型 + 时间戳 + 系列英文名，编码处理
			try {
				Long factorySn = mxjQrCodeFactory.getSn();
				if(factorySn == null){
					mxjQrCodeFactory = new MxjQrCodeFactory();
					mxjQrCodeFactory.setType(type);
					mxjQrCodeFactory.setQuantity(quantity);
					mxjQrCodeFactory.setDataComplete(0);
					mxjQrCodeFactory.setPackageComplete(0);
					mxjQrCodeFactory.setPublishComplete(0);
					mxjQrCodeFactory.setPrintComplete(0);
					mxjQrCodeFactoryDao.insertOrUpdate(mxjQrCodeFactory);
				} else {
					qrCodeTempDao.deleteByFactorySn(factorySn);
				}
				factorySn = mxjQrCodeFactory.getSn();
				String mPrintTimes = getPrintCodeOfMonth(mxjQrCodeFactory);
		        String sequenceHead = getSequenceHeadStr(COMPANY_CODE_STR, type);
				for(int i = 0; i < quantity; i ++){
					//二维码内容
					String data = "focus3d" + "mxj" + type + DateUtils.getCurDate(DateUtils.DEFAULT_FORMATE_ALL) + UUID.randomUUID();
					String content = SHAUtil.byte2Hex(SHAUtil.getSHA1Digest(data)) + "_" + MxjQrCodeType.getNameEn(type);
					//生成二维码
					String sequenceBody = mPrintTimes + generateFixedLenthNumStr(i + 1, 4);
					//二维码编号
					String qrId = sequenceHead + sequenceBody;
					long qrFileSn = getQrFileSn(content, qrId);
					if(qrFileSn >  0){
							MxjQrCodeTemp qrCodeModel = new MxjQrCodeTemp();
							qrCodeModel.setQrFileSn(qrFileSn);
							qrCodeModel.setContent(content);
							qrCodeModel.setType(type);
							qrCodeModel.setQrCodeFactorySn(factorySn);
							qrCodeModel.setQrId(qrId);
							qrCodeTempDao.insert(qrCodeModel);
					}
					double progressValue = MathUtils.div((i + 1), quantity);
					MxjQrCodePackageProcess.putProcess(TCUtil.sv(progressValue));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				String prePackagePath = mxjQrCodeFactory.getPackagePath();
				mxjQrCodeFactory.setDataComplete(1);
				mxjQrCodeFactory.setPackageComplete(0);
				mxjQrCodeFactory.setDownloadComplete(0);
				mxjQrCodeFactory.setPublishComplete(0);
				mxjQrCodeFactory.setPrintComplete(0);
				mxjQrCodeFactory.setRandomValue(TCUtil.iv(mPrintTimes));
				mxjQrCodeFactory.setPackageName("");
				mxjQrCodeFactory.setPackagePath("");
				mxjQrCodeFactoryDao.insertOrUpdate(mxjQrCodeFactory);
				deleteZipFile(prePackagePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mxjQrCodeFactory;
	}

	private String getPrintCodeOfMonth(MxjQrCodeFactory factory){
		if(factory == null){
			throw new RuntimeException("参数不能为空");
		}
		//印刷次数
		int count = mxjQrCodeFactoryDao.getCount(factory.getType(), 1, DateUtils.getCurDate("yyyy-MM"), factory.getSn());
		String printTimes = generateFixedLenthNumStr(count + 1, 3);
        //月印刷次数编码
		return DateUtils.getCurDate("MM") + printTimes;
	}

	@Override
	public void doPackage(MxjQrCodeFactory mxjQrCodeFactory) {
		int strategyType = mxjQrCodeFactory.getStrategyType();
		mxjQrCodeFactory = mxjQrCodeFactoryDao.select(mxjQrCodeFactory.getSn());
		Integer quantity = mxjQrCodeFactory.getQuantity();
		Integer type = mxjQrCodeFactory.getType();
		if(quantity != null && quantity > 0 && type != null && type > 0){
			deleteZipFile(mxjQrCodeFactory.getPackagePath());
			String property = SystemTool.getProperty(NLGlobal.APP_REAL_PATH);
			String parentDir = property + File.separator + "qrcodetemp" + File.separator;
			File parentFile = new File(parentDir);
			if(!parentFile.exists()){
				parentFile.mkdir();
			}
			String sequenceHead = getSequenceHeadStr(COMPANY_CODE_STR, type);
			String sequenceBody = generateFixedLenthNumStr(mxjQrCodeFactory.getRandomValue(), 5);
			String printQuantity = generateFixedLenthNumStr(quantity, 4);
			String packageName = sequenceHead + sequenceBody + printQuantity;
			File packageFile = new File(parentDir + packageName);

			//deleteDir(parentFile);
			packageFile.mkdir();

			List<MxjQrCodeTemp> arCodeTemps = qrCodeTempDao.selectByFactorySn(mxjQrCodeFactory.getSn());
			int process = 0;
			MxjQrCodePackageProcess.putProcess(TCUtil.sv(process));
			MxjQrCodeCreateContext codeCreateContext = new MxjQrCodeCreateContext(strategyType, fileManageClient, packageFile.getPath());
			for (MxjQrCodeTemp mxjQrCodeTemp : arCodeTemps) {
					Long qrFileSn = mxjQrCodeTemp.getQrFileSn();
					codeCreateContext.create(qrFileSn);
					++ process;
					double progressValue = MathUtils.div(process, quantity);
					if(progressValue < 1){
						MxjQrCodePackageProcess.putProcess(TCUtil.sv(progressValue));
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			//压缩
			String zipFileName = packageName + ".zip";
			String zipFilePath = parentFile.getPath() + File.separator + zipFileName;
			File packageZipFile = new File(zipFilePath);
			ZipUtil.zipFile(packageZipFile, new File[]{packageFile});
			mxjQrCodeFactory.setPackageName(zipFileName);
			mxjQrCodeFactory.setPackagePath(zipFilePath);
			mxjQrCodeFactory.setPackageComplete(1);
			mxjQrCodeFactory.setDownloadComplete(0);
			mxjQrCodeFactory.setPublishComplete(0);
			mxjQrCodeFactory.setPrintComplete(0);
			MxjQrCodePackageProcess.putProcess(TCUtil.sv(1));
		}
	}

	/**
	 * 获取二维码sn
	 * *
	 * @param productInfo
	 * @return
	 */
	private long getQrFileSn(String content, String sequence) throws RuntimeException {
		long qrFileSn = 0;
		try {
			FileInfo fileUploadObject = new FileInfo();
			fileUploadObject.setName(sequence + ".jpg");
			//fileUploadObject.setBytes(QrGeneratorUtil.generate(content));
			fileUploadObject.setBytes(generate(content));
			IFileManageClient fileManageClient = FileManageFactory.getFileManageClient(fileUploadObject);
			fileManageClient.upload();
			qrFileSn = TCUtil.lv(fileManageClient.getFileId());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return qrFileSn;
	}

	@Override
	public List<MxjQrCodeFactory> getList() {
		List<MxjQrCodeFactory> list = mxjQrCodeFactoryDao.getList();
		for (MxjQrCodeFactory factory : list) {
			Integer randomValue = factory.getRandomValue();
			if(factory != null && randomValue != null){
				String generateFixedLenthNumStr = getSequenceHeadStr(COMPANY_CODE_STR, factory.getType()) + generateFixedLenthNumStr(randomValue, 5);
				factory.setRandomValueStr(generateFixedLenthNumStr);
			}
		}
		return list;
	}

	@Override
	public MxjQrCodeFactory completeAll(MxjQrCodeFactory t) {
		Long sn = t.getSn();
		MxjQrCodeFactory mxjQrCodeFactory = mxjQrCodeFactoryDao.select(sn);
		if(sn != null && sn > 0){
			qrCodeDao.delteByFactorySn(sn);
			List<MxjQrCodeTemp> qrCodeTemps = qrCodeTempDao.selectByFactorySn(sn);
			for (MxjQrCodeTemp mxjQrCodeTemp : qrCodeTemps) {
				MxjQrCode qrCode = new MxjQrCode();
				qrCode.setType(mxjQrCodeTemp.getType());
				qrCode.setQrFileSn(mxjQrCodeTemp.getQrFileSn());
				qrCode.setContent(mxjQrCodeTemp.getContent());
				qrCode.setQrCodeFactorySn(mxjQrCodeTemp.getQrCodeFactorySn());
				qrCode.setQrId(mxjQrCodeTemp.getQrId());
				qrCodeDao.insertOrUpdate(qrCode);
			}
		}
		mxjQrCodeFactory.setPublishComplete(1);
		return mxjQrCodeFactory;
	}
	@Override
	public void rollback(Long sn) {
		if(sn != null){
			MxjQrCodeFactory qrCodeFactory = mxjQrCodeFactoryDao.select(sn);
			if(qrCodeFactory != null){
				String prePackagePath = qrCodeFactory.getPackagePath();
				qrCodeDao.delteByFactorySn(sn);
				qrCodeFactory.setDataComplete(0);
				qrCodeFactory.setPackageComplete(0);
				qrCodeFactory.setDownloadComplete(0);
				qrCodeFactory.setPublishComplete(0);
				mxjQrCodeFactoryDao.insertOrUpdate(qrCodeFactory);
				deleteZipFile(prePackagePath);
			}
		}
	}
	@Override
	public void delete(Long sn) {
		if(sn != null){
			MxjQrCodeFactory qrCodeFactory = mxjQrCodeFactoryDao.select(sn);
			if(qrCodeFactory != null){
				String prePackagePath = qrCodeFactory.getPackagePath();
				qrCodeDao.delteByFactorySn(sn);
				qrCodeTempDao.deleteByFactorySn(sn);
				deleteZipFile(prePackagePath);
				mxjQrCodeFactoryDao.delete(qrCodeFactory);
			}
		}
	}
	/**
	 *
	 *
	 */
	private static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				String childrenName = children[i];
				if (!"empty.txt".equals(childrenName) && !"qrcodetemp".equals(childrenName) && !".svn".equals(childrenName)) {
					boolean success = deleteDir(new File(dir, childrenName));
					if (!success) {
						return false;
					}
				}
			}
		}
		return dir.delete();
	}

	/**
	 *
	 * *
	 * @param prePackagePath
	 */
	private void deleteZipFile(String prePackagePath) {
		//删除旧文件
		if(StringUtils.isNotEmpty(prePackagePath)){
			File packageFile = new File(prePackagePath);
			if(packageFile.exists()){
				packageFile.delete();
			}
			deleteDir(new File(prePackagePath.substring(0, prePackagePath.lastIndexOf("."))));
		}
	}

	/**
	 *
	 * 生成
	 * */
	public static byte[] generate(String content){
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.MARGIN, 1);
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 319, 319, hints);
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "jpg", arrayOutputStream);
			return arrayOutputStream.toByteArray();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 生成固定长度的数字字符串
	 * *
	 * @param value
	 * @param length
	 * @return
	 */
	private String generateFixedLenthNumStr(int value, int length){
		int vLength = TCUtil.sv(value).length();
		if(vLength > length){
			//throw new RuntimeException(value + " 长度不能大于生成的长度：" + length);
			return TCUtil.sv(value);
		} else {
			if(vLength == length){
				return TCUtil.sv(value);
			} else {
				String s = "";
				for(int i = 0, j = length - vLength; i < j; i ++){
					s += "0";
				}
				return s + value;
			}
		}
	}
	/**
	 *
	 * *
	 * @param companyStr
	 * @param mxjType
	 * @return
	 */
	private String getSequenceHeadStr(String companyStr, int mxjType){
		return companyStr + "-" + MxjQrCodeType.getPrintName(mxjType) + "-";
	}
	/**
	 *
	 * *
	 */
	@Override
	public MxjQrCodeFactory select(Serializable id) {
		MxjQrCodeFactory factory = super.select(id);
		Integer randomValue = factory.getRandomValue();
		if(factory != null && randomValue != null){
			String generateFixedLenthNumStr = getSequenceHeadStr(COMPANY_CODE_STR, factory.getType()) + generateFixedLenthNumStr(randomValue, 5);
			factory.setRandomValueStr(generateFixedLenthNumStr);
		}
		return factory;
	}


}
