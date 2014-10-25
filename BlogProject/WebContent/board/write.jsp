<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
게시글 쓰기
	<center>
	<form method="post" name="writeForm">
		<table>
			<tr><td>
				<select id="openState">
					<option>전체공개</option>
					<option>비공개</option>
				</select>
			</td></tr>
			<tr><td>제목</td></tr>
			<tr><td><input type="text" name="title" size="55"></td></tr>
			<tr><td>내용</td></tr>
			<tr><td><textarea rows="10" cols="60" name="content"></textarea> </td></tr>
			<tr><td align="right"><input type="button" onclick="postWrite()" value="등록"></td></tr>
		</table>
		<input type="hidden" name="openState">
	</form>
	</center>
	<script>
		function postWrite() {
			if(document.getElementById("openState").value == "전체공개") {
				document.getElementsByName("openState")[0].value = "O";
			} else {
				document.getElementsByName("openState")[0].value = "C";
			}
			document.writeForm.action = "con?action=write";
			document.writeForm.submit();
		}
	</script>
</body>
</html>