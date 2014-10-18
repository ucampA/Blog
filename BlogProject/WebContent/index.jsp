<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="header"><jsp:include page="common/header.jsp"/></div>
		<div id="content"><jsp:include page="blog/blogList.jsp"/></div>
		<div id="login"><jsp:include page="common/login.jsp"/></div>
		<div id="menu"><jsp:include page="common/menu.jsp"/></div>
		<div id="footer">footer</div>
	</div>
</body>
</html>