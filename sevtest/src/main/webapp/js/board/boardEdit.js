function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	fn_content();
}

function fn_update(){
	if(!$("#TITLE").val()){
		alert("제목을입력하세요");
		return;
	}
	if(!$("#CONTENT").val()){
		alert("내용을입력하세요");
		return false;
	}
	if($("#CONTENT").val().length > 200){
		alert("200자 미만으로 입력하세요");
		return false;
	}
	var frm = $("#frm").serialize();
	var frmData = decodeURIComponent(frm);
//	alert($("#frm").serialize());
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/boardEdit_ok.do",
		data:frmData,
		success:function(data){
			if(data=="ture"){
				alert("수정완료");
				opener.document.location.reload();
				self.close();
			}else{
				alert("수정실패");
			}
		}
	});
}
function fn_content(){
	var content = $("#CONTENT").val();
	$("#cnt").html('<strong>'+content.length+'<strong>' +"/ 200");
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});