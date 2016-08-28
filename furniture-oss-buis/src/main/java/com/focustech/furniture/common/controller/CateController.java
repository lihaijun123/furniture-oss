/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.furniture.common.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.furniture.common.service.CoreCategoryService;
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
    private CoreCategoryService coreCategoryService;

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

}
