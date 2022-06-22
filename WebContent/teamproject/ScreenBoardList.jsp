<%@page import="cs.dit.dto.ScreenBoardDto"%>
<%@page import="cs.dit.dao.ScreenBoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<% 
	ScreenBoardDao dao = new ScreenBoardDao();
	ArrayList<ScreenBoardDto> dtos =  dao.list();
	pageContext.setAttribute("dtos", dtos);
%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
	h2 { text-align : center;}
  </style>
</head>
<body>
	<h2><b>스크린샷 게시판</b></h2>
	<table class="table table-striped">
		<tr>
			<th width = "150px">아이디</th>
			<th width = "100px">제목</th>
			<th width = "150px">날짜</th>
			<th width = "50px">조회수</th>
		</tr>

		<c:forEach var='dto' items='${dtos}'>
			<tr>
				<td><a href="ScreenBoard.sc?id=${dto.id }">${dto.id }</a></td>
				<td>${dto.id}</td>
				<td>${dto.title}</td>				
				<td>${dto.viewcount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>