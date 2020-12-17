function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_edit(){
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/noticeUpdate_ok.do",   
		processData : true,
		data: $("#frm").serialize(),
		success:function(success){
			if(success=="true"){
				alert("수정완료.");
				location.href="/notice.do";
			}else{
				alert("삭제실패.");	
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