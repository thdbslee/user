function fn_onload(){
	fn_setDefault();
}
function fn_setDefault(){
	console.log("fn_setDefault");
	fn_content();
}
function fn_add(){
		
		if(!$("#TITLE").val()){
			alert("제목을 입력하세요");
			return;
		}
		if(!$("#CONTENT").val()){
			alert("내용을 입력하세요");
			return;
		}
		var content = $("#CONTENT").val();
		if(content.length > 200){
			alert("200자 미만으로 입력하세요");
			return false;
		}
		var formData = new FormData($("#frm")[0]);
		$.ajax({
			contentType:"application/x-www-form-urlencoded;charset=UTF-8",
			type:"POST",
			url:"/noticeInsert_ok.do",      
			data: formData,
			processDate: false,
			async       : false,
			traditional : true,
			processData: false,
			contentType: false,
			success:function(success){
				if(success=="true"){
					alert("공지사항 등록완료.");
					location.href="/notice.do";
				}else{
					alert("등록실패.");	
				}
			},error:function(indx){
				alert("에러");
			}
		});
	}
function fn_content(){
	console.log("content");
	var content = $("#CONTENT").val();
	$("#cnt").html('<strong>'+content.length+'</strong>'+"/200");
}
$(document).ready(function(){
	try{
		fn_onload();
	}catch(e){
		alert(e.message);
	}
});