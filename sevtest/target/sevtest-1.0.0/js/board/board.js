function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){



}
function fn_add(){
	window.open("/boardInsert.do",'insert','width=600px,height=800px');
}
function fn_detail(INX){
	window.open("/boardDetail.do?INX="+INX,'detail','width=600px,height=800px');
}
function fn_edit(){
	if($("input[name='INX_CHK']:checked").length < 1){
		alert("수정할 게시판 선택하세요");
		return;
	}
	if($("input[name='INX_CHK']:checked").length > 1){
		alert("수정할 게시판 하나만 선택하세요");
		return;
	}
	var INX_CHK= $("input[name='INX_CHK']:checked").val();
	window.open("/boardEdit.do?INX="+INX_CHK,'update','width=600px,height=1000px');
}
function fn_delete(){
			if(!confirm('선택한 사용자 삭제하시겠습니까 ?')){
				return;
			}
			$.ajax({
				contentType:"application/x-www-form-urlencoded;charset=UTF-8",
				type:"POST",
				url:"/boardDelete.do",      
				data: $("#boardfrm").serialize(),
				processData : false,
				success:function(success){
					if(success=="true"){
						alert("삭제완료");
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