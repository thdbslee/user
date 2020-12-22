<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
 <script type="text/javascript" src="/js/notice/notice.js" ></script> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>공지사항</title> 
    </head>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">공지사항</h1>        	 
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                공지사항
                            </div>
                            <div class="card-body" >
                                <div class="table-responsive" >
                                	<form id="frm" name="frm">
                                	<input type="hidden" id="ID" name="ID" value="${loginvo.ID}">
									<input type="hidden" id="LEVEL" name="LEVEL" value="${loginvo.LEVEL }">
                                	<input type="hidden" id="AUTH_CODE" name="AUTH_CODE" value="${loginvo.AUTH_CODE}">
                  
                                    <table class="table table-bordered" id="dataTable" >
                                    <div>
										<c:choose>
										<c:when test="${loginvo.AUTH_CODE eq '9'}">
	                                    	<a class="button" href="/noticeInsert.do">등록</a>
	                                    	<a class="button" href="javascript:fn_edit();">수정</a>
	                                    	<a class="button" href="javascript:fn_delete();">삭제</a>
	                                    </c:when>
	                                    </c:choose>
                                    </div>
                                      	<thead>
                                      		<tr>
                                      			<th style="width:10%;"><input type="checkbox" id="all_check" name="all_check"></th>
                                      			<th>title</th>
                                      			<th>이름</th>
                                      			<th style="width:8%;">조회수</th>
                                      			<th style="width:100px;">date</th>
                                      		</tr>
                                      	</thead>
                    					<tbody>
                    						
                    							<c:forEach var="list" items="${list}">
                    								<tr>
                    									<c:choose>
                    									<c:when test="${loginvo.AUTH_CODE eq '9'}">
                    									<td><input type="checkbox" id="INX_CHK" name="INX_CHK" value="${list.INX}"></td>
                    									</c:when>
                    									<c:otherwise>
                    										<td></td>
                    									</c:otherwise>
                    									</c:choose>
                    									<td style="cursor:pointer;" onclick='fn_click(${list.INX})'>${list.TITLE}</td>
                    									<td style="cursor:pointer;" onclick='fn_click(${list.INX})'>${list.NAME}</td>
                    									<td style="cursor:pointer;" onclick='fn_click(${list.INX})'>${list.INFO}</td>
                    									<td style="cursor:pointer;" onclick='fn_click(${list.INX})'>${list.INSERT_DATE}</td>
                    								</tr>
                    							</c:forEach>
                    						
                    					</tbody>
                                      		
                                    </table>          
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

