<%@page import="com.focustech.common.utils.TCUtil"%>
<%@page import="com.focustech.cief.filemanage.common.utils.FileManageUtil"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/tags/focus.tld" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息审核</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="userInfoModel" action="/userinfo.do" method="post">
	<input type="hidden" name="method" value="audit" />
	<form:hidden path="companyInfoModel.sn"/>
	<form:hidden path="sn"/>
	<table width="100%">
		<font color="red">${msg }</font>
		<caption class="x-panel-header">用户信息审核</caption>
		<tr>
			<td colspan="3"><b>用户信息</b></td>
		</tr>
		<tr>
			<th>头像：</th>
			<td >
				<f:img id="iconFileSn_img" hname="iconFileSn" hid="iconFileSn" width="120" height="120" src="${userInfoModel.iconFileSn}" /><br>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>昵称：</th>
			<td ><form:input path="nick" readonly="true"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>真实姓名：</th>
			<td ><form:input path="name" readonly="true"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>电话：</th>
			<td ><form:input path="contact" readonly="true"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>性别：</th>
			<td ><form:input path="sex" readonly="true"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>省份：</th>
			<td ><form:input path="province" readonly="true"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>城市：</th>
			<td ><form:input path="city" readonly="true"/></td>
		</tr>
		<tr>
			<td colspan="3"><b>公司信息</b></td>
		</tr>

		<tr>
			<th><font color="red">*</font>类型：</th>
			<td >
				<f:complex  id="companyInfoModel.type"
							name="companyInfoModel.type"
							type="select"
							itemLabel="parameterValue"
							itemValue="parameterKey"
							paramType="COMPANY_TYPE_LIST"
							siteType="1"
							firstItemText="请选择"
							firstItemValue="1"
							defaultValue="${userInfoModel.companyInfoModel.type }"
							/>
			</td>
		</tr>
		<!--
		<tr>
			<th><font color="red">*</font>图标：</th>
			<td >
				<f:img id="company_iconFileSn_img" hname="companyInfoModel.iconFileSn" hid="company_iconFileSn" width="120" height="120" src="${userInfoModel.companyInfoModel.iconFileSn}" /><br>
			</td>
		</tr>
		<tr>
			<th>图片：</th>
			<td >
				<f:img id="company_imageFileSn_img" hname="companyInfoModel.imageFileSn" hid="company_imageFileSn" width="120" height="120" src="${userInfoModel.companyInfoModel.imageFileSn}" /><br>
			</td>
		</tr>
		-->
		<tr>
			<th><font color="red">*</font>名称：</th>
			<td ><form:input path="companyInfoModel.name" readonly="true"/></td>
		</tr>
		<!--
		<tr>
			<th><font color="red">*</font>宣传视频：</th>
			<td >
				<f:img id="company_videoPicFileSn_img" hname="companyInfoModel.videoPicFileSn" hid="company_videoPicFileSn" width="120" height="120" src="${userInfoModel.companyInfoModel.videoPicFileSn}" /><br>
				<form:hidden path="companyInfoModel.videoFileSn"/>
			</td>
		</tr>
		-->
		<tr>
			<th><font color="red">*</font>简介 ：</th>
			<td ><form:input path="companyInfoModel.summary" readonly="true"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>地址：</th>
			<td>
				<input type="text" id="companyInfoModel.address" name="companyInfoModel.address" value="${userInfoModel.companyInfoModel.address}" style="width: 800px;" readonly="true"/>
				<form:errors path="companyInfoModel.address" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>网址 ：</th>
			<td ><form:input path="companyInfoModel.url" readonly="true"/></td>
		</tr>
		<tr>
			<td colspan="3"><b>审核</b></td>
		</tr>
		<tr>
			<th><font color="red">*</font>审核意见：</th>
			<td >
				<form:textarea path="auditRemark" rows="30" cols="10"/>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>有效状态：</th>
			<td >
				<f:complex id="status"
							name="status"
							type="radio"
							itemLabel="parameterValue"
							itemValue="parameterKey"
							paramType="AUDIT_STATUS"
							siteType="1"
							exceptItems="2,4,7,8,9"
							defaultValue="${status }"
							/>
			</td>
		</tr>
	</table>
	<div style="display: none;">
		<table>
			<caption class="x-panel-header">操作信息</caption>
			<tr>
				<td>添加人：${adderName } <input type="hidden" name="adderName" value="${adderName }"/> </td>
				<td>添加时间 ：${addTime } <input type="hidden" name="addTime" value="${addTime }"/>
				</td>
			</tr>
			<tr>
				<td>修改人：</td>
				<td>修改时间：</td>
			</tr>
		</table>
	</div>
	<div class="buttons">
		<input type="submit"  class="submitc" value="提交 "/>
	</div>
</form:form>
<div class="buttons">
	<a href="/userinfo.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080316">返回列表</a>
</div>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<script src="/js/ImageEditor/imageEditor.js"></script>
<script type="text/javascript" src="/js/userinfo/userinfo.js"></script>
</html>