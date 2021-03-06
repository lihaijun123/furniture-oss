
$(function(){
	var initJson1 = {};
	initJson1.fileExt = "*.unity3d";
	initJson1.fileDesc = "*.unity3d";
	veUploadify(initJson1, "file_upload1");
	
	var initJson2 = {};
	initJson2.fileExt = "*.jpg;*.jpeg;*.png";
	initJson2.fileDesc = "*.jpg;*.jpeg;*.png";
	veUploadify(initJson2, "file_upload2");
	
	$("#categoryName").category();
	
	$("#fntProductForm").validate({
    	onfocusout:function(element){$(element).valid();},
    	errorPlacement: function(error, element){
    		error.appendTo(element.parent());
    	},
    	rules: {
    		name:{
    			required: true,
    			maxlength: 30
    		},
    		price:{
    			required: true,
    			maxlength: 30,
    		 	number:true
    		},
    		category:{
    			required: true,
    			maxlength: 30
    		}
    	},
    	messages: {
    		name:{
	    		required: "请输入产品名称",
	    		maxlength: "请输入{0}个字以内"
	    	},
	    	price:{
				required: "请输入价格",
				maxlength: "请输入{0}个字以内",
				number: "请输入正确的价格"
			},
			category:{
	    		required: "请输入类别",
	    		maxlength: "请输入{0}个字以内"
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
