function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_add(){
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