<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="con?action=join" method="post" name="joinFrm">
		<h1>회원가입</h1><br><hr><br>
		id: <input type="text" name="id"><br>
		pw: <input type="text" name="pw"><br>
		name: <input type="text" name="name"><br>
		phone: <input type="text" name="phone"><br>
		blog title: <input type="text" name="title"><br>
		<button type="submit">Join</button>
	</form>
</body>
</html>