
$(function(){

	//video
	var initJson1 = {};
	initJson1.fileExt = "*.xml";
	initJson1.fileDesc = "*.xml";
	veUploadify(initJson1, "file_upload1");

	var initJson2 = {};
	initJson2.fileExt = "*.dat";
	initJson2.fileDesc = "*.dat";
	veUploadify(initJson2, "file_upload2");
});


//需提供文件html元素id
function getfile_upload1Id(){
	return "xmlFileSn";
}
function getfile_upload2Id(){
	return "datFileSn";
}