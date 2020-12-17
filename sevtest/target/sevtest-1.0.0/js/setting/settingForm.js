function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	console.log("default");
}
function fn_confirm(){

	$.ajax({
		contentType :"application/x-www-form-urlencoded;charset=UTF-8",
		type    :"POST",
		data 	:$("#frm").serialize(),
		url 	:"/setting_passwd.do",
		success : function(data){
			if(data=="true"){
				location.href="/setting_edit_form.do";
			}else{
				alert("비밀번호일치하지않습니다.");
			}
		}
	});
}

$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e).message;
	}
});