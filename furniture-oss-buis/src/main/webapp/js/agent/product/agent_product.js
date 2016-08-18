
$(function(){

	$("#agentProduct").validate({
    	onfocusout:function(element){$(element).valid();},
    	errorPlacement: function(error, element){
    		error.appendTo(element.parent());
    	},
    	rules: {
    		name:{
    			required: true,
    			maxlength: 15
    		},
    		price:{
	    		required: true,
	    		maxlength: 15,
	    		number: true

	    	}
    	},
    	messages: {
    		name:{
				required: "请输入名称",
				maxlength: "请输入{0}个字以内"
			},
			price: {
	    		required: "请输入价格",
	    		maxlength: "请输入{0}个字以内",
	    		number: "请输入正确的价格"
	    	}
    	},
    	submitHandler:function(form){
    		form.submit();
    	}
    });
});
