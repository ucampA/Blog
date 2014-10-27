<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	.updateTd {
		width:100px;
		text-align: center;
		height: 30px;
	}
</style>
</head>
<body>
	<center>
		 <br><br><font style="font-size:16pt;"><b>정보수정</b></font><br><br>
		 <form action="con?action=updateSave" method="post" name="updateFrm">
		 	<table>
				<tr><td class="updateTd">아이디</td><td>${requestScope.bean.getUserid() }</td></tr>
				<tr><td class="updateTd">패스워드</td><td><input type="text" name="pw" value="${requestScope.bean.getUserpw() }"></td></tr>
				<tr><td class="updateTd">이름</td><td><input type="text" name="name" value="${requestScope.bean.getName() }"></td></tr>
				<tr><td class="updateTd">연락처</td><td><input type="text" name="phone" value="${requestScope.bean.getPhone() }"></td></tr>
				<tr><td class="updateTd">블로그이름</td><td><input type="text" name="title" value="${requestScope.bean.getBlogname() }"></td></tr>
			</table>
			<br>
			<button type="submit">Save</button>
		</form>
	</center>
</body>
</html>