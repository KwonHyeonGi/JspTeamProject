<%/*================================================================
       파일명 :
       변경이력 : 
       프로그램 내용 : 
   =================================================================*/%>
<%@ page import = "cs.dit.dto.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% MemberDto dto = (MemberDto)session.getAttribute("dtos"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>마이페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/login_out/logoutimg.jsp"/>
	<form name="Login" action="update.do" method="post">
	<div id="update_box">
		<h2 id="login_title">나의 회원정보</h2>

			<img id="side"alt="" src="../images/board.png" width="50px" height="50px"> <br>
			
			<table id = "update_input">
				<tr>
				 	<th><span id="update_text">아아디 :</span></th>
				 	<th><input id="update_input_bar" type="text" name="ids" required oninvalid="this.setCustomValidity('아이디을 입력하지 않음')" value="<%=dto.getId()%>"></th>
				</tr>
				<tr>
					 <th><span id="update_text">비밀번호 :</span></th>
				 	<th><input id="update_input_bar" type="text" name ="pwds" required oninvalid="this.setCustomValidity('비밀번호을 입력하지 않음')" value="<%=dto.getPassword()%>"></th>
				</tr>
				<tr>
					 <th><span id="update_text">닉네임 :</span></th>
				 	<th><input id="update_input_bar" type="text" name ="names" required oninvalid="this.setCustomValidity('닉네임을 입력하지 않음')" value="<%=dto.getNickName()%>"></th>
				</tr>
				<tr>
					 <th><span id="update_text">이메일 :</span></th>
				 	<th><input id="update_input_bar" type="text" name ="emails" required oninvalid="this.setCustomValidity('이메일을 입력하지 않음')" value="<%=dto.getEmail()%>"></th>
				</tr>
				<tr>
					 <th><span id="update_text">취미 :</span></th>
				 	<th><input id="update_input_bar" type="text" name ="hobbys" required oninvalid="this.setCustomValidity('취미을 입력하지 않음')" value="<%=dto.getHobby()%>"></th>
				</tr>
			</table>
			
			<input id="update_set" class="btn btn-warning" type="submit" value="회원 수정"> <br>
          	<button id="update_set" type="button" class="btn btn-warning" onclick="location.href='secession.do'"> 회원탈퇴</button>
		</div>
	</form>	
</body>
</html>