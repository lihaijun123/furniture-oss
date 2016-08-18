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
<title>梦想家App菜单管理</title>
<link rel="stylesheet" type="text/css" href="/css/oss.css" />
<link rel="stylesheet" type="text/css" href="/css/pop.css" />
</head>
<body>
<form:form modelAttribute="appMenuItem" action="/appmenuitem.do" method="post">
	<input type="hidden" name="method" value="edit" />
	<form:hidden path="sn"/>
	<form:hidden path="fileLength"/>
	<form:hidden path="filePath"/>
	<form:hidden path="callBack"/>
	<form:hidden path="processValue"/>
	<form:hidden path="androidVersionNum"/>
	<form:hidden path="iosVersionNum"/>
	<form:hidden path="iosPadVersionNum"/>
	<form:hidden path="name"/>
	<form:hidden path="levelName"/>
	<font style="color:red;">${message }</font>
	<table width="100%">
		<caption class="x-panel-header">修改菜单界面</caption>
		<tr>
			<th><font color="red">*</font>中文名称：</th>
			<td >
				<select name="keyValue">
					<option value="UI" ${appMenuItem.keyValue eq "UI" ? "selected='selected'" : ""}>UI</option>
					<option value="spell" ${appMenuItem.keyValue eq "spell" ? "selected='selected'" : ""}>汉语拼音</option>
					<option value="sky" ${appMenuItem.keyValue eq "sky" ? "selected='selected'" : ""}>遨游星空</option>
					<option value="science" ${appMenuItem.keyValue eq "science" ? "selected='selected'" : ""}>科学常识</option>
					<option value="country" ${appMenuItem.keyValue eq "country" ? "selected='selected'" : ""}>我的祖国</option>
					<option value="protect" ${appMenuItem.keyValue eq "protect" ? "selected='selected'" : ""}>自我保护</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>英文名称：</th>
			<td >
				${appMenuItem.name}
			</td>
		</tr>
		<tr>
			<th>Key：</th>
			<td >
				${appMenuItem.keyValue}
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>isUnload：</th>
			<td >
				<select id="isUnload" name="isUnload">
					<option value="0" ${appMenuItem.isUnload eq "0" ? "selected='selected'" : "" }>false</option>
					<option value="1" ${appMenuItem.isUnload eq "1" ? "selected='selected'" : "" }>true</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>Android文件：</th>
			<td>
				<input id="file_upload1" name="file_upload1" type="file" /><br>
				<f:fileInfo id="span1" value="${appMenuItem.androidFileSn }" hid="androidFileSn" hname="androidFileSn"/>
				<span id="androidFileSn_namedisplay" /><br>
			</td>
		</tr>
		<tr>
			<th>Ios文件：</th>
			<td>
				<input id="file_upload2" name="file_upload2" type="file" /><br>
				<f:fileInfo id="span2" value="${appMenuItem.iosFileSn }" hid="iosFileSn" hname="iosFileSn"/>
				<span id="iosFileSn_namedisplay" /><br>
			</td>
		</tr>
		<tr>
			<th>Ios Pad文件：</th>
			<td>
				<input id="file_upload3" name="file_upload3" type="file" /><br>
				<f:fileInfo id="span3" value="${appMenuItem.iosPadFileSn }" hid="iosPadFileSn" hname="iosPadFileSn"/>
				<span id="iosPadFileSn_namedisplay" /><br>
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
	<a href="/appmenuitem.do?method=new">新建</a>|
	<a href="/uitoolList.ui?funcID=1080330">返回列表</a>
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
<%@include file="/WEB-INF/jsp/common/uploadfile.jsp" %>
<script src="/js/ImageEditor/imageEditor.js"></script>
<script src="/js/appmenu/appmenuitem.js"></script>
</html>