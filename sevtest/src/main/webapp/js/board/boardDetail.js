function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_cmdelete(inx){

	$("#delInx").val(inx);
	if(!confirm('댓글삭제하시겠습니까?')){
		return;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/comDelete.do",
		data:$("#frm").serialize(),
		success:function(data){
			if(data=="true"){
				alert("댓글삭제완료");
				location.reload();
			}else{
				alert("삭제실패");
			}
		}
	});
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	$("#pageIndex").val(pageNo);
	document.frm.action = '/boardDetail.do';
   	document.frm.submit();
	
}

function fn_close(){
	opener.document.location.reload();
	self.close();
}
function fn_add(){
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/comment_ok.do",   
		processData : true,
		data: $("#frm").serialize(),
		success:function(success){
			if(success=="true"){
				alert("등록완료.");
				location.reload();
			}else{
				alert("등록실패.");	
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