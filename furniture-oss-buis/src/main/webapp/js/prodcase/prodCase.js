
$(function(){
	var initJson = {};
	initJson.fileExt = "*.jpg;*.jpeg;*.png";
	initJson.fileDesc = "*.jpg;*.jpeg;*.png";
	veUploadify(initJson, "file_upload1");
	veUploadify(initJson, "file_upload11");
	veUploadify(initJson, "file_upload12");
	veUploadify(initJson, "file_upload13");
	veUploadify(initJson, "file_upload14");
	veUploadify(initJson, "file_upload15");
	veUploadify(initJson, "file_upload8");
	veUploadify(initJson, "file_upload9");
	//截图
	veUploadify(initJson, "file_upload1_0");
	veUploadify(initJson, "file_upload1_1");
	veUploadify(initJson, "file_upload1_2");
	veUploadify(initJson, "file_upload1_3");
	veUploadify(initJson, "file_upload1_4");
	//video
	var initJson2 = {};
	initJson2.fileExt = "*.wmv;*.mp4;*.swf";
	initJson2.fileDesc = "*.wmv;*.mp4;*.swf";
	veUploadify(initJson2, "file_upload2_0");
	veUploadify(initJson2, "file_upload2_1");
	veUploadify(initJson2, "file_upload2_2");
	veUploadify(initJson2, "file_upload2_3");
	veUploadify(initJson2, "file_upload2_4");
	//prodcase file
	var initJson3 = {};
	initJson3.fileExt = "*.wmv;*.mp4;*.swf";
	initJson3.fileDesc = "*.wmv;*.mp4;*.swf";
	initJson3.onComplete = videoUploadOnComplete;
	veUploadify(initJson3, "file_upload3");

	var lineNum = parseInt($("#lineNum").val());
	for(var i = 0; i < lineNum; i ++){
		var type = $("#caseFile_contents" + i + "_type").val();
		contentTypeSelect(i, type);
	}

});

function contentTypeSelect(index, key){
	if(key == 3){
		$("#contentVideo_" + index + "_div").show();
		$("#contentImg_" + index + "_div").hide();
		//position = $("#position1 option:selected").val();
	} else {
		$("#contentImg_" + index + "_div").show();
		$("#contentVideo_" + index + "_div").hide();
	}
}

//需提供文件html元素id
function getfile_upload1Id(){
	return "imageFileSn";
}
function getfile_upload11Id(){
	return "indexImageFileSn";
}
function getfile_upload12Id(){
	return "serviceImageFileSn";
}
function getfile_upload13Id(){
	return "caseImageFileSn";
}
function getfile_upload14Id(){
	return "ciefImageFileSn";
}
function getfile_upload15Id(){
	return "aboutImageFileSn";
}
function getfile_upload8Id(){
	return "playPicFileSn";
}
function getfile_upload9Id(){
	return "bkPicFileSn";
}

function checkInt(obj){
	var cknum = /^[1-9]\d*$/;
	if(!cknum.test(obj.value)){
		$("#" + obj.id).val("");
	}
}

//需提供文件html元素id
function getfile_upload1_0Id(){
	return "contentFileSn_0";
}
//需提供文件html元素id
function getfile_upload1_1Id(){
	return "contentFileSn_1";
}
//需提供文件html元素id
function getfile_upload1_2Id(){
	return "contentFileSn_2";
}
//需提供文件html元素id
function getfile_upload1_3Id(){
	return "contentFileSn_3";
}
//需提供文件html元素id
function getfile_upload1_4Id(){
	return "contentFileSn_4";
}
//video

//需提供文件html元素id
function getfile_upload2_0Id(){
	return "contentFileSn_0";
}
//需提供文件html元素id
function getfile_upload2_1Id(){
	return "contentFileSn_1";
}
//需提供文件html元素id
function getfile_upload2_2Id(){
	return "contentFileSn_2";
}
//需提供文件html元素id
function getfile_upload2_3Id(){
	return "contentFileSn_3";
}
//需提供文件html元素id
function getfile_upload2_4Id(){
	return "contentFileSn_4";
}
function getfile_upload2_0UrlParam(){
	return {type:"_video_"};
}
function getfile_upload2_1UrlParam(){
	return {type:"_video_"};
}
function getfile_upload2_2UrlParam(){
	return {type:"_video_"};
}
function getfile_upload2_3UrlParam(){
	return {type:"_video_"};
}
function getfile_upload2_4UrlParam(){
	return {type:"_video_"};
}
//prodcase file
function getfile_upload3Id(){
	return "fileSn";
}
function getfile_upload3UrlParam(){
	return {screenshotSize:"500*500", screenshotFromTime:10};
}
function videoUploadOnComplete(event, ID, fileObj, response, data){
	//文件上传空间对象的id
	var uploadFileId = event.currentTarget.id;

	//文件文本域id一般对应model中的一个属性
	var filedId = eval("get" + uploadFileId + "Id()");
	//返回文件id,url
	var returnJsonAry = eval("(" + response + ")");

	var rv = returnJsonAry[0];
	//新保存的id
	var newFileId = rv.fileId;
	//原先Id
	var oldFileId = $("#" + filedId).val();
	//修改文件后删除服务器上面的旧文件
	if(oldFileId){
		//deleteFileById(oldFileId);
	}
	$("#" + filedId).val(newFileId);
	//var fileUrlValue = $("#fileUrls").val();
	//$("#fileUrls").val(rv.fileUrl);
	var picId = rv.screenshotId;
	var picUrl = rv.screenshotUrl;
	//如果有图片
	var imagFieldId = "playPicFileSn";
	var imgObj = document.getElementById(imagFieldId);
	if(imgObj){
		$("#" + imagFieldId + "_img").attr("src", picUrl);
		$("#" + imagFieldId).val(picId);
	}
	//如果有文件，则显示文件名称
	var fileNameDisplayId = filedId + "_namedisplay";
	var fileNameDisplayObj = document.getElementById(fileNameDisplayId);
	if(fileNameDisplayObj){
		$("#" + fileNameDisplayId).text("上传成功 " + fileObj.name);
	}
}

//清除内容

function clean(index){
	$("#caseFile_contents" + index + "_name").val("");
	$("#contentFileSn_" + index).val("");
	$("#contentFileSn_" + index + "_img").attr("src", "/js/uploadFile/pic120.gif");
	$("#contentFileSn_" + index + "_namedisplay").html("");
}
