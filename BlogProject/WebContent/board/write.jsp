<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<br><br><font style="font-size:16pt;"><b>�Խñ� ����</b></font><br><br><br>
	<form method="post" name="writeForm">
		<table>
			<tr>
				<td style="width:80px;">��������</td>
				<td>
					<select id="openState">
						<option>��ü����</option>
						<option>�����</option>
					</select>
				</td>
			</tr>
			<tr><td colspan="2">����</td></tr>
			<tr><td colspan="2"><input type="text" name="title" size="55"></td></tr>
			<tr><td colspan="2">����</td></tr>
			<tr><td colspan="2"><textarea rows="10" cols="60" name="content"></textarea> </td></tr>
			<tr><td colspan="2" align="right"><input type="button" onclick="postWrite()" value="���"></td></tr>
		</table>
		<input type="hidden" name="openState">
	</form>
	</center>
	<script>
		function postWrite() {
			if(document.getElementById("openState").value == "��ü����") {
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