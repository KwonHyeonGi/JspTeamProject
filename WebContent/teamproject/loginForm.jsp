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
<title>로그인</title>
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="../css/styledata.css">
</head>
<body>
	  <jsp:include page="/WEB-INF/view/default/defaultbanner.jsp"/>
	<form action="loginPro.do" method="post">
	<div id="login_box">
		<h2 id="login_title">로그인</h2>

			<img id="side"alt="" src="../images/board.png" width="50px" height="50px"> <br>
			
			<table>
				<tr>
				 	<th><span style="font-family: 'Black Han Sans', sans-serif; font-size: 25px;">ID :</span></th>
				 	<th><input id="input_bar" type="text" name="id_text" required oninvalid="this.setCustomValidity('아이디을 입력하지 않음')"></th>
				</tr>
				<tr>
					 <th><span style="font-family: 'Black Han Sans', sans-serif; font-size: 25px;">PWD :</span></th>
				 	<th><input id="input_bar" type="password" name ="pwd_text" required oninvalid="this.setCustomValidity('비밀번호을 입력하지 않음')"></th>
				</tr>
			</table>
			
			<input id="login_set" class="btn btn-warning" type="submit" value="로그인"> <br>
          	<button id="login_set" type="button" class="btn btn-warning" onclick="location.href='#'"> 아이디 및 비밀번호 찾기</button><br>
          	<button id="login_set" type="button" class="btn btn-warning" onclick="location.href='insertForm.jsp'"> 회원가입</button> 
		</div>
	</form>	
</body>
</html>