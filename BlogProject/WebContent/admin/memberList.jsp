<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<table>
	<tr bgcolor="#FAECC5" align="center">
		<td>NO</td><td>ID</td><td>NAME</td><td>PHONE</td><td>BLOGNAME</td>
	</tr>
		<c:forEach items="${requestScope.members}" var="member" varStatus="index">
			<tr align="center">
				<td>${index.index+1}</td><td>${member.userid}</td>
				<td>${member.name}</td><td>${member.phone}</td><td>${member.blogname}</td>
			</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>

<%-- <c:forEach items="${applicationScope.key}" var="v">
		${v} &nbsp;&nbsp;&nbsp;
	</c:forEach> --%>