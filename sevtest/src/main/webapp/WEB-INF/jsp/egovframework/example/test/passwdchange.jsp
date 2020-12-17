<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
 <%
//  	request.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link type="text/css" rel="stylesheet" href="/css/egovframework/sample.css"/>
<script type="text/javascript" src="/js/passwdchange.js" ></script>

</head>
<title>비밀번호 변경</title>
<body>
	<div>
			<form id="frm" name="frm" method="post">
			<input type="hidden" id="ID" name="ID" value="${loginvo.ID}">
				<table class="simple_table">
					<tr>
						<th>현재비밀번호</th>
						<td><input type="password" id="OLDPASSWD" name="OLDPASSWD" placeholder="현재비밀번호"></td>
					</tr>
					<tr>	
						<th>변경비밀번호</th>
						<td><input type="password" id="NEWPASSWD" name="NEWPASSWD" placeholder="비밀번호"></td>
					</tr>
					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" id="PASSWDCHK" name="PASSWDCHK" placeholder="비밀번호확인"></td>
					</tr>
				</table>
				<a  class="button" href="javascript:fn_passwdchange()" >변경하기</a>
				<a  class="button" href="javascript:self.close()">닫기</a>
			</form>	
	</div>
</body>
<div id="dialog" class="dialog" >
	<div id="dialogType">
		<p id="dialogMsg" class="dialog_msg"></p>
	</div>
</div>	
<style>
.simple_table { width: 100%; height:70px; border:1px; margin:auto;text-align:center;}
.simple_table th { font_size :20px ;padding: 5px; border: none;  border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:center; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { font_size :20px ;padding: 5px; border: none; border-bottom: 1px solid #DDD; text-align:center; }
.button {

  background-color: pink;

  border: none;

  color: white;

  padding: 15px 30px;

  text-align: center;

  text-decoration: none;

  display: inline-block;

  font-size: 16px;
  font-weight : bold;
  margin: 4px 2px;

  cursor: pointer;

}
</style>