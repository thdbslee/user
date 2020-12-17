function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_join(){
	if(!$("#ID").val()){
		alert("아이디입력하세요");
		return;
	}
	if(!$("#PASSWD").val()){
		alert("비밀번호입력하세요");
		return;
	}
	if(!$("#PASSWD2").val()){
		alert("비밀번호확인하세요");
		return;
	}
	if(!$("#NAME").val()){
		alert("이름입력하세요");
		return;
	}
	if(!$("#PHONE").val()){
		alert("번호입력하세요");
		retrun;
	}
	if(!$("#AGE").val()){
		alert("나이입력하세요");
		return ;
	}
	var pass = $("#PASSWD").val();
	var passcheck = $("#PASSWD2").val();
	if(pass!=passcheck){
		alert("비밀번호값이 일치하지않습니다. 다시 입력하세요");
		return false;	
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/join_ok.do",      
		data: $("#frm").serialize(),
		processData : false,
		success:function(success){
			if(success=="true"){
				alert("가입완료.로그인 후 사용하세요");
				location.href="/login.do"
			}else if(success="false"){
				alert("이미 등록된 ID입니다. 다시입력해주세요")
				return false;
			}
			else{
				alert("등록실패.");
				return false;
			}
		},error:function(indx){
			alert("에러");
		}

	});
	
}

$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});