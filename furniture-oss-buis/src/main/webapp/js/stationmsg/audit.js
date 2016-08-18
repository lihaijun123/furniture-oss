/** 审核信息*/

$(document).ready(function(){
	var initJson5 = {};
	initJson5.buttonImg = "/images/fileupload-browse.gif";
	initJson5.multi = false;
	initJson5.onComplete = uploadComplete;
	veUploadify(initJson5, "file_uploadAttach");
});

function getfile_uploadAttachId(){
	return "file_uploadAttach";
}

//新建备注页
function newRemark() {
	$(".clearVal").val("");
	document.getElementById('remarkDiv').style.display = 'block';
	$(".addRemarkBtn").show();
	$(".editRemarkBtn").hide();
}

function backRemark() {
	document.getElementById('remarkDiv').style.display = 'none';
}
function uploadComplete(event, ID, fileObj, response, data){
	var data = (new Function("return " + response))();
	data = data[0];
	var $fileSn = data.fileId;
	var $fileUrl = data.fileUrl;
	$("#attachSn").val($fileSn);
	$("#attach").val($fileUrl);
}

//新建备注
function addRemark(){
	var url = "/product-info.do?method=remark&title="+$("#attachTitle").val()+"&type="+$("#attachType").val()+"&priority="+$("#attachPriority").val()+"&content="+$("#content").val()+"&attachSn="+$("#attachSn").val()+"&auditTargetId="+$("#auditTargetId").val()+"&auditType="+$("#auditType").val();

	$.ajax({
		url : url,
		type : 'post',
		success : function(result) {
			if(result != "fasle"){
				var data = (new Function("return " + result))();
				var num = parseInt($("#num").val()) + 1;
				$(".remark table")
					.append(
							"<tr id='tr"
									+ data.SN
									+ "'><td>"
									+ num
									+ "</td><td><a href='javascript:toEditAuditRemark("
									+ data.SN + ")'>"
									+ data.TITLE
									+ "</a></td><td>"
									+ data.CONTENT
									+ "</td><td>"
									+ data.UPDATETIME
									+ "</td><td>"
									+ data.UPDATERNAME
									+ "</td></tr>");
							$("#remarkDiv").css("display", "none");
							$("#attachSn").val(data.ATTACHID);
							$("#attSn").val(data.ATTACHID);
						}
					}
			})
}

//进入修改备注页
function toEditAuditRemark(id) {
	$(".clearVal").val("");
	$("#remarkDiv").css("display", "block");
	$(".editRemarkBtn").show();
	$(".addRemarkBtn").hide();
	$.ajax( {
		type:"GET",
		url:"product-info.do",
		data:"method=getRemark&remarkSn="+id+"&timeStamp=" + new Date().getTime(),
		success : function(result) {
			var data = (new Function("return " + result))();
			$("#auditRemarkSn").val(data.SN);
			$("#attachTitle").val(data.TITLE);
			$("#attachType").val(data.TYPE);
			$("#attachPriority").val(data.PRIORITY);
			$("#content").val(data.CONTENT);
			$("#attach").val(data.ATTACHADDR);
			$("#attSn").val(data.ATTACHSN);
			$("#attachSn").val(data.ATTACHSN);
		}
	});
}

function editRemark() {
	var sn = $("#auditRemarkSn").val();

	var url = "/product-info.do?method=editRemark&title="+$("#attachTitle").val()+"&type="+$("#attachType").val()+"&priority="+$("#attachPriority").val()+"&content="+$("#content").val()+"&attachSn="+$("#attachSn").val()+"&attSn="+$("#attSn").val()+"&auditTargetId="+$("#auditTargetId").val()+"&auditRemarkSn="+sn+"&auditType="+$("#auditType").val();
	$.ajax({
		url : url,
		type : 'post',
		success : function(result) {
			var data = (new Function("return " + result))();
			var num = $("#tr" + sn).children().eq(0).html();

			$("#tr" + sn)
					.html(
							"<td>"
									+ num
									+ "</td><td><a href='javascript:toEditAuditRemark("
									+ data.SN + ")'>"
									+ data.TITLE
									+ "</a></td><td>"
									+ data.CONTENT
									+ "</td><td>"
									+ data.UPDATETIME
									+ "</td><td>"
									+ data.UPDATERNAME
									+ "</td>");
			$("#remarkDiv").css("display", "none");
		}
	})
}

function delOfAddRemark(){
	$(".clearVal").val("");
}

//删除备注
function delOfEditRemark(){
	var sn = $("#auditRemarkSn").val();
	vConfirm("确定删除?", "", function(isTrue){
		if(isTrue){
			$.ajax( {
				type:"GET",
				url:"product-info.do",
				data:"method=delRemark&remarkSn="+sn+"&timeStamp=" + new Date().getTime(),
				success : function(result) {
					if(result === "ok"){
						$("#remarkDiv").css("display", "none");
						$("#tr" + sn).next("tr").find("td:first").each(function(){
							var bb = parseInt($(this).html())-1;
							$(this).html(bb);
						})
						$("#tr" + sn).remove();
					}
				}
			});
		}
	});
}

//删除附件
function delAttach() {
	$("#attach").val("");
	$("#attachSn").val("0");
}
