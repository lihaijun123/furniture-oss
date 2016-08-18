
$(function(){
	var initJson = {};
	initJson.fileExt = "*.jpg;*.jpeg";
	initJson.fileDesc = "*.jpg;*.jpeg";
	veUploadify(initJson, "file_upload1");
});

//需提供文件html元素id
function getfile_upload1Id(){
	return "imageFileSn";
}

function checkInt(obj){
	var cknum = /^[1-9]\d*$/;
	if(!cknum.test(obj.value)){
		$("#" + obj.id).val("");
	}
}
