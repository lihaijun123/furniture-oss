<%@ page import = "com.focustech.common.utils.TCUtil" %>
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
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="customer">
<input type="hidden" name="method" value="create" />
<table width="100%">
<caption class="x-panel-header">查看客户信息</caption>
		<tr>
			<td colspan="2" align="center">
				<font color="red">${message}</font>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>客户名称：</th>
			<td >${customer.nameList[0] }</td>

		</tr>
		<tr>
			<th>自定义标签：</th>
			<td >${customer.tag.name }</td>

		</tr>
		<tr>
			<th><font color="red">*</font>地区：</th>
			<td>
				<div style="float: left;">
					<select id="province" name="province" value1="${customer.province}" disabled = "disabled">
           			<option></option>
           			</select>
           			<select id="city" name="city" value1="${customer.city}" disabled = "disabled">
            		<option></option>
          			</select>
				</div>
			</td>
		</tr>
		<tr>
			<th>客户级别：</th>
			<td >
				<f:complex  id="grade"
							name="grade"
							type="select"
							itemLabel="parameterName"
							itemValue="parameterKey"
							paramType="SL_CUSTOMER_GRADE"
							siteType="1"
							firstItemText="请选择"
							firstItemValue="1"
							defaultValue="${customer.select}"
							otherAttrs="disabled"
							/>
			</td>
		</tr>
		<tr>
			<th>客户属性：</th>
			<td >
				<f:complex  id="status"
							name="status"
							type="select"
							itemLabel="parameterName"
							itemValue="parameterKey"
							paramType="SL_CUSTOMER_STATUS"
							siteType="1"
							firstItemText="请选择"
							firstItemValue="1"
							defaultValue="${customer.status}"
							otherAttrs="disabled"
							/>
			</td>
		</tr>
		<tr>
			<th>电话：</th>
			<td >${customer.phoneInfoList[0].phoneAreaCode }-${customer.phoneInfoList[0].phoneCode }-${customer.phoneInfoList[0].phoneExt }-${customer.phoneInfoList[0].phoneLabel }</td>
		</tr>
		<tr>
			<th>公司地址：</th>
			<td >${customer.address }</td>
		</tr>
		<tr>
			<th>公司主页：</th>
			<td >${urlList[0] }</td>
		</tr>
		<tr>
			<th>备注︰</th>
			<td colspan="3">
				<form:textarea path="remark" rows="10" cols="80" readonly = "true"/><br></br>
			</td>
		</tr>
		<tr>
			<th>销售人员︰</th>
			<td >${customer.sellerName } ( ${customer.sellerSn } )</td>
			<form:hidden path="sellerSn"/>
			<form:hidden path="sellerName"/>
			<form:hidden path="list"/>
		</tr>
	</table>
<c:if test="${customer.status==2}">
<div class="buttons">
		<input type="button"  class="submitc" value=" 不开放 "
					onclick="window.location='/sale/customer.do?method=open&sn=${customer.sn }&isopen=1&list=${customer.list }'">
		<c:if test="${customer.list=='all'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/uitoolList.ui?funcID=1080325'">
		</c:if>
		<c:if test="${customer.list=='one'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/uitoolList.ui?funcID=1080323'">
		</c:if>
</div>
</c:if>
</form:form>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/sale/customer/province_city.js"></script>
<script type="text/javascript" src="/js/sale/customer/customer.js"></script>
</html>