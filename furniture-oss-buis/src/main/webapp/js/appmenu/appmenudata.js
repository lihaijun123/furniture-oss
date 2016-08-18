
$(function(){

	//video
	var initJson2 = {};
	initJson2.fileExt = "*.unity3d";
	initJson2.fileDesc = "*.unity3d";
	veUploadify(initJson2, "file_upload1");
	veUploadify(initJson2, "file_upload2");
});


//需提供文件html元素id
function getfile_upload1Id(){
	return "androidFileSn";
}
function getfile_upload2Id(){
	return "iosFileSn";
}