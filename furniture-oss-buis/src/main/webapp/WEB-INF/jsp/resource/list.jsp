<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>所有资源列表</title>
		<!-- Ext Css -->
		<link rel="stylesheet" type="text/css" href="/resources/css/ext-all.css" />
		<link rel="stylesheet" type="text/css" href="/css/oss.css" />
		<!-- Ext Js Lib -->
		<script type="text/javascript" src="/extjs/ext-base.js"></script>
		<script type="text/javascript" src="/extjs/ext-all.js"></script>
		<!-- User Defined Js -->
		<script src="extjs/style.js" type="text/javascript"></script>
		<script src="extjs/validate_form.js" type="text/javascript"></script>


	</head>
	<body>
		<table width="100%">
			<caption class="x-panel-header">
				所有资源列表
			</caption>
			<tr>
				<td align="center" colspan="3">
					<font size="+1" color="#00aaff"><b>菜单资源</b> </font>
				</td>
				<td align="right">
				</td>
			</tr>
			<tr>
				<td>
					<b>资源编号</b>
				</td>
				<td>
					<b>资源名称</b>
				</td>
				<td>
					<b>描述</b>
				</td>
				<td align="center">
					<a href="/resource.do?method=menuAdd">添加</a>
				</td>

			</tr>
			<c:forEach var="resources" items="${menuResourcesList}">
				<tr>
					<td>
						${resources.resourceId}
					</td>
					<td title="${resources.resourceName }">
						${resources.resourceName }
					</td>
					<td>
						${resources.description }
					</td>
					<c:if test="${resources.resourceId ne 0 }">

					<td align="center" nowrap title="${resources.resourceName }">
						<a href="resource.do?method=details&resourceId=${resources.resourceId }&url=menu">查看</a>&nbsp;&nbsp;
						<a href="resource.do?method=menuModify&resourceId=${resources.resourceId }">修改</a>&nbsp;&nbsp;
						<a href="resource.do?method=delete&resourceId=${resources.resourceId }">刪除</a>
						<a title="${resources.resourceName }" href="resource.do?method=exportSql&resourceId=${resources.resourceId }">导出sql</a>
					</td>
					</c:if>
				</tr>
			</c:forEach>

			<!-- **************************** 工作台 type-6 ****************************************************-->
			<tr>
				<td align="center" colspan="3">
					<font size="+1" color="#00aaff"><b>首页资源</b> </font>
				</td>
				<td align="center"">
					<font size="2"><a href="/resource.do?method=workspaceAdd">添加</a>
					</font>
				</td>
			</tr>

			<c:forEach var="workspace" items="${workspaceResourcesList}">
				<tr>
					<td>
						${workspace.resourceId}
					</td>
					<td>
						${workspace.resourceName }
					</td>
					<td>
						${workspace.resourceDescription }
					</td>
					<td align="center" nowrap>
						<a href="resource.do?method=details&resourceId=${workspace.resourceId }">查看</a>&nbsp;&nbsp;
						<a href="resource.do?method=workspaceModify&resourceId=${workspace.resourceId }">修改</a>&nbsp;&nbsp;
						<a href="resource.do?method=delete&resourceId=${workspace.resourceId }">刪除</a>
					</td>
				</tr>
			</c:forEach>

			<!-- ****************************  方法資源  ****************************************************
			<tr>
				<td align="center" colspan="3">
					<font size="+1" color="#00aaff"><b>方法资源</b> </font>
				</td>
				<td align="right">
					<font size="2"><a href="/resource.do?method=methodAdd">添加方法资源</a>
					</font>
				</td>
			</tr>

			<c:forEach var="resources" items="${methodResourcesList}">
				<tr>
					<td>
						${resources.resourceId}
					</td>
					<td>
						${resources.resourceName }
					</td>
					<td>
						${resources.description }
					</td>
					<td align="center" nowrap>
						<a
							href="resource.do?method=details&resourceId=${resources.resourceId }">查看</a>&nbsp;&nbsp;
						<a
							href="resource.do?method=methodModify&resourceId=${resources.resourceId }">修改</a>&nbsp;&nbsp;
						<a
							href="resource.do?method=delete&resourceId=${resources.resourceId }">刪除</a>
					</td>
				</tr>
			</c:forEach>


		</table>
		<!--form內容結束-->
	</body>
</html>