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
<title>梦想家激活码生成</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
</head>
<body>
	<form:form action="/mxjqrcodetemp.do" modelAttribute="mxjQrCodeFacotry">
		<input type="hidden" name="method" value="generate"/>
		<form:hidden path="sn"/>
		<form:hidden path="dataComplete"/>
		<form:hidden path="packageComplete"/>
		<form:hidden path="downloadComplete"/>
		<form:hidden path="publishComplete"/>
		<form:hidden path="printComplete"/>
		<form:hidden path="packageName"/>
		<form:hidden path="packagePath"/>
		<table width="100%">
			<caption class="x-panel-header">梦想家激活码生成</caption>
			<tr>
				<th>梦想家系列：</th>
				<td >
					<select id="type" name="type">
						<c:forEach var="qrType" items="${mxjQrCodeTypes }">
							<option value="${qrType.parameterKey}" ${qrType.parameterKey eq mxjQrCodeFacotry.type ? "selected='selected'" : ""}>${qrType.parameterValue}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>生成数量：</th>
				<td >
					<select id="quantity" name="quantity">
						<c:forEach var="l" items="${quantityList }">
							<option value="${l }" ${l eq mxjQrCodeFacotry.quantity ? "selected='selected'" : "" }>${l }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="red">数量：</font>${mxjQrCodeFacotry.quantity } <br>
					<font color="red">实际数量：</font>${qrCodeTempSize}
				</td>
			</tr>
			<tr>
				<td colspan="2">
					打包编号：${mxjQrCodeFacotry.randomValueStr }
				</td>
			</tr>
			<tr>
				<td colspan="2">
				</td>
			</tr>
		</table>
	</form:form>

	<c:if test="${mxjQrCodeFacotry.printComplete eq 0}">
		<input type="button" id="generateBtn" value="制作" class="submitc"/>&nbsp;<span id="generateSpan" style="color: green;"></span><br><br>
		<c:if test="${mxjQrCodeFacotry.dataComplete eq 1}">
			<input type="hidden" id="strategyType" name="strategyType" value="3"/>
			<br>
			<input type="button" id="packageBtn" value="打包" class="submitc"/>&nbsp;<span id="packageSpan" style="color: green;"></span><br><br>
			<c:if test="${mxjQrCodeFacotry.packageComplete eq 1}">
				<input type="button" id="downloadBtn" value="下载" class="submitc"/>&nbsp;<span id="downloadSpan" style="color: green;"></span>
			</c:if>
		</c:if>
		<div class="progress progress-striped active" >
		   <div id="progressDiv" class="progress-bar progress-bar-success" role="progressbar"
		      aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
		      <span id="progressSpan"></span>
		   </div>
		</div>
		<form id="completeAllForm" action="/mxjqrcodetemp.do" method="post">
			<input type="hidden" name="method" value="completeAll"/>
			<input type="hidden" name="sn" value="${mxjQrCodeFacotry.sn }"/>
			<c:if test="${mxjQrCodeFacotry.packageComplete eq 1}">
				<span><font color="red">下载检查确认后请点击”发布“按钮</font></span><br>
				<input type="button" id="completeAllBtn" value="发布" class="submitc"/>&nbsp;<span id="publishSpan" style="color: green;"></span>
			</c:if>
		</form>
		<br>

		<c:if test="${mxjQrCodeFacotry.publishComplete eq 1}">
			<input type="button" id="rollbackBtn" value="回滚" class="submitc"/>
		</c:if>

		<form id="printForm" action="/mxjqrcodetemp.do" method="post">
			<input type="hidden" name="method" value="print"/>
			<input type="hidden" name="sn" value="${mxjQrCodeFacotry.sn }"/>
			<c:if test="${mxjQrCodeFacotry.packageComplete eq 1}">
				<span><font color="red">印刷完成后不许再操作</font></span><br>
				<input type="button" id="printBtn" value="印刷完成" class="submitc"/>&nbsp;<span id="printSpan" style="color: green;"></span>
			</c:if>
		</form>
	</c:if>
	<textarea id="remark" name="remark" rows="10" cols="5">${mxjQrCodeFacotry.remark }</textarea>
</body>
<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<script src="/js/ImageEditor/imageEditor.js"></script>
<script src="/js/qrCodeTemp/generate.js"></script>
<script src="/js/bootstrap.minn-3.3.5.js"></script>
</html>