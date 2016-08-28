
$(function(){
	$("#parentCatCodeSel").change(function(){
		var parentCode = $(this).val();
		var curObj = $(this);
		curObj.next().remove();
		$("#parentCatCode").val(parentCode);
		if(parentCode > 0){
			$.ajax({
				type: "get",
				url: "/cate.do?method=next",
				data: {
					parentCode : parentCode
				},
				dataType: "json",
				success: function(data){
					if(data){
						var sl = "<select>";
						sl += "<option value='-1'>请选择</option>";
						for(var idx in data){
							var value = data[idx].value;
							var text = data[idx].text;
							sl += "<option value='" + value + "'>" + text + "</option>";
						}
						sl += "</select>";
						curObj.after(sl);
						curObj.next().on("change", function() {
						    var cVal = $(this).val();
						    if(cVal > 0){
						    	$("#parentCatCode").val(cVal);
						    } else {
						    	$("#parentCatCode").val($("#parentCatCodeSel").val());
						    }
						});
					}
				}
			});
		}
	});
	$("#categoryForm").validate({
    	onfocusout:function(element){$(element).valid();},
    	errorPlacement: function(error, element){
    		error.appendTo(element.parent());
    	},
    	rules: {
    		catNameCn:{
    			required: true,
    			maxlength: 30
    		},
    		parentCatCode:{
    			required: true,
    			maxlength: 30
    		}
    	},
    	messages: {
    		catNameCn:{
	    		required: "请输入名称",
	    		maxlength: "请输入{0}个字以内"
	    	},
	    	parentCatCode:{
				required: "请选择上级目录",
				maxlength: "请输入{0}个字以内"
			}
    	},
    	submitHandler:function(form){
    		form.submit();
    	}
    });
});
