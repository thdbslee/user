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
function fn_add(){
	/*var a = $("#STWORK").val();
	var mm = a.substr(0,2);
	console.log("월"+mm);
	var dd=  a.substr(3,2);
	console.log("일"+dd)
	var yy = a.substr(6,4);
	console.log("년도"+yy);
	var date = yy+"-"+mm+"-"+dd;
	console.log("날짜->"+date);
	$("#STWORK").val(date);*/


	if(!$("#NAME").val()){
		alert("이름 입력하세요");
		return;
	}
	if(!$("#ID").val()){
		alert("아이디입력하세요");
		return;
	}
	if(!$("#PASSWD").val()){
		alert("비밀번호입력하세요");
		return;
	}
	if(!$("#PHONE").val()){
		alert("폰번호입력하세요");
		return;
	}
	if(!$("#AGE").val()){
		alert("나이입력하세요");
		return;
	}
	if(!$("#STWORK").val()){
		alert("입사일 or 입사예정일 선택하세요");
		return;
	}
	
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/workInsert_ok.do",      
		data: $("#frm").serialize(),
		processData : false,
		success:function(success){
			if(success=="TRUE"){
				alert("등록완료.");
				opener.document.location.reload();
				self.close();
			}else if(success="false"){
				alert("아이디중복입니다.다시입력하세요");
				return;
			}
			else{
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
});