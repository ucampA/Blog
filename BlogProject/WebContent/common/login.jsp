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
			<form action="con?action=login" method="post" name="loginFrm">
				<table align="center">
					<tr>
						<td>ID</td>
						<td><input type="text" name="userid" size="10"></td>
					</tr>
					<tr>
						<td>PW</td>
						<td><input type="text" name="userpw" size="10"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Login">
							<input type="button" value="Join" onclick="javascript:location='index.jsp?page=member/join.jsp'">
						</td>
					</tr>
				</table>	
			</form>
		</c:when>
		<c:otherwise>
			<center>
				<br>
				${sessionScope.userid }�� �ȳ��ϼ���.<br>
				<a href="#">��������</a>
				<a href="con?action=logout">�α׾ƿ�</a>
			</center>
		</c:otherwise>	
	
	</c:choose>
	
</body>
</html>