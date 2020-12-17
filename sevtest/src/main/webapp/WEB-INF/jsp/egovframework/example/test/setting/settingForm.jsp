<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
<script type="text/javascript" src="/js/setting/settingForm.js" ></script> 
<!DOCTYPE html>
<html lang="en">
   
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                     style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">MyPage</h1>
      					<div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                개인정보 보호를 위해 비밀번호를 다시확인합니다.
                            </div>
                            <div>
                                <div>
                                <form id="frm" name="frm">
                               		<input type="hidden" id="ID" name="ID" value="${loginvo.ID}">
                                    <table  width="100%" cellspacing="0">
                                      	<tbody>
                                      		<tr>
                                      			<th>비밀번호입력</th>
                                      			<td  align="left"><input type="password" id="PASSWD" name="PASSWD"></td>
                                      		</tr>
                                      	</tbody>
                                    </table>
                                    <a align="center" href="javascript:fn_confirm()" class="button">확인</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
              
            </div>
        </div>
      
    </body>
</html>

<style>

.button {

  background-color: black;

  border: none;

  color: white;

  padding: 5px 3px;

  text-align: center;

  text-decoration: none;

  display: inline-block;

  font-size: 16px;

  margin: 4px 2px;

  cursor: pointer;

}

</style>
<script>
function fn_changePasswd(){
	window.open("/changePasswd.do",'passwdchange','width=450,height=300');
}
</script>
