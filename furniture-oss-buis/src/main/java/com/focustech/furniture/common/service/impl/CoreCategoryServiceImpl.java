package com.focustech.furniture.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.TCUtil;
import com.focustech.furniture.common.dao.CoreCategoryDao;
import com.focustech.furniture.common.service.CoreCategoryService;
import com.focustech.furniture.model.common.CoreCategory;
import com.focustech.furniture.model.common.Param;
/**
 * 产品目录
 * *
 * @author lihaijun
 *
 */
@Service("ciefCoreCategoryServiceImpl")
public class CoreCategoryServiceImpl implements CoreCategoryService {
	@Autowired
	@Qualifier("ciefCoreCategoryDaoImpl")
	private CoreCategoryDao<CoreCategory> coreCategoryDao;

	@Override
	public List<List<Param>> getFirstLevelCn(String curLevel) {
		List<List<Param>> result = new ArrayList<List<Param>>();
        List<Param> pl = convert2ParamList(coreCategoryDao.selectFirstLevelCates());
        if (pl != null && pl.size() > 0) {
            result.add(pl);
            result.addAll(getCateByParentCn(String.valueOf(Integer.parseInt(curLevel) + 1), pl.get(0).getValue()));
        }
        return result;
	}

	@Override
	public List<List<Param>> getCateByParentCn(String curLevel, String parentCode) {
		int level = Integer.parseInt(curLevel);
        int needProcessLen = level;
        if (level <= TOTAL_LEVEL) {
            needProcessLen = TOTAL_LEVEL;
        }
        List<List<Param>> result = new ArrayList<List<Param>>();
        result = getCategoryLink(result, parentCode);
        if (result.size() < needProcessLen - level + 1) {
            for (int i = 0; i < needProcessLen - level + 1 - result.size(); i++) {
                result.add(new ArrayList<Param>());
            }
        }
        return result;
	}

	@Override
	public List<Param> getCateByCode(String codes) {
		 List<CoreCategory> result = coreCategoryDao.selectCatesByCodes(codes);
        if (result == null || result.size() < 0) {//将1改成0
            return new ArrayList<Param>();
        }
        return convert2ParamList(result);
	}

	/**
     * 将参数信息转换到页面控件上需要显示的Param中去。如果提供的params是空，则返回空的列表（注意，不是返回null。）
     *
     * @param params 需要转换的参数。
     * @return 返回转换后的列表
     */
    private List<Param> convert2ParamList(List<CoreCategory> cates) {
        List<Param> paramList = new ArrayList<Param>();
        if (cates != null && cates.size() > 0) {
            for (int i = cates.size() - 1; i >= 0; --i) {
            	CoreCategory cate = cates.get(i);
                Param pa = new Param();
                pa.setText(cate.getCatNameCn());
                pa.setValue(TCUtil.sv(cate.getCatCode()));
                paramList.add(pa);
            }
        }
        return paramList;
    }

    /**
     * 递归获取对应下级的目录码。一直找到没有下级目录为止。
     *
     * @param result 结果链
     * @param parenCatcode 父目录码
     * @return
     */
    private List<List<Param>> getCategoryLink(List<List<Param>> result, String parenCatcode) {
        List<Param> tmp = convert2ParamList(coreCategoryDao.getRelatedCates(parenCatcode));
        if (tmp != null && tmp.size() > 0) {
            result.add(tmp);
            return getCategoryLink(result, tmp.get(0).getValue());
        }
        else {
            return result;
        }
    }

    /**
     * 通过二级/三级目录找到一级目录
     *
     * @param code 目录
     * @return
     */
	public String getFirstCatLevelByCode(String code) {
    	CoreCategory coreCategory=coreCategoryDao.selectCategoryByCatCode(code);
    	if(coreCategory.getCatLevel()==CAT_LEVEL_TWO){
    		return TCUtil.sv(coreCategoryDao.selectCategoryByCatCode(TCUtil.sv(coreCategory.getParentCatCode())).getCatCode());
    	}
    	else if(coreCategory.getCatLevel()==CAT_LEVEL_THREE){
    		return TCUtil.sv(coreCategoryDao.selectCategoryByCatCode(TCUtil.sv(coreCategoryDao.selectCategoryByCatCode(TCUtil.sv(coreCategory.getParentCatCode())).getParentCatCode())).getCatCode());
    	}
    	else{
    		return code;
    	}
	}

}
