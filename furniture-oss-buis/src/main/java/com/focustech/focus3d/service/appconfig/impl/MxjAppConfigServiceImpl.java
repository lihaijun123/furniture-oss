package com.focustech.focus3d.service.appconfig.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focustech.common.utils.ListUtils;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.dao.appconfig.MxjAppConfigDao;
import com.focustech.focus3d.model.appconfig.AppConfigKeyValue;
import com.focustech.focus3d.model.appconfig.MxjAppConfig;
import com.focustech.focus3d.service.appconfig.MxjAppConfigService;
import com.focustech.oss2008.dao.BaseHibernateDao;
import com.focustech.oss2008.model.AutoArrayList;
import com.focustech.oss2008.service.impl.BaseEntityServiceImpl;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
public class MxjAppConfigServiceImpl extends BaseEntityServiceImpl<MxjAppConfig> implements MxjAppConfigService<MxjAppConfig> {

	@Autowired
	private MxjAppConfigDao<MxjAppConfig> appConfigDao;

	public static final String SERVICE_KEYS = "focus3d.mxj.appconfig.get,focus3d.mxj.appconfig.type.get";

	@Override
	public BaseHibernateDao<MxjAppConfig> getEntityDao() {
		return appConfigDao;
	}

	@Override
	public void insertOrUpdate(MxjAppConfig config) {
		//转换
		List<AppConfigKeyValue> localValues = config.getLocalValues();
		JSONObject localJo = buildKeyValue(localValues);
		List<AppConfigKeyValue> cloudValues = config.getCloudValues();
		JSONObject cloudJo = buildKeyValue(cloudValues);
		config.setKeyValue(localJo.toString());
		config.setKeyValueCloud(cloudJo.toString());
		super.insertOrUpdate(config);
	}

	@Override
	public void update(MxjAppConfig config) {
		//转换
		List<AppConfigKeyValue> localValues = config.getLocalValues();
		JSONObject localJo = buildKeyValue(localValues);
		List<AppConfigKeyValue> cloudValues = config.getCloudValues();
		JSONObject cloudJo = buildKeyValue(cloudValues);
		config.setKeyValue(localJo.toString());
		config.setKeyValueCloud(cloudJo.toString());
		super.update(config);
	}

	@Override
	public void delete(Serializable id) {
		super.delete(id);
	}

	@Override
	public MxjAppConfig select(Serializable id) {
		MxjAppConfig config = super.select(id);
		String localKeyValue = config.getKeyValue();
		String cloudKeyValue = config.getKeyValueCloud();
		List<AppConfigKeyValue> localKeyValueList = buildKeyValue(localKeyValue);
		List<AppConfigKeyValue> cloudKeyValueList = buildKeyValue(cloudKeyValue);
		config.setLocalValues(localKeyValueList);
		config.setCloudValues(cloudKeyValueList);
		return config;
	}
	/**
	 *
	 * *
	 * @param configKeyValueList
	 * @param localJo
	 */
	private JSONObject buildKeyValue(List<AppConfigKeyValue> configKeyValueList) {
		JSONObject jo = new JSONObject();
		for (AppConfigKeyValue appConfigKeyValue : configKeyValueList) {
			String key = appConfigKeyValue.getKey();
			Object value = appConfigKeyValue.getValue();
			if(StringUtils.isNotEmpty(key) && value != null){
				if(Boolean.TRUE.toString().toLowerCase().equals(String.valueOf(value).toLowerCase())){
					value = Boolean.TRUE;
				}
				else if(Boolean.FALSE.toString().toLowerCase().equals(String.valueOf(value).toLowerCase())){
					value = Boolean.FALSE;
				}
				jo.put(key, value);
			}
		}
		return jo;
	}

	private List<AppConfigKeyValue> buildKeyValue(String keyValue) {
		List<AppConfigKeyValue> configKeyValueList = new AutoArrayList<AppConfigKeyValue>(AppConfigKeyValue.class);
		if(StringUtils.isNotEmpty(keyValue)){
			try {
				JSONObject jo = JSONObject.fromObject(keyValue);
				Iterator keys = jo.keys();
				while(keys.hasNext()){
					Object key = keys.next();
					Object value = jo.get(key);
					AppConfigKeyValue configKeyValue = new AppConfigKeyValue();
					configKeyValue.setKey(TCUtil.sv(key));
					configKeyValue.setValue(TCUtil.sv(value));
					configKeyValueList.add(configKeyValue);
				}
			} catch (Exception e) {
			}
		}
		if(ListUtils.isEmpty(configKeyValueList)){
			//默认加一条空白
			configKeyValueList.add(new AppConfigKeyValue());
		}
		return configKeyValueList;
	}

	@Override
	public void copyConfig(MxjAppConfig newObj, Long targetSn) {
		if(targetSn != null){
			MxjAppConfig select = select(targetSn);
			if(select != null){
				newObj.setLocalValues(select.getLocalValues());
				newObj.setCloudValues(select.getCloudValues());
			}
		}
	}

	@Override
	public List<MxjAppConfig> getList() {
		return appConfigDao.getList();
	}

}
