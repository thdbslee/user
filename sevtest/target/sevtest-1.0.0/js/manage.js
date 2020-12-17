function fn_onLoad(){
	fn_DefaultSet();
}
function fn_DefaultSet(){

}
function fn_add(){
	console.log("add");
	window.open("/workInsert.do","inser2t",'width=400, height=200, scrollbars=no, resizable=no, toolbars=no, menubar=no');
}
function fn_edit(){
//	console.log("inx_check->"+$("input[name='inx_check']:checked").val());
	
	var len = $("input[name='inx_check']:checked").length;
	if(len == 0){
		alert("수정할 사용자 체크하세요");
		return false;
	}
	if(len > 1){
		alert("수정할 사용자 하나만 선택하세요");
		return false;
	}
	var selectInx = $("input:checkbox[name='inx_check']:checked").val();
	window.open("/workEdit.do?INX="+selectInx, 'edit','width=400, height=200, scrollbars=no, resizable=no, toolbars=no, menubar=no');
	
	
}
function fn_delete(){
	console.log("delete");
	if($("input[name='inx_check']:checked").length == 0){
		alert("삭제할 사용자 하나만 선택하세요");
		return false;
	}
	if(!confirm('선택한 사용자 삭제하시겠습니까 ?')){
		return;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/workDelete.do",      
		data: $("#frm").serialize(),
		processData : false,
		success:function(success){
			if(success=="true"){
				alert("삭제완료");
				location.reload();
				
			}else{
				alert("삭제실패.");	
			}
		},error:function(indx){
			alert("에러");
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