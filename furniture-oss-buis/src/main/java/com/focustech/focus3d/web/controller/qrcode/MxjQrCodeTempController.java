package com.focustech.focus3d.web.controller.qrcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.focustech.common.utils.DownloadUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.model.qrcode.MxjQrCodeFactory;
import com.focustech.focus3d.model.qrcode.MxjQrCodeTemp;
import com.focustech.focus3d.service.qrcode.MxjQrCodeFactoryService;
import com.focustech.focus3d.service.qrcode.MxjQrCodeTempService;
import com.focustech.oss2008.model.OssAdminParameter;
import com.focustech.oss2008.service.OssAdminParameterService;
import com.focustech.oss2008.web.AbstractController;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/mxjqrcodetemp.do")
@SessionAttributes({"quantityList", "mxjQrCodeTypes"})
public class MxjQrCodeTempController extends AbstractController{
	@Autowired
	private OssAdminParameterService parameterService;
	@Autowired
	private MxjQrCodeFactoryService<MxjQrCodeFactory> qrCodeFactoryService;
	@Autowired
	private MxjQrCodeTempService<MxjQrCodeTemp> qrCodeTempService;
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		List<OssAdminParameter> mxjQrCodeTypes = parameterService.listParameters("MXJ_QR_CODE_TYPE");
		modelMap.addAttribute("mxjQrCodeTypes", mxjQrCodeTypes);
		List<Integer> quantityList = new ArrayList<Integer>();
		quantityList.add(1);
		quantityList.add(10);
		quantityList.add(100);
		quantityList.add(200);
		quantityList.add(300);
		quantityList.add(400);
		quantityList.add(500);
		quantityList.add(1000);
		modelMap.addAttribute("quantityList", quantityList);
		List<MxjQrCodeFactory> qrCodeFactories = qrCodeFactoryService.getList();
		modelMap.addAttribute("qrCodeFactories", qrCodeFactories);
		return "/focus3d/mxjqrcodetemp/index";
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		MxjQrCodeFactory mxjQrCodeFactory = new MxjQrCodeFactory();
		mxjQrCodeFactory.setDataComplete(0);
		mxjQrCodeFactory.setPackageComplete(0);
		mxjQrCodeFactory.setDownloadComplete(0);
		mxjQrCodeFactory.setPublishComplete(0);
		mxjQrCodeFactory.setPrintComplete(0);
		modelMap.addAttribute("mxjQrCodeFacotry", mxjQrCodeFactory);
		return "/focus3d/mxjqrcodetemp/edit";
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Long sn, ModelMap modelMap){
		MxjQrCodeFactory mxjQrCodeFactory = qrCodeFactoryService.select(sn);
		modelMap.addAttribute("mxjQrCodeFacotry", mxjQrCodeFactory);
		List<MxjQrCodeTemp> qrCodeTemps = qrCodeTempService.selectByFactorySn(mxjQrCodeFactory.getSn());
		modelMap.addAttribute("qrCodeTempSize", qrCodeTemps.size());
		return "/focus3d/mxjqrcodetemp/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=generate", method = RequestMethod.POST)
	public void generate(MxjQrCodeFactory mxjQrCodeFactory, ModelMap modelMap, HttpServletResponse response){
		mxjQrCodeFactory = qrCodeFactoryService.generateData(mxjQrCodeFactory);
		try {
			ajaxOutput(response, TCUtil.sv(mxjQrCodeFactory.getSn()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打包
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=package", method = RequestMethod.POST)
	public void doPackage(MxjQrCodeFactory mxjQrCodeFactory, ModelMap modelMap, HttpServletResponse response){
		qrCodeFactoryService.doPackage(mxjQrCodeFactory);
		try {
			ajaxOutput(response, TCUtil.sv(mxjQrCodeFactory.getSn()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * *
	 * @param line
	 * @param type
	 * @param modelMap
	 */
	@RequestMapping(params = "method=download", method = RequestMethod.GET)
	public void download(MxjQrCodeFactory mxjQrCodeFactory, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		mxjQrCodeFactory = qrCodeFactoryService.select(mxjQrCodeFactory.getSn());
		String packageName = mxjQrCodeFactory.getPackageName();
		String parentDir = mxjQrCodeFactory.getPackagePath();
		DownloadUtils.download(parentDir, packageName, request, response);
		mxjQrCodeFactory.setDownloadComplete(1);
		qrCodeFactoryService.insertOrUpdate(mxjQrCodeFactory);
	}
	/**
	 *
	 * *
	 * @param mxjQrCodeFactory
	 * @param modelMap
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=completeAll", method = RequestMethod.POST)
	public String completeAll(MxjQrCodeFactory mxjQrCodeFactory, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		qrCodeFactoryService.completeAll(mxjQrCodeFactory);
		return redirectTo("/mxjqrcodetemp.do?method=edit&sn=" + mxjQrCodeFactory.getSn());
	}
	/**
	 *
	 * *
	 * @param mxjQrCodeFactory
	 * @param modelMap
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=rollback", method = RequestMethod.POST)
	public void rollback(Long sn, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		if(sn != null){
			qrCodeFactoryService.rollback(sn);
		}
		try {
			ajaxOutput(response, TCUtil.sv(sn));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=delete", method = RequestMethod.GET)
	public String delete(Long sn, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		if(sn != null){
			qrCodeFactoryService.delete(sn);
		}
		return redirectTo("/mxjqrcodetemp.do?method=index");
	}
	/**
	 *
	 * *
	 * @param mxjQrCodeFactory
	 * @param modelMap
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "method=print", method = RequestMethod.POST)
	public String print(Long sn, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		if(sn != null){
			MxjQrCodeFactory qrCodeFactory = qrCodeFactoryService.select(sn);
			qrCodeFactory.setPrintComplete(1);
			qrCodeFactoryService.insertOrUpdate(qrCodeFactory);
		}
		return redirectTo("/mxjqrcodetemp.do?method=edit&sn=" + sn);
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @param response
	 */
	@RequestMapping(params = "method=process", method = RequestMethod.GET)
	public void process(ModelMap modelMap, HttpServletRequest req, HttpServletResponse response){
		try {
			ajaxOutput(response, MxjQrCodePackageProcess.getProcess());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @param response
	 */
	@RequestMapping(params = "method=remark", method = RequestMethod.POST)
	public void saveRemark(Long sn, String remark, HttpServletRequest req, HttpServletResponse response){
		if(sn != null && sn > 0){
			MxjQrCodeFactory mxjQrCodeFactory = qrCodeFactoryService.select(sn);
			if(mxjQrCodeFactory != null){
				mxjQrCodeFactory.setRemark(remark);
				qrCodeFactoryService.insertOrUpdate(mxjQrCodeFactory);
			}
		}
		try {
			ajaxOutput(response, "1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
