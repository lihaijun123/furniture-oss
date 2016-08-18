

$(function(){
		var province = $("#province").attr("value1")=="" ? "请选择" : $("#province").attr("value1");
		var city = $("#city").attr("value1")=="" ? "请选择" : $("#city").attr("value1");
	   	setup(province, city);

	   	var initJson = {};
	   	initJson.defaultImage = "/js/uploadFile/no_photo_cn.gif";
		initJson.fileExt = "*.jpg;*.jpeg;*.png";
		initJson.fileDesc = "*.jpg;*.jpeg;*.png";
		veUploadify(initJson, "file_upload1");
		veUploadify(initJson, "file_upload2");
		var initJson3 = {};
		initJson3.fileExt = "*.doc;*.docx;*.xls;*.xlsx;*.jpg;*.jpeg;*.png;*.pdf;*.gif;";
		initJson3.fileDesc = "*.doc;*.docx;*.xls;*.xlsx;*.jpg;*.jpeg;*.png;*.pdf;*.gif;";
		veUploadify(initJson3, "file_upload3");

		$("input[type='checkbox']").each(function(){
			var val = $(this).val();
			var prodObj = $(this);
			$("input[id^='userProductList_']").each(function(){
				var userProdVal = $(this).val();
				if(userProdVal === val){
					prodObj.attr("checked", "checked");
				}
			});
		});

		$("#resetPwd").click(function(){
			if(confirm("确定重置密码？")){
				 $.ajax({
			         type: "POST",
			         url: "/agentUser.do?method=resetpwd",
			         data: {
					 	userId : $("#userId").val()
			     	 },
			         dataType: "json",
			         success: function(data){
			     		 alert("密码重置成功");
			         }
			     });
			}
		});


		$("#agentUser").validate({
	    	onfocusout:function(element){$(element).valid();},
	    	errorPlacement: function(error, element){
	    		error.appendTo(element.parent());
	    	},
	    	rules: {
	    		partnerId:{
	    			required: true,
	    			maxlength: 30
	    		},
	    		userName:{
		    		required: true,
		    		maxlength: 30
		    	},
		    	mobilePhone:{
	    			required: true,
	    			maxlength: 30
	    		},
	    		street:{
	    			required: true,
	    			maxlength: 30
	    		}

	    	},
	    	messages: {
	    		partnerId:{
					required: "请输入合作编号",
					maxlength: "请输入{0}个字以内"
				},
				userName:{
		    		required: "请输入姓名",
		    		maxlength: "请输入{0}个字以内"
		    	},
		    	mobilePhone:{
					required: "请输入手机号",
					maxlength: "请输入{0}个字以内"
				},
				street:{
		    		required: "请输入街道信息",
		    		maxlength: "请输入{0}个字以内"
		    	}
	    	},
	    	submitHandler:function(form){
	    		form.submit();
	    	}
	    });

		$("#downloadsqs").click(function(){
			if(confirm("下载前建议先保存当前页面，是否继续下载？点击”取消“自动保存，点击”确定“开始下载。")){
				window.location.href = $(this).attr("vhref");
			} else {
				if(confirm("是否保存当前页面？")){
					$("form").submit();
				}
			}
		});


});

function getfile_upload1Id(){
	return "idCardFileSn";
}
function getfile_upload2Id(){
	return "kbisFileSn";
}
function getfile_upload3Id(){
	return "contractFileSn";
}