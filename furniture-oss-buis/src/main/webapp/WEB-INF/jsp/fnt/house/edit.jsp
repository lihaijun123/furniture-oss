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
<title>户型管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />

</head>
<body>
<form:form id="fntHouseForm" modelAttribute="fntHouse" action="/fnt/house.do" method="post">
	<input type="hidden" name="method" value="edit" />
	<font color="red">${message }</font>
	<table width="100%">
		<caption class="x-panel-header">添加户型</caption>
		<tr>
			<th><font color="red">*</font>户型名称：</th>
			<td ><form:input path="name"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>户型类型：</th>
			<td >
				<select name="type">
					<option value="1">小区房 </option>
					<option value="2">别墅 </option>
					<option value="3">自建房 </option>
					<option value="4">两限房 </option>
					<option value="5">经适房</option>
				</select>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>面积：</th>
			<td ><form:input path="area"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>户型图片：</th>
			<td >
				<f:img id="picFileSn_img" hid="picFileSn" hname="picFileSn" width="120" height="120" src="${fntHouse.picFileSn }"/><br>
				<input id="file_upload2" name="file_upload2" type="file" /><br>
			</td>
		</tr>
		<tr>
			<th>模型名称：</th>
			<td ><form:input path="modelName"/></td>
		</tr>
		<tr>
			<th>模型文件：</th>
			<td>
				<input id="file_upload1" name="file_upload1" type="file" /><br>
				<f:fileInfo id="modelFileSn_namedisplay" hid="modelFileSn" hname="modelFileSn" value="${fntHouse.modelFileSn }"/>
			</td>
		</tr>
		<tr>
			<th>几房几厅：</th>
			<td >
				<select name="roomNum">
					<option value="1">1 </option>
					<option value="2">2 </option>
					<option value="3">3 </option>
					<option value="4">4 </option>
					<option value="5">5</option>
				</select>
				房
				<select name="livingRoomNum">
					<option value="1">1 </option>
					<option value="2">2 </option>
					<option value="3">3 </option>
					<option value="4">4 </option>
					<option value="5">5</option>
				</select>
				厅
			</td>
		</tr>
		<tr>
			<th>地址：</th>
			<td >
				<div style="float: left;">
					<select id="province" name="province" value1="">
           				<option></option>
           			</select>
           			<select id="city" name="city" value1="">
            			<option></option>
          			</select>
          			<form:textarea path="street"/>
				</div>
			</td>
		</tr>
		<tr>
			<th>楼座号：</th>
			<td ><form:input path="buildingNo"/></td>
		</tr>
		<tr>
			<th>状态：</th>
			<td >
				<f:complex id="status"
							name="status"
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
			<th>描述︰</th>
			<td colspan="3">
				<form:textarea path="remark" rows="10" cols="80" /><br></br>
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
	<a href="/fnt/product.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080346">返回列表</a>
</div>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="/extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>

<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<%@include file="/WEB-INF/jsp/common/category.jsp" %>
<script type="text/javascript" src="/js/province_city.js"></script>
<script type="text/javascript" src="/js/fnt/house.js"></script>
</html>