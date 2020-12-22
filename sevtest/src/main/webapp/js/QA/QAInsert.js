function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	fn_content();
}
function fn_content(){
	var content = $("#CONTENT").val();
	$("#cnt").html('<strong>'+content.length+'</strong>'+"/200");
}
function fn_add(){
	if(!$("#TITLE").val()){
		alert("제목을 입력하세요");
		return false;
	}
	if(!$("#CONTENT").val()){
		alert("내용을 입력하세요");
		return false;
	}
	var content = $("#CONTENT").val();
	if(content.length > 200){
		alert("200자 미만으로 입력하세요");
		return false;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/qa_insert_ok.do",
		data:$("#frm").serialize(),
		success:function(data){
			if(data=="true"){
				alert("등록완료");
				opener.document.location.reload();
				self.close();
			}else{
				alert("등록실패");
			}
		}
	})
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});