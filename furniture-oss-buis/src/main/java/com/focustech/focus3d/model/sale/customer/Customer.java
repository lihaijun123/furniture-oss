package com.focustech.focus3d.model.sale.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.focustech.model.common.BaseEntity;
import com.focustech.oss2008.model.AutoArrayList;

import com.focustech.common.utils.StringUtils;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Entity
@Table(name = "sl_customer")
public class Customer extends BaseEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sn;
	private String id;
	private String name;
	private String telephone;
	private String url;
	private String province;
	private String city;
	private String county;
	private String grade;
	private Integer status;
	private String address;
	private String remark;
	private String sellerSn;
	private Integer isDelete;

	@Transient
	private String sellerName;

	@Transient
	private CustomerTag customerTag = new CustomerTag();

	@Transient
	private Tag tag = new Tag();

	@Transient
	private List<PhoneInfo> phoneInfoList = new AutoArrayList<PhoneInfo>(PhoneInfo.class);

	@Transient
	private List<String> nameList = new AutoArrayList<String>(String.class);

	@Transient
	private List<String> urlList = new AutoArrayList<String>(String.class);

	@Transient
	private List<CheckInfo> checkInfoList = new ArrayList<CheckInfo>();

	@Transient
	private Integer isSeller;

	@Transient
	private String list;


	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSellerSn() {
		return sellerSn;
	}
	public void setSellerSn(String sellerSn) {
		this.sellerSn = sellerSn;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public CustomerTag getCustomerTag() {
		return customerTag;
	}
	public void setCustomerTag(CustomerTag customerTag) {
		this.customerTag = customerTag;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public List<PhoneInfo> getPhoneInfoList() {
		return phoneInfoList;
	}
	public void setPhoneInfoList(List<PhoneInfo> customerTagList) {
		this.phoneInfoList.clear();
		this.phoneInfoList.addAll(customerTagList);
	}

	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<String> getUrlList() {
		return urlList;
	}
	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	public List<CheckInfo> getCheckInfoList() {
		return checkInfoList;
	}
	public void setCheckInfoList(List<CheckInfo> checkInfoList) {
		this.checkInfoList = checkInfoList;
	}

	public Integer getIsSeller() {
		return isSeller;
	}
	public void setIsSeller(Integer isSeller) {
		this.isSeller = isSeller;
	}

	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}

	/**
	 * 把国家区号,城市区号,电话拼成电话
	 */
	public void concatPhone() {
		String phoneAll = "";
		List<PhoneInfo> phoneInfoList = getPhoneInfoList();
		for(int i = 0;i<phoneInfoList.size();i++){
			PhoneInfo phoneInfo =  phoneInfoList.get(i);
			if(phoneInfo.concatPhone()!=""){
				phoneAll= phoneAll + (StringUtils.isEmpty(phoneAll)?"":",") + phoneInfo.concatPhone();
			}
		}
		setTelephone(phoneAll);
	}

	/**
	 * 把电话/传真拆成国家区号,城市区号,电话/传真
	 */
	public void splitPhone() {
		String phoneAll = getTelephone();
		List<PhoneInfo> phoneInfoAll = new AutoArrayList<PhoneInfo>(PhoneInfo.class);
		if(StringUtils.isNotEmpty(phoneAll)){
			String[] phoneList = phoneAll.split(",", -1);
			for(String x: phoneList){
				PhoneInfo phoneInfo = new PhoneInfo();
				phoneInfo.splitPhone(x);
				phoneInfoAll.add(phoneInfo);
			}
		}else{
			PhoneInfo phoneInfo = new PhoneInfo();
			phoneInfo.setPhoneAreaCode("000");
			phoneInfoAll.add(phoneInfo);
		}
		setPhoneInfoList(phoneInfoAll);

	}

	public void concatName() {
		List<String> nameList = getNameList();
		String nameAll = "";
		for(int i = 0;i<nameList.size();i++){
			String name =  nameList.get(i);
			if(StringUtils.isNotEmpty(name)){
				nameAll= nameAll + (StringUtils.isEmpty(nameAll)?"":",") + name;
			}
		}
		setName(nameAll);
	}

	public void splitName() {
		String nameAll = getName();
		List<String> nameList = new AutoArrayList<String>(String.class);
		if(StringUtils.isNotEmpty(nameAll)){
			nameList = Arrays.asList(nameAll.split(",", -1));
		}else{
			nameList.add("");
		}
		setNameList(nameList);
	}
	public void concatUrl() {
		List<String> urlList = getUrlList();
		String urlAll = "";
		for(int i = 0;i<urlList.size();i++){
			String url =  urlList.get(i);
			if(StringUtils.isNotEmpty(url)){
				urlAll= urlAll + (StringUtils.isEmpty(urlAll)?"":",") + url;
			}
		}
		setUrl(urlAll);
	}

	public void splitUrl() {
		String urlAll = getUrl();
		List<String> urlList = new AutoArrayList<String>(String.class);
		if(StringUtils.isNotEmpty(urlAll)){
			urlList = Arrays.asList(urlAll.split(",", -1));
		}else{
			urlList.add("");
		}
		setUrlList(urlList);
	}
}
