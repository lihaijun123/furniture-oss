package com.focustech.focus3d.common.constant;

import com.focustech.common.constant.NumberConst;

/**
 * 消息栏
 * *
 * @author lihaijun
 *
 */
public class MsgBoardConst implements NumberConst{


	/**消息类型:[1]-名片;[2]-聊天;[3]-站内信;[4]-系统消息*/
	public static final String MSG_TYPE_CARD = ONE;
	public static final String MSG_TYPE_CHAT = TWO;
	public static final String MSG_TYPE_LETTER = THREE;
	public static final String MSG_TYPE_SYSMSG = FOUR;

	/**消息状态[1]-新消息;[3]-已读;[2]-已忽略*/
	public static final String STATUS_NEW = ONE;
	public static final String STATUS_READ = THREE;
	public static final String STATUS_IGNORE = TWO;

	/**当消息类型为[1]:[1]-获取名片请求;[2]-交换名片请求;[3]-获取名片成功消息;[4]-获取名片失败消息;[5]-交换名片成功消息;[6]-交换名片失败消息
                   当消息类型为[2]:[1]-申请加为好友消息;[2]-申请加入群组消息;[3]-加为好友成功消息;[4]-加为好友失败消息;[5]-加入群组成功消息;[6]-加入群组失败消息
                    当消息类型为[3]:[1]-新站内信消息   */
	public static final String INTERACTION_TYPE_ONE = ONE;
	public static final String INTERACTION_TYPE_TWO = TWO;
	public static final String INTERACTION_TYPE_THREE = THREE;
	public static final String INTERACTION_TYPE_FOUR = FOUR;
	public static final String INTERACTION_TYPE_FIVE = FIVE;
	public static final String INTERACTION_TYPE_SIX = SIX;
}
