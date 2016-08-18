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
<title>撞单检查结果</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<!-- Ext Js Lib -->
		<script type="text/javascript" src="/extjs/ext-base.js"></script>
		<script type="text/javascript" src="/extjs/ext-all.js"></script>
		<script src="extjs/validate_form.js" type="text/javascript"></script>
		<script type="text/javascript">
			function closeWin(){
				window.opener = null;
				window.open('','_top');
				window.close();
			}
		</script>
</head>
<body>
	<table>
		<caption>
			<center>
				与<font color="red">${customer.name}/(${customer.id})</font>客户发送撞单的结果如下：
			</center>
		</caption>
		<tbody>
			<c:if test="${customer.checkInfoList.size()==0}">
			<tr class = "title">
				<td align = "center">
				<font color="red">没有与之撞单的客户！</font>
				</td>
			</tr>
			</c:if>
			<c:if test="${customer.checkInfoList.size()!=0}">
			<tr>
				<td><b>序号</b></td>
				<td><b>客户ID</b></td>
				<td><b>客户名称</b></td>
				<td><b>开放标志</b></td>
				<td><b>销售人员</b></td>
				<td><b>撞单信息</b></td>
			</tr>
			</c:if>

			<c:forEach var="line" items="${customer.checkInfoList}" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${line.id }</td>
				<td>${line.name }</td>
				<td>${line.status }</td>
				<td>${line.sellerName }</td>
				<td>${line.remark }</td>
			</c:forEach>
			</tr>
		</tbody>
	</table>
	<div class="buttons">
		<c:if test="${return=='close'}">
		<input type="button" value=" 关闭"
					onclick="javasctript:closeWin()" class="submitc">
		</c:if>
		<c:if test="${return=='return'}">
		<input type="button" value="返 回"  class="submitc"
					onclick="javasctript:history.back();" class="submitc">
		</c:if>
	</div>
</body>
</html>