// 로그인 폼 제어
function loginCheck(){
	if(document.frm.id.value==""){
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	
	if(document.frm.pw.value==""){
		alert("비밀번호를 입력해주세요");
		frm.pw.focus();
		return false;
	}
	return true;
}

//아이디 중복 체크
function idCheck(){
	if(document.frm.id.value==""){
		alert("아이디를 입력해주세요.")
		frm.id.focus();
		return ;
	}
	
	// 중복체크를 위한 창띄우기 스크립트 작성하고
	//데이터베이스에 존재하는 아이디인지 점검하여 사용여부 판단
	var url="idCheck.do?id="+document.frm.id.value;
	window.open(url,"_blank_1","width=350, height=130, toolbar=no, menubar=no, resizable=no, scrollbars=yes")
}

//아이디 중복 체크 완료 처리를 위한 자바스크립트 함수
function idok(id){
	opener.frm.id.value=document.frm.id.value;
	opener.frm.id_re.value=document.frm.id.value;
	self.close();
}

//필수항목 회원정보 유효성 체크
function joinCheck(){
	if(document.frm.id.value==""){
		alert("아이디를 입력해주세요.")
		frm.id.focus();
		return false;
	}
	
	if(document.frm.id_re.value==""){
		alert("아이디 중복체크를 해주세요")
		frm.id.focus();
		return false;
	}
	
	if(document.frm.pw.value==""){
		alert("비밀번호를 입력해주세요.")
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.pw_re.value==""){
		alert("비밀번호를 다시 입력해주세요.")
		frm.pw_re.focus();
		return false;
	}
	
	if(document.frm.pw.value != document.frm.pw_re.value){
		alert("비밀번호가 일치하지 않습니다.")
		frm.pw_re.focus();
		return false;
	}
	
	if(document.frm.name.value==""){
		alert("이름을 입력해주세요.")
		frm.name.focus();
		return false;
	}
	
	if(document.frm.year.value==""){
		alert("태어난 년도를 입력해주세요.")
		frm.year.focus();
		return false;
	}	
	
	if(document.frm.month.value==""){
		alert("태어난 월를 입력해주세요.")
		frm.month.focus();
		return false;
	}
	
	if(document.frm.day.value==""){
		alert("태어난 일를 입력해주세요.")
		frm.day.focus();
		return false;
	}
	
	if(document.frm.phone.value==""){
		alert("전화번호를 입력해주세요.")
		frm.phone.focus();
		return false;
	}
	return true;
}
