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
<title>App 产品添加VrAr</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />
</head>
<body>
<form:form modelAttribute="prod" action="/app.do" method="post">
	<input type="hidden" name="method" value="addvrar" />
	<form:hidden path="sn"/>
	<form:hidden path="name"/>
	<table width="100%">
		<font color="red"><h2>${msg }</h2></font>
		<caption class="x-panel-header">产品特效添加</caption>
		<tr>
			<th>产品名称：</th>
			<td>${prod.name }</td>
		</tr>
		<tr>
			<th>安卓模型文件：</th>
			<td>
			    <form:hidden path="vrAr.sn"/>
				<input id="file_upload0" name="file_upload0" type="file" /><br>
				<f:fileInfo id="modelFileSn_0_namedisplay" hid="modelFileSn_0" hname="vrAr.modelFileSn" value="${prod.vrAr.modelFileSn}"/>
			</td>
		</tr>
		<tr>
			<th>IOS模型文件：</th>
			<td>
				<input id="file_upload_ios0" name="file_upload_ios0" type="file" /><br>
				<f:fileInfo id="iosModelFileSn_0_namedisplay" hid="iosModelFileSn_0" hname="vrAr.iosModelFileSn" value="${prod.vrAr.iosModelFileSn}"/>
			</td>
		</tr>
	</table>
	<div class="buttons">
		<input type="submit"  class="submitc" value="提交 "/>
	</div>
</form:form>
<div class="buttons">
	<a href="/app.do?method=audit&sn=${prod.app.sn }">返回</a>
</div>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<script type="text/javascript">
jQuery(function($){

	var initJson = {};
	initJson.fileExt = "*.unity3d";
	initJson.fileDesc = "*.unity3d";
	var prodSize = 1;
	for(var i = 0; i < prodSize; i ++){
		eval("getfile_upload" + i + "Id= new Function(\"return 'modelFileSn_" + i + "';\")");
		veUploadify(initJson, "file_upload" + i);
		eval("getfile_upload_ios" + i + "Id= new Function(\"return 'iosModelFileSn_" + i + "';\")");
		veUploadify(initJson, "file_upload_ios" + i);
	}

});


</script>

</html>