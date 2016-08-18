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
<title>梦想家订单管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="agentOrder" action="/agentOrder.do" method="post">
	<input type="hidden" name="method" value="edit" />
	<input type="hidden" name="sn" value="${agentOrder.sn }" />

	<table width="100%">
		<caption class="x-panel-header">订单信息</caption>
		<tr>
			<th>订单编号：</th>
			<td >
				${agentOrder.orderNum }
			</td>
		</tr>
		<tr>
			<th>应付金额：</th>
			<td ><form:input path="totalPrice"/></td>
		</tr>
		<tr>
			<th>状态：</th>
			<td>
				<c:if test="${agentOrder.status eq 2}">
					未支付
				</c:if>
				<c:if test="${agentOrder.status eq 3}">
					已支付
				</c:if>
				<c:if test="${agentOrder.status eq 4}">
					已取消
				</c:if>
			</td>
		</tr>
		<c:if test="${agentOrder.status eq 3}">
			<tr>
				<th>付款方式：</th>
				<td>
					<c:if test="${agentOrder.agentOrderTrans.transPlatformType eq \"1\"}">
						中国银联
					</c:if>
					<c:if test="${agentOrder.agentOrderTrans.transPlatformType eq \"2\"}">
						支付宝
					</c:if>
					<c:if test="${agentOrder.agentOrderTrans.transPlatformType eq \"3\"}">
						微信扫码
					</c:if>
				</td>
			</tr>
		</c:if>
	</table>
	<table width="100%">
		<caption class="x-panel-header">产品信息</caption>
		<tr>
			<th><b>名称</b></th>
			<th><b>单价</b></th>
			<th><b>数量</b></th>
		</tr>
		<c:forEach var="item" items="${agentOrder.items }">
			<tr>
				<th>${item.agentProduct.name }</th>
				<th>${item.itemPrice }</th>
				<th>${item.itemAmount }</th>
			</tr>
		</c:forEach>

	</table>
	<table width="100%">
		<caption class="x-panel-header">收货信息</caption>
		<form:hidden path="revAddress.sn"/>
		<form:hidden path="orderLogtc.sn"/>
		<tr>
			<th>收件人：</th>
			<td >
				${agentOrder.revAddress.userName }
			</td>
		</tr>
		<tr>
			<th>手机号码：</th>
			<td >
				${agentOrder.revAddress.mobilePhone }
			</td>
		</tr>
		<tr>
			<th>地址：</th>
			<td >
				${agentOrder.revAddress.province } &nbsp; ${agentOrder.revAddress.city } &nbsp; ${agentOrder.revAddress.street }
			</td>
		</tr>
		<tr>
			<th>送货方式：</th>
			<td >
				<c:if test="${agentOrder.orderLogtc.logicType eq 1}">
					快递
				</c:if>
				<c:if test="${agentOrder.orderLogtc.logicType eq 2}">
					物流
				</c:if>
			</td>
		</tr>
		<tr>
			<th>快递 / 物流 名称：</th>
			<td >
				<form:input path="orderLogtc.logtcName"/><font color="red">发货后填写，便于客户查单</font>
			</td>
		</tr>
		<tr>
			<th>快递 / 物流 单号：</th>
			<td >
				<form:input path="orderLogtc.logtcId"/><font color="red">发货后填写，便于客户查单</font>
			</td>
		</tr>
	</table>
	<c:if test="${agentOrder.isInvoice eq 1 }">
		<table width="100%">

			<c:if test="${agentOrder.invoiceType eq 1 }">
				<caption class="x-panel-header">发票信息（个人）</caption>
				<tr>
					<th>发票抬头：</th>
					<td >
						${agentOrder.invoiceHead }
					</td>
				</tr>
			</c:if>
			<c:if test="${agentOrder.invoiceType eq 2 }">
				<caption class="x-panel-header">发票信息（公司）</caption>
				<tr>
					<th>单位名称：</th>
					<td >
						${agentOrder.invoiceCompanyName }
					</td>
				</tr>
				<tr>
					<th>纳税人识别号：</th>
					<td >
						${agentOrder.invoiceTaxpayerId }
					</td>
				</tr>
				<tr>
					<th>地址：</th>
					<td >
						${agentOrder.invoiceAddress }
					</td>
				</tr>
				<tr>
					<th>电话：</th>
					<td >
						${agentOrder.invoicePhone }
					</td>
				</tr>
				<tr>
					<th>开户行：</th>
					<td >
						${agentOrder.invoiceBankName }
					</td>
				</tr>
				<tr>
					<th>账号：</th>
					<td >
						${agentOrder.invoiceBankAccount }
					</td>
				</tr>
			</c:if>
		</table>

	</c:if>
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
	<a href="/uitoolList.ui?funcID=1080340">返回列表</a>
</div>
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
</html>