package com.focustech.focus3d.web.controller.model;

import com.focustech.focus3d.model.model.ModelContentInfo;
import com.focustech.focus3d.model.model.ModelInfo;
import com.focustech.focus3d.service.model.ModelInfoService;
import com.focustech.focus3d.web.validator.model.ModelInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/modelInfo.do")
public class ModelInfoController {

    @Autowired
    private ModelInfoService<ModelInfo> modelInfoService;

    @RequestMapping(params = "method=new", method = RequestMethod.GET)
    public String _new(ModelMap modelMap) {
        modelMap.addAttribute("modelInfo", new ModelInfo());
        return "/focus3d/model/new";
    }

    @RequestMapping(params = "method=create", method = RequestMethod.POST)
    public String create(ModelInfo modelInfo, BindingResult result, ModelMap modelMap) {
		new ModelInfoValidator(modelInfo, result).validate();
        if (result.hasErrors()) {
        	return "/focus3d/model/new";
        }
        modelInfoService.createOrUpdateModel(modelInfo);
        fillList(modelInfo);
        modelMap.addAttribute("modelInfo", modelInfo);
        return "/focus3d/model/edit";
    }

    @RequestMapping(params = "method=edit", method = RequestMethod.GET)
    public String edit(Long sn, ModelMap modelMap) {
        ModelInfo modelInfo = modelInfoService.select(sn);
        fillList(modelInfo);
		modelMap.addAttribute("modelInfo", modelInfo);
        return "/focus3d/model/edit";
    }

    private void fillList(ModelInfo modelInfo) {
        List<ModelContentInfo> list = modelInfo.getModelContentInfoList();
        int idx = list.size();
        if(idx < 5){
            for(int i = 0; i < (5 - idx);i++){
                list.add(new ModelContentInfo());
            }
        }
    }

    @RequestMapping(params = "method=edit", method = RequestMethod.POST)
    public String edit(ModelInfo modelInfo, BindingResult result, ModelMap modelMap) {
		new ModelInfoValidator(modelInfo, result).validate();
        if (result.hasErrors()) {
        	return "/focus3d/model/edit";
        }
        modelInfoService.createOrUpdateModel(modelInfo);
        fillList(modelInfo);
        modelMap.addAttribute("modelInfo", modelInfo);
        return "/focus3d/model/edit";
    }

}
