<%@page import="cs.dit.LoginDto" %>
<%@page import="cs.dit.LoginDao" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
<%
//DBCP를 사용하여 DB 연동
	
	LoginDao dao = new LoginDao();
	
	ArrayList<LoginDto> dtos = dao.list();
	
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">	
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
   <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="../css/styledata.css">
<title>DB 연결</title>
</head>
<body>
 		<div>
        	<img id="webbanner" src="../images/Webben.png" alt="배너" width="800px" height="200px"/>
        </div>
        <div>
        	   <img id="searchicon" alt="검색" src="../images/search.png" width="50px" height="50px">
        	   <input id="searchinput" class="w3-input w3-border w3-round-large" type="text" placeholder="검색할 제목 혹은 아이디를 입력 하시오.">
        </div>
        <div id="userbox">
        	<h2 style="font-family: 'Black Han Sans', sans-serif; font-size: 25px;">회원정보</h2>
        </div>
        <div id="userlist">
	<table class="w3-table-all w3-hoverable">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>pwd</th>
		</tr>
		<tr>
<%
	for(LoginDto dto : dtos){
		%>
	<td><a href="updateForm.jsp?id=<%=dto.getId() %>"><%=dto.getId() %></a></td>
	<td><%=dto.getName() %></td>
	<td><%=dto.getPwd() %></td>
	</tr>
	
	<% 
		}	
	%>
	</table> <br>
	<button type="button" class="button-3d" onclick="location.href='index.jsp'"> 돌아가기</button> <br>
	</div>
</body>
</html>