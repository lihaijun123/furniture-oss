<%@page import="com.focustech.common.utils.TCUtil"%>
<%@page import="com.focustech.cief.filemanage.common.utils.FileManageUtil"%>
<%@page import="java.util.List"%>
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
<title>App信息审核</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/focus3d.css" />
</head>
<body>
<form:form modelAttribute="app" action="/app.do" method="post">
	<input type="hidden" name="method" value="audit" />
	<input type="hidden" id="prodSize" name="prodSize" value="${app.prods.size()}" />
	<form:hidden path="sn"/>
	<table width="100%">
		<font color="red"><h2>${msg }</h2></font>
		<caption class="x-panel-header">App信息审核</caption>

		<tr>
			<td colspan="3"><b>用户信息</b></td>
		</tr>
		<tr>
			<th>用户邮箱：</th>
			<td >${user.loginInfo.email }</td>
		</tr>
		<tr>
			<th>用户名称：</th>
			<td >${user.name }</td>
		</tr>
		<tr>
			<td colspan="3"><b>App信息</b></td>
		</tr>
		<tr>
			<th>名称：</th>
			<td >${app.name }</td>
		</tr>
		<tr>
			<th>图标：</th>
			<td ><f:img width="50" height="50" src="${app.icon.imageFileSn}" /></td>
		</tr>
	    <tr>
			<td colspan="3"><b>封面信息</b></td>
		</tr>
		<tr>
			<th>图片：</th>
			<td >
				<c:if test="${app.boot.setupType eq 1}">
					默认：
					<f:img width="50" height="50" src="${app.boot.defaultImageFileSn}" />
				</c:if>
				<c:if test="${app.boot.setupType eq 2}">
				   	 自定义：
					<f:img width="50" height="50" src="${app.boot.imageFileSn}" />
				</c:if>
			</td>
		</tr>
		<tr>
			<th>名称：</th>
			<td >${app.boot.name }</td>
		</tr>
		<tr>
			<th>版权信息：</th>
			<td >${app.boot.copyrigthText }</td>
		</tr>
		<tr>
			<td colspan="3"><b>引导页信息</b></td>
		</tr>
		<tr>
			<th>引导图片：</th>
			<td >
				<c:forEach var="d" items="${app.guid.detail}">
					自定义：
					<f:img width="50" height="50" src="${d.imageFileSn}" />
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="3"><b>风格设置</b></td>
		</tr>
		<tr>
			<th>图片：</th>
			<td >
				<c:if test="${app.style.setupType eq 1}">
					默认：
					<c:if test="${app.style.color ne ''}">
					颜色：${app.style.color}
					</c:if>
					<c:if test="${app.style.industy ne ''}">
					<f:img width="50" height="50" src="${app.style.industy}" />
					</c:if>
				</c:if>
				<c:if test="${app.style.setupType eq 2}">
				   	 自定义：
				   	 公司简介：
					<f:img width="50" height="50" src="${app.style.imageFileSn}" />
					<f:img width="50" height="50" src="${app.style.videoPicFileSn}" />
					<f:img width="50" height="50" src="${app.style.contactFileSn}" />
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="3"><b>产品信息</b></td>
		</tr>
		<c:forEach var="prod" items="${app.prods}" varStatus="status">
			<tr>
				<th>
				<c:if test="${prod.vrAr.sn eq null}">
					<a href="/app.do?method=addvrar&prodSn=${prod.sn }">${status.index + 1}</a>
				</c:if>
				<c:if test="${prod.vrAr.sn ne null}">
					${status.index + 1}
				</c:if>
				</th>
				<td >
					<table>
						<tr>
							<th>名称：</th>
							<td>${prod.name }</td>
						</tr>
						<tr>
							<th>型号：</th>
							<td>${prod.type }</td>
						</tr>
						<tr>
							<th>图片：</th>
							<td><f:img width="50" height="50" src="${prod.imageFileSn}" /></td>
						</tr>
						<tr>
							<th>广告语：</th>
							<td>${prod.adText }</td>
						</tr>
						<tr>
							<th>简介：</th>
							<td>${prod.summary }</td>
						</tr>
						<c:if test="${prod.vrAr.sn ne null}">
						<tr>
							<td colspan="3"><b>VR-AR信息</b></td>
						</tr>
						<tr>
							<th>安卓模型文件：</th>
							<td>
							    <form:hidden path="prods[${status.index }].sn"/>
							    <form:hidden path="prods[${status.index }].vrAr.sn"/>
								<input id="file_upload${status.index }" name="file_upload${status.index }" type="file" /><br>
								<f:fileInfo id="modelFileSn_${status.index }_namedisplay" hid="modelFileSn_${status.index }" hname="prods[${status.index }].vrAr.modelFileSn" value="${prod.vrAr.modelFileSn}"/>
							</td>
						</tr>
						<tr>
							<th>IOS模型文件：</th>
							<td>
								<input id="file_upload_ios${status.index }" name="file_upload_ios${status.index }" type="file" /><br>
								<f:fileInfo id="iosModelFileSn_${status.index }_namedisplay" hid="iosModelFileSn_${status.index }" hname="prods[${status.index }].vrAr.iosModelFileSn" value="${prod.vrAr.iosModelFileSn}"/>
							</td>
						</tr>
						<tr>
							<th>制作打包文件：</th>
							<td>
								<f:fileInfo value="${prod.vrAr.modelMakePackFileSn}"/>
								<f:fileDownload value="${prod.vrAr.modelMakePackFileSn}"/>
							</td>
						</tr>
						<tr>
							<th>AR识别图：</th>
							<td>
								<f:img width="50" height="50" src="${prod.vrAr.arPackFileSn}" />
							</td>
						</tr>
						<tr>
							<th>场景文件：</th>
							<td><f:img width="50" height="50" src="${prod.vrAr.sceneFileSn}" /></td>
						</tr>
						</c:if>

						<c:if test="${prod.videoAr.sn ne null}">
						<tr>
							<td colspan="3"><b>Video-AR信息</b></td>
						</tr>
						<tr>
							<th>视频文件：</th>
							<td>
								<f:fileInfo value="${prod.videoAr.videoFileSn}"/>
								<f:fileDownload value="${prod.videoAr.videoFileSn}"/>
							</td>
						</tr>
						<tr>
							<th>视频截图：</th>
							<td><f:img width="50" height="50" src="${prod.videoAr.videoPicFileSn}" /></td>
						</tr>
						<tr>
							<th>AR识别图：</th>
							<td>
								<f:img width="50" height="50" src="${prod.videoAr.arPackFileSn}" />
							</td>
						</tr>
						</c:if>
					</table>

				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3"><b>审核</b></td>
		</tr>
		<tr>
			<th>审核意见：</th>
			<td >
				<form:textarea path="auditRemark" rows="30" cols="10"/>
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>状态：</th>
			<td >
				<f:complex id="appStatus"
							name="status"
							type="radio"
							itemLabel="parameterValue"
							itemValue="parameterKey"
							paramType="App_STATUS"
							siteType="1"
							exceptItems="1,2"
							defaultValue="${status }"
							/>
			</td>
		</tr>
	</table>
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
	<a href="/userinfo.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080318">返回列表</a>
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
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/calendar.js"></script>
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<script type="text/javascript">
jQuery(function($){
	//表单验证
	$("form").validate({
    	onfocusout:function(element){$(element).valid();},
    	errorPlacement: function(error, element){
    		error.appendTo(element.parent().parent());
        },
        rules: {
            status: {
                required: true
            }
        },
        messages: {
        	status: {
                required: "请选择状态",
            }
        },
        submitHandler:function(form){
			form.submit();
        }
    });


	var initJson = {};
	initJson.fileExt = "*.unity3d";
	initJson.fileDesc = "*.unity3d";
	var prodSize = $("#prodSize").val();
	for(var i = 0; i < prodSize; i ++){
		//android模型
		eval("getfile_upload" + i + "Id= new Function(\"return 'modelFileSn_" + i + "';\")");
		veUploadify(initJson, "file_upload" + i);
		//ios模型
		eval("getfile_upload_ios" + i + "Id= new Function(\"return 'iosModelFileSn_" + i + "';\")");
		veUploadify(initJson, "file_upload_ios" + i);
	}
});


</script>

</html>