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
		<c:when test="${sessionScope.userid==null }">
			<center>
			<form action="con?action=login" method="post" name="loginFrm">
				<br>
				<table align="center">
					<tr>
						<td>ID</td>
						<td><input type="text" name="userid" size="10"></td>
					</tr>
					<tr>
						<td>PW</td>
						<td><input type="password" name="userpw" size="10"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<br>
							<input type="submit" value="Login">
							<input type="button" value="Join" onclick="javascript:location='index.jsp?page=member/join.jsp'">
						</td>
					</tr>
				</table>	
			</form>
			</center>
		</c:when>
		<c:otherwise>
			<center>
				<br>
				<b>${sessionScope.userid }님 안녕하세요.</b><br><br>
				<a href="con?action=update">정보수정</a><br>
				<a href="con?action=logout">로그아웃</a><br>
				<c:if test="${sessionScope.userid != 'admin'}">
					<a href="con?action=deleteMemberByID&id=${sessionScope.userid}">탈퇴하기</a>
				</c:if>
			</center>
		</c:otherwise>	
	</c:choose>
</body>
</html>