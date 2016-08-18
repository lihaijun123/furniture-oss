
$(function(){
	var initJson = {};
	initJson.fileExt = "*.jpg;*.jpeg;*.png;";
	initJson.fileDesc = "*.jpg;*.jpeg;*.png;";
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
