$(document).ready(function(){
	var initJson = {};
	initJson.multi = false;
	initJson.simUploadLimit=1;
	initJson.sizeLimit = 2097152;//2M
	initJson.queueSizeLimit= 3;//图片数量
//	initJson.fileDesc = "图像文件(*.gif,*.jpg,*.jpeg,*.png,*.bmp)";
//	initJson.fileExt = "*.gif;*.jpg;*.jpeg;*.png;*.bmp";//图片格式
	initJson.fileDesc = "图像文件(*.jpg,*.jpeg,*.png,*.bmp)";
	initJson.fileExt = "*.jpg;*.jpeg;*.png;*.bmp";//图片格式
	initJson.onComplete = uploadComplete;
	veUploadify(initJson, "file_upload");
	initJson.onComplete = uploadComplete1;
	veUploadify(initJson, "file_upload1");

	 //图片删除
	 $(".upBox").live("click",function(){
	 	var _this = this;
	 	vConfirm("你确定要删除此图片吗？","",function(r){
			if (r) {
			 	$(_this).parent().remove();
			}
		});
	 });
	//地区联动
		if ($("#userArea").val() !== null) {
	        var _pareaGear = $("#userArea").areaGear({
	            divPopId: "userArea",
	            mode: "simple",
	            gearCustom: [{
	                url: "/areaGear.do?method=getProvince",
	                dataPar: "",
	                id: "province",
	                name: "province",
	                defkey: $("#provinceHidden").val(),
	                attVal: "省份",
	                setDef: null,
	                show: true
	            }, {
	                url: "/areaGear.do?method=getCity",
	                dataPar: "province",
	                id: "city",
	                name: "city",
	                defkey: $("#cityHidden").val(),
	                attVal: "城市",
	                setDef: null,
	                show: true
	            }]
	        });
		}
		if($("#dateslip_end_dis").val()===""){
			$("#dateslip_end_dis").val("长期");
		}
		//长期操作
		$("#opeProd_long").click(function(){
			$("#dateslip_end_dis").val("长期");
		});
	    //即时提醒
	    $("#dateslip_end_dis,#dateslip_start").bind("blur",function(){
			$(this).closest("td").find(".errors").remove();
	    	if($("#dateslip_end_dis").val() !== "" && $("#dateslip_start").val() !== "" && $("#dateslip_end_dis").val() !== "长期"){
	    		if($("#dateslip_end_dis").val() <= $("#dateslip_start").val()){
	    			vAlertWarning("经营期限的开始时间必须小于结束时间！");
	    			$(this).val("");
	    		}
	    	}
			if($("#dateslip_end_dis").val() === ""){
				$(".errors[name='opeProdEnd']").remove();
				//$(this).closest("td").find("div[htmlfor='dateslip_end_dis']").remove();
				$(this).closest("td").append("<span class='errors'>请您输入经营期限的结束时间！</span>");
			}
			if($("#dateslip_start").val() === ""){
				$(this).closest("td").append("<span class='errors'>请您输入经营期限的开始时间！</span>");
			}
	    });

	    $("input[name='businessScope']").live("click",function (){
	    	if($(this).attr("checked")){
	    		if($("input:checked[name='businessScope']").length > 10){
	    			$(this).attr("checked",false);
	    			vAlertWarning("最多只能选择十类！");
	    		}
	    	}
	    });

	    //年检初始操作
	    if($("input:checked[name='isInspection']").val()=== "0"){
	    	$("input[name='inspection']").attr("disabled" , "disabled");
    		$("input[name='inspection']").attr("checked" , false);
	    }
	    //年检是否可操作
	    $("input[name='isInspection']").live("click",function (){
	    	if($(this).val() === "0"){
	    		$("input[name='inspection']").attr("disabled" , "disabled");
	    		$("input[name='inspection']").attr("checked" , false);
	    	}else{
	    		$("input[name='inspection']").removeAttr("disabled");

	    	}
	    });

	//联系方式即时校验
    $("#phoneCountryNo,#phoneCityNo,#phoneNo").blur(function() {
		$(this).closest("td").find(".errors").remove();
        var phoneCountryNo = $.trim($("#phoneCountryNo").val());
        var phoneCityNo = $.trim($("#phoneCityNo").val());
        var phone = $.trim($("#phoneNo").val());
		if(phoneCountryNo != "" && !/^[0-9A-Za-z]+$/.test(phoneCountryNo)){
			$(this).parent().append("<span class='errors'>请填写数字，英文字母，分机用\"-\"分割！</span>");
			$("#appPhone").val("");
			return;
		}
		if(phoneCityNo != "" && !/^[0-9A-Za-z]+$/.test(phoneCityNo)){
			$(this).parent().append("<span class='errors'>请填写数字，英文字母，分机用\"-\"分割！</span>");
			$("#appPhone").val("");
			return;
		}
		if(phone != "" && !/^[0-9A-Za-z\-]+$/.test(phone)){
			$(this).parent().append("<span class='errors'>请填写数字，英文字母，分机用\"-\"分割！</span>");
			$("#appPhone").val("");
			return;
		}
		var allFill = phoneCountryNo !== "" && phoneCityNo !== "" && phone !== "";
		if (allFill) {
		    $("#appPhone").val(phoneCountryNo+phoneCityNo+phone);
		 } else {
		 	$("#appPhone").val("");
		    $(this).closest("td").append("<span class='errors'>国家区号，城市区号，电话号码都不能为空！</span>");
		 }
    });
	    $("#saveInfor_B").click(function(){
			$(".errors").remove();
	    	//年检检测
	    	//$("#isInspection_1").parent().parent().find(".errors").remove();
	    	if($("#isInspection_1").attr("checked")===true){
	    		var ok = false;
	    		$("input[name='inspection']").each(function(){
	    			if($(this).attr("checked")){
	    				ok=true;
	    				return false;
	    			}
	    		});
	    		if(!ok){
	    			$("#isInspection_1").parent().parent().append("<span class='errors'>请选择年检记录！</span>");
	    		}else{
	    			$("#isInspection_1").parent().parent().children(".errors").remove();
	    		}
	    	}
	    	//注册号检测
	    	$("#regNumber").blur();
	    	//联系方式检测
	    	$("#phoneCountryNo").blur();
			//经营期限的结束日期
			var opeRangeEnd = $("#dateslip_end_dis").val();
			if(opeRangeEnd==="长期"){
				$("#dateslip_end").val("");
			}else{
				$("#dateslip_end").val(opeRangeEnd);
			}
			//发送邮件中返回意见为空检测
			if($("#auth_fail").attr("checked")){
				if($("#auditRemark").val() === ""){
					$("#auditRemark").after("<span class='errors'>请填写邮件中的返回意见！</span>");
					return;
				}else{
					$("#auditRemark").parent().find(".errors").remove();
				}
			}
	    	if($("body").find(".errors").length>0)
	    		return;
	    	$("form").submit();
	    });
	    //返回意见
	    $("#xinxi1,#xinxi2,#xinxi3").click(function(){
	    	var remark = $("#auditRemark").val();
			if($("#auditRemark").val()==="")
	    		$("#auditRemark").val($(this).parent().children("p").html());
	    	else
	    		$("#auditRemark").val(remark+$(this).parent().children("p").html());
		});

	    //公司信息查找
	    $("#findCompanyInfo").click(function(){
	    	$.get("/real-name-auth.do?method=findCompanyInfo&memberInfoSn="+
	    			$(this).parent().children("input[type='hidden']").val(),
	    			function(msg){
	    			var data = (new Function("return " + msg))();
	    			$("#companyName_span").text(data.companyName);
	    			$("#memberId_span").text(data.memberId);
	    			$("#memberStatus_span").text(data.memberStatus);
	    	});
	    });

	    //注册号（纯数字）
	    $("#regNumber").blur(function(){
	    	var str = $(this).val();
			var exc = /^\+?[0-9][0-9]*$/;
			if (!exc.test(str)){
				if($(this).parent().find(".errors").length === 0)
					$(this).after("<span class='errors'>注册号格式错误，请输入阿拉伯数字！</span>");
				return;
			}else
				$(this).parent().children(".errors").remove();
	    });
	    //联系方式（英文或者阿拉伯数字）
	    $("#appPhone").blur(function(){
	    	var str = $(this).val();
			var exc = /^[0-9A-Za-z]+$/;
			if (!exc.test(str)){
				if($(this).parent().find(".errors").length === 0)
					$(this).after("<span class='errors'>号码中含有非法字符，请使用英文字符和阿拉伯数字！</span>");
				return;
			}else
				$(this).parent().children(".errors").remove();
	    });
		//注册资本校验（非负浮点数（以非零开头、正浮点数））
	    $("#regCapital").blur(function(){
	    	var str = $(this).val();
			var exc = /(^[1-9]+[0-9]*)((\.?[0-9]+)|([0-9]*))$/;
			if (!exc.test(str)){
				if($(this).closest("td").find(".errors").length === 0)
					$(this).closest("td").append("<span class='errors'>请输入正确格式的注册资本！</span>");
				return;
			}else
				$(this).parent().children(".errors").remove();
	    });
		// 自动截取
	    $("input").bind("paste", function() {
			//只有是数值型的才能取值为数值，其他形式（非数值、为空、未定义等）的都为-1
			var maxStr= $(this).attr("maxlength");
			if( maxStr !==""){
				var max = parseInt($(this).attr("maxlength"));
				if(max>0){
			        $(this).parent().children("div").remove();
			        $(this).autoTrancate(max);
				}
			}
	    });
		$("#dateslip_end_dis").attr("name","");
		$("#telephone").blur(function(){
	    	var str = $(this).val();
			var exc = /^[0-9A-Za-z\-]+$/;
			if (!exc.test(str)){
				if($(this).closest("td").find(".errors").length === 0)
					$(this).closest("td").append("<span class='errors'>请填写数字，英文字母，分机用\"-\"分割！</span>");
				return;
			}else
				$(this).parent().children(".errors").remove();
	    });
});

