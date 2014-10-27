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
<style>
	.thTd {
		width: 120px;
		text-align: center;
		height:25px;
	}
</style>
</head>
<body>
	<center>
		<br>
		<table>
			<tr align="center" bgcolor="white">
				<th>글번호</th><th width="150px">제목</th><th>ID</th><th>작성일</th><th>조회수</th>
			</tr>
			<c:forEach items="${blogs}" var="blog">
				<c:if test="${blog.openState == 'O'}">
					<tr align="center">
						<td>${blog.no}</td>
						<td><a href="con?action=detailContent&pno=${blog.no}">${blog.title}</a></td>
						<td>${blog.userid}</td>
						<td>${blog.writeday}</td>
						<td>${blog.readcount}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</center>
</body>
</html>