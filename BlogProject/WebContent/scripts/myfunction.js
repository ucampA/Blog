function joinCheck(){
	var key = document.getElementsByTagName("img")[0].getAttribute("key");
	var vailed = document.getElementById("vailed").value;
	var id = document.getElementsByName("id")[0].value;
	var pw = document.getElementsByName("pw")[0].value;
	
	if(vailed != key){
		alert("���ڸ� �ٽ� �Է����ֽʽÿ�");
		document.getElementById("vailed").focus();
		return;
	}
	if(id.length == 0 || pw.length == 0 || vailed != key){
		alert("�Է��� �ٽ����ּ���");
	}else{
		alert("ȸ������");
		document.joinForm.submit();
	}
}