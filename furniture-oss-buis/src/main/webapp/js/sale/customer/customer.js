/**
 * @author yangrongrong
 */
$(document).ready(function(){
	var phoneSize = $("#phoneSize").val();
	var nameSize = $("#nameSize").val();
	var urlSize = $("#urlSize").val();
	$("#addPhone").bind("click", function(){
		var s1="";
		s1+="<div style ='border' name='"+phoneSize+"'>";
		s1+="<input type='text'  name='phoneInfoList["+phoneSize+"].phoneAreaCode' style = 'width:68px' value ='000'/>- ";
		s1+="<input type='text'  name='phoneInfoList["+phoneSize+"].phoneCode' style = 'width:116px'/>- ";
		s1+="<input type='text'  name='phoneInfoList["+phoneSize+"].phoneExt' style = 'width:116px'/>- ";
		s1+="<input type='text'  name='phoneInfoList["+phoneSize+"].phoneLabel' style = 'width:164px'/>- ";
		s1+="<input type='button'  value='删除' name = 'del'/>";
		s1+="</div>";
		$("#phonelist").append(s1);
		phoneSize++;
    });
	$("input[name='del']").live("click", function() {
		$(this).parent().remove();
    });

	$("#addName").bind("click", function() {
		var name="";
		name+="<div>";
		name+="<input type='text'  name='nameList["+nameSize+"]' style = 'width:116px'/> ";
		name+="<input type='button'  value='删除' name = 'del'/>";
		name+="</div>";
		$("#namelist").append(name);
		nameSize++;
    });

	$("#addUrl").bind("click", function() {

		var url="";
		url+="<div>";
		url+="<input type='text'  name='urlList["+urlSize+"]' style = 'width:116px'/> ";
		url+="<input type='button'  value='删除' name = 'del'/>";
		url+="</div>";
		$("#urllist").append(url);
		urlSize++;
    });

	var province = $("#province").attr("value1")=="" ? "请选择" : $("#province").attr("value1");
	var city = $("#city").attr("value1")=="" ? "请选择" : $("#city").attr("value1");
   	setup(province, city);
});

function check(){
	$("#form").attr("action","/sale/customer.do?method=check");
	$("#form").attr("target","_blank");
	$("#form").submit();
}
function submitclick(){
	$("#form").attr("action","/sale/customer.do");
	$("#form").removeAttr("target");
	$("#form").submit();
}
function delclick(sn){
	if(confirm("确认置为撞单么？（置为撞单后本客户会删除哒！！！）")){
		window.location="/sale/customer.do?method=del&sn="+sn+"&list="+$("#list").val();
	}
}

