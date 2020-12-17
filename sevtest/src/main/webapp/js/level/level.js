function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){

}
function fn_add(){

	window.open("/level_insert.do",'insert','width=500px,height=500px;');
}
function fn_detail(INX){
	console.log("fn_detail");
	window.open("/level_detail.do?INX="+INX,'detail','width=700px,height=800px');
}
function fn_edit(){
	if($("input[name='INX']:checked").length  < 1){
		alert("수정할 게시물 선택하세요");
		return;
	};
	if($("input[name='INX']:checked").length > 1){
		alert("수정할 게시물 하나만 선택하세요");
		return;
	}
	var INX = $("input[name='INX']:checked").val();
   
	window.open("/level_edit.do?INX="+INX,'edit','width=500px,height=500px;');
	
}
function fn_delete(){
	if($("input[name='INX']:checked").length < 1){
		alert("삭제할 게시물을 선택하세요");
		return ; 
	}

	if(!confirm('선택한 사용자 삭제하시겠습니까 ?')){
		return;
	}
	
	$.ajax({
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		type:"POST",  
		url:"/levelDelete.do",      
		data: $("#frm").serialize(),
		success:function(data){ 
			if(data=="true") {
				alert("삭제완료");
				location.reload();
			} else {
				alert("삭제 실패");
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