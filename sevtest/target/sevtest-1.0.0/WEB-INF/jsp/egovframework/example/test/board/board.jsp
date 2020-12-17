<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/admin/dist/css/style.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <title>게시판</title>
        <link href="resources/admin/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="/js/board/board.js" ></script> 
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="/mainTest.do">HOME</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a>
                        <a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/logout.do">로그아웃</a>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                직원관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/sev_manage.do">사용자관리</a>
                                    <a class="nav-link" href="/user_List.do">사용자리스트</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">탈퇴리스트</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                게시판
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                    				 <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="/board.do">자유게시판</a>
                                            <a class="nav-link" href="register.html">등업게시판</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a>
                                        </nav>
                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        공지사항
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">게시판</h1>
                       	<h7>${login.ID}접속중입니다.</h7>     
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                게시판
                            </div>
                            <div class="card-body" >
                                <div class="table-responsive" >
                                	<form id="boardfrm" name="boardfrm">

                                	<input type="hidden" id="AUTH_CODE" name="AUTH_CODE" value="${login.AUTH_CODE}">
                                    <table class="table table-bordered" id="dataTable" >
                                    <div>
										                                    
                                    	<a class="button" href="javascript:fn_add();">등록</a>
                                    	<a class="button" href="javascript:fn_edit();">수정</a>
                                    	<a class="button" href="javascript:fn_delete();">삭제</a>
                                    </div>
                                      	<thead>
                                      		<tr>
                                      			<th style="width:10%;"><input type="checkbox" id="all_check" name="all_check"></th>
                                      			<th>title</th>
                                      			<th>id</th>
                                      			<th style="width:8%;">조회수</th>
                                      			<th style="width:100px;">date</th>
                                      		</tr>
                                      	</thead>
                                      		<tbody id="aatbody">
                                      			<c:forEach var="list" items="${list}">
                                      				<tr>
                                      				<td>
                                      				<c:choose>
                                      					<c:when test="${login.AUTH_CODE eq 9 }">
                                      						<input type="checkbox" id="INX_CHK" name="INX_CHK" value="${list.INX}"> 
                                      					</c:when>
                                  						<c:when test="${login.ID eq list.ID}">
                                  							<input type="checkbox" id="INX_CHK" name="INX_CHK" value="${list.INX}"> 
                                  						</c:when>
                                      				</c:choose>
                                      								
                              						</td>
                                      				<td  id="test" name="test" style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                                      				${list.TITLE}</td>
                                      				<td>${list.ID}</td>
                                      				<td style="text-align:center">
                                      				<input type="hidden" id="INFO" name="INFO" value="${list.INFO}">${list.INFO}</td>
                                      				<td style="width:100px;">${list.NOTICE_DATE}</td>
                                      				</tr>
                                      			</c:forEach>
                                      		</tbody>
                                      		
                                    </table>          
                                    </form>
                                   
                                </div>
                            </div>
                        </div>-
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
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

