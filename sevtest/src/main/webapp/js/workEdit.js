function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	$("#STWORK").datepicker();
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
}
function fn_edit(){

	
	console.log("edit");
	$.ajax({      
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		type:"POST",  
		url:"/workEdit_ok.do",      
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
})