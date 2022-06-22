<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% 
    	String usercheck = (String)session.getAttribute("checkid"); 
    %>
<!DOCTYPE html>
<html>
<head>
<title>자유 게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">	
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="../css/styledata.css">
</head>
<body>
	<c:set var="checks" value="<%=usercheck%>"></c:set>
	<jsp:include page="/WEB-INF/view/login_out/logoutimg.jsp"/>
		<c:if test="${checks eq dto.id}">
			<div id="board_change_input">
		    	<input type="button" class ="btn btn-primary" value="수정" onclick ="location.href='updateview.fr?title=${dto.title}'">
		    	<input type="button" class = "btn btn-primary" value="삭제" onclick ="location.href='delete.fr?title=${dto.title}'">
		    </div>
		</c:if>
	<form action="FreeBoardList.fr" method="post">
		
  	 <div>
  	 	<h2 id= "board_title">게시글</h2>
  	 	<div>
			<span id = "title_pos_two">제목 : <span id="title_text_one">${dto.title}</span> 등록일 : <span id="title_text_two">${dto.date}</span></span>
			<span id = "title_id">작성자 : <span id="title_text_id">${dto.id}</span></span>
			<!--  <span id = "title_count"> 조회수 : <span id="title_text_count"></span></span> -->
		</div>
  	 </div>
  	 <span id="text_area_view">${dto.textarea}</span>

		<input id="board_btn_back"type="submit" class="btn btn-primary" value="자유 게시판 목록 으로 돌아가기"></input>
	</form>
</body>
</html>