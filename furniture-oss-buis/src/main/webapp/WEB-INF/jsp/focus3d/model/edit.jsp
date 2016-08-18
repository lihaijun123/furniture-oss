<%@ page import="com.focustech.focus3d.model.model.ModelContentInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.focustech.focus3d.model.model.ModelInfo" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/tags/focus.tld" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>商店模型管理</title>
    <link rel="stylesheet" type="text/css" href="/css/oss.css"/>
    <link rel="stylesheet" type="text/css" href="/css/pop.css"/>
</head>
<body>
<form:form modelAttribute="modelInfo" action="/modelInfo.do" method="post">
    <input type="hidden" name="method" value="edit"/>
    <table width="100%">
        <caption class="x-panel-header">修改模型</caption>
        <tr>
            <th><font color="red">*</font>名称：</th>
            <td>
                <form:input path="name"/>
                <form:errors path="name" cssClass="errors"/>
            </td>
            <form:hidden path="sn"/>
        </tr>

        <tr>
            <th><font color="red">*</font>类型：</th>
            <td>
                <f:complex id="type"
                           name="type"
                           type="select"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="STORE_MODEL_TYPE"
                           siteType="1"
                           firstItemText="请选择"
                           firstItemValue="-1"
                           defaultValue="${modelInfo.type}"
                        />
                <form:errors path="type" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>价格：</th>
            <td>
                <form:input path="price" onblur="checkPrice(this);"/>
                <form:errors path="price" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>文件：</th>
            <td>
                <input id="file_upload1" name="file_upload1" type="file"/><br>
                <input type="hidden" id="fileSn" name="fileSn" value="${modelInfo.fileSn}"/><br>
                <form:errors path="fileSn" cssClass="errors"/>
                <span id="fileSn_namedisplay"/><br>
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>图片：</th>
            <td>
                <f:img id="imageFileSn_img" hid="imageFileSn" hname="imageFileSn" width="120" height="120"
                       src="${modelInfo.imageFileSn}"/><br>
                <input id="file_upload2" name="file_upload2" type="file"/><br>
                <form:errors path="imageFileSn" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>优先级：</th>
            <td>
                <form:input path="priority" onblur="checkInt(this);"/>
                <form:errors path="priority" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>是否有效：</th>
            <td>
                <f:complex id="validFlag"
                           name="validFlag"
                           type="radio"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="VALID_FLAG_TWO"
                           siteType="1"
                           defaultValue="${modelInfo.validFlag}"
                        />
            </td>
        </tr>
        <tr>
            <th>描述︰</th>
            <td colspan="3">
                    <form:textarea path="summary" rows="10" cols="80"/></br></br>
            </td>
        </tr>
    </table>
    <table id="tb_1">
        <caption class="x-panel-header">模型明细1 <a href="javascript:clean(1)">删除</a></caption>
        <tr>
            <th><font color="red">*</font>名称：</th>
            <td><input type="text" name="modelContentInfoList[0].name"
                       value="${modelInfo.modelContentInfoList[0].name}"/></td>
        </tr>

        <tr>
            <th><font color="red">*</font>类型：</th>
            <td>
                <f:complex id="type_0"
                           name="modelContentInfoList[0].type"
                           type="select"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="STORE_MODEL_CONTENT_TYPE"
                           siteType="1"
                           firstItemText="请选择"
                           firstItemValue="-1"
                           defaultValue="${modelInfo.modelContentInfoList[0].type}"
                        />
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>图片：</th>
            <td>
                <f:img id="fileSn_0_img" hid="fileSn_0" hname="modelContentInfoList[0].fileSn" width="120" height="120"
                       src="${modelInfo.modelContentInfoList[0].fileSn}"/><br>
                <input id="file_upload_0" name="file_upload_0" type="file"/><br>
                    <%--<form:errors path="fileSn" cssClass="errors"/>--%>
            </td>
        </tr>

    </table>
    <table id="tb_2">
        <caption class="x-panel-header">模型明细2 <a href="javascript:clean(2)">删除</a></caption>
        <tr>
            <th><font color="red">*</font>名称：</th>
            <td><input type="text" name="modelContentInfoList[1].name"
                       value="${modelInfo.modelContentInfoList[1].name}"/></td>
        </tr>

        <tr>
            <th><font color="red">*</font>类型：</th>
            <td>
                <f:complex id="type_1"
                           name="modelContentInfoList[1].type"
                           type="select"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="STORE_MODEL_CONTENT_TYPE"
                           siteType="1"
                           firstItemText="请选择"
                           firstItemValue="-1"
                           defaultValue="${modelInfo.modelContentInfoList[1].type}"
                        />
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>图片：</th>
            <td>
                <f:img id="fileSn_1_img" hid="fileSn_1" hname="modelContentInfoList[1].fileSn" width="120" height="120"
                       src="${modelInfo.modelContentInfoList[1].fileSn}"/><br>
                <input id="file_upload_1" name="file_upload_1" type="file"/><br>
                    <%--<form:errors path="fileSn" cssClass="errors"/>--%>
            </td>
        </tr>

    </table>
    <table id="tb_3">
        <caption class="x-panel-header">模型明细3 <a href="javascript:clean(3)">删除</a></caption>
        <tr>
            <th><font color="red">*</font>名称：</th>
            <td><input type="text" name="modelContentInfoList[2].name"
                       value="${modelInfo.modelContentInfoList[2].name}"/></td>
        </tr>

        <tr>
            <th><font color="red">*</font>类型：</th>
            <td>
                <f:complex id="type_2"
                           name="modelContentInfoList[2].type"
                           type="select"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="STORE_MODEL_CONTENT_TYPE"
                           siteType="1"
                           firstItemText="请选择"
                           firstItemValue="-1"
                           defaultValue="${modelInfo.modelContentInfoList[2].type}"
                        />
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>图片：</th>
            <td>
                <f:img id="fileSn_2_img" hid="fileSn_2" hname="modelContentInfoList[2].fileSn" width="120" height="120"
                       src="${modelInfo.modelContentInfoList[2].fileSn}"/><br>
                <input id="file_upload_2" name="file_upload_2" type="file"/><br>
                    <%--<form:errors path="fileSn" cssClass="errors"/>--%>
            </td>
        </tr>

    </table>
    <table id="tb_4">
        <caption class="x-panel-header">模型明细4 <a href="javascript:clean(4)">删除</a></caption>
        <tr>
            <th><font color="red">*</font>名称：</th>
            <td><input type="text" name="modelContentInfoList[3].name"
                       value="${modelInfo.modelContentInfoList[3].name}"/></td>
        </tr>

        <tr>
            <th><font color="red">*</font>类型：</th>
            <td>
                <f:complex id="type_3"
                           name="modelContentInfoList[3].type"
                           type="select"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="STORE_MODEL_CONTENT_TYPE"
                           siteType="1"
                           firstItemText="请选择"
                           firstItemValue="-1"
                           defaultValue="${modelInfo.modelContentInfoList[3].type}"
                        />
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>图片：</th>
            <td>
                <f:img id="fileSn_3_img" hid="fileSn_3" hname="modelContentInfoList[3].fileSn" width="120" height="120"
                       src="${modelInfo.modelContentInfoList[3].fileSn}"/><br>
                <input id="file_upload_3" name="file_upload_3" type="file"/><br>
                    <%--<form:errors path="fileSn" cssClass="errors"/>--%>
            </td>
        </tr>

    </table>
    <table  id="tb_5">
        <caption class="x-panel-header">模型明细5 <a href="javascript:clean(5)">删除</a></caption>
        <tr>
            <th><font color="red">*</font>名称：</th>
            <td><input type="text" name="modelContentInfoList[4].name"
                       value="${modelInfo.modelContentInfoList[4].name}"/></td>
        </tr>

        <tr>
            <th><font color="red">*</font>类型：</th>
            <td>
                <f:complex id="type_4"
                           name="modelContentInfoList[4].type"
                           type="select"
                           itemLabel="parameterValue"
                           itemValue="parameterKey"
                           paramType="STORE_MODEL_CONTENT_TYPE"
                           siteType="1"
                           firstItemText="请选择"
                           firstItemValue="-1"
                           defaultValue="${modelInfo.modelContentInfoList[4].type}"
                        />
            </td>
        </tr>
        <tr>
            <th><font color="red">*</font>图片：</th>
            <td>
                <f:img id="fileSn_4_img" hid="fileSn_4" hname="modelContentInfoList[4].fileSn" width="120" height="120"
                       src="${modelInfo.modelContentInfoList[4].fileSn}"/><br>
                <input id="file_upload_4" name="file_upload_4" type="file"/><br>
                    <%--<form:errors path="fileSn" cssClass="errors"/>--%>
            </td>
        </tr>
    </table>
    <div style="display: none;">
        <table>
            <caption class="x-panel-header">操作信息</caption>
            <tr>
                <td>添加人：${adderName } <input type="hidden" name="adderName" value="${adderName }"/></td>
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
        <input type="submit" class="submitc" value="提交 "/>
    </div>
</form:form>
<div class="buttons">
    <a href="/modelInfo.do?method=new">新建</a>|
    <a href="/uitoolList.ui?funcID=1080313">返回列表</a>
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
<script type="text/javascript" src="/js/model/model.js"></script>
</html>