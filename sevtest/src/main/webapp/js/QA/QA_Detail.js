function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	fn_content();
}
function fn_content(){
	var content=$("#CONTENT").val();
	$("#cnt").html('<strong>'+content.length+'</strong>'+"/100");
}
function fn_add(){
	var content = $("#CONTENT").val();
	if(content.length > 100){
		alert("100자 미만으로 입력하세요");
		return false;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/answer_ok.do",   
		processData : true,
		data: $("#QAfrm").serialize(),
		success:function(success){
			if(success=="true"){
				alert("등록완료.");
				location.reload();
			}else{
				alert("등록실패.");	
			}
		}
	});
}
function fn_close(){
	opener.parent.location.reload();
	window.close();
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});