<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css" />
<script src="<%=request.getContextPath()%>/scripts/jquery-1.9.1.js"></script>
<script>
$(document).ready(function(){
	var imgJson;
    $.getJSON("common/imgJson.jsp", function(result){
    	imgJson = result;
    	var index = Math.floor(Math.random() * result.length);
    	jQuery("img").attr("src","img/"+result[index].img);
    	jQuery("img").attr("key",result[index].key);
    })
    
    $('#reset').click(function () {
    	var index = Math.floor(Math.random() * imgJson.length);
    	jQuery("img").attr("src","img/"+imgJson[index].img);
    	jQuery("img").attr("key",imgJson[index].key);    
    });

});
</script>

<title>Insert title here</title>
</head>
<body>
<br><br>
	<center>
	<form action="con?action=join" method="post" name="joinForm">
		<table height="300px">
		<tr align="left"><td colspan="2">회원가입</td></tr>
		<tr><td align="right">id</td><td><input type="text" name="id"><span class="comment">&nbsp;4글자 이상입력해주세요</span></td></tr>
		<tr><td align="right">pw</td><td><input type="password" name="pw"><span class="comment">&nbsp;4글자 이상입력해주세요</span></td></tr>
		<tr><td align="right">name</td><td><input type="text" name="name"></td></tr>
		<tr><td align="right">phone</td><td><input type="text" name="phone"></td></tr>
		<tr><td align="right">blog title</td><td><input type="text" name="title"></td></tr>
		<tr><td align="right"><img></td><td><input type="text" id="vailed">&nbsp;<input type="button" id="reset" value="새로고침"></td></tr>
		<tr><td colspan="2" align="right"><input type="button" value="회원가입" onclick="joinCheck()"></td></tr>
		</table>
	</form>
	</center>
	<script src="<%=request.getContextPath()%>/scripts/myfunction.js"></script>
</body>
</html>