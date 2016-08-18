$(function (){

    //页面加载成功后值处理
	doDefaultValue();
	clearProdCat();

	//频道值改变时检测
	$(":checkbox[name='sourceTypes']").change(function(){
		var isProdCat=false;//默认目录无效

		//匹配类型中不含“排除”则增加“排除”类型
		if($(":radio[name='matchType'][value='3']").size()<=0){
			var _dataRadio="<label for=\"matchType_3\" >";
			_dataRadio += "<input id=\"matchType_3\" type=\"radio\" name=\"matchType\" value=\"3\" />排除";
			_dataRadio +="</label>";
			$("#matchType").append(_dataRadio);
		}
		//遍历频道
		$(":checkbox[name='sourceTypes'][checked=true]").each(function(){
			//如果频道中含有非搜索的频道，则去掉“排除”匹配类型
			if($(this).val()!=="3" && $(this).val()!=="4" && $(this).val()!=="5" && $(":radio[name='matchType'][value='3']").size()>0){
				$(":radio[name='matchType'][value='3']").parent("label").remove();
			}
			//如果频道中含“后台会员信息/产品审核”，则置目录有效标识为true
			if($(this).val()==="2"){
				isProdCat=true;
			}
		});

		//如果频道中不含“后台会员信息/产品审核”，则目录文本框置灰、失效，同时移除“清除目录”
		if(!isProdCat){
			$("#prodCatName").attr("disabled",true);
			if ($("#clearProdCat").size() > 0) {
				$("#clearProdCat").remove();
			}
		}
		else{
			$("#prodCatName").attr("disabled",false);
			if($("#clearProdCat").size()<=0){
			   $("#prodCatCode").after("<a href='javascript:void(0);' id='clearProdCat'>清除目录</a>");
			   clearProdCat();
			}
		}
	});

	//如果是精确匹配，则对敏感词空格进行过滤
	$("#sourceValue").change(function(){
		var sourceValue=$.trim($("#sourceValue").val());
		var matchType=$(":radio[name='matchType'][checked=true]").val();
        if (sourceValue !== "" && matchType === "1" && (sourceValue.indexOf(" ") > 0 || sourceValue.indexOf("　") > 0)) {
            alert("精确匹配敏感词只能输入单个英文词，中间不允许有空格隔开！");
        }
		//将全角空格转换成半角空格
		if(sourceValue !== "" && matchType !== "1" &&  sourceValue.indexOf("　") > 0){
			$("#sourceValue").val(sourceValue.replace(new RegExp("　")," "));
		}
	});
	$("#matchType").change(function(){
		$("#sourceValue").change();
	});

});

function doDefaultValue(){
	var isProdCatLoad=false;//默认目录无效
	$(":checkbox[name='sourceTypes'][checked=true]").each(function(){
		//加载时，如果频道中含有非搜索的频道，则去掉“排除”匹配类型
		if($(this).val()!=="3" && $(this).val()!=="4" && $(this).val()!=="5" && $(":radio[name='matchType'][value='3']").size()>0){
			$(":radio[name='matchType'][value='3']").parent("label").remove();
		}
		//加载时，如果频道中含“后台会员信息/产品审核”，则置目录有效标识为true
		if($(this).val()==="2"){
			isProdCatLoad=true;
		}
	});
	if(!isProdCatLoad){
	    //如果频道中不含“后台会员信息/产品审核”，则目录文本框置灰、失效，同时移除“清除目录”
		$("#prodCatName").attr("disabled",true);
		if ($("#clearProdCat").size() > 0) {
			$("#clearProdCat").remove();
		}
	}
	else{
		$("#prodCatName").attr("disabled",false);
		if($("#clearProdCat").size()<=0){
		   $("#prodCatCode").after("<a href='javascript:void(0);' id='clearProdCat'>清除目录</a>");
		   clearProdCat();
		}
	}
}

//清除目录
function clearProdCat(){
	$("#clearProdCat").click(function(){
		$("#prodCatName").val("");
		$("#prodCatCode").val("");
	});
}

function checkForm(){
    //如果是精确匹配，则对敏感词空格进行过滤
    var sourceValue = $.trim($("#sourceValue").val());
    var matchType = $(":radio[name='matchType'][checked=true]").val();
    if (sourceValue !== "" && matchType === "1" && (sourceValue.indexOf(" ") > 0 || sourceValue.indexOf("　") > 0)) {
        alert("精确匹配敏感词只能输入单个英文词，中间不允许有空格隔开！");
        return false;
    }
    else {
		if(sourceValue !== "" && matchType !== "1" &&  sourceValue.indexOf("　") > 0){
			//将全角空格转换成半角空格
			$("#sourceValue").val(sourceValue.replace(new RegExp("　")," "));
		}
        return true;
    }
}
