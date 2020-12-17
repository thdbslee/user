function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){

}
function fn_edit(){
	console.log("edit");
	$.ajax({
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		type:"POST",  
		url:"/levelEidt_ok.do",      
		data: $("#frm").serialize(),
		success:function(data){ 
			if(data=="true") {
				alert("수정하였습니다.");
				opener.location.reload();
				self.close();
			} else {
				alert("수정에 실패하였습니다");
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