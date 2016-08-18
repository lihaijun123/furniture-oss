package com.focustech.focus3d.web.controller.prodcase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.focus3d.model.prodcase.ProdCase;
import com.focustech.focus3d.model.prodcase.ProdCaseFile;
import com.focustech.focus3d.model.prodcase.ProdCaseFileContent;
import com.focustech.focus3d.service.prodcase.ProdCaseService;
import com.focustech.focus3d.web.validator.prodcase.ProdCaseValidator;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/prodcase.do")
public class ProdCaseController {
	public static final int LINE_NUM = 2;
	@Autowired
	private ProdCaseService<ProdCase> prodCaseService;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		modelMap.addAttribute("prodCase", new ProdCase());
		return "/focus3d/prodcase/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(ProdCase prodCase, BindingResult result,ModelMap modelMap){
		new ProdCaseValidator(prodCase, result).validate();
        if (result.hasErrors()) {
        	return "/focus3d/prodcase/new";
        }
		prodCaseService.insertOrUpdate(prodCase);
        modelMap.addAttribute("prodCase", prodCase);
        return "/focus3d/prodcase/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Long sn, ModelMap modelMap){
		ProdCase prodCase = prodCaseService.select(sn);
		setLine(prodCase);
		modelMap.addAttribute("prodCase", prodCase);
		return "/focus3d/prodcase/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(ProdCase prodCase, BindingResult result,ModelMap modelMap){
		new ProdCaseValidator(prodCase, result).validate();
        if (result.hasErrors()) {
        	return "/focus3d/prodcase/edit";
        }
        prodCaseService.insertOrUpdate(prodCase);
        setLine(prodCase);
        modelMap.addAttribute("prodCase", prodCase);
        return "/focus3d/prodcase/edit";
	}

	@ModelAttribute("lineNum")
	public int setLineNum(){
		return LINE_NUM;
	}
	/**
	 *
	 * *
	 * @param prodCase
	 */
	private void setLine(ProdCase prodCase) {
		ProdCaseFile caseFile = prodCase.getCaseFile();
		if(caseFile != null){
			List<ProdCaseFileContent> contents = caseFile.getContents();
			int size = contents.size();
			if(size < 5){
				for(int i = 0; i < LINE_NUM - size; i ++){
					contents.add(new ProdCaseFileContent());
				}
			}
		}
	}
}
