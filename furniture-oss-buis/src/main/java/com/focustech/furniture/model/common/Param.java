/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.furniture.model.common;

import java.io.Serializable;

/**
 * 用于给页面中参数相关的组件提供数据的数据结构。之所以不直接使用Parameter，是因为考虑到传输到页面上数据量的大小对网速和js处理的效率等方面。
 *
 */
public class Param implements Serializable {
	private static final long serialVersionUID = -2610084473145762028L;

	public Param() {
	}

	public Param(String str1, String str2) {
		this.text = str2;
		this.value = str1;
	}

	/** 控件显示的内容 */
	private String text;
	/** 用于控件实际提交的内容 */
	private String value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
