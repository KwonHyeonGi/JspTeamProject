<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	String usercheck = (String)session.getAttribute("checkid"); 
    %>
<!DOCTYPE html>
<html>
<head>
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
		    	<input type="button" class ="btn btn-primary" value="수정" onclick ="location.href='updateview.in?title=${dto.title}'">
		    	<input type="button" class = "btn btn-primary" value="삭제" onclick ="location.href='delete.in?title=${dto.title}'">
		    </div>
		</c:if>
	<form action="InfBoardList.in" method="post">
		
  	 <div>
  	 	<h2 id= "board_title">정보 게시글</h2>
  	 	<div>
			<span id = "title_pos_two">제목 : <span id="title_text_one">${dto.title}</span> 등록일 : <span id="title_text_two">${dto.date}</span></span>
			<span id = "title_id">작성자 : <span id="title_text_id">${dto.id}</span></span>
			<!--  <span id = "title_count"> 조회수 : <span id="title_text_count"></span></span> -->
		</div>
  	 </div>
  	 <span id="text_area_view">${dto.textarea}</span> 
		<input id="board_btn_back"type="submit" class="btn btn-primary" value="정보 게시판 목록 으로 돌아가기"></input>
		<div id="title_uploadfile">파일 : <a id="title_text_uplodfile" download href="/fileupload/uploadfiles/${dto.filename}">${dto.filename}</a></div>
	</form>
<!--  <div class="container">
	<h2>정보게시판</h2>
	<br/>
	<form action="view.in" method="post">
		<div>
		 <table class="table table-striped table-hover">
		  <tr>
			<th>제목</th><td>${dto.title}</td>
			<th>등록일</th><td>${dto.date}</td>
		  </tr>
		  <tr>
		  	<th>작성자</th><td>${dto.id}</td>
		  </tr>
		  <tr>
		   <th>내용</th>
		   <th>${dto.textarea}</th>
		  </tr>
		  <tr>
		  	<th>등록 파일</th>
		  	<th><a download href="/fileupload/uploadfiles/${dto.filename}">${dto.filename}</a></th>
		  <tr>
		   <td colspan="4">
		    <button type="button" class="btn btn-primary" onclick="location.href='InfBoardList.in'">글 목록보기</button>
		    <br/>
		    <br/>
		    <input type="button" class ="btn btn-primary" value="수정" onclick ="location.href='InfBoardUpdate.in'">
		    <input type="button" class = "btn btn-primary" value="삭제" onclick ="location.href='delete.in?title=${dto.title}'">
		   </td>
		  </tr>
		</table>
		</div>
	</form>
</div>-->

</body>
</html>