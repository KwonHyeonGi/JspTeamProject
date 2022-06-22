<%/*================================================================
       파일명 :
       변경이력 : 
       프로그램 내용 : 
   =================================================================*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 로그아웃 정보 표시</title>
<style>
#nav_menu {

background-color:#045FB4;
border-top: 3px groove #9A2EFE;
border-bottom: 3px groove #9A2EFE;
text-align: center;
vertical-align:middle;
padding:10px;
width: 1480px;
height: 50px;
position: absolute;
left: 20px;
top: 200px;
}
 li {
	display:inline;
	font-family: 'Black Han Sans', sans-serif;
	cursor:pointer;
	border-left: 3px solid #F78181;
	padding-left: 25px;
	margin: 10px;
	color:#FBEFFB;
	font-size:15pt;
	
}
#nav_menu ul li:first-child {
border-left: none;
}
</style>
</head>
<body>
	<div id="nav_menu">
		<ul>
			<li><a onclick="#">공지사항</a></li>
			<li><a onclick="#">고객센터</a></li>
			<li><a onclick="location.href='FreeBoardList.jsp'">자유게시판</a></li>
			<li><a onclick="location.href='InfBoardList.in'">정보게시판</a></li>
			<li><a onclick="location.href='FreeBoardInsertForm.jsp'">자유게시판 작성</a></li>
			<li><a onclick="location.href='InfBoardInsertForm.in'">정보게시판 작성</a></li>
		</ul>
	</div>
</body>
</html>