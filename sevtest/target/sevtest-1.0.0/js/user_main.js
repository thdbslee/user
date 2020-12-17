function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	//alert($("#AUTH_CODE").val());
	if($("#AUTH_CODE").val()==1){
		console.log("일반사용자");
		$("#manage").hide();
	}
}

$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
})