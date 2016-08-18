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
		<meta http-equiv="pragma" content="no-cache">
		<link rel="stylesheet" type="text/css" href="/css/oss.css" />
		<link rel="stylesheet" type="text/css" href="/css/pop.css" />
		<link rel="stylesheet" type="text/css" href="/css/portal.css" />
	</head>
	<body>
	<div id ="modules" style = "width:100%;right:0%;left:0%">
		<table style = "table-layout:fixed">
		<caption class="x-panel-header">
			<center>
				客户的联系记录如下：
			</center>
		</caption>
		<tbody>
			<tr class ="title">
				<td width="25%"><b>客户名称</b></td>
				<td width="40%"><b>计划内容</b></td>
				<td width="15%"><b>计划时间</b></td>
				<td width="20%"></td>
			</tr>
			<c:forEach var="line" items="${contactPlanList}" varStatus="status">
			<tr>

				<td nowrap style="overflow:hidden;text-overflow:ellipsis"  width="25%"><a onclick="activateCenterPage();" href = "/sale/customer.do?method=edit&sn=${line.customerSn}&list=planListall" target="centerPage">${line.customerName }</a></td>
				<td nowrap style="overflow:hidden;text-overflow:ellipsis" width="40%"><a href="javascript:openwin('/sale/contact.do?method=edit&sn=${line.sn}',1000,600)">${line.planContent }</a></td>
				<td width="20%">${line.planTime }</td>
				<td width="15%"><a href="javascript:openwin('/sale/contact.do?method=edit&sn=${line.sn}',1000,600)">查看</a>   <a href="javascript:openwin('/sale/contact.do?method=doplan&sn=${line.sn}&customerSn=${line.customerSn}',1000,600)">执行</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</body>
	<!-- Ext Js Lib -->
		<script type="text/javascript" src="/extjs/ext-base.js"></script>
		<script type="text/javascript" src="/extjs/ext-all.js"></script>
		<script src="extjs/validate_form.js" type="text/javascript"></script>
		<script type="text/javascript" src="/js/uitool.js"></script>
		<script type="text/javascript" src="/js/focus-portal-min.js"></script>
</html>