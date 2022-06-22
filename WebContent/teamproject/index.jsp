<%/*================================================================
       파일명 :
       변경이력 : 
       프로그램 내용 : 
   =================================================================*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
	String id = (String)session.getAttribute("userid");
	String usercheck = (String)session.getAttribute("checkid");
	usercheck = "";
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
<title>게임 커뮤니티 사이트</title>
</head>
<body>
		<% if(id != null) {%>
			<jsp:include page="/WEB-INF/view/login_out/logoutimg.jsp"/>
		<%} else {%>
			<jsp:include page="/WEB-INF/view/login_out/loginimg.jsp"/>
		<%} %>
		
		<% if(id != null) {%>
			<jsp:include page="/WEB-INF/view/login_out_object/midObjectlogin.jsp"/>
		<%} else {%>
			<jsp:include page="/WEB-INF/view/login_out_object/midObjectlogout.jsp"/>
		<%} %>
     		<div class="main_banner owl-carousel owl-theme">
     			<div class="item first">
     				<h2 class="title">5월 11일부터 6월 11까지 할인 중인 <strong class="em">인디 게임 지금 구매해서 즐겨보세요.</strong></h2>
     				<span class="subtitle">인디 개발자의 꿈과 희망을 플레이해보세요!</span>
     			</div>
     			<div class="item second">
     				<h2 class="title">마운트 블레이드 이벤트 진행중 <strong class="em">지금 구매해서 즐겨보세요.</strong></h2>
     				<span class="subtitle">당신의 지휘로 다른 군을 이겨보세요!</span>
     			</div>
     			<div class="item third">
     				<h2 class="title">이런 체험은 어떻시나요? <strong class="em">이 커뮤니티가 직접 추천합니다.</strong></h2>
     				<span class="subtitle">저만 믿으라고요!</span>
     			</div>
     		</div>
        <div id="main">
        	<h2 style="font-family: 'Black Han Sans', sans-serif;">자유게시글</h2>
        	<table class="w3-table-all w3-hoverable">
        	<thead>
        		<tr class="w3-light-grey">
        			<th>아이디</th>
        			<th>제목</th>
        			<th>날짜</th>
        		</tr>
        	</thead>
        		<tr>
        			<td>gildong</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.</td>
        			<td>2022-05-17</td>
        		</tr>
        		<tr>
        			<td>gildong2</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.2</td>
        			<td>2022-05-18</td>
        		</tr>
        		
        		<tr>
        			<td>gildong3</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.1</td>
        			<td>2022-05-18</td>
        		</tr>
        	</table>
        	<hr>
        		<h2 style="font-family: 'Black Han Sans', sans-serif;">최근게시글</h2>
        		<table class="w3-table-all w3-hoverable">
        	<thead>
        		<tr class="w3-light-grey">
        			<th>아이디</th>
        			<th>제목</th>
        			<th>날짜</th>
        		</tr>
        	</thead>
        		<tr>
        			<td>gildong</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.</td>
        			<td>2022-05-17</td>
        		</tr>
        		<tr>
        			<td>gildong2</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.2</td>
        			<td>2022-05-18</td>
        		</tr>
        		
        		<tr>
        			<td>gildong3</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.1</td>
        			<td>2022-05-18</td>
        		</tr>
        	</table>
        	<hr>
        		<h2 style="font-family: 'Black Han Sans', sans-serif;">정보게시글</h2>
        		<table class="w3-table-all w3-hoverable">
        	<thead>
        		<tr class="w3-light-grey">
        			<th>아이디</th>
        			<th>제목</th>
        			<th>날짜</th>
        		</tr>
        	</thead>
        		<tr>
        			<td>gildong</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.</td>
        			<td>2022-05-17</td>
        		</tr>
        		<tr>
        			<td>gildong2</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.2</td>
        			<td>2022-05-18</td>
        		</tr>
        		
        		<tr>
        			<td>gildong3</td>
        			<td>이 게임에서 필요한 가장 좋은 꿀팁 공유합니다.1</td>
        			<td>2022-05-18</td>
        		</tr>
        	</table>
        </div>
		<% if(id != null) {%>
			<jsp:include page="/WEB-INF/view/login_out/logoutTag.jsp"/>
		<%} else {%>
			<jsp:include page="/WEB-INF/view/login_out/loginTag.jsp"/>
		 <%} %>
        <div id="menu">
        	<span id="menu_text">게임 순위</span> <br>
        	<hr id="menu_hr">
        	<img  id="menu_img"src="../images/game.png">
        </div>
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="../owlcarousel/owl.carousel.min.js"></script>
	<script src="../js/rollingbanner.js"></script>
</html>