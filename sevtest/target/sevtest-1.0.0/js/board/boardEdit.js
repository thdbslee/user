function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	console.log("editsetDefault");
}
function fn_update(){
	console.log("update");
	if(!$("#TITLE").val()){
		alert("제목을입력하세요");
		return;
	}

	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/boardEdit_ok.do",
		data:$("#frm").serialize(),
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
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});