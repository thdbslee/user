<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="/js/workInsert.js" ></script> 

<title>직원등록</title>
<div>
<form id="frm" name="frm" method="post">
	<table>
		<tbody>
			<tr>
				<th>이름</th>
				<td><input type="text" id="NAME" name="NAME"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="ID" name="ID"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="PASSWD" name="PASSWD"></td>
			</tr>
			<tr>
				<th>직급</th>
				<td>
				<select name="LEVEL" id="LEVEL">
					<option value="0">director</option>
					<option value="1">manager</option>
					<option value="2">staff</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="text" id="PHONE" name="PHONE"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" id="AGE" name="AGE"></td>
			</tr>
			<tr>
				<th>입사일 OR 입사예정일</th>
				<td><input type="text" id="STWORK" name="STWORK" readOnly></td>
			</tr>
		</tbody>
	</table>
		<a style="width:100px;cursor:pointer;"  onclick="fn_add();">등록</a>
		<a style="width:100px;cursor:pointer;"  onclick="self.close;">닫기</a>
	
</form>
</div>