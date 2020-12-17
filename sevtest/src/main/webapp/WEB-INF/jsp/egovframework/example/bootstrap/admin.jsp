<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
<!DOCTYPE html>
<html lang="en">
            <div id="layoutSidenav_content">
                <main>
                     <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">WELCOME</h1>
                       	<h4>${login.ID}님 접속중입니다.</h4>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">사용자관리</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="/sev_manage.do">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">자유게시판</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="/board.do">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Q&A게시판</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="/QAlist.do">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">공지사항</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="/notice.do">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                사용자리스트
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>이름</th>
                                                <th>등급</th>
                                                <th>번호</th>
                                                <th>나이</th>
                                                <th>입사일</th>
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Name</th>
                                                <th>Position</th>
                                                <th>Office</th>
                                                <th>Age</th>
                                                <th>START_DATE</th>
                                         
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                         
                                   				<c:forEach var="list" items="${list}">
                                   					<tr>
                                   					<td align="center">${list.NAME}</td>
                                   					<td align="center">${list.LEVEL_NAME}</td>
                                   					<td align="center">${list.PHONE }</td>
                                   					<td align="center">${list.AGE}</td>
                                   					<td align="center">${list.STWORK}</td>
                                   					</tr>
                                   				</c:forEach>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
     
            </div>
        </div>
    </body>
</html>
<script>
function fn_changePasswd(){
	window.open("/changePasswd.do",'passwdchange','width=450,height=300');
}

</script>
