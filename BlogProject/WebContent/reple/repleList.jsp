<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${requestScope.repleList }" var="reple">
		 <div class="reple" align="left">
			<span>${reple.userid }</span>
			<span class="repledate">${fn:substring(reple.writeday,0,16)}</span>
			<c:if test="${sessionScope.userid==reple.userid }">
				<span class="repledate">
					<span onclick="updateRepleOpen(${reple.rno},${reple.pno})">수정</span>&nbsp;
					<span onclick="deleteReple(${reple.rno})">삭제</span>
				</span>
			</c:if>
			<div id="repleContent${reple.rno}">&nbsp;${reple.content }</div>
		</div>
	</c:forEach>
	
	<script type="text/javascript">

	function deleteReple(rno){
		$.ajax({			
    		url:"con?action=deleteReple",
    		data: "rno="+rno,
    		success:function(result){
      			repleList($("input[name=pno]").val());
    		}
		});
	}
	function updateRepleOpen(rno,pno,content){
		$.ajax({
			type:"post",
    		url:"reple/repleUpdate.jsp",
    		data: "rno=" +rno+ "&pno=" +pno,
    		success:function(result){
      			$("#repleContent"+rno).html(result);
    		}
		});
	}
	
	</script>
</body>
</html>