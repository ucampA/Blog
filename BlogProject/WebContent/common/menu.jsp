<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center><br>
		<font style="font-size:15pt;"><b>menu</b></font><br><br>
		<c:choose>
			<c:when test="${sessionScope.userid==null }">
				�α��� �ϼ���.
			</c:when>
			<c:when test="${sessionScope.userid=='admin' }">
				<a href="con?action=memberList">�ɹ�����Ʈ</a><br><br>
			</c:when>
			<c:otherwise>
				<a href="index.jsp?page=board/write.jsp">�۾���</a><br><br>
				<a href="con?action=getAllPosts">�Խñ� ���</a><br><br>
			</c:otherwise>	
		</c:choose>
	</center>
</body>
</html>