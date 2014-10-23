function joinCheck(){
	var key = document.getElementsByTagName("img")[0].getAttribute("key");
	var vailed = document.getElementById("vailed").value;
	var id = document.getElementsByName("id")[0].value;
	var pw = document.getElementsByName("pw")[0].value;
	
	if(vailed != key){
		alert("문자를 다시 입력해주십시오");
		document.getElementById("vailed").focus();
		return;
	}
	if(id.length == 0 || pw.length == 0 || vailed != key){
		alert("입력을 다시해주세요");
	}else{
		alert("회원가입");
		document.joinForm.submit();
	}
}