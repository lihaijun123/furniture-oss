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
<title>梦想家App配置管理</title>
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
</head>
<body>
	<div class="panel panel-default">
	   <div class="panel-heading">
	       	复制配置
	   </div>
	   <div class="panel-body">
			<form id="copyConfigForm" action="/appconfig.do" method="get" class="form-inline" role="form">
				<input type="hidden" name="method" value="new" />
				<div class="form-group">
					<label class="sr-only" for="name">名称</label>
					<select class="form-control" name="copyConfigSn">
						<option value="">请选择</option>
						<c:forEach var="config" items="${appConfigList }">
							<option value="${config.sn }" ${config.sn eq copyConfigSn ? "selected='selected'" : ""}>${config.keyName }</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-default">复制</button>
			</form>
	   </div>
	</div>
<form:form modelAttribute="appConfig" action="/appconfig.do" method="post" cssClass="form-horizontal">
	<input type="hidden" name="method" value="create" />
	<form:hidden path="isValid"/>
	<font style="color:red;">${message }</font>
	<div class="panel panel-default">
	   <div class="panel-heading">
	   	版本信息
	   </div>
	   <div class="panel-body">
		   <div class="form-group">
	      	  <label for="name" class="col-sm-2 control-label">版本名称</label>
		      <div class="col-sm-10">
		      	<input type="text" class="form-control" id="keyName" name="keyName" placeholder="请输入名字">
		      </div>
		   </div>
		   <input type="hidden" name="type" value="1"/>
		   <!--
		   <div class="form-group">
	      	  <label for="name" class="col-sm-2 control-label">产品类型</label>
		      <div class="col-sm-10">
				<select class="form-control" name="type">
						<option value="">请选择</option>
						<option value="1">汉语拼音</option>
						<option value="2">遨游星空</option>
						<option value="3">科学常识</option>
						<option value="4">我的祖国</option>
						<option value="5">自我保护</option>
				</select>
		      </div>
		   </div>
		    -->
		   <div class="form-group">
	      	  <label for="name" class="col-sm-2 control-label">备注</label>
		      <div class="col-sm-10">
		      	<textarea class="form-control" id="remark" name="remark" rows="3"></textarea>
		      </div>
		   </div>
	   </div>
	</div>
	<div class="panel panel-info">
	   <div class="panel-heading">
	      <h3 class="panel-title">配置项</h3>
	   </div>
	   <div class="panel-body">
			<div class="row">
				<div class="col-md-6">
					<div class="col-md-6 ">
						<span class="label label-primary">本地</span>
					</div>
					<div class="col-md-6 text-right">
						<span id="addLocalLine" class="glyphicon glyphicon-plus"></span>
					</div>
					<table id="localTable" class="table">
						<caption class="x-panel-header"></caption>
						<tbody>
							<c:forEach var="config" items="${appConfig.localValues }" varStatus="status">
							<tr>
								<td><label for="name">键</label></td>
								<td ><input type="text" class="form-control" name="localValues[${status.index }].key" value="${config.key }" placeholder="请输入名称"></td>
								<td><label for="name">值</label></td>
								<td ><input type="text" class="form-control" name="localValues[${status.index }].value" value="${config.value }" placeholder="请输入名称"></td>
								<td ><span id="rmLocalLine_${status.index }" class="glyphicon glyphicon-minus"></span></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-6">
					<div class="col-md-6">
						<span class="label label-primary">阿里云</span>
					</div>
					<div class="col-md-6 text-right">
						<span id="addCloudLine" class="glyphicon glyphicon-plus"></span>
					</div>
					<table id="cloudTable" class="table">
						<caption class="x-panel-header"></caption>
						<tbody>
							<c:forEach var="config" items="${appConfig.cloudValues }" varStatus="status">
							<tr>
								<td><label for="name">键</label></td>
								<td ><input type="text" class="form-control" name="cloudValues[${status.index }].key" value="${config.key }" placeholder="请输入名称"></td>
								<td><label for="name">值</label></td>
								<td ><input type="text" class="form-control" name="cloudValues[${status.index }].value" value="${config.value }" placeholder="请输入名称"></td>
								<td ><span id="rmCloudLine_${status.index }" class="glyphicon glyphicon-minus"></span></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	   </div>
	</div>
	<div class="panel panel-info">
	   <div class="panel-heading">
	      <h3 class="panel-title">配置切换</h3>
	   </div>
	   <div class="panel-body">
	     	<div class="row">
				<div class="col-md-6">
					<label class="checkbox-inline">
				      <input type="radio" name="configGetType" id="configGetType"
				         value="1" checked>本地
				   </label>
				   <label class="checkbox-inline">
				      <input type="radio" name="configGetType" id="configGetType"
				         value="2">阿里云
				   </label>
				</div>
			</div>
	   </div>
	</div>

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
	<div class="text-center">
		<button type="submit" class="btn btn-info">提交</button>
	</div>
</form:form>
<div class="text-center">
	<a href="/appconfig.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080337">返回列表</a>
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
<script src="/js/bootstrap.minn-3.3.5.js"></script>
<script src="/js/appconfig/config.js"></script>
</html>