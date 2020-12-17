function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});