function uploadComplete(event, ID, fileObj, response, data){
	if($("input[name='blCopy']").length >= 3){
		$(".uploadifyQueue").html("");
		$(this).parent().find(".cancel").click();
		vAlertWarning("最多只能上传3张图片！");
	 }else{
		//$("#pic").uploadifyUpload();
		//等比例压缩处理
		var oldPic = $("#hiddenPic").val();
	    var data = (new Function("return " + response))();
	    data = data[0];
	    if (oldPic !== "") {
//	        deleteFileById(oldPic);
	    }
	    //增加展示图片
	    picView(data.fileUrl,data.fileId,"blCopy");
	 }
}
function uploadComplete1(event, ID, fileObj, response, data){
	if($("input[name='authCopy']").length >= 3){
		$(".uploadifyQueue").html("");
		$(this).parent().find(".cancel").children("a").click();
		vAlertWarning("最多只能上传3张图片！");
	}else{
//		$("#pic1").uploadifyUpload();
		var oldPic = $("#hiddenPic").val();
	    var data = (new Function("return " + response))();
	    data = data[0];
	    if (oldPic !== "") {
//	        deleteFileById(oldPic);
	    }
	    //增加展示图片
	    picView(data.fileUrl,data.fileId,"authCopy");
	 }
}

//图片展示
function picView(url,fileId,obj){
		var htmlPic="";
		htmlPic +="<div class=\"imgBox\" style=\"margin-top:5px;\" >";
			htmlPic +="<a href=\"javascript:deleteImg('"+fileId+"')\" class=\"upBox\">";
				htmlPic +="<img src=\"images/ico_close_red.gif\" alt=\"取消\"/>";
			htmlPic +="</a>";
			htmlPic +="<img src='"+url+"' width=\"100px;\" height=\"100px;\" name='"+fileId+"' class=\"upImage\" />";
		htmlPic +="<input type='hidden' value='"+fileId+"' name='"+obj+"'></div>";
		$(htmlPic).appendTo("#"+obj);
}