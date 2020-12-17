<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <head>
<script type="text/javascript" src="/js/level/level.js" ></script> 
<c:import url="/layoutMenu.do"></c:import>


            <div id="layoutSidenav_content">
                <main>
                   <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">등업게시판</h1>

                       	    <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                게시판
                            </div>
                       		  <div class="card-body" >
                                <div class="table-responsive" >
                                	<form id="frm" name="frm">
<input type="hidden" id="msgContent" name="msgContent" value="${msgContent}">
                                    <table class="table table-bordered" id="dataTable" >
                                    <div>
										                                    
                                    	<a class="button" href="javascript:fn_add();">등록</a>
                                    	<a class="button" href="javascript:fn_edit();">수정</a>
                                    	<a class="button" href="javascript:fn_delete();">삭제</a>
                                    </div>
                                      	<thead>
                        					<tr>	
                        						<th style="width:5%"></th>
                        						<th style="width:20%">제목</th>
                        						<th style="width:10%">아이디</th>
                        						<th style="width:10%">작성일</th>
                        					</tr>
                        					
                                      	</thead>
                                      		<tbody>
                                      		<c:forEach var="list" items="${list}">
                                      			<tr>
                                      				<td><input type="checkbox" id="INX" name="INX" value="${list.INX}"></td>
                                      				<td style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                                      				${list.TITLE}</td>
                                      				<td style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                                      				${list.ID}</td>
                                      				<td style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                                      				${list.INSERT_DATE}</td>
                                      			</tr>
                                      		</c:forEach>
                                      		</tbody>
                                      		<tfoot>
                                      			
                                      		</tfoot>
                                    </table>          
                                    </form>
                                   
                                </div>
                            </div>
                       		
                       	</table>
                    	
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

