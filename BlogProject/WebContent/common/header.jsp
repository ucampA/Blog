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
	<c:choose>
	 	<c:when test="${not empty sessionScope.userid}">
	 		<c:choose>
	 			<c:when test="${blog.userid == sessionScope.userid }">
					<a href="index.jsp?page=blog/blogList.jsp"><font size="80px" color="#F6F6F6">${sessionScope.blogName}</font></a><br>
				</c:when>
				<c:when test="${not empty blog.userid}">
					<a href="index.jsp?page=blog/blogList.jsp"><font size="80px" color="#F6F6F6">${blog.userid}</font></a><br>
				</c:when>
				<c:otherwise>
					<a href="index.jsp?page=blog/blogList.jsp"><font size="80px" color="#F6F6F6">${sessionScope.blogName}</font></a><br>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${not empty blog.userid}">
					<a href="index.jsp?page=blog/blogList.jsp"><font size="80px" color="#F6F6F6">${blog.userid}</font></a><br>
				</c:when>
				<c:otherwise>
					<a href="index.jsp?page=blog/blogList.jsp"><font size="80px" color="#F6F6F6">${sessionScope.blogName}</font></a><br>
				</c:otherwise>
			
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>