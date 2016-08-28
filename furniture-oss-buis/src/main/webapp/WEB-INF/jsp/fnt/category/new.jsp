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
<title>产品目录</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />

</head>
<body>
<form:form id="categoryForm" modelAttribute="category" action="/cate.do" method="post">
	<input type="hidden" name="method" value="create" />
	<table width="100%">
		<caption class="x-panel-header">添加目录</caption>
		<tr>
			<th><font color="red">*</font>名称：</th>
			<td ><form:input path="catNameCn"/></td>
		</tr>
		<tr>
			<th><font color="red">*</font>上级目录：</th>
			<td>
				<form:hidden path="parentCatCode"/>
				<select id="parentCatCodeSel">
					<option value="-1">无</option>
					<c:forEach var="cate" items="${list }">
						<option value="${cate.catCode }">${cate.catNameCn }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>状态：</th>
			<td >
				<input type="radio" name="catStatus" value="1" checked="checked"/> 启用
				<input type="radio" name="catStatus" value="2"/> 停用
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
	<a href="/cate.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080345">返回列表</a>
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
<script type="text/javascript" src="/js/fnt/category.js"></script>
</html>