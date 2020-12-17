<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>

<html lang="ko">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script type="text/javascript" src="/js/board/boardInsert.js" ></script>
 <script type="text/javascript" src="/js/egovframework/EgovMultiFile.js" ></script>
</head>
<title>게시판 등록 </title>
<body>
	<div>
		<form id="frm" name="frm" enctype="multipart/form-data" method="post">
			<table class="simple_table">
				<tbody>
					<h4>게시판 등록</h4>
				<tr>
					<th>작성자</th>
					<td><input type="hidden" id="ID" name="ID" value="${login.ID}" readOnly>${login.ID}</td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TITLE"></td>
				</tr>	
				<tr> 
					<th>내용</th>
					<td><textarea rows="5" cols="30" name="CONTENT" id="CONTENT"></textarea>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file"  id="egovComFileUploader" name="IMG1" id="IMG1"></td>
					<label>파일찾기</label>
					<div id="egovComFileList"></div>
				</tr>
				</tbody>
			</table>
		<a href="javascript:fn_add();" class="button">등록</a>
		<a href="javajscript:self.close();" class="button">닫기</a>
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
.simple_table th { padding: 15px; border: none; border-left: 5px solid #C03; border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:center; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { padding: 15px; border: none; border-bottom: 1px solid #DDD; text-align: left; vertical-align: baseline;}
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
</style>

