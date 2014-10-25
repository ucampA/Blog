<%@page import="java.util.List"%>
<%@page import="blog.model.dao.PostDAO"%>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List blogs =PostDAO.selectAll();
	request.setAttribute("blogs", blogs);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr align="center" bgcolor="white">
		<td>글번호</td><td width="150px">제목</td><td>ID</td><td>작성일</td><td>조회수</td>
	</tr>
	<c:forEach items="${blogs}" var="blog">
		<tr align="center">
			<td>${blog.no}</td>
			<td><a href="con?action=detailContent&pno=${blog.no}">${blog.title}</a></td>
			<td>${blog.userid}</td>
			<td>${blog.writeday}</td>
			<td>${blog.readcount}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>