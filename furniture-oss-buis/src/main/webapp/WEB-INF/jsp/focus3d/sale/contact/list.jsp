<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="/WEB-INF/tags/focus.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系信息列表</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
</head>
<body>
	<table style = "table-layout:fixed">
		<caption class="x-panel-header">
			<center>
				<font color="red">${customerName}</font>客户的联系记录如下：
			</center>
		</caption>
		<tbody>
			<tr>
				<td><b>序号</b></td>
				<td><b>联系时间</b></td>
				<td width="40%"><b>联系内容</b></td>
				<td><b>添加人</b></td>
				<td><b>计划时间</b></td>
				<td><a href="javascript:openwin('/sale/contact.do?method=new&customerSn=${customerSn}',1000,600)">添加</a></td>
			</tr>
			<c:forEach var="line" items="${contactList}" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${line.contactTime }</td>
				<td nowrap style="overflow:hidden;text-overflow:ellipsis" width="40%">${line.contactContent }</td>
				<td>${line.sellerName }</td>
				<td>${line.planTime }</td>
				<td><a href="javascript:openwin('/sale/contact.do?method=edit&sn=${line.sn}',1000,600)">修改</a></td>
			</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="buttons">
		<input type="button" value="返 回"  class="submitc"
					onclick="javasctript:history.back();" class="submitc">

	</div>
</body>
<!-- Ext Js Lib -->
		<script type="text/javascript" src="/extjs/ext-base.js"></script>
		<script type="text/javascript" src="/extjs/ext-all.js"></script>
		<script src="extjs/validate_form.js" type="text/javascript"></script>
		<script type="text/javascript" src="/js/uitool.js"></script>
</html>