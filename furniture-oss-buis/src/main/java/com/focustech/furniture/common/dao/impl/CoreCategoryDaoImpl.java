package com.focustech.furniture.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.focustech.common.utils.StringUtils;
import com.focustech.furniture.common.dao.CoreCategoryDao;
import com.focustech.furniture.model.common.CoreCategory;
import com.focustech.oss2008.dao.OssHibernateDaoSupport;
/**
 * 产品目录
 * *
 * @author lihaijun
 *
 */
@Repository("ciefCoreCategoryDaoImpl")
public class CoreCategoryDaoImpl extends OssHibernateDaoSupport<CoreCategory> implements CoreCategoryDao<CoreCategory> {
	private static final String CAT_STATUS_EFFECT = "1";
	@Override
	public List<CoreCategory> selectFirstLevelCates() {
		Criteria crit = getCurrentSession().createCriteria(CoreCategory.class);
		crit.add(Restrictions.eq("catLevel", new Integer(1)));
		return crit.list();
	}

	@Override
	public List<CoreCategory> getRelatedCates(String parenCatcode) {
		Criteria crit = getCurrentSession().createCriteria(CoreCategory.class);
		crit.add(Restrictions.eq("parentCatCode", new Long(parenCatcode)));
		crit.add(Restrictions.eq("catStatus", CAT_STATUS_EFFECT));
		return crit.list();
	}

	@Override
	public List<CoreCategory> selectCatesByCodes(String codes) {
        codes = StringUtils.trimToEmpty(codes);
        List<Long> codeList = new ArrayList<Long>();
        List<CoreCategory> cateList = new ArrayList<CoreCategory>();
        if (StringUtils.isNotEmpty(codes)) {
            String[] cs = codes.split(",");
            for (String c : cs) {
                c = StringUtils.trim(c);
                if (StringUtils.isEmpty(c) || !StringUtils.isInteger(c)) {
                    continue;
                }
                else {
                	codeList.add(Long.parseLong(c));
                }
            }
        }
        if (codeList.size() > 0) {
        	Criteria crit = getCurrentSession().createCriteria(CoreCategory.class);
    		crit.add(Restrictions.in("catCode", codeList.toArray()));
    		cateList = crit.list();
        }
        return cateList;
	}

	public CoreCategory selectCategoryByCatCode(String catCode){
		String hql = "from " + CoreCategory.class.getName()  + " where catCode=" + catCode;

		return (CoreCategory)getCurrentSession().createQuery(hql).uniqueResult();
	}

}
