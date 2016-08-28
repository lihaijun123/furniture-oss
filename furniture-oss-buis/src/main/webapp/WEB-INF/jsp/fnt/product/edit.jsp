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
<title>产品管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />

</head>
<body>
<form:form id="fntProductForm" modelAttribute="fntProduct" action="/fnt/product.do" method="post">
	<input type="hidden" name="method" value=edit />
	<font color="red">${message }</font>
	<form:hidden path="sn"/>
	<table width="100%">
		<caption class="x-panel-header">添加产品</caption>
		<tr>
			<th><font color="red">*</font>名称：</th>
			<td ><form:input path="name"/></td>
		</tr>
		<tr>
			<th>品牌：</th>
			<td ><form:input path="brand"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>价格：</th>
			<td ><form:input path="price"/></td>
		</tr>
		<tr>
			<th>材质：</th>
			<td ><form:input path="materia"/></td>
		</tr>
		<tr>
			<th>颜色：</th>
			<td ><form:input path="color"/></td>
		</tr>
		<tr>
			<th>规格名称：</th>
			<td ><form:input path="specName"/></td>
		</tr>
		<tr>
			<th>规格尺寸：</th>
			<td ><form:input path="specSize"/></td>
		</tr>
		<tr>
			<th>参数：</th>
			<td ><form:input path="grossWeight"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>类别：</th>
			<td >
				<input type="text" id="categoryName" name="categoryName" value="${fntProduct.categoryName }"/>
				<input type="hidden" class="text w4"  id="categoryCode" name="categoryCode" value="${fntProduct.categoryCode}"/>
			</td>
		</tr>
		<tr>
			<th>风格：</th>
			<td ><form:input path="style"/></td>
		</tr>
		<tr>
			<th>毛重：</th>
			<td ><form:input path="parameter"/></td>
		</tr>
		<tr>
			<th>模型名称：</th>
			<td ><form:input path="modelName"/></td>
		</tr>
		<tr>
			<th>图案：</th>
			<td ><form:input path="design"/></td>
		</tr>
		<tr>
			<th>模型文件：</th>
			<td>
				<input id="file_upload1" name="file_upload1" type="file" /><br>
				<f:fileInfo id="modelFileSn_namedisplay" hid="modelFileSn" hname="modelFileSn" value="${fntProduct.modelFileSn }"/>
			</td>
		</tr>
		<tr>
			<th>是否上架：</th>
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
	<a href="/uitoolList.ui?funcID=1080344">返回列表</a>
</div>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<%@include file="/WEB-INF/jsp/common/category.jsp" %>
<script type="text/javascript" src="/js/fnt/product.js"></script>
</html>