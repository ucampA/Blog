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
	게시글 리스트<br>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:if test="${not empty requestScope.postList}">
			<c:forEach items="${requestScope.postList}" var="post">
				<c:if test="${post.openState == 'O'}">
					<tr>
						<td>${post.no}</td>
						<td><a href="con?action=detailContent&pno=${post.no}">${post.title}</a></td>
						<td>${post.writeday}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>