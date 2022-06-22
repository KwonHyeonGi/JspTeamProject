<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <style type="text/css">
	h2 { text-align : center;}
</style>
</head>
<body>
<h2>게시글 작성</h2>
  <form action="ScreenBoardList.sc" method="post">
	<table style="border: 1px solid; border-collapse:collapse; margin-left:auto; margin-right:auto;">
		<tr class="input-group mb-3" style="border:solid 1px;">
			<th class="input-group-text">작성자</th><td><input type="text" class="form-control" name="id"></input></td>
			<th class="input-group-text">제목</th><td><input type="text" class="form-control" style="width:100%" name="title"></input></td>
		</tr>
	</table>
	<table style="border:1px solid; border-collapse:collapse; margin-left:auto; margin-right:auto;">
		<tr style="border : solid 1px;">
			<td style="border:1px solid;"><textarea style="width:100%; border:0; resize:none;"rows="20" cols="104.7" name="textarea"></textarea></td>
		</tr>
	</table>
	<input type="submit" class="btn btn-primary"style="position:fixed;top:56%;left:45%;" value="게시"></input>
	<button type="button" class="btn btn-primary"style="position:fixed;top:56%;left:49%;" onclick="location.href='main.html'">돌아가기</button>
  </form>
</body>
</html>