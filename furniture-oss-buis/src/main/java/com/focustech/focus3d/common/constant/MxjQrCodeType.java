package com.focustech.focus3d.common.constant;
/**
 *
 * *
 * @author lihaijun
 *
 */
public enum MxjQrCodeType {

	UI(0, "UI", "UI", ""),
	HYPY(1, "汉语拼音", "spell", "PY"),
	HYXK(2, "遨游星空", "sky", "XK"),
	KXCS(3, "科学常识", "science", "CS"),
	WDZG(4, "我的祖国", "country", "ZG"),
	ZWBH(5, "自我保护", "protect", "BH");

	private int type;

	private String name;

	private String nameEn;

	private String printName;

	MxjQrCodeType(int type, String name, String nameEn, String printName){
		this.type = type;
		this.name = name;
		this.nameEn = nameEn;
		this.printName = printName;
	}
	/**
	 * 获取类型中文名称
	 * *
	 * @param type
	 * @return
	 */
	public static String getName(int type){
		for(MxjQrCodeType t : MxjQrCodeType.values()){
			if(t.getType() == type){
				return t.getName();
			}
		}
		return null;
	}
	/**
	 *
	 * *
	 * @param nameEn
	 * @return
	 */
	public static String getName(String nameEn){
		for(MxjQrCodeType t : MxjQrCodeType.values()){
			if(t.getNameEn().equals(nameEn)){
				return t.getName();
			}
		}
		return null;
	}
	/**
	 * 获取类型英文名称
	 * *
	 * @param type
	 * @return
	 */
	public static String getNameEn(int type){
		for(MxjQrCodeType t : MxjQrCodeType.values()){
			if(t.getType() == type){
				return t.getNameEn();
			}
		}
		return null;
	}
	/**
	 * *
	 * @param type
	 * @return
	 */
	public static String getPrintName(int type){
		for(MxjQrCodeType t : MxjQrCodeType.values()){
			if(t.getType() == type){
				return t.getPrintName();
			}
		}
		return null;
	}

	public static int getTypeByNameEn(String nameEn){
		for(MxjQrCodeType t : MxjQrCodeType.values()){
			if(nameEn.equals(t.getNameEn())){
				return t.getType();
			}
		}
		return -1;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getPrintName() {
		return printName;
	}
	public void setPrintName(String printName) {
		this.printName = printName;
	}

}
