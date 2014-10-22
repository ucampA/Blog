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
게시글 쓰기
	<center>
	<form action="con?action=write" method="post" name="writeFrm">
		<table>
			<tr align="center" bgcolor="white"><td colspan="2">${blog.no}.${blog.title}</td></tr>
			<tr><td>작성자: ${blog.userid}</td><td>조회수:${blog.readcount}</td></tr>
			<tr><td colspan="2">작성일: ${blog.writeday}</td></tr>
			<tr><td colspan="2">내용</td></tr>
			<c:choose>
				<c:when test="${blog.userid == sessionScope.userid }">
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content">${blog.content}</textarea> </td></tr>
					<tr><td align="right"><button type="button">update</button><button type="button">delete</button></td></tr>
				</c:when>
				<c:otherwise>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content" disabled="disabled">${blog.content}</textarea> </td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
	</center>
</body>
</html>