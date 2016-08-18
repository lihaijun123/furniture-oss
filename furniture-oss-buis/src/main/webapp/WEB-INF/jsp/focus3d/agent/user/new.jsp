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
<title>微商代理管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />
<style type="text/css">
	#idCard, #wxId{
		width: 200px !important;
	}
</style>
</head>
<body>
<form:form modelAttribute="agentUser" action="/agentUser.do" method="post">
	<font color="red">${message }</font>
	<input type="hidden" name="method" value="create" />
	<table width="100%">
		<caption class="x-panel-header">添加微商代理</caption>
		<tr>
			<th><font color="red">*</font>合作编号：</th>
			<td >
				<form:input path="partnerId"/>
			</td>
		</tr>
		<tr>
			<th>合作性质：</th>
			<td >
				<select name="partnerType">
					<option value="1">个人</option>
					<option value="2">企业</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>合作级别：</th>
			<td >
				<select name="agentGrade">
					<c:forEach var="agentRole" items="${agentRoleList }">
						<option value="${agentRole.sn }">${agentRole.roleName }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>姓名：</th>
			<td >
				<form:input path="userName"/>
			</td>
		</tr>
		<tr>
			<th>公司名：</th>
			<td >
				<form:input path="companyName"/>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>手机号：</th>
			<td ><form:input path="mobilePhone"/><font color="red"><br>手机号用于后面登录的账号</font></td>
		</tr>
		<tr>
			<th><font color="red">*</font>地区：</th>
			<td>
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
			<th>状态：</th>
			<td>
				<f:complex id="status"
							name="status"
							type="radio"
							itemLabel="parameterValue"
							itemValue="parameterKey"
							paramType="AUDIT_STATUS"
							siteType="1"
							defaultValue="1"
							exceptItems="2,5,6,7,8,9"
							/>
			</td>
		</tr>

		<tr>
			<th>你的优势：</th>
			<td>
				<form:textarea path="remark"/>
			</td>
		</tr>
		<tr>
			<th>手持身份证：</th>
			<td >
				<f:img id="idCardFileSn_img" hname="idCardFileSn" hid="idCardFileSn" width="120" height="120"/><br>
				<input id="file_upload1" name="file_upload1" type="file" /><br>
				<form:errors path="idCardFileSn" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>企业营业执照：</th>
			<td >
				<f:img id="kbisFileSn_img" hname="kbisFileSn" hid="kbisFileSn" width="120" height="120"/><br>
				<input id="file_upload2" name="file_upload2" type="file" /><br>
				<form:errors path="kbisFileSn" cssClass="errors" />
			</td>
		</tr>
		<tr>
			<th>合作有效期：</th>
			<td >
				<f:dateInput path="validStartDate" onclick="show(this,'yyyy-MM-dd')"
							cssClass="Wdate" size="20"
							readonly="true" format="yyyy-MM-dd"/>
				-
				<f:dateInput path="validEndDate" onclick="show(this,'yyyy-MM-dd')"
							cssClass="Wdate" size="20"
							readonly="true" format="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<th>合同文件：</th>
			<td >
				<f:fileInfo hid="contractFileSn" hname="contractFileSn" id="contractFileSn_namedisplay" value=""/>
				<br>
				<input id="file_upload3" name="file_upload3" type="file" /><br>
			</td>
		</tr>
		<tr>
			<th>身份证号码：</th>
			<td >
				<form:input path="idCard"/>
			</td>
		</tr>
		<tr>
			<th>微信号：</th>
			<td >
				<form:input path="wxId"/>
			</td>
		</tr>
	</table>
	<!--
	<table width="100%">
		<caption class="x-panel-header">活动价格分配</caption>
		<tr>
			<td></td>
			<td>
					<c:forEach var="product" items="${productList }" varStatus="status">
						<input type="checkbox" name="productList[${status.index}].sn" value="${product.sn }"/><label title="${product.price }">${product.name }(${product.price })</label>
					</c:forEach>
			</td>
		</tr>

	</table>
	 -->
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
	<a href="/agentUser.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080339">返回列表</a>
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
<script type="text/javascript" src="/js/sale/customer/province_city.js"></script>
<script type="text/javascript" src="/js/agent/user/agent_user.js"></script>

</html>