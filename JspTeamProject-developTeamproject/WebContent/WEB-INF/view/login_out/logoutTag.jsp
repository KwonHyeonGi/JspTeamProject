<%/*================================================================
       파일명 :
       변경이력 : 
       프로그램 내용 : 
   =================================================================*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String id = (String)session.getAttribute("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<div id="login">
			<span id="login_text"><%=id %>님 환영합니다.</span> <br>
          <div class="btn-group">
          	<button id="login_btn" type="button" class="button-3d" onclick="location.href='logout.do'"> 로그아웃</button>
          	<button id="login_btn" type="button" class="button-3d" onclick="location.href='selectone.do?id=<%=id%>'"> 마이페이지</button>
			</div>
         </div>
</body>
</html>