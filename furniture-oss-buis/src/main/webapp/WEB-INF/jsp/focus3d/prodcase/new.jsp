<%@page import="com.focustech.common.utils.TCUtil"%>
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
<title>产品案例</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="prodCase" action="/prodcase.do" method="post">
	<input type="hidden" name="method" value="create" />
	<table width="100%">
		<caption class="x-panel-header">视频案例添加</caption>
		<tr>
			<th><font color="red">*</font>名称：</th>
			<td ><form:input path="name"/><form:errors path="name" cssClass="errors" /></td>
		</tr>

		<tr>
			<th>类型：</th>
			<td >
				<f:complex  id="type"
							name="type"
							type="select"
							itemLabel="parameterName"
							itemValue="parameterKey"
							paramType="PRODUCT_CASE_TYPE"
							siteType="1"
							firstItemText="请选择"
							firstItemValue="1"
							defaultValue="1"
							/>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>图片：</th>
			<td >
				<f:img id="imageFileSn_img" hname="imageFileSn" hid="imageFileSn" width="120" height="120"/><br>
				<input id="file_upload1" name="file_upload1" type="file" /><br>
				<form:errors path="imageFileSn" cssClass="errors" />
			</td>
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
							defaultValue="1"
							/>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>权重：</th>
			<td>
				<form:input path="priority" onblur="checkInt(this);"/>
				<form:errors path="priority" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>描述︰</th>
			<td colspan="3">
				<form:textarea path="summary" rows="10" cols="80" /><br></br>
			</td>
		</tr>
	</table>
	<table>
			<caption class="x-panel-header">视频文件</caption>
			<tr>
				<th><font color="red">*</font>名称：</th>
				<td ><form:input path="caseFile.fileName"/><form:errors path="caseFile.fileName" cssClass="errors" /></td>
			</tr>
			<input type="hidden" name="caseFile.type" value="2"/>
			<!--
			<tr>
			<th>类型：</th>
			<td >
				<f:complex  id="caseFile.type"
							name="caseFile.type"
							type="select"
							itemLabel="parameterName"
							itemValue="parameterKey"
							paramType="PRODUCT_CASE_FILE_TYPE"
							siteType="1"
							firstItemText="请选择"
							firstItemValue="1"
							defaultValue="1"
							/>
			</td>
			</tr>
			 -->
		<tr>
			<th><font color="red">*</font>文件：</th>
			<td>
				<input id="file_upload3" name="file_upload3" type="file" /><br>
				<input type="hidden" id="fileSn" name="caseFile.fileSn"/><br>
				<form:errors path="caseFile.fileSn" cssClass="errors" />
				<span id="fileSn_namedisplay" /><br>
			</td>
		</tr>
		<tr>
			<th>播放图片：</th>
			<td >
				<f:img id="playPicFileSn_img" hname="caseFile.playPicFileSn" hid="playPicFileSn" width="120" height="120"/><br>
				<input id="file_upload8" name="file_upload8" type="file" /><br>
				<form:errors path="caseFile.playPicFileSn" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>背景图片：</th>
			<td >
				<f:img id="bkPicFileSn_img" hname="caseFile.bkPicFileSn" hid="bkPicFileSn" width="120" height="120"/><br>
				<input id="file_upload9" name="file_upload9" type="file" /><br>
				<form:errors path="caseFile.bkPicFileSn" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>描述︰</th>
			<td colspan="3">
				<form:textarea path="caseFile.summary" rows="10" cols="80" /><br></br>
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
	<a href="/prodCase.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080313">返回列表</a>
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
<script type="text/javascript" src="/js/prodcase/prodCase.js"></script>
</html>