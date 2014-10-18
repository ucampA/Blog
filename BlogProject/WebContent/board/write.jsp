<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
게시글 쓰기
	<center>
	<form action="con?action=write" method="post" name="writeFrm">
		<table>
			<tr><td>제목</td></tr>
			<tr><td><input type="text" name="title" size="55"> </td></tr>
			<tr><td>내용</td></tr>
			<tr><td><textarea rows="10" cols="60" name="content"></textarea> </td></tr>
			<tr><td align="right"><button type="submit">save</button></td></tr>
		</table>
	</form>
	</center>
</body>
</html>