package com.focustech.focus3d.web.controller.qrcode;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.focustech.common.utils.StringUtils;
import com.focustech.focus3d.model.qrcode.MxjQrCode;
import com.focustech.focus3d.service.qrcode.MxjQrCodeService;

/**
 *
 * *
 * @author lihaijun
 *
 */
@SessionAttributes("mxjQrCodeTypes")
@Controller
@RequestMapping(value = "/mxjqrcode.do")
public class MxjQrCodeController {
	@Autowired
	private MxjQrCodeService<MxjQrCode> mxjQrCodeService;


	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=view", method = RequestMethod.GET)
	public String view(Long sn, ModelMap modelMap){
		MxjQrCode mxjQrCode = mxjQrCodeService.select(sn);
		modelMap.addAttribute("mxjQrCode", mxjQrCode);
		return "/focus3d/mxjqrcode/view";
	}

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=search", method = RequestMethod.POST)
	public String postSearch(String qrCodeType, String qrCodeId, String qrCodeContent, ModelMap modelMap){
		MxjQrCode mxjQrCode = null;
		if(StringUtils.isNotEmpty(qrCodeId) && StringUtils.isNotEmpty(qrCodeId)){
			mxjQrCode = mxjQrCodeService.selectByQrId(qrCodeType + qrCodeId);
		}
		if(StringUtils.isNotEmpty(qrCodeContent)){
			mxjQrCode = mxjQrCodeService.selectByQrContent(qrCodeContent);
		}
		List<Map<String, String>> infoList = null;
		if(mxjQrCode != null){
			infoList = mxjQrCodeService.selectList(mxjQrCode.getSn());
		}
		modelMap.addAttribute("qrCodeType", qrCodeType);
		modelMap.addAttribute("qrCodeId", qrCodeId);
		modelMap.addAttribute("qrCodeContent", qrCodeContent);
		modelMap.addAttribute("infoList", infoList);
		modelMap.addAttribute("qrCode", mxjQrCode);
		return "/focus3d/mxjqrcode/search";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=search", method = RequestMethod.GET)
	public String getSearch(String qrId, String qrContent, ModelMap modelMap){
		return "/focus3d/mxjqrcode/search";
	}

}
