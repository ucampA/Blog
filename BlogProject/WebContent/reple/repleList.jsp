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
 repleList in here
 	<table border="1">
 		<tr>
		 	<c:forEach items="${requestScope.repleList }" var="reple">
				<td>${reple.userid }<br>${reple.writedate }</td>
				<td>${reple.content }</td>		 		
		 	</c:forEach>
 	 	</tr>
 	</table>
 	<button onclick="javascript:location.href='../con?action=repleList&pno=1'">test</button>
</body>
</html>