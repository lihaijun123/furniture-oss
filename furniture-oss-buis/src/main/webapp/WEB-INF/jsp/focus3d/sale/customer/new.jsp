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
<input type="hidden" name="method" value="create" />
<table width="100%">
	<caption class="x-panel-header">添加客户信息</caption>
		<tr>
			<th><font color="red">*</font>客户名称：</th>
			<td >
			<form:input path="nameList[0]"/>
			<form:errors path="name" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>自定义标签：</th>
			<td ><form:input path="tag.name"/>
			<form:errors path="tag" cssClass="errors" />
			</td>

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
							defaultValue="4"
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
							defaultValue="1"
							/>
			</td>
		</tr>
		<tr>
			<th>电话：</th>
			<td id = "phonelist">
				<div>
				<input type="button" value="添加" id = "addPhone"  class="submitc">
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
				<input type="text" name="phoneInfoList[${status.index }].phoneLabel" value="${line.phoneLabel }" style = "width:164px"/>-
				<c:if test="${status.index!=0}">
					<input type="button" value="删除" name = "del" >
				</c:if>
				</div>
				</c:forEach>
			</td>
			<input type="hidden" id="phoneSize" name="phoneSize" value="1" />
		</tr>
		<tr>
			<th>公司地址：</th>
			<td ><form:input path="address"/>
			<form:errors path="address" cssClass="errors" /></td>
		</tr>
		<tr>
			<th>公司主页：</th>
			<td id = "urllist">
				<div>
				<input type="button" value="添加" id = "addUrl"  class="submitc">
				</div>
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
			<input type="hidden" id="urlSize" name="urlSize" value="1" />
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
		<input type="button"  class="submitc" value="提交 "
					onclick="submitclick()"/>
		<input type="button"  class="submitc" value="撞单检查 "
					onclick="check()"/>
		<input type="button" value=" 返 回 "
					onclick="javasctript:history.back();" class="submitc">
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
<script type="text/javascript" src="/js/calendar.js"></script>
<script src="/js/ImageEditor/imageEditor.js"></script>
<script type="text/javascript" src="/js/sale/customer/province_city.js"></script>
<script type="text/javascript" src="/js/sale/customer/customer.js"></script>
</html>