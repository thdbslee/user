function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_update(){
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/qa_edit_ok.do",
		data:$("#frm").serialize(),
		success:function(data){
			if(data=="true"){
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