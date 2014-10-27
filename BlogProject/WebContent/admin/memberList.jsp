<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/scripts/jquery-1.9.1.js"></script>
<script>
$(document).ready(function(){
    $('input').click(function () {
    	var id = jQuery(this).attr("userid");
    	$.ajax({			
    		url:"con?action=deleteMemberByID",
    		data:"id="+id,
    		success:function(result){
      			location.reload(true);
    		}
		});
    });

});
</script>
</head>
<body>
	<center>
	<table>
	<tr bgcolor="#FAECC5" align="center">
		<td>NO</td><td>ID</td><td>NAME</td><td>PHONE</td><td>BLOGNAME</td><td>추방</td>
	</tr>
		<c:forEach items="${requestScope.members}" var="member" varStatus="index">
			<c:if test="${member.userid != 'admin'}">
			<tr align="center">
				<td>${index.index+1}</td><td>${member.userid}</td>
				<td>${member.name}</td><td>${member.phone}</td><td>${member.blogname}</td><td><input userid="${member.userid}" type="button" value="삭제"></td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	</center>
</body>
</html>
