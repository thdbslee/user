<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
 
<!DOCTYPE html>

<html lang="ko">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link type="text/css" rel="stylesheet" href="/css/egovframework/sample.css"/>
<script type="text/javascript" src="/js/board/boardDetail.js" ></script>



</head>
<title>게시판 상세보기 </title>
<body onbeforeunload="fn_close()">
	<div>
			<table class="simple_table">
				<tbody>
					<h4>게시판 상세보기</h4>
				<tr>
					<th scope="row">제목</th>
					<td><input type="hidden" id="TITLE" name="TITLE" value="${boardvo.TITLE}">${boardvo.TITLE }</td>
				</tr>	
				<tr> 
					<th>내용</th>
					<td><textarea rows="5" cols="30" name="CONTENT" readOnly>${boardvo.CONTENT}</textarea>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
					<c:if test="${boardvo.IMG_1 ne null}">
					<img src="/upload/${boardvo.IMG_1}" style="max-width: 50%; max-height: 50%;">
					</c:if>
					</td>
				</tr>
				</tbody>
			</table>
		
			
		<h5>댓글</h5>
		<form id="frm" name="frm">
		<input type="hidden" id="pageIndex" name="pageIndex" value="${cmvo.pageIndex}" > 
		<input type="hidden" name="INX" value="${boardvo.INX}">
		<input type="hidden" id="ID" name="ID" value="${sevvo.ID}">
		<table class="simple_table" >
			<tbody>
			<input type="hidden" id="B_INX" name="B_INX" value="${boardvo.INX}"/>
				<c:forEach var="cmlist" items="${cmlist}">
					<tr>
						<th style="width:20px;">ID</th>
						<td style="width:20px;">${cmlist.id}</td>
						<th style="width:20px;">댓글</th>
						<td style ="text-align:left;">${cmlist.comment}</td>
						<th style="width:20px;">등록날짜</th>
						<td style="width:100px;">${cmlist.loginDate }</td>
						<th style="width:10px">
						<c:if test="${loginvo.ID == cmlist.id }">
							<a class="button" href="javascript:fn_cmdelete(${cmlist.inx})">
							<input type="hidden" id="delInx" name="delInx" value="${cmlist.inx}">삭제</a> 
						</c:if>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="simple_table">
			<tfoot>
				<tr>
					<th></th>
					<td><textarea rows="3" cols="30" name="COMMENT" id="COMMENT">
					</textarea><a class="button" href="javascript:fn_add();">등록</a>
					</td>		
				</tr>
			</tfoot>
		</table>
    	<div id="paging">
      		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
      	</div>
		<a href="javascript:fn_close();" class="button">닫기</a>
		
		</form>
		

		
	</div>
</body>

<style>
.button {

  background-color: pink;

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
.simple_table { width: 100%; border: none; border-collapse: separate; border-spacing: 2px;}
.simple_table th { padding: 5px; border: none;  border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:center; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { padding: 5px; border: none; border-bottom: 1px solid #DDD; text-align:center; }
table.type07 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border: 1px solid #ccc;
    margin: 20px 10px;
}
table.type07 thead {
    border-right: 1px solid #ccc;
    border-left: 1px solid #ccc;
    background: #e7708d;
}
table.type07 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
}
table.type07 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #fcf1f4;
}
table.type07 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
<style>



</style>

</style>

