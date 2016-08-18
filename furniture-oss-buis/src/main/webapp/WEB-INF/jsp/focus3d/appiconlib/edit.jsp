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
<title>app icon lib管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="appIconLib" action="/appiconlib.do" method="post">
	<input type="hidden" name="method" value="edit" />
	<form:hidden path="sn"/>
	<table width="100%">
		<caption class="x-panel-header">编辑app图标库</caption>
		<tr>
			<th><font color="red">*</font>名称：</th>
			<td >
				<form:input path="name"/>
				<form:errors path="name" cssClass="errors" />
			</td>
		</tr>

		<tr>
			<th><font color="red">*</font>类型：</th>
			<td >
				<f:complex  id="type"
							name="type"
							type="select"
							itemLabel="parameterName"
							itemValue="parameterKey"
							paramType="APP_ICON_LIB_TYPE"
							siteType="1"
							firstItemText="请选择"
							firstItemValue="1"
							defaultValue="${bannerInfo.type}"
							/>
			</td>
		</tr>
		<tr>
			<th>分组：</th>
			<td >
			<form:select path="groupId">
				<form:option value="0">无</form:option>
				<form:option value="99">请选择-用于背景图</form:option>
				<form:option value="bj_blue">bj_blue</form:option>
				<form:option value="bj_yellow_0">bj_yellow_0</form:option>
				<form:option value="bj_green_0">bj_green_0</form:option>
				<form:option value="bj_blue_1">bj_blue_1</form:option>
				<form:option value="bj_red_0">bj_red_0</form:option>
				<form:option value="bj_white_0">bj_white_0</form:option>
				<form:option value="99">请选择-用于引导图</form:option>
				<form:option value="1">第一套-操作使用</form:option>
				<form:option value="2">第二套-场景使用</form:option>
			</form:select>
			<form:errors path="groupId" cssClass="errors" />
			<font color="red">&nbsp;运用于1：“背景图”类型，2：引导图</font>
			</td>
		</tr>
		<tr>
			<th>设备：</th>
			<td >
			手机&nbsp;<form:radiobutton path="deviceType" value="1"/>
			Pad&nbsp;<form:radiobutton path="deviceType" value="2"/>
			所有&nbsp;<form:radiobutton path="deviceType" value="3"/>
			<form:errors path="deviceType" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>图片：</th>
			<td >
				<f:img id="imageFileSn_img" hid="imageFileSn" hname="imageFileSn" width="120" height="120" src="${appIconLib.imageFileSn}" /><br>
				<input id="file_upload1" name="file_upload1" type="file" /><br>
				<form:errors path="imageFileSn" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>标识：</th>
			<td ><form:input path="imageKey"/><form:errors path="imageKey" cssClass="errors" /></td>
		</tr>
		<tr>
			<th><font color="red">*</font>有效状态：</th>
			<td >
				<f:complex id="validFlag"
							name="validFlag"
							type="radio"
							itemLabel="parameterValue"
							itemValue="parameterKey"
							paramType="VALID_FLAG_TWO"
							siteType="1"
							defaultValue="${appIconLib.validFlag}"
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
	<a href="/appIconLib.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080317">返回列表</a>
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
<script type="text/javascript" src="/js/appiconlib/appiconlib.js"></script>
</html>