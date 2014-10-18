<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


menu<br>

로그인시에<br>
글쓰기<br>
삭제<br>
수정<br>

	<c:choose>
		<c:when test="${sessionScope.userid==null }">
			로그인 하세영.
		</c:when>
		<c:otherwise>
			<a href="index.jsp?page=board/write.jsp">글쓰기</a><br>
			<a href="#">삭제</a><br>
			<a href="#">수정</a><br>
		</c:otherwise>	
	</c:choose>


</body>
</html>