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

	<c:choose>
		<c:when test="${sessionScope.userid==null }">
			�α��� �ϼ���.
		</c:when>
		<c:when test="${sessionScope.userid=='admin' }">
			<a href="index.jsp?page=admin/memberList.jsp">�ɹ�����Ʈ</a><br>
		</c:when>
		<c:otherwise>
			<a href="index.jsp?page=board/write.jsp">�۾���</a><br>
			
		</c:otherwise>	
	</c:choose>


</body>
</html>