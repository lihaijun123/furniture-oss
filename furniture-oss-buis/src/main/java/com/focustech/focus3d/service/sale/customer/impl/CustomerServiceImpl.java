package com.focustech.focus3d.service.sale.customer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.DateUtils;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.sale.contact.ContactDao;
import com.focustech.focus3d.dao.sale.customer.CustomerDao;
import com.focustech.focus3d.model.sale.contact.Contact;
import com.focustech.focus3d.model.sale.customer.CheckInfo;
import com.focustech.focus3d.model.sale.customer.Customer;
import com.focustech.focus3d.model.sale.customer.CustomerTag;
import com.focustech.focus3d.model.sale.customer.PhoneInfo;
import com.focustech.focus3d.model.sale.customer.Tag;
import com.focustech.focus3d.service.sale.customer.CustomerService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.dao.UserDao;
import com.focustech.oss2008.model.OssAdminUser;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
import com.focustech.focus3d.dao.sale.customer.CustomerTagDao;
import com.focustech.focus3d.dao.sale.customer.TagDao;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer> implements CustomerService<Customer> {
	@Autowired
	private CustomerDao<Customer> customerDao;

	@Autowired
	private CustomerTagDao<CustomerTag> customerTagDao;

	@Autowired
	private TagDao<Tag> tagDao;

	@Autowired
	private UserDao<OssAdminUser> userDao;

	@Autowired
	private ContactDao<Contact> contactDao;

	@Override
	public BaseHibernateDao<Customer> getEntityDao() {
		return customerDao;
	}

	@Override
	public Customer creat(){
		Customer customer = new Customer();
		customer = setSellerInfo(customer);
		customer = resetInfo(customer);
		return customer;
	}

	@Override
	public void insert(Customer customer){
		customer = resetInfo(customer);
		getEntityDao().insert(customer);
		insertOrUpdateTag(customer);
		customer.setId(generet12CharacterId(customer.getSn()));
		getEntityDao().update(customer);
	}

	@Override
	public void update(Customer customer){
		customer = resetInfo(customer);
		getEntityDao().update(customer);
		insertOrUpdateTag(customer);
	}

	public void insertOrUpdateTag(Customer customer){
		CustomerTag customerTag = customer.getCustomerTag();
		Tag tag = customer.getTag();

		//标签内容为空字符串
		if(StringUtils.isEmpty(tag.getName())){
			if(customerTag.getSn()!=null){
				customerTagDao.deleteBySn(customerTag.getSn());
				customer.setCustomerTag(new CustomerTag());
			}
			if(tag.getSn()!=null){
				tagDao.deleteBySn(tag.getSn());
				customer.setTag(new Tag());
			}
		}else{
				setNewInfo(tag);
				setUpdateInfo(tag);
				tag.setSellerSn(getLoginUser().getUserId());
				tagDao.insertOrUpdate(tag);

				setNewInfo(customerTag);
				setUpdateInfo(customerTag);
				customerTag.setCustomerSn(customer.getSn());
				customerTag.setTagSn(tag.getSn());
				customerTagDao.insertOrUpdate(customerTag);
		}
	}

	@Override
	public Customer selectAll(Long sn){
		Customer customer = getEntityDao().select(sn);
		List<CustomerTag> customerTagList =  customerTagDao.getListByCustomerSn(sn);
		if(customerTagList.size()>=1){
			customer.setCustomerTag(customerTagList.get(0));
			List<Tag> tagList = tagDao.getListByTagSn(customer.getCustomerTag().getTagSn());
			if(tagList.size()>=1){
				customer.setTag(tagList.get(0));
			}
		}
		customer.splitPhone();
		customer.splitName();
		customer.splitUrl();
		customer = setSellerInfo(customer);
		return customer;
	}

	@Override
	public Customer updateStatus(Long sn,Integer status){
		Customer customer = selectAll(sn);
		customer.setStatus(status);
		customer.setSellerSn(getLoginUser().getUserId());
		customer.setSellerName(getLoginUser().getFullname());
		getEntityDao().update(customer);
		return customer;
	}

	@Override
	public Customer updateDelete(Long sn){
		Customer customer = selectAll(sn);
		customer.setIsDelete(1);

		CustomerTag customerTag = customer.getCustomerTag();
		Tag tag = customer.getTag();

		if(customerTag.getSn()!=null){
			customerTagDao.deleteBySn(customerTag.getSn());
			customer.setCustomerTag(new CustomerTag());
		}
		if(tag.getSn()!=null){
			tagDao.deleteBySn(tag.getSn());
			customer.setTag(new Tag());
		}
		contactDao.deleteByCustomerSn(sn);
		getEntityDao().update(customer);
		return customer;
	}

	public Customer setSellerInfo(Customer customer){
		if(customer.getSellerSn()==null){
			customer.setSellerSn(getLoginUser().getUserId());
		}
		if(StringUtils.isNotEmpty(customer.getSellerSn())){
			OssAdminUser userInfo = userDao.select(customer.getSellerSn());
			customer.setSellerName(userInfo.getFullname());
		}

		if(customer.getSellerSn().equals(getLoginUser().getUserId())){
			customer.setIsSeller(0);
		}else{
			customer.setIsSeller(1);
		}

		return customer;
	}

	public Customer getCheckInfo(Customer customer){

		List<CheckInfo> checkInfoList = new ArrayList<CheckInfo>();

		List<PhoneInfo> phoneInfoList = customer.getPhoneInfoList();
		for(int i = 0;i<phoneInfoList.size();i++){
			PhoneInfo phoneInfo =  phoneInfoList.get(i);
			if(StringUtils.isNotEmpty(phoneInfo.concatAreaAndPhone())){
				List<Customer> customerByPhoneList = customerDao.getListByCustomerPhone(phoneInfo.concatAreaAndPhone());
				for(int j = 0;j<customerByPhoneList.size();j++){
					if(!customerByPhoneList.get(j).getSn().equals(customer.getSn())){
						checkInfoList.add(setCheckInfo(customerByPhoneList.get(j),1,phoneInfo.concatAreaAndPhone()));
					}
				}
			}
		}

		List<String> nameList = customer.getNameList();
		for(int i = 0;i<nameList.size();i++){
			if(StringUtils.isNotEmpty(nameList.get(i))){
				List<Customer> customerByNameList =  customerDao.getListByCustomerName(nameList.get(i));
				for(int j = 0;j<customerByNameList.size();j++){
					if(!customerByNameList.get(j).getSn().equals(customer.getSn())){
						checkInfoList.add(setCheckInfo(customerByNameList.get(j),2,nameList.get(i)));
					}
				}
			}
		}
		customer.setCheckInfoList(checkInfoList);

		customer.concatName();
		return customer;
	}

	public String generet12CharacterId(Long recordSn) {
    	if(null != recordSn){
    		String code = DateUtils.getCurDate("yyyyMMdd");
    		return code + ( ( recordSn >= 0 && recordSn <= 1000 ) ? StringUtils.frontCompWithZore( TCUtil.iv( recordSn ) , 4 )
    				: recordSn.toString().substring( recordSn.toString().length() - 4 ) );
    	}
		return null;
	}

	public CheckInfo setCheckInfo(Customer customer,Integer type,String remark) {
		//sellername
		String sellername = "";
		if(StringUtils.isNotEmpty(customer.getSellerSn())){
			OssAdminUser userInfo = userDao.select(customer.getSellerSn());
			sellername = userInfo.getFullname();
		}
		String status = "";
		if(customer.getStatus().equals(1)){
			status = "私有";

		}else if(type.equals(2)){
			status = "开放";
		}
		//remark
		if(type.equals(1)){
			remark = "与客户（"+customer.getId()+"）的电话传真或者电话（"+remark+"）完全匹配100%";

		}else if(type.equals(2)){
			remark = "与客户（"+customer.getId()+"）的名称（"+remark+"）完全匹配100%";
		}

		CheckInfo checkInfo = new CheckInfo();
		checkInfo.setId(customer.getId());
		checkInfo.setName(customer.getName());
		checkInfo.setSellerName(sellername);
		checkInfo.setStatus(status);
		checkInfo.setRemark(remark);
		return checkInfo;
	}

	public Customer resetInfo(Customer customer){
		if(customer.getId()==null){
			customer.setId("");
		}
		customer.concatPhone();
		customer.splitPhone();
		customer.concatName();
		customer.splitName();
		customer.concatUrl();
		customer.splitUrl();
		customer.setIsDelete(0);
		if(customer.getProvince()!=null&&customer.getProvince().equals("请选择")){
			customer.setProvince("");
		};
		if(customer.getCity()!=null&&customer.getCity().equals("请选择")){
			customer.setCity("");
		};
		if(customer.getSellerSn().equals(getLoginUser().getUserId())){
			customer.setIsSeller(0);
		}else{
			customer.setIsSeller(1);
		}
		return customer;
	}
}
