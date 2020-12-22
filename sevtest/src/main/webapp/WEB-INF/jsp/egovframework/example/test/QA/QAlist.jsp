<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
 <script type="text/javascript" src="/js/QA/QAlist.js" ></script> 
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Q&A 게시판</title>
        <link href="resources/admin/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>

    </head>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">QA게시판</h1>    
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                게시판
                            </div>
                            <div class="card-body" >
                                <div class="table-responsive" >
                                	<form id="frm" name="frm">
                                    <table class="table table-bordered" id="dataTable" >
                                    <div>
										                                    
                                    	<a class="button" href="javascript:fn_add();">등록</a>
	                                    <a class="button" href="javascript:fn_edit();">수정</a>
	                                    <a class="button" href="javascript:fn_delete();">삭제</a>
                            
                                    </div>
                                      	<thead>
                                      		<tr>
                                      			<th style="width:10%;"></th>
                                      			<th>title</th>
                                      			<th style="width:10%">아이디</th>
                                      			<th>이름</th>
                                      			<th style="width:30%;">date</th>
                                      			<th style="width:5%;">answer</th>
                                      		</tr>
                                      	</thead>
                                      		<tbody>
                        						<c:forEach var="list" items="${qalist}">
                        							<tr>
                        								<c:choose>
                        								<c:when test="${loginvo.AUTH_CODE eq '9' }">
                        									<td><input type="checkbox" id="INX" name="INX" value="${list.INX }"></td>
                        								</c:when>
                        								<c:when test="${loginvo.ID eq list.ID}">
                        									<td><input type="checkbox" id="INX" name="INX" value="${list.INX }"></td>
                        								</c:when>
														<c:when test="${loginvo.ID ne list.ID}">
															<td></td>
														</c:when>
                        								</c:choose>
                        								<c:choose>
                        									<c:when test="${loginvo.AUTH_CODE eq '9' }">
                        										<td style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                        										${list.TITLE}</td>
                        									</c:when>
                        									<c:when test="${loginvo.ID eq list.ID}">
                        									<td style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                        									${list.TITLE}</td>
                        									</c:when>
                        									<c:otherwise>
                        										<td>${list.TITLE}</td>
                        									</c:otherwise>
                        								</c:choose>
                        								
                        								<td>${list.ID}</td>
                        								<td>${list.NAME}</td>
                        								<td>${list.INSERT_DATE}</td>
                        								<td>${list.ANSWER}</td>
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

