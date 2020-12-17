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
<script type="text/javascript" src="/js/QA/QA_Detail.js" ></script>



</head>
<title>문의창</title>
<body>
	<div>
			<form id="frm" name="frm" method="post">
			<table class="simple_table">
				<tbody>
					<h4>문의창</h4>
				<tr>
					<th>ID</th>
					<td><input type="hidden"  id="ID" name="ID" value="${qavo.ID}">${qavo.ID}</td>
				</tr>
				<tr>
					
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TITLE" value="${qavo.TITLE}"></td>
				</tr>	
				<tr> 
					<th>문의내용</th>
					<td><textarea rows="5" cols="30" name="CONTENT">${qavo.CONTENT}</textarea>
				</tr>
	
				</tbody>
			</table>
			
			</form>	
	</div>
	<!-- 관리자 답변 폼 -->
	<form id="QAfrm" name="QAfrm">
	<input type="hidden" id="INX" name="INX" value="${qavo.INX}"> 문의
	<input type="hidden" id="QAINX" name="QAINX" value="${qavo.INX}"> 답변
		<table class="simple_table">
				<tbody>
					<c:forEach var="list" items="${list}">
						<tr>
							<th>아이디</th>
							<td style="width:10%;">${list.ID}</td>
							<th>내용</th>
							<td>${list.CONTENT}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<h4>답변</h4>
					<tr>
						<th>아이디</th>
						<td><input type="hidden" id="ID" name="ID" value="${loginvo.ID}">${loginvo.ID}</td>
						<th></th>
						<td><textarea rows="3" cols="30" name="CONTENT" id="CONTENT">
						</textarea><a class="button" href="javascript:fn_add();">등록</a>
						</td>
							
					</tr>
	
				</tfoot>
			</table>
	</form>
		<a href="javascript:fn_close();" class="button">닫기</a>
</body>

<style>
.simple_table { width: 100%; height:100px; border:1px; margin:auto;text-align:center;}
.simple_table th { padding: 5px; border: none;  border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:left; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { padding: 5px; border: none; border-bottom: 1px solid #DDD; text-align:left; }
.button {

  background-color: pink;

  border: none;

  color: white;

  padding: 15px 30px;

  text-align: left;

  text-decoration: none;

  display: inline-block;

  font-size: 16px;

  margin: 4px 2px;

  cursor: pointer;

}
</style>

