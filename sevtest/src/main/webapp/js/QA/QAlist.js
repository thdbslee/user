function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_detail(INX){
	window.open("/qa_detail.do?INX="+INX,'detail','width=600px; height=600px;');
}
function fn_add(){
	window.open("/qa_insert.do",'insert','width=400px; heigth=400px;');
}
function fn_edit(){
	if($("input[name='INX']:checked").length < 1){
		alert("수정할 게시판을 선택하세요");
		return false;
	}
	if($("input[name='INX']:checked").length > 1){
		alert("수정할 게시판 하나만 선택하세요 ");
		return false;
	}
	var INX = $("input[name='INX']:checked").val();
	console.log(INX);
	window.open("/qa_edit.do?INX="+INX,'edit','width=300px; height=300px;');
}
function fn_delete(){
	
	console.log($("input[name='INX']:checked").length);
	if($("input[name='INX']:checked").length == 0){
		alert("삭제할 게시물을 선택하세요");
		return ;
	}
	if(!confirm('선택한 게시물 삭제하시겠습니까 ?')){
		return;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/qaDelete.do",   
		processData : true,
		data: $("#frm").serialize(),
		success:function(success){
			if(success=="true"){
				alert("삭제완료.");
				location.reload();
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
		alert(e.message);
	}
});