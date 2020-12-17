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
   <script type="text/javascript" src="/js/notice/notice.js" ></script> 
  <script type="text/javascript" src="/js/egovframework/EgovMultiFile.js" ></script>

        <title>공지사항등록</title>

    </head>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">공지사항 등록</h1>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                공지사항작성
                            </div>
                            <div class="card-body" >
                             <table class="table table-bordered" id="dataTable" >
                             	<form id="frm" name="frm" method="post" enctype="multipart/form-data">
                                    <div>
	                                    <tbody>
	                                    	<tr>
	                                    		<th>제목</th> 
	                                    		<td><input type="text" id="TITLE" name="TITLE"></td>
	                                    	</tr>
	                                    	<tr>
	                                    		<th>이름</th>
	                                    		<td style="width:5%;">
	                                    		<input type="hidden" id="NAME" name="NAME" value="${loginvo.NAME}">
	                                    		${loginvo.NAME}</td>
	                                    		<th>아이디</th>
	                                    		<td><input type="hidden" id="ID" name="ID" value="${loginvo.ID}">${loginvo.ID}</td>
	                                    	</tr>
	                                    	<tr>
	                                    		<th>내용</th>
	                                    		<td colspan="5">
	                                    			<textarea rows="20" cols="30" style="width:99%;" id="CONTENT" name="CONTENT"></textarea>
	                                    		</td>
	                                    	</tr>
	                                    	<tr>
	                                    		<th>첨부파일</th>
	                                    		<td><input type="file"  id="egovComFileUploader" name="IMG1" id="IMG1"></td>
												<div id="egovComFileList"></div>
	                                    	</tr>
	                                    </tbody>
	                                    <tfoot>
	                                    	<a class="button" href="javascript:fn_add()">등록</a>
	                                    	<a class="button" href="/notice.do">목록</a>
	                                    </tfoot>
                                   </div>
                                  </form>
                 				</table>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="resources/admin/dist/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="resources/admin/dist/assets/demo/chart-area-demo.js"></script>
        <script src="resources/admin/dist/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="resources/admin/dist/assets/demo/datatables-demo.js"></script>
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
<script>
	function fn_add(){
		if(!$("#TITLE").val()){
			alert("제목을 입력하세요");
			return;
		}
		if(!$("#CONTENT").val()){
			alert("내용을 입력하세요");
			return;
		}
		var formData = new FormData($("#frm")[0]);
		$.ajax({
			contentType:"application/x-www-form-urlencoded;charset=UTF-8",
			type:"POST",
			url:"/noticeInsert_ok.do",      
			data: formData,
			processDate: false,
			async       : false,
			traditional : true,
			processData: false,
			contentType: false,
			success:function(success){
				if(success=="true"){
					alert("공지사항 등록완료.");
					location.href="/notice.do";
				}else{
					alert("등록실패.");	
				}
			},error:function(indx){
				alert("에러");
			}
		});
	}
</script>

