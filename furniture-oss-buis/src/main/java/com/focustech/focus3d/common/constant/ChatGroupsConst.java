/*
 * Copyright 2012 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.focus3d.common.constant;

/**
 * 群组常量
 * 
 * @author liushuyan
 */
public class ChatGroupsConst {

	/**
	 * 使用权限： 1.所有用户、2.所有会员、3.所有参观会员、
	 * 4.所有注册参观会员、5.所有完善参观会员、6.所有实名参观会员、7.所有认证参观会员、8.所有参展商
	 */
	public static final Integer PERMIS_ALL_USER = 1;
	public static final Integer PERMIS_ALL_MEMBER = 2;
	public static final Integer PERMIS_ALL_VISIT_MEMBER = 3;
	public static final Integer PERMIS_REGISTER_VISIT_MEMBER = 4;
	public static final Integer PERMIS_CONSUMMATE_VISIT_MEMBER = 5;
	public static final Integer PERMIS_REALNAME_VISIT_MEMBER = 6;
	public static final Integer PERMIS_IDENTIFY_VISIT_MEMBER = 7;
	public static final Integer PERMIS_EXHIBIT_MEMBER = 8;

	/**
	 * 群组位置类型：1.咖啡厅、2.会议厅、3.服务中心、4.直播室、5.展台
	 */
	public static final Integer LOCATION_TYPE_COFFEE = 1;
	public static final Integer LOCATION_TYPE_MEETING = 2;
	public static final Integer LOCATION_TYPE_SERVICE = 3;
	public static final Integer LOCATION_TYPE_STADIO = 4;
	public static final Integer LOCATION_TYPE_BOOTH = 5;

	/**
	 * 群组创建方式：1.系统自动创建、2.运营人员手动创建
	 */
	public static final Integer CREATE_WAY_AUTOMATIC = 1;
	public static final Integer CREATE_WAY_MANUAL = 2;

	/** parameter表中权限的存储类型 */
	public static final String PERMIS_PARAMETER_TYPE = "CHATGROUPS_PERMIS";

	/** parameter表中群组位置一级类型的存储类型 */
	public static final String LOCATION_PARAMETER_TYPE = "CHATGROUPS_LOCATION_LEVEL1";

	/** parameter表中群组位置咖啡厅中聊天室的存储类型 */
	public static final String COFFEE_PARAMETER_TYPE = "CHATGROUPS_LOCATION_COFFEE";

	/** parameter表中群组状态的存储类型 */
	public static final String STATUS_PARAMETER_TYPE = "CHATGROUPS_STATUS";
}
