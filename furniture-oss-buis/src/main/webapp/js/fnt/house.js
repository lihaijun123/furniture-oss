
$(function(){
	var province = $("#province").attr("value1")=="" ? "请选择" : $("#province").attr("value1");
	var city = $("#city").attr("value1")=="" ? "请选择" : $("#city").attr("value1");
   	setup(province, city);
   	
	var initJson1 = {};
	initJson1.fileExt = "*.unity3d";
	initJson1.fileDesc = "*.unity3d";
	veUploadify(initJson1, "file_upload1");
	
	var initJson2 = {};
	initJson2.fileExt = "*.jpg;*.jpeg";
	initJson2.fileDesc = "*.jpg;*.jpeg";
	veUploadify(initJson2, "file_upload2");
	
	$("#fntHouseForm").validate({
    	onfocusout:function(element){$(element).valid();},
    	errorPlacement: function(error, element){
    		error.appendTo(element.parent());
    	},
    	rules: {
    		name:{
    			required: true,
    			maxlength: 30
    		},
    		area:{
    			required: true,
    			maxlength: 30,
    		 	number:true
    		}
    	},
    	messages: {
    		name:{
	    		required: "请输入户型名称",
	    		maxlength: "请输入{0}个字以内"
	    	},
	    	area:{
				required: "请输入面积",
				maxlength: "请输入{0}个字以内",
				number: "请输入正确的面积"
			}
    	},
    	submitHandler:function(form){
    		form.submit();
    	}
    });

	
});
//需提供文件html元素id
function getfile_upload1Id(){
	return "modelFileSn";
}

function getfile_upload2Id(){
	return "picFileSn";
}
