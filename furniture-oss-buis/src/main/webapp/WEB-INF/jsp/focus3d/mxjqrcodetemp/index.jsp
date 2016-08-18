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

<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<style type="text/css">

	body{background-color:#f4f8ff }
</style>
</head>
<body>
	<table class="table table-hover">
		<caption>二维码制作任务列表</caption>
   		<thead>
      		<tr>
         		<th>序号</th>
         		<th>类型</th>
         		<th>制作数量</th>
         		<th>打包编号</th>
         		<th>制作完成</th>
         		<th>打包完成</th>
         		<th>下载完成</th>
         		<th>发布完成</th>
         		<th>印刷完成</th>
         		<th>添加时间</th>
         		<th>备注</th>
         		<th><a href="/mxjqrcodetemp.do?method=new" class="glyphicon glyphicon-plus"></a></th>
      		</tr>
   		</thead>
		<tbody>
			<c:forEach var="f" items="${qrCodeFactories }" varStatus="status">
		      	<tr>
					<td>${status.index + 1 }</td>
					<td>

					<select id="type" name="type" disabled="disabled">
						<c:forEach var="qrType" items="${mxjQrCodeTypes }">
							<option value="${qrType.parameterKey}" ${qrType.parameterKey eq f.type ? "selected='selected'" : ""}>${qrType.parameterValue}</option>
						</c:forEach>
					</select>

					</td>
		         	<td>${f.quantity }</td>
					<td>${f.randomValueStr}</td>
		         	<td>${f.dataComplete eq 1 ? "<span class='glyphicon glyphicon-ok' style='color: green;'></span>" : "<span class='glyphicon glyphicon-remove' style='color: red;'></span>"}</td>
					<td>${f.packageComplete eq 1 ? "<span class='glyphicon glyphicon-ok' style='color: green;'></span>" : "<span class='glyphicon glyphicon-remove' style='color: red;'></span>"}</td>
		         	<td>${f.downloadComplete eq 1 ? "<span class='glyphicon glyphicon-ok' style='color: green;'></span>" : "<span class='glyphicon glyphicon-remove' style='color: red;'></span>"}</td>
					<td>${f.publishComplete eq 1 ? "<span class='glyphicon glyphicon-ok' style='color: green;'></span>" : "<span class='glyphicon glyphicon-remove' style='color: red;'></span>"}</td>
					<td>${f.printComplete eq 1 ? "<span class='glyphicon glyphicon-ok' style='color: green;'></span>" : "<span class='glyphicon glyphicon-remove' style='color: red;'></span>"}</td>
		         	<td>${f.addTime }</td>
		         	<td><a id="setRemark_${f.sn }" sn="${f.sn }">${f.remark eq null or f.remark eq ""  ? "<span class='glyphicon glyphicon-pencil'></span>" : f.remark}</a></td>
		         	<td>
			         	<c:if test="${f.printComplete eq 0}">
			         		<a href="/mxjqrcodetemp.do?method=edit&sn=${f.sn }" class="glyphicon glyphicon-pencil">${mxjQrCodeFacotry.printComplete}</a>
			         		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				         	<a id="deleteLk_${f.sn }" sn="${f.sn }" href="#" class="glyphicon glyphicon-minus"></a>
			         	</c:if>
		         	</td>
		      	</tr>
			</c:forEach>
	   	</tbody>
	</table>
</body>


<!-- 模态框（Modal） -->
<div class="modal fade" id="remarkModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close"
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
         </div>
         <div class="modal-body">
			<div class="form-group">
		    	<label for="name">备注</label>
		    	<textarea id="remark" class="form-control" rows="3"></textarea>
		  	</div>
         </div>
         <div class="modal-footer">
            <button id="submitRemark" type="button" class="btn btn-primary">
              	 提交
            </button>
         </div>
      </div>
</div>
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
<script src="/js/qrCodeTemp/list.js"></script>
<script src="/js/bootstrap.minn-3.3.5.js"></script>
</html>