package com.focustech.focus3d.common;
/**
 *
 * *
 * @author lihaijun
 *
 */
public enum AgentUserGradeType {
	YJDL(1, "一级代理"),
	JPHZ(2, "金牌合作"),
	HHR(3, "合伙人");

	int code;
	String name;

	AgentUserGradeType(int code, String name){
		this.code = code;
		this.name = name;
	}
	/**
	 *
	 * *
	 * @param code
	 * @return
	 */
	public static String getName(int code){
		AgentUserGradeType[] values = values();
		for (AgentUserGradeType agentUserGradeType : values) {
			if(agentUserGradeType.getCode() == code){
				return agentUserGradeType.getName();
			}
		}
		return "";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
