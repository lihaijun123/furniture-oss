package com.focustech.focus3d.common.constant;

public interface X3dModelCompConst {
	public String getName();
	public String getKey();
	public String getValue();

	enum ModelCiefType implements X3dModelCompConst{
		Custom("Custom","自定义"),
		SubHall("SubHall","子展馆"),
		Booth("Booth","展示厅"),
		Studio("Studio","演播厅"),
		LiveRoom("LiveRoom","直播室"),
		DemandRoom("DemandRoom","点播室"),
		MeetingHall("MeetingHall","会议厅 "),
		MeetingRoom("MeetingRoom","会议室"),
		Others("Others","其他");

		private final String key;
		private final String value;

		private ModelCiefType(String key, String value){
			this.key = key;
			this.value = value;
		}
		@Override
		public String getName() {
			return name();
		}

		@Override
		public String getValue() {
			return value;
		}
		@Override
		public String getKey() {
			return key;
		}
	}

	enum IsExecut implements X3dModelCompConst{
		NeedExecut("1","定时器需要执行"),
		NotNeedExecut("0","立即执行，定时器不需要执行");

		private final String key;
		private final String value;

		private IsExecut(String key, String value){
			this.key = key;
			this.value = value;
		}
		@Override
		public String getName() {
			return name();
		}

		@Override
		public String getValue() {
			return value;
		}
		@Override
		public String getKey() {
			return key;
		}
	}
}
