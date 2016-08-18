package com.focustech.focus3d.service.sale.contact.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.DateUtils;
import com.focustech.common.utils.StringUtils;
import com.focustech.focus3d.dao.sale.contact.ContactDao;
import com.focustech.focus3d.dao.sale.customer.CustomerDao;
import com.focustech.focus3d.model.sale.contact.Contact;
import com.focustech.focus3d.model.sale.customer.Customer;
import com.focustech.focus3d.service.sale.contact.ContactService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.model.OssAdminUser;
import com.focustech.oss2008.dao.UserDao;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;

@Service
public class ContactServiceImpl extends BaseEntityServiceImpl<Contact> implements
		ContactService<Contact> {

	@Autowired
	private ContactDao<Contact> contactDao;
	@Autowired
	private CustomerDao<Customer> customerDao;
	@Autowired
	private UserDao<OssAdminUser> userDao;

	private HashMap<String,String> map = new HashMap<String,String>();;

	@Override
	public BaseHibernateDao<Contact> getEntityDao() {
		return contactDao;
	}

	@Override
	public Contact creat(Long customerSn){
		Contact contact = new Contact();
		contact.setCustomerSn(customerSn);
		contact.setContactTime(DateUtils.getCurDate());
		contact.setIsPlanDone(0);
		contact = forMateInfo(contact);
		return contact;
	}
	@Override
	public void insert(Contact contact){
		contact = forMateInfo(contact);
		getEntityDao().insertOrUpdate(contact);
	}

	@Override
	public Contact select(Long sn){
		Contact contact = getEntityDao().select(sn);
		contact = forMateInfo(contact);
		return contact;
	}

	public List<Contact> getContactList(Long customerSn){
		List<Contact> contactList = contactDao.getListByCustomerSn(customerSn);
		HashMap<String,String> map = new HashMap<String,String>();
		for(int i = 0;i<contactList.size();i++){
			Contact contact = contactList.get(i);
			if(!map.containsKey(contact.getSellerSn())){
				OssAdminUser userInfo = userDao.select(contact.getSellerSn());
				map.put(contact.getSellerSn(), userInfo.getFullname());
			}
			contactList.get(i).setSellerName(map.get(contact.getSellerSn()));
			if(contact.getContactTime()!=null){
				contactList.get(i).setContactTime(forMateDate(contact.getContactTime()));
			}
			if(contact.getPlanTime()!=null){
				contactList.get(i).setPlanTime(forMateDate(contact.getPlanTime()));
			}

		}
		return contactList;
	}
	public Date forMateDate(Date date){
		date = java.sql.Date.valueOf(DateUtils.formateDate("yyyy-MM-dd",date));
		return date;
	}

	public Contact forMateInfo(Contact contact){
		if(contact.getSellerSn()==null){
			contact.setSellerSn(getLoginUser().getUserId());
		}
		if(StringUtils.isNotEmpty(contact.getSellerSn())){
			OssAdminUser userInfo = userDao.select(contact.getSellerSn());
			contact.setSellerName(userInfo.getFullname());
		}

		if(contact.getContactTime()!=null){
			contact.setContactTime(forMateDate(contact.getContactTime()));
		}
		if(contact.getPlanTime()!=null){
			contact.setPlanTime(forMateDate(contact.getPlanTime()));
		}

		Customer customer = customerDao.select(contact.getCustomerSn());
		contact.setCustomerName(customer.getName());
		return contact;
	}

	public List<Contact> getContactPlanList(){
		List<Contact> contactList = contactDao.getPlanListByCustomerSn(getLoginUser().getUserId());
		for(int i = 0;i<contactList.size();i++){
			Contact contact = contactList.get(i);
			Customer customer = customerDao.select(contact.getCustomerSn());
			contact.setCustomerName(customer.getName());
			if(contact.getPlanTime()!=null){
				contactList.get(i).setPlanTime(forMateDate(contact.getPlanTime()));
			}
		}
		return contactList;
	}

	@Override
	public void insertPlan(Contact contact){
		insert(contact);
		contactDao.updatePlanBySn(contact.getParentContactSn(), contact.getSn());
	}

}
