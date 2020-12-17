function fn_onload(){
	fn_setDefault();
}
function fn_setDefault(){

}
function fn_passwdchange(){
	if(!$("#OLDPASSWD").val()){
		alert("현재비밀번호를 입력하세요");
		return ;
	}
	if(!$("#NEWPASSWD").val()){
		alert("비밀번호 입력하세요");
		return ;
	}
	if(!$("#PASSWDCHK").val()){
		alert("비밀번호 확인 입력하세요")
		return;
	}
	if($("#NEWPASSWD").val()!=$("#PASSWDCHK").val()){
		alert("변경할비밀번호와 비밀번호확인값이 다릅니다.다시확인하세요");
		return;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		type:"POST",  
		url:"/passwdchange_ok.do",      
		data: $("#frm").serialize(),
		success:function(data){ 
			if(data=="Y") {
				alert("비밀번호 변경 완료.");
				opener.location.reload();
				self.close();
			} else {
				alert("현재 비밀번호값이 틀립니다. 다시입력하세요");
				return;
			}
		}
	});
}
function goMsgError(msg) {
	$('#dialogMsg').html(msg);

	$('#dialog').dialog({//해당 id로 지정된 내용의 다이얼로그 생성
		modal:true
		,title:'정보'
		,dialogClass:'dialog'
		,width:'auto'
   
	});
	$("#dialog").dialog("option","buttons",[
		{
			text:"확인",
			click:function(){
				$(this).dialog("close");
			}
		}
	]);
}
$(document).ready(function(){
	try{
		fn_onload();
	}catch(e){
		alert(e.message);
	}
});