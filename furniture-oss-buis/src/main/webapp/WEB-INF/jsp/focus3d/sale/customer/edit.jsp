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
<form:form modelAttribute="customer" action="/sale/customer.do" method="post" id = "form" >
<input type="hidden" name="method" value="edit" />
<form:hidden path="sn"/>
<form:hidden path="id"/>
<form:hidden path="tag.sn"/>
<form:hidden path="customerTag.sn"/>
<table width="100%">
	<caption class="x-panel-header">编辑客户信息</caption>
		<tr>
			<td colspan="2" align="center">
				<font color="red">${message}</font>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>客户名称：</th>
			<td  id = "namelist" ><input type="button" value="添加" id = "addName">
				<div>
					<c:forEach var="line" items="${customer.nameList}" varStatus="status">
						<div>
						<input type="text" name="nameList[${status.index }]"  value="${line }" style = "width:116px"/>
						<input type="button" value="删除" name = "del" >
						</div>
					</c:forEach>
				</div>
				<form:errors path="name" cssClass="errors" />
			</td>
			<input type="hidden" id="nameSize" name="nameSize" value="${customer.nameList.size()}" />
		</tr>
		<tr>
			<th>自定义标签：</th>
			<td ><form:input path="tag.name"/>
			<form:errors path="tag.name" cssClass="errors" /></td>
		</tr>
		<tr>
			<th>地区：</th>
			<td>
				<div style="float: left;">
					<select id="province" name="province" value1="${customer.province}">
           			<option></option>
           			</select>
           			<select id="city" name="city" value1="${customer.city}">
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
							firstItemValue="1"
							defaultValue="${customer.status}"
							otherAttrs="disabled"
							/>
				<form:hidden path="status"/>
			</td>
		</tr>
		<tr>
			<th>电话：</th>
			<td id = "phonelist">
				<div >
				<input type="button" value="添加" id = "addPhone">
				（格式：区号-电话或手机-分机号-备注）
				</div>
				<div>
				<form:errors path="telephone" cssClass="errors" />
				</div>
				<c:forEach var="line" items="${customer.phoneInfoList}" varStatus="status">
				<div name = "${status.index}">
				<input type="text" name="phoneInfoList[${status.index }].phoneAreaCode"  value="${line.phoneAreaCode }" style = "width:68px"/>-
				<input type="text" name="phoneInfoList[${status.index }].phoneCode" value="${line.phoneCode }" style = "width:116px"/>-
				<input type="text" name="phoneInfoList[${status.index }].phoneExt" value="${line.phoneExt }" style = "width:116px"/>-
				<input type="text" name="phoneInfoList[${status.index }].phoneLabel" value="${line.phoneLabel }" style = "width:164px"/>
				<c:if test="${status.index!=0}">
					<input type="button" value="删除" name = "del" >
				</c:if>
				</div>
				</c:forEach>
			</td>
			<input type="hidden" id="phoneSize" name="phoneSize" value="${customer.phoneInfoList.size()}" />
		</tr>
		<tr>
			<th>公司地址：</th>
			<td ><form:input path="address"/>
			<form:errors path="address" cssClass="errors" /></td>
		</tr>
		<tr>
			<th>公司主页：</th>
			<td  id = "urllist" ><input type="button" value="添加" id = "addUrl">
				<div>
				<form:errors path="url" cssClass="errors" />
				</div>
				<div>
					<c:forEach var="line" items="${customer.urlList}" varStatus="status">
						<div>
						<input type="text" name="urlList[${status.index }]"  value="${line }" style = "width:116px"/>
						<input type="button" value="删除" name = "del" >
						</div>
					</c:forEach>
				</div>
			</td>
			<input type="hidden" id="urlSize" name="urlSize" value="${customer.urlList.size()}" />

		</tr>
		<tr>
			<th>备注︰</th>
			<td colspan="3">
			<div>
				<form:errors path="remark" cssClass="errors" />
			</div>
				<form:textarea path="remark" rows="10" cols="80" /><br></br>
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
	<div class="buttons">
		<input type="button" value="联系列表 "  class="submitc"
					onclick="window.location='/sale/contact.do?method=list&customerSn=${customer.sn }&list=${customer.list}'">
		<input type="button"  class="submitc" value="撞单检查 "
					onclick="check()"/>
		<input type="button"  class="submitc" value="置为撞单 "
					onclick="delclick(${customer.sn })" //>
		<input type="button"  class="submitc" value="开放 "
					onclick="window.location='/sale/customer.do?method=open&sn=${customer.sn }&isopen=2&list=${customer.list }'"  class="submitc"/>
		<input type="button"  class="submitc" value="提交 "
					onclick="submitclick()"/>
		<c:if test="${customer.list=='all'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/uitoolList.ui?funcID=1080325'">
		</c:if>
		<c:if test="${customer.list=='one'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/uitoolList.ui?funcID=1080323'">
		</c:if>
		<c:if test="${customer.list=='planListall'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/sale/contact.do?method=planlistAll'">
		</c:if>
	</div>
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