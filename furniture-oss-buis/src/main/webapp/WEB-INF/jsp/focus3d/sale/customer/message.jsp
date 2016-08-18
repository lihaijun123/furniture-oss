<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="/WEB-INF/tags/focus.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理</title>
</head>
<body>
<table width="100%">
	<tr>
		<td align="center">
			<font color="red">${message}</font>
		</td>
	</tr>
	<tr>
		<td align="center">
		<c:if test="${return=='return'}">
		<input type="button" value="返 回"  class="submitc"
					onclick="javasctript:history.back();" class="submitc">
		</c:if>
		<c:if test="${return=='all'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/uitoolList.ui?funcID=1080325'">
		</c:if>
		<c:if test="${return=='one'}">
		<input type="button" value=" 返 回 "  class="submitc"
					onclick="window.location.href='/uitoolList.ui?funcID=1080323'">
		</c:if>


		</td>
	</tr>
</table>
</body>
</html>