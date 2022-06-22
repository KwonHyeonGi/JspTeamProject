<%@page import="cs.dit.dto.InfBoardDto"%>
<%@page import="cs.dit.dao.InfBoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<% 
	InfBoardDao dao = new InfBoardDao();
	ArrayList<InfBoardDto> dtos =  dao.list();
	pageContext.setAttribute("dtos", dtos);
	
	String id = (String)session.getAttribute("userid");
%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">	
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="../owlcarousel/assets/owl.carousel.min.css">
  <link rel="stylesheet" href="../owlcarousel/assets/owl.theme.default.css">
  <link rel="stylesheet" href="../css/styledata.css">
  <style>
	h2 { text-align : center;}
  </style>
</head>
<body>
<%if(id != null) {%>
	 	<jsp:include page="/WEB-INF/view/login_out/logoutimg.jsp"/>
	<%} else {%>
	  	<jsp:include page="/WEB-INF/view/login_out/loginimg.jsp"/>
	<%} %>
	<img id="free_banner" src="../images/Infboardbanner.png">
	<div id="infboard_list">
	<table class="w3-table-all w3-hoverable">
		<tr  class="w3-light-grey">
			<th>제목</th>
			<th>아이디</th>
			<th>파일 이름</th>
			<th>날짜</th>
		</tr>
		<c:forEach var='dto' items='${dtos}'>
			<tr>
				<td><a href="view.in?title=${dto.title}">${dto.title}</a></td>
				<td>${dto.id}</td>
				<td>${dto.filename}</td>
				<td>${dto.date}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>