//필수항목 회원정보 유효성 체크
/*변수 선언*/
var id=document.querySelector('#id');

var pw=document.querySelector('#pw');
var pwMsg=document.querySelector('#alertTxt');
var pwImg1=document.querySelector('#pwImg1');
var pwMsgArea=document.querySelector('.int_pass');

var pw_re=document.querySelector('#pw_re');
var pwImg2=document.querySelector('#pwImg2');

var userName=document.querySelector('#name');

var year=document.querySelector('#year');
var month=document.querySelector('#month');
var day=document.querySelector('#day');

var email1=document.querySelector('#email1');
var email2=document.querySelector('#email2');

var phone=document.querySelector('#phone');

var error=document.querySelectorAll('.error_next_box');

/*이벤트 핸들러 연결*/
id.addEventListener("focusout", checkId);
pw.addEventListener("focusout", checkPw);
pw_re.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
year.addEventListener("focusout", isBirthCompleted);
month.addEventListener("focusout", isBirthCompleted);
day.addEventListener("focusout", isBirthCompleted);
email1.addEventListener("focusout", isEmailCorrect);
email2.addEventListener("focusout", isEmailCorrect);
phone.addEventListener("focusout", checkPhoneNum);

/*콜백 함수 생성*/
function checkId(){
	var idPattern = /[a-zA-Z0-9_-]{3,20}/;
	if(id.value === ""){
		error[0].innerHTML = "필수 정보입니다.";
		error[0].style.display = "block";
	}else if(!idPattern.test(id.value)){
		error[0].innerHTML = "영문(대∙소문자), 숫자, 특수문자(-, _)로 3~20자 이내로 입력해 주세요.";
		error[0].style.display = "block";
	}else{
		error[0].style.display = "none";
	}
}

function checkPw(){
	var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{4,16}/;
	if(pw.value === ""){
		error[1].innerHTML = "필수 정보입니다.";
		error[1].style.display = "block";
	}else if(!pwPattern.test(pw.value)){
		error[1].innerHTML = "영문(대∙소문자), 숫자, 특수문자로 4~16자 이내로 입력해 주세요.";
		pwMsg.innerHTML = "사용불가";
		error[1].style.display = "block";
		pwMsg.style.display = "block";
		pwImg1.src = "img/icon_not_use.png";
	}else{
		error[1].style.display = "none";
		pwMsg.innerHTML = "안전";
		pwMsg.style.display = "block";
		pwMsg.style.color = "#03c75a";
		pwImg1.src = "img/icon_safe.png";
	}
}

function comparePw(){
	if(pw_re.value === pw.value && pw_re.value !== ""){
		pwImg2.src = "img/icon_check_enable.png";
		error[2].style.display = "none";
	}else if(pw_re.value !== pw.value){
		pwImg2.src = "img/icon_check_disable.png";
		error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
		error[2].style.display = "block";
	}if(pw_re.value === ""){
		error[2].innerHTML = "필수 정보입니다.";
		error[2].style.display = "block";
	}
}

function checkName(){
	var namePattern = /[a-zA-Z가-힣]/;
	if(userName.value === ""){
		error[3].innerHTML = "필수 정보입니다.";
		error[3].style.display = "block";
	}else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1){
		error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요(특수문자 및 공백 사용 불가)";
		error[3].style.display = "block";
	}else{
		error[3].style.display = "none";
	}
}

function isBirthCompleted(){
	var yearPattern = /[0-9]{4}/;
	if(year.value === ""){
		error[4].innerHTML = "태어난 년도를 입력해주세요.";
		error[4].style.display = "block";
	}else if(!yearPattern.test(year.value)){
		error[4].innerHTML = "태어난 년도 4자리를 정확하게 입력하세요.";
		error[4].style.display = "block";
	}else{
		isMonthSelected();
	}
	
	function isMonthSelected(){
		if(month.value === ""){
			error[4].innerHTML = "태어난 월을 선택하세요.";
			error[4].style.display = "block";
		}else{
			isDateCompleted();
		}
	}
	
	function isDateCompleted(){
		if(day.value === ""){
			error[4].innerHTML = "태어난 일을 입력해주세요.";
			error[4].style.display = "block";
		}else{
			isDayRight();
		}
	}	
}

function isDayRight(){
	var datePattern = /\d{2}/;
	if(!datePattern.test(day.value) || Number(day.value)<1 || Number(day.value)>31){
			error[4].innerHTML = "태어난 일을 다시 확인해주세요.";
	}else{
		checkAge();
	}
}

function checkAge(){
	if(Number(year.value) < 1920){
		error[4].innerHTML = "태어난 년도를 확인해주세요.";
		error[4].style.display = "block";
	}else if(Number(year.value) > 2023){
		error[4].innerHTML = "존재하지 않는 년도입니다.";
		error[4].style.display = "block";
	}else if(Number(year.value) > 2008){
		error[4].innerHTML = "만 14세 미만의 어린이는 보호자 동의가 필요합니다.";
		error[4].style.display = "block";
	}else{
		error[4].style.display = "none";
	}
}
	
function isEmailCorrect(){
	var email1Pattern = /[a-zA-Z0-9]{2,}/;
	var email2Pattern = /[a-zA-Z0-9-]{2,}\.[a-zA-Z0-9]{2,}/;
	if(email1.value === "" && email2.value === ""){
		error[5].style.display = "none";
	}else if(!email1Pattern.test(email1.value)){
		error[5].style.display = "block";
	}else if(!email2Pattern.test(email2.value)){
		error[5].style.display = "block";
	}else{
		error[5].style.display = "none";
	}
}

function checkPhoneNum(){
	var isPhoneNum= /([01]{2})([01679]{1})-([0-9]{3,4})-([0-9]{4})/;
	if(phone.value === ""){
		error[6].innerHTML = "필수 정보입니다.";
		error[6].style.display = "block";
	}else if(!isPhoneNum.test(phone.value)){
		error[6].innerHTML = "형식에 맞지 않는 번호입니다.";
		error[6].style.display = "block";
	}else{
		error[6].style.display = "none";
	}
}