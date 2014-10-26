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
	<c:when test="${blog.userid == sessionScope.userid }">
	게시글 수정
	</c:when>
	<c:otherwise>
	게시글 보기
	</c:otherwise>
</c:choose>
	<center>
	<form method="post" name="writeForm">
		<table>
			<c:choose>
				<c:when test="${blog.userid == sessionScope.userid }">
				<tr align="center" bgcolor="white"><td colspan="2">${blog.no}</td></tr>
				<tr><td>글제목</td><td><input type="text" name="title" size="30" value="${blog.title}"></td></tr>
				<tr><td>작성자: ${blog.userid}</td><td>조회수:${blog.readcount}</td></tr>
				<tr><td colspan="2">작성일: ${blog.writeday}</td></tr>
					<tr><td>
						<select name="openState">
							<c:choose>
								<c:when test="${blog.openState == 'O'}">
									<option selected="selected" value="O">전체공개</option>
									<option value="C">비공개</option>
								</c:when>
								<c:otherwise>
									<option value="O">전체공개</option>
									<option selected="selected" value="C">비공개</option>
								</c:otherwise>
							</c:choose>
						</select>
					</td></tr>
					<tr><td colspan="2">내용</td></tr>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content">${blog.content}</textarea> </td></tr>
					<tr><td align="right">
						<input type="button" onclick="proceed(this.value, ${blog.no})" value="update">
						<input type="button" onclick="proceed(this.value, ${blog.no})" value="delete">
					</td></tr>
				</c:when>
				<c:otherwise>
					<tr align="center" bgcolor="white"><td colspan="2">${blog.no}</td></tr>
					<tr><td>글제목</td><td><input type="text" name="title" size="30" value="${blog.title}"disabled="disabled" ></td></tr>
					<tr><td>작성자: ${blog.userid}</td><td>조회수:${blog.readcount}</td></tr>
					<tr><td colspan="2">내용</td></tr>
					<tr><td colspan="2"><textarea rows="10" cols="60" name="content" disabled="disabled">${blog.content}</textarea> </td></tr>
				</c:otherwise>
			</c:choose>
		</table>
		<input type="hidden" name="openState">
	</form>
	
	
	<jsp:include page="../reple/repleList.jsp"></jsp:include><br>
	<c:if test="${sessionScope.userid != null }">
		<jsp:include page="../reple/reple.jsp"></jsp:include>
	</c:if>
	
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