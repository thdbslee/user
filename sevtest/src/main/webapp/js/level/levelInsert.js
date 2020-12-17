function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){

}
function fn_insert(){
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/level_insert_ok.do",
		data:$("#frm").serialize(),
		success:function(data){
			if(data=="true"){
				alert("등록완료");
				opener.document.location.reload();
				self.close();
			}else if(data=="upgrade"){
				alert("등록완료");
				alert("등업완료 자유게시판 이용가능합니다.");
				opener.document.location.reload();
				self.close();
			}
			else{
				alert("등록실패");
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