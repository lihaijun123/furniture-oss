$(function(){
	$("#appConfig").validate({
    	onfocusout:function(element){$(element).valid();},
    	errorPlacement: function(error, element){
    		error.appendTo(element.parent());
    	},
    	rules: {
    		keyName:{
    			required: true,
    			maxlength: 30
    		},
	    	type:{
	    		required: true,
	    		maxlength: 4
	    	}
    	},
    	messages: {
    		keyName:{
				required: "请输入版本名称",
				maxlength: "请输入{0}个字以内"
			},
	    	type:{
	    		required: "请选择产品类型",
	    		maxlength: "请输入{0}个字以内"
	    	}
    	},
    	submitHandler:function(form){
    		form.submit();
    	}
    });
	//本地配置
	var localTableName = "localTable";
	var localRmLinePrefixName = "rmLocalLine_";
	var localValueFieldPrefixName = "localValues";
	addLocalTableClickEvent("addLocalLine", localTableName, localRmLinePrefixName, localValueFieldPrefixName);

	//阿里云配置
	var cloudTableName = "cloudTable";
	var cloudRmLinePrefixName = "rmCloudLine_";
	var cloudValueFieldPrefixName = "cloudValues";
	addLocalTableClickEvent("addCloudLine", cloudTableName, cloudRmLinePrefixName, cloudValueFieldPrefixName);
});


function addLocalTableClickEvent(clickTag, tableName, rmLinePrefixName, valueFieldPrefixName){
	$("#" + clickTag).click(function() {
		var tableLength = $("#" + tableName + " tr").length;
		operationLine(tableName, tableLength, rmLinePrefixName, valueFieldPrefixName);
	});
	//删除行
	$("span[id^='" + rmLinePrefixName + "']").click(function() {
		if(($("#" + tableName + " tr").length) > 1){
			$(this).parent().parent().remove();
		}
	});
}

function operationLine(localTableName, localTableLength, rmLinePrefixName, valueFieldPrefixName){
	var newTr = $("#" + localTableName + " tr").eq(localTableLength - 1).clone();
	//删除行
	newTr.find("span[id^='" + rmLinePrefixName + "']").each(function(){
		//更改name
		var name = $(this).attr("id");
		$(this).attr("id", rmLinePrefixName + localTableLength);
		$(this).show();
		//绑定事件
		$(this).bind("click", function(){
			if(($("#" + localTableName + " tr").length) > 1){
				$(this).parent().parent().remove();
			}
		});
	});
	//修改域
	newTr.find("input[type='text']").each(function(){
		//更改name
		var name = $(this).attr("name");
		if(name.indexOf("key") != -1){
			$(this).attr("name", valueFieldPrefixName + "[" + localTableLength +  "].key");
		}
		if(name.indexOf("value") != -1){
			$(this).attr("name", valueFieldPrefixName + "[" + localTableLength +  "].value");
		}

	});
	newTr.insertAfter("#" + localTableName + " tr:last");
}