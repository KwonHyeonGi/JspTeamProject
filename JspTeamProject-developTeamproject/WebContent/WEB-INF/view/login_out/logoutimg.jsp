<%/*================================================================
       파일명 :
       변경이력 : 
       프로그램 내용 : 
   =================================================================*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("userid"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../css/styledata.css">
</head>
<body>
	  	<div>
        	<a href="../teamproject/index.jsp"><img id="webbanner" src="../images/Webben.png" alt="배너" width="800px" height="200px"/></a>
        </div>
       	<div>
		<img id="selectone" src="../images/logout.png" width="50" height="50" onclick="location.href='logout.do'">
		<img id="selecttwo" src="../images/profile.png" width="50" height="50" onclick="location.href='selectone.do?id=<%=id%>'">
	</div>
        <div>
        	   <img id="searchicon" alt="검색" src="../images/search.png" width="50px" height="50px">
        	   <input id="searchinput" class="w3-input w3-border w3-round-large" type="text" placeholder="검색할 제목 혹은 아이디를 입력 하시오.">
        </div>

</body>
</html>