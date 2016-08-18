/**
 * @author yangrongrong
 */
$(document).ready(function(){
	var close = $("#close").val();
	if(close=="close"){
		window.opener.location.reload();
		window.close();
	}
	else if(close=="reload"){
		window.opener.location.reload();
	}
});

