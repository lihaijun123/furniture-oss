/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.furniture.common.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.common.utils.ListUtils;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.extend.spring.argresolver.RedirectAttributes;
import com.focustech.furniture.common.service.CoreCategoryService;
import com.focustech.furniture.model.common.CoreCategory;
import com.focustech.furniture.model.common.Param;
import com.focustech.oss2008.web.AbstractController;

/**
 *
 *
 * 产品目录目录选择的后端AJAX
 * @author lihaijun
 *
 */ 
@Controller
@RequestMapping("/cate.do")
public class CateController extends AbstractController{
    @Autowired
    @Qualifier("ciefCoreCategoryServiceImpl")
    private CoreCategoryService<CoreCategory> coreCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public void index(String level, String value, HttpServletResponse response, Model model) {
    	List<List<Param>> paramList = null;
        if ("1".equals(level)) {
        	paramList = coreCategoryService.getFirstLevelCn(level);
        }
        else {
        	paramList = coreCategoryService.getCateByParentCn(level, value);
        }
        try {
			ajaxOutput(response, buildJson(paramList));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * 构建JSON
     * *
     * @param list
     * @return
     */
    private String buildJson(List<List<Param>> list){
    	JSONArray jar = new JSONArray();
    	JSONArray levelJar = null;
    	List<Param> paramList = null;
    	for(int i = 0, j = list.size(); i < j; i ++){
    		levelJar = new JSONArray();
    		paramList = list.get(i);
    		buildLevelJson(paramList, levelJar);
    		jar.add(levelJar);
    	}
    	return jar.toJSONString();
    }
    /**
     * 构建层级JSON数据
     *
     * *
     * @param list
     * @param jsonAry
     */
    private void buildLevelJson(List<Param> list, JSONArray jsonAry){
    	JSONObject jo = null;
    	Param param = null;
    	for(int i = 0, j = list.size(); i < j; i ++){
    		jo = new JSONObject();
    		param = list.get(i);
    		jo.put("value", param.getValue());
    		jo.put("text", param.getText());
    		jsonAry.add(jo);
    	}
    }
    @ModelAttribute
    public void initList(ModelMap modelMap){
    	List<CoreCategory> listLevel1 = coreCategoryService.getListByLevel(1);
    	//List<CoreCategory> listLevel2 = coreCategoryService.getListByLevel(2);
		modelMap.addAttribute("list", listLevel1);
		//modelMap.addAttribute("list2", listLevel2);
    }
    /**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		modelMap.addAttribute("category", new CoreCategory());
		return "/fnt/category/new";
	}
	/**
	 *
	 * *
	 * @param coreCategory
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(CoreCategory coreCategory, ModelMap modelMap, RedirectAttributes redirectAttributes){
		rebuildCategory(coreCategory);
		modelMap.addAttribute("category", coreCategory);
		redirectAttributes.addFlashAttribute("创建成功");
		return redirectTo("/cate.do?method=edit&sn=" + coreCategory.getRecId());
	}
	/**
	 * *
	 * @param coreCategory
	 */
	private void rebuildCategory(CoreCategory coreCategory) {
		Long parentCatCode = coreCategory.getParentCatCode();
		if(parentCatCode == null || parentCatCode < 0){
			parentCatCode = 0L;
		}
		Long catCode = 0L;
		int level = 1;
		int cateCodeIndex = 0;
		if(parentCatCode > 0){
			CoreCategory parentCate = coreCategoryService.getByCateCode(parentCatCode);
			if(parentCate != null){
				level = parentCate.getCatLevel() + 1;
			}
		}
		cateCodeIndex = coreCategoryService.getCateCodeIndex(parentCatCode);
		if(level == 1){
			catCode = TCUtil.lv((10 + cateCodeIndex) + "00000000");
		} else {
			String codeStr = TCUtil.sv(parentCatCode);
			if(codeStr.length() == 10){
				if (level == 2){
					catCode = TCUtil.lv((TCUtil.iv(codeStr.substring(0, 4)) + cateCodeIndex) + "000000");
				} else if(level == 3){
					catCode = TCUtil.lv((TCUtil.iv(codeStr.substring(0, 6 )) + cateCodeIndex) + "0000");
				}
			}
		}
		coreCategory.setParentCatCode(parentCatCode);
		coreCategory.setCatCode(catCode);
		coreCategory.setCatLevel(level);
		coreCategory.setCatType("0");
		coreCategory.setLinkCatCode(0L);
		coreCategory.setOldCatCode("0");
		coreCategory.setLastUpdaterNo(1);
		coreCategory.setLastUpdaterName(getLoginUser().getFullname());
		coreCategory.setLastUpdateTime(new Date());
		coreCategory.setCatStatus("1");
		coreCategory.setAimCatCode(0L);
		coreCategory.setCatProperty("0");
		coreCategoryService.insertOrUpdate(coreCategory);
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Integer sn, ModelMap modelMap){
		CoreCategory category = coreCategoryService.select(sn);
		Integer catLevel = category.getCatLevel();
		if(catLevel == 2){
			CoreCategory paCategory = coreCategoryService.getByCateCode(category.getParentCatCode());
			category.setParent(paCategory);
		} else if (catLevel == 3){
			CoreCategory paCategory = coreCategoryService.getByCateCode(category.getParentCatCode());
			category.setParent(paCategory);
			CoreCategory paPaCategory = coreCategoryService.getByCateCode(paCategory.getParentCatCode());
			category.getParent().setParent(paPaCategory);
		}
		modelMap.addAttribute("category", category);
		return "/fnt/category/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(CoreCategory category, ModelMap modelMap){
		String catStatus = category.getCatStatus();
		String catNameCn = category.getCatNameCn();
		category = coreCategoryService.select(category.getRecId());
		if(StringUtils.isNotEmpty(catStatus)){
			category.setCatStatus(catStatus);
		}
		if(StringUtils.isNotEmpty(catNameCn)){
			category.setCatNameCn(catNameCn);
		}
		coreCategoryService.insertOrUpdate(category);
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("message", "修改成功");
		return "/fnt/category/edit";
	}
	/**
	 * 
	 * *
	 * @param sn
	 * @param modelMap
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(params = "method=next", method = RequestMethod.GET)
	public void selectNext(String parentCode, ModelMap modelMap, HttpServletResponse response) throws IOException{
		List<CoreCategory> list = coreCategoryService.getListByParentCode(TCUtil.lv(parentCode));
		String rv = "";
		if(ListUtils.isNotEmpty(list)){
			JSONArray jsonArray = new JSONArray();
			for (CoreCategory coreCategory : list) {
				JSONObject jo = new JSONObject();
				jo.put("value", coreCategory.getCatCode());
				jo.put("text", coreCategory.getCatNameCn());
				jsonArray.add(jo);
			}
			rv = jsonArray.toJSONString();
		}
		ajaxOutput(response, rv);
	}
}
