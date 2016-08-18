$(function (){
	$("select[name='SOURCE_TYPE']").change(function(){
		var oldVal=$("select[name='SOURCE_TYPE']").val();
		var oldOper=$("select[name='SOURCE_TYPE'] + :hidden[name='searchOper']").val();
		if(oldVal!=""){
			$("select[name='SOURCE_TYPE'] + :hidden[name='searchOper']").val("like");
		}
	});
});