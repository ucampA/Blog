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
�Խñ� ����
	<center>
	<form method="post" name="writeForm">
		<table>
			<tr align="center" bgcolor="white"><td colspan="2">${blog.no}</td></tr>
			<tr><td>������</td><td><input type="text" name="title" size="30" value="${blog.title}"></td></tr>
			<tr><td>�ۼ���: ${blog.userid}</td><td>��ȸ��:${blog.readcount}</td></tr>
			<tr><td colspan="2">�ۼ���: ${blog.writeday}</td></tr>
			
			<c:choose>
				<c:when test="${blog.userid == sessionScope.userid }">
					<tr><td>
						<select id="openState">
							<option>��ü����</option>
							<option>�����</option>
						</select>
					</td></tr>
					<tr><td colspan="2">����</td></tr>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content">${blog.content}</textarea> </td></tr>
					<tr><td align="right">
						<input type="button" onclick="proceed(this.value, ${blog.no})" value="update">
						<input type="button" onclick="proceed(this.value, ${blog.no})" value="delete">
					</td></tr>
				</c:when>
				<c:otherwise>
					<tr><td colspan="2">����</td></tr>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content" disabled="disabled">${blog.content}</textarea> </td></tr>
				</c:otherwise>
			</c:choose>
		</table>
		<input type="hidden" name="openState">
	</form>
	
	
	<jsp:include page="../reple/repleList.jsp"></jsp:include><br>
	<jsp:include page="../reple/reple.jsp"></jsp:include>
	
	</center>
	<script>
		function proceed(value, pno) {
			if(value="update") {
				if(document.getElementById("openState").value == "��ü����") {
					document.getElementsByName("openState")[0].value = "O";
				} else {
					document.getElementsByName("openState")[0].value = "C";
				}
				document.writeForm.action = "con?action=updatePost&pno=" + pno;
			} else {
				document.writeForm.action = "con?action=deletePost&pno=" + pno;
			}
			document.writeForm.submit();
		}
	</script>
</body>
</html>