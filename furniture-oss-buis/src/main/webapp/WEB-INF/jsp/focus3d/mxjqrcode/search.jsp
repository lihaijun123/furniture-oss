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
<title>梦想家激活码查询</title>

<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<style type="text/css">

	body{background-color:#f4f8ff }
</style>
</head>
<body>

<div>
	<br>
	<form action="/mxjqrcode.do" method="post" class="form-inline" role="form">
	   <input type="hidden" name="method" value="search"/>
	   <div class="form-group">
	      <label  for="name">二维码类型：</label>
	      <select name="qrCodeType" class="form-control">
	         <option value="">请选择</option>
	         <option value="F3D-PY-" ${qrCodeType eq "F3D-PY-" ? "selected='selected'" : ""}>F3D-PY</option>
	         <option value="F3D-XK-" ${qrCodeType eq "F3D-XK-" ? "selected='selected'" : ""}>F3D-XK</option>
	         <option value="F3D-CS-" ${qrCodeType eq "F3D-CS-" ? "selected='selected'" : ""}>F3D-CS</option>
	         <option value="F3D-ZG-" ${qrCodeType eq "F3D-ZG-" ? "selected='selected'" : ""}>F3D-ZG</option>
	         <option value="F3D-BH-" ${qrCodeType eq "F3D-BH-" ? "selected='selected'" : ""}>F3D-BH</option>
	      	</select>
	      	<input type="text" class="form-control" name="qrCodeId" value="${qrCodeId }" placeholder="请输入二维码编号">
	   </div>
	   <div class="form-group">
	      <label for="inputfile">二维码内容：</label>
	      <input type="text" class="form-control" name="qrCodeContent" value="${qrCodeContent }" placeholder="请输入二维码内容">
	   </div>
	   <button type="submit" class="btn btn-primary">查询</button>
	</form>

	<br>
	<div class="panel panel-default">
	   <div class="panel-heading">
	      二维码信息
	   </div>
	   <div class="panel-body">
			<div class="row" >
				类型：${qrCode.typeName }
			</div>
			<div class="row" >
				内容：${qrCode.content }
			</div>
			<div class="row" >
				生成时间：${qrCode.addTime }
			</div>
	   </div>
	</div>
	<div class="panel panel-default">
	   <div class="panel-heading">
	      授权信息
	   </div>
	   <div class="panel-body">
	      <table class="table table-hover">
	   		<thead>
	      		<tr>
	         		<th>序号</th>
	         		<th>设备编号</th>
	         		<th>授权时间</th>
	      		</tr>
	   		</thead>
			<tbody>
				<c:forEach var="f" items="${infoList}" varStatus="status">
			      	<tr>
						<td>${status.index + 1 }</td>
						<c:forEach var="mp" items="${f}">
						<td>
							${mp.value}
						</td>
						</c:forEach>
			      	</tr>
				</c:forEach>
		   	</tbody>
		</table>
	   </div>
	</div>
</div>

</body>

<!-- Ext Js Lib Start -->
<script type="text/javascript" src="/extjs/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext-all.js"></script>
<!-- Ext Js Lib End -->
<!-- User Defined Js Start -->
<script src="extjs/validate_form.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/util.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.minn-3.3.5.js"></script>
</html>