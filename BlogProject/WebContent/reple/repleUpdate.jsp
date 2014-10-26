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
	<form action="con?action=updateReple" name="repleUpdateFrm" method="post">
		<%-- <c:set var="repleUp" value="${param.reple}" /> --%>
		<input type="text" name="repleContent" value="${param.content }">
		<input type="hidden" name="rno" value="${param.rno }">
		<input type="hidden" name="pno" value="${param.pno }">
		<!-- <button id="repleSave">save</button> -->
		<button type="submit">save</button>
	</form>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#repleSave").click(function(){
		alert("up")
			$.ajax({	
				type:"post",
	    		url:"con?action=updateReple",
	    		data: $("repleUpdateFrm").serialize(),
	    		success:function(result){
	      			repleList($("input[name=pno]").val());
	    		}
			});
		});
	});
	
	</script>
	
</body>
</html>