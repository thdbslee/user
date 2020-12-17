<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
 <script type="text/javascript" src="/js/setting/setting.js" ></script> 
<!DOCTYPE html>
<html lang="en">
    <head>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                     style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">MyPage</h1>
      					<div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                MyPage
                            </div>
                            <div>
                                <div>
                                <form id="frm" name="frm">
                                    <table  width="100%" cellspacing="0">
                                       <thead>
                                       		<tr>
                                       			<th>아이디</th>
                                       			<td>
                                       				<input type="hidden" id="ID" name="ID" value="${loginvo.ID}" readOnly>${loginvo.ID}
                                       			</td>
                                       		</tr>
                                       		<tr>
                                       			<th>이름</th>
                                       			<td>
                                       				<input type="text" id="NAME" name="NAME" value="${loginvo.NAME}">
                                       			</td>
                                       		</tr>
                                       		<tr>
                                       			<th>비빌번호</th>
                         						<td>
                         						<input type="password" id="PASSWD" name="PASSWD" ></td>
                                       		</tr>
                                       		<tr>
                                       			<th>번호</th>
                                       			<td><input type="text" id="PHONE" name="PHONE" value="${loginvo.PHONE}"></td>
                                       		</tr>
                                       </thead>
                                    </table>
                                    <a href="javascript:fn_userEdit()" class="button">변경</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
 
            </div>
        </div>
      
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
