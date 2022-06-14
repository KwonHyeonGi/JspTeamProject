<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
<title>자유게시판 글 등록</title>
</head>
<body>
	<h2>자유게시판 글 등록</h2>
	<form action="FreeBoardInsert.do" method="post">
		아이디 : <input type="text" name="id"><br>
		제목 : <input type="text" name="title"><br>
		내용 : <input type="txtarea" name="txtarea"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>