<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	reple writer ID: ${sessionScope.userid } 
	<form action="con?action=sendReple" name="repleFrm" method="post">
		<input type="text" name="repleContent">
		<input type="hidden" name="pno" value="${blog.no}">
	</form>
	<button onclick="sendReple()">send</button>
	
	<script type="text/javascript">
		/* function proceed(value, pno) {
			if(value="update") {
				if(document.getElementById("openState").value == "전체공개") {
					document.getElementsByName("openState")[0].value = "O";
				} else {
					document.getElementsByName("openState")[0].value = "C";
				}
				document.writeForm.action = "con?action=updatePost&pno=" + pno;
			} else {
				document.writeForm.action = "con?action=deletePost&pno=" + pno;
			}
			document.writeForm.submit();
		} */
		function sendReple(){
			document.repleFrm.submit();
		}
		
	</script>
	
</body>
</html>