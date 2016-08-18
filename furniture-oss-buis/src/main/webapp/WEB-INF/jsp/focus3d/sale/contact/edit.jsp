<%@ page import = "com.focustech.common.utils.TCUtil" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
<title>编辑业务联系记录</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="contact" action="/sale/contact.do" method="post" id = "form" >
<input type="hidden" name="method" value="${method}" />
<input type="hidden" id ="close"  name="close" value="${close}" />
<form:hidden path="sn"/>
<form:hidden path="customerSn"/>
<form:hidden path="sellerSn"/>
<table width="100%">
<caption class="x-panel-header">编辑业务联系记录</caption>
	<tr>
		<td colspan="2" align="center">
			<font color="red">${message}</font>
		</td>
	</tr>
	<tr>
		<th>客户名称：</th>
		<td >
			${contact.customerName }
		</td>
		<form:hidden path="customerName"/>
	</tr>
	<tr>
		<th>联系时间：</th>
		<td>
		${contact.contactTime }
		</td>
		<form:hidden path="contactTime"/>
	</tr>
	<tr>
		<th>联系内容：</th>
		<td colspan="3">
			<div>
				<form:errors path="contactContent" cssClass="errors" />
			</div>
			<form:textarea path="contactContent" rows="10" cols="80"/><br></br>
		</td>
	</tr>
	<tr>
		<th>计划时间：</th>
		<td>
		<form:hidden path="isPlanDone"/>
		<input id = "planTime" type="text" value="${contact.planTime}" name="planTime" onclick="show(this,'yyyy-MM-dd')" readonly = false/>
		</td>
	</tr>
	<tr>
		<th>计划内容：</th>
		<td colspan="3">
			<div>
				<form:errors path="planContent" cssClass="errors" />
			</div>
			<form:textarea path="planContent" rows="10" cols="80" /><br></br>
		</td>
	</tr>
	<tr>
		<th>备注：</th>
		<td colspan="3">
			<div>
				<form:errors path="remark" cssClass="errors" />
			</div>
			<form:textarea path="remark" rows="10" cols="80" /><br></br>
		</td>
	</tr>
</table>
<div class="buttons">
		<input type="submit"  class="submitc" value="提交 "/>
		<input type="button" value=" 关闭"
					onclick="javasctript:closeWin()" class="submitc">


	</div>
</form:form>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script type="text/javascript" src="/js/calendar.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/sale/contact/contact.js"></script>
<script type="text/javascript">
			function closeWin(){
				window.opener = null;
				window.open('','_top');
				window.close();
			}
		</script>
</html>