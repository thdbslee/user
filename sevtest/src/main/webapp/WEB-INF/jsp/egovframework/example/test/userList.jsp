<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
<!DOCTYPE html>
<html lang="en">
    <head>


        <title>사용자리스트</title>
            <div id="layoutSidenav_content">
                <main>
                  <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">사용자리스트</h1>
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
