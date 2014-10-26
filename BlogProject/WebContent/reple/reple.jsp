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
<body>

	<div id="repleList"></div>
	
	<c:if test="${sessionScope.userid != null }">
		reple writer ID: ${sessionScope.userid } 
		<form name="repleFrm" method="post">
			<input type="hidden" name="pno" value="${blog.no}">
			<input type="text" name="repleContent">
			<button id="sendReple">send</button>
			<!-- <button onclick="sendReple()">send</button> -->
		</form>
	</c:if>
	<script type="text/javascript">
		/* function sendReple(){
			document.repleFrm.submit();
		} */
		
		
		$(document).ready(function(){
			
			repleList();
			
			
			$("#sendReple").click(function(){
				$.ajax({			
		    		url:"con?action=sendReple",
		    		data: $("form").serialize(),
		    		success:function(result){
		    			//alert("send complite");
		      			//$("#repleList").html(result);
		      			repleList();
		    		}
				});
			});
		});
		function repleList(){
			$.ajax({			
	    		url:"con?action=repleList",
	    		data:"pno=1",
	    		success:function(result){
	    			alert("reple List");
	      			$("#repleList").html(result);
	    		}
			});
		}
		
	</script>
	
</body>
</html>