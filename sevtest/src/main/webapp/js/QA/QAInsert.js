function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_add(){
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