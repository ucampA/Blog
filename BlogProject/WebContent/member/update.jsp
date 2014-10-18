<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	 정보수정<br>
	 <hr><br>
	 <form action="con?action=updateSave" method="post" name="updateFrm">
		id: <input type="text" name="id" value="${requestScope.bean.getUserid() }"><br>
		pw: <input type="text" name="pw" value="${requestScope.bean.getUserpw() }"><br>
		name: <input type="text" name="name" value="${requestScope.bean.getName() }"><br>
		phone: <input type="text" name="phone" value="${requestScope.bean.getPhone() }"><br>
		blog title: <input type="text" name="title" value="${requestScope.bean.getBlogname() }"><br>
		<button type="submit">Save</button>
	</form>
</body>
</html>