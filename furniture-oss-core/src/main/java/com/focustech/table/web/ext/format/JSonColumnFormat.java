package com.focustech.table.web.ext.format;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;
import net.sf.json.processors.JsonValueProcessor;

import com.focustech.oss2008.model.OssAdminParameter;

/**
 * Transforms a java.util.Date property into a JSONObject ideal for JsDate conversion
 *
 * @author Andres Almiray <aalmiray@users.sourceforge.net>
 */
public class JSonColumnFormat implements JsonValueProcessor {
    private JsonBeanProcessor processor;
    private HashMap<String, List> parameterMap = new HashMap();
    private List datas = null;

    public JSonColumnFormat() {
        processor = new ColumnFormatBeanProcessor();
    }

    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value, jsonConfig);
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        List<OssAdminParameter> list = parameterMap.get(key);
        if (list != null) {
            Map hm = getMap(list);
            return hm.get(value);
        }
        else if (value instanceof Timestamp) {
            return value.toString();
        }
        else if (value instanceof Date) {
            return value.toString();
        }
        else {
            return value;
        }
    }

    private Object process(Object value, JsonConfig jsonConfig) {
        return processor.processBean(value, jsonConfig);
    }

    public void addParameter(String name, List list) {
        parameterMap.put(name, list);
    }

    public Map getMap(List<OssAdminParameter> list) {
        Map hm = new HashMap();
        int size = list.size();
        int i = 0;
        for (i = 0; i < size; i++) {
            OssAdminParameter OssAdminParameter = list.get(i);
            hm.put(OssAdminParameter.getParameterKey(), OssAdminParameter.getParameterValue());
        }
        return hm;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }
}
