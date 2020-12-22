function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	fn_content();
}
function fn_content(){
	var content = $("#CONTENT").val();
	$("#cnt").html('<strong>'+content.length+'<strong>' +"/ 200");
	
}
function fn_add(){
	if(!$("#TITLE").val()){
		alert("제목을 입력하세요");
		return false;
	}
	if(!$("#CONTENT").val()){
		alert("내용을 입력하세요");
		return false;
	}
	if(!$("#CONTENT").val().length > 200){
		alert("200자 미만으로 입력하세요");
		return false;
	}
	var formData = new FormData($("#frm")[0]);
	$.ajax({
	contentType:"application/x-www-form-urlencoded;charset=UTF-8",
	type:"POST",
	url:"/boardInsert_ok.do",      
	data: formData,
	processDate: false,
	async       : false,
	traditional : true,
	processData: false,
	contentType: false,
	success:function(success){
		if(success=="true"){
			alert("게시물 등록완료.");
			opener.document.location.reload();
			self.close();
		}else{
			alert("등록실패.");	
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
})