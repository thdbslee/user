function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_userEdit(){

	$.ajax({
		contentType :"application/x-www-form-urlencoded;charset=UTF-8",
			type    :"POST",
			data 	:$("#frm").serialize(),
			url 	:"/setting_eidt.do",
			success : function(data){
				if(data=="true"){
					alert("사용자 정보 변경완료");
					location.href="/userMain.do";
				}else if(data=="N"){
					alert("비밀번호맞지않습니다.");
				}
				else{
					alert("변경실패");
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