<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<br><br><font style="font-size:16pt;"><b>게시글 리스트</b></font><br><br><br>
		<table>
			<tr>
				<th class="thTd">글번호</th>
				<th class="thTd">제목</th>
				<th class="thTd">날짜</th>
			</tr>
			<c:if test="${not empty requestScope.postList}">
				<c:forEach items="${requestScope.postList}" var="post">
					<tr>
						<td class="thTd">${post.no}</td>
						<td class="thTd"><a href="con?action=detailContent&pno=${post.no}">${post.title}</a></td>
						<td style="width:200px;text-align: center;">${post.writeday}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</center>
</body>
</html>