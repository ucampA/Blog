<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	.detailTd	{ height: 30px; }
</style>
</head>
<body>
	<center>
	<c:choose>
		<c:when test="${blog.userid == sessionScope.userid }">
		<br><br>&nbsp;<font style="font-size:16pt;"><b>�Խñ� ����</b></font><br><br>
		</c:when>
		<c:otherwise>
		<br><br>&nbsp;<font style="font-size:16pt;"><b>�Խñ� ����</b></font><br><br>
		</c:otherwise>
	</c:choose>
	<form method="post" name="writeForm">
		<table>
			<c:choose>
				<c:when test="${blog.userid == sessionScope.userid }">
					<tr align="center" bgcolor="white"><td class="detailTd" colspan="2">${blog.no}</td></tr>
					<tr><td class="detailTd">�ۼ���:&nbsp;&nbsp;${blog.userid}</td><td align="right">��ȸ��:&nbsp;&nbsp;${blog.readcount}</td></tr>
					<tr><td class="detailTd">�ۼ���</td><td align="right">${blog.writeday}</td></tr>
					<tr><td class="detailTd">������</td><td><input type="text" name="title" size="30" value="${blog.title}"></td></tr>
					<tr>
						<td class="detailTd">��������</td>
						<td>
							<select name="openState">
								<c:choose>
									<c:when test="${blog.openState == 'O'}">
										<option selected="selected" value="O">��ü����</option>
										<option value="C">�����</option>
									</c:when>
									<c:otherwise>
										<option value="O">��ü����</option>
										<option selected="selected" value="C">�����</option>
									</c:otherwise>
								</c:choose>
							</select>
						</td>
					</tr>
					<tr><td class="detailTd" colspan="2">����</td></tr>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content">${blog.content}</textarea> </td></tr>
					<tr><td class="detailTd" colspan="2" align="center" style="height:30px;">
						<input type="button" onclick="proceed(this.value, ${blog.no})" value="update">
						<input type="button" onclick="proceed(this.value, ${blog.no})" value="delete">
					</td></tr>
				</c:when>
				<c:otherwise>
					<tr align="center" bgcolor="white"><td colspan="2">${blog.no}</td></tr>
					<tr><td class="detailTd">�ۼ���:&nbsp;&nbsp;${blog.userid}</td><td align="right">��ȸ��:&nbsp;&nbsp;${blog.readcount}</td></tr>
					<tr><td class="detailTd">�ۼ���</td><td align="right">${blog.writeday}</td></tr>
					<tr><td class="detailTd">������</td><td><input type="text" name="title" size="30" value="${blog.title}"disabled="disabled" ></td></tr>
					<tr><td class="detailTd" colspan="2">����</td></tr>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content" disabled="disabled">${blog.content}</textarea> </td></tr>
				</c:otherwise>
			</c:choose>
		</table>
		<input type="hidden" name="openState">
	</form>
	<br><br>
	
	<jsp:include page="../reple/reple.jsp"></jsp:include>
	
	</center>
	<script>
		function proceed(value, pno) {
			if(value="update") {
				document.writeForm.action = "con?action=updatePost&pno=" + pno;
			} else {
				document.writeForm.action = "con?action=deletePost&pno=" + pno;
			}
			document.writeForm.submit();
		}
	</script>
</body>
</html>