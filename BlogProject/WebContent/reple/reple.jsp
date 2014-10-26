<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<title>Insert title here</title>
</head>
<body onload="repleList(${blog.no})">
	
	<div id="repleList"></div>
	
	<c:if test="${sessionScope.userid != null }">
		reple writer ID: ${sessionScope.userid } 
		<div class="reple">
			<form name="repleFrm" method="post">
				<input type="hidden" name="pno" value="${blog.no}">
				<input type="text" name="repleContent" size="40">
				<button id="sendReple">send</button>
			</form>
		</div>
	</c:if>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#sendReple").click(function(){
				$.ajax({			
		    		url:"con?action=sendReple",
		    		data: $("form").serialize(),
		    		success:function(result){
		      			repleList($("input[name=pno]").val());
		    		}
				});
			});
		});
		function repleList(pno){
			$.ajax({			
	    		url:"con?action=repleList",
	    		data:"pno="+pno,
	    		success:function(result){
	      			$("#repleList").html(result);
	    		}
			});
		}
	</script>
	
</body>
</html>