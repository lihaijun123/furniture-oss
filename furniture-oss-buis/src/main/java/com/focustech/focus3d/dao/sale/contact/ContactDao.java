package com.focustech.focus3d.dao.sale.contact;

import java.util.List;

import com.focustech.oss2008.dao.BaseHibernateDao;

public interface ContactDao<T> extends BaseHibernateDao<T> {

	/**
	 *
	 * *
	 * @param sn
	 */
	List<T> getListByCustomerSn(Long customerSn);
	/**
	 *
	 * *
	 * @param sn
	 */
	List<T> getPlanListByCustomerSn(String sellerSn);

	 /**
     * 更新执行的计划信息
     *
     * @param sendFlag
     * @param msgReceiverSn
     * @return
     */
    public int updatePlanBySn(Long sn, Long planContactSn);

    /**
	 *
	 * *
	 * @param sn
	 */
	void deleteByCustomerSn(Long customerSn);
}
