<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/manage.js" ></script> 
<!DOCTYPE html>
<html lang="en">
            <div id="layoutSidenav_content">
            <form id="frm" name="frm">
            <input type="hidden" id="AUTH_CODE" name="AUTH_CODE" value="${loginvo.AUTH_CODE}">
                <main>
                   <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">사용자관리</h1>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                사용자관리
                                         
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           			<div>
										                                    
                                    	<a class="button" href="javascript:fn_add();">등록</a>
                                    	<a class="button" href="javascript:fn_edit();">수정</a>
                                    	<a class="button" href="javascript:fn_delete();">삭제</a>
                                    </div>
                                       <thead>
                                            <tr>
                                            	<th></th>
                                                <th>이름</th>
                                                <th>아이디</th>
                                                <th>등급</th>
                                                <th>번호</th>
                                                <th>나이</th>
                                                <th>로그인날짜</th>
                                                <th>입사일</th>
                                                <th>계정잠금</th>
                                                <th>로그인실패</th>
                                            </tr>
                                        </thead>
                                        <tbody id="workTbody">
                                            
                                   				<c:forEach var="list" items="${list}">
                                   				<tr>
                                   					<td><input type="checkbox" id="inx_check" name="inx_check" value="${list.INX}">
                                   					<td align="center">${list.NAME}</td>
                                   					<td align="center">${list.ID}</td>
                                   					<td align="center">${list.LEVEL_NAME}</td>
                                   					<td align="center">${list.PHONE}</td>
                                   					<td align="center">${list.AGE}</td>
                                   					<td align="center">${list.LOGIN_DATE}</td>
                                   					<td align="center">${list.STWORK}</td>
                                   					<td align="center">${list.LOCK_YN}</td>
                                   					<td align="center">${list.FAIL_COUNT}</td>
                                   				</tr>
                                   				</c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                 <div class="btArea3">
				
			</div>
                        </div>
                    </div>
                </main>
                </form>
                
                
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



