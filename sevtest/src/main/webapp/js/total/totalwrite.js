function fn_onload(){
	
	fn_setDefault();
}
function fn_setDefault(){
}
function fn_detail(RNUM){
	
	location.href="/total_detail.do?RNUM="+RNUM;
	$("#RNUM").val(RNUM);
}
function fn_search(){
	$("#frm").submit();
}
function fn_delete(){
	
	
}
$(document).ready(function(){
	try{
		fn_onload();
	}catch(e){
		alert(e.message);
	}
});