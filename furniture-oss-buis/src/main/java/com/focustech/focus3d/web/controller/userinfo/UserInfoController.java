package com.focustech.focus3d.web.controller.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.common.constant.OverallConst;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.model.companyinfo.CompanyInfo;
import com.focustech.focus3d.model.searchtable.SearchTable;
import com.focustech.focus3d.model.userinfo.UserInfo;
import com.focustech.focus3d.service.companyinfo.CompanyInfoService;
import com.focustech.focus3d.service.searchtable.SearchTableService;
import com.focustech.focus3d.service.userinfo.UserInfoService;

/**
 *
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/userinfo")
public class UserInfoController {
	@Autowired
	private UserInfoService<UserInfo> userInfoService;
	@Autowired
	private CompanyInfoService<CompanyInfo> companyInfoService;
	@Autowired
	private SearchTableService<SearchTable> searchTableService;

	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=audit", method = RequestMethod.GET)
	public String getAudit(Long sn, ModelMap modelMap){
		UserInfo userinfo = userInfoService.select(sn);
		modelMap.addAttribute("userInfoModel", userinfo);
		return "/focus3d/userinfo/audit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=audit", method = RequestMethod.POST)
	public String doAudit(UserInfo userInfo, ModelMap modelMap){
		CompanyInfo companyInfoModel = userInfo.getCompanyInfoModel();
		if(companyInfoModel != null){
			companyInfoModel.setStatus(userInfo.getStatus());
		}
		companyInfoService.insertOrUpdate(companyInfoModel);
		userInfoService.insertOrUpdate(userInfo);
		if(TCUtil.sv(userInfo.getStatus()).equals(OverallConst.STATUS_3)){
			searchTableService.maintanceSearchUpdateTable("biz_user_info", userInfo.getSn(), OverallConst.PASS);
			searchTableService.maintanceSearchUpdateTable("biz_company_info", companyInfoModel.getSn(), OverallConst.PASS);
		}
		modelMap.addAttribute("userInfoModel", userInfo);
		modelMap.addAttribute("msg", "审核通过");
		return "/focus3d/userinfo/audit";
	}
}
