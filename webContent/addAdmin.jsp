<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 정보 등록</title>
	<link rel="stylesheet" type="text/css" href="css/joinStyle.css">
	<script src="script/member.js"></script>
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<section>
		<div class="contentWrap">
			<div class="top">
				<div class="content">
					<p><strong>올바로병원</strong> 관리자를 등록해주세요</p>
					<span>
						관리자 정보를 입력해주세요.<br/>
						관리자 정보를 입력 후 가입이 완료됩니다.
					</span>
				</div>
				
				<div class="img">
					<img alt="기타 그림" src="img/update.png">
				</div>		
			</div>
		</div>
			
		<form action="addadmin.do" method="post" name="frm">				
			<div class="main">
				<div class="middle">
					<div class="input">
						<strong><img alt="기타 그림" src="img/mypage.png">관리자 기본 정보 입력</strong>
					</div>
					
					<div class="notice">
						<span><img alt="주의사항" src="img/notice.png">아이디는 수정이 불가능하므로 정확한 정보를 입력해주세요.</span>
					</div>
				</div>
			
				<table>
					<tr>
						<td><span>*</span> 아이디</td>
						<td>
							<div class="box">
								<input type="text" name="id" id="id" required>
								<input type="hidden" name="id_re" required>
								<input type="button" value="중복체크" onclick="return idCheck()" class="inR">
							</div>
							<span class="error_next_box"></span>	
						</td>
					</tr>
	
					<tr>
						<td><span>*</span> 비밀번호</td>
						<td>
							<div class="box int_pass">
								<input type="password" name="pw" id="pw" required>
								<span id="alertTxt">사용불가</span>
								<img src="img/icon_pass.png" alt="비밀번호" class="inR pwImg" id="pwImg1"><br/>
							</div>	
							<span class="error_next_box"></span>
						</td>
					</tr>
					
					<tr>
						<td><span>*</span> 비밀번호 확인</td>
						<td>
							<div class="box">	
								<input type="password" name="pw_re" id="pw_re" required>
								<img src="img/icon_check_disable.png" alt="비밀번호 확인" class="inR pwImg" id="pwImg2"><br/>
							</div>
							<span class="error_next_box"></span>
						</td>
					</tr>
					
					<tr>
						<td><span>*</span> 이름</td>
						<td>
							<div class="box">
								<input type="text" name="name" id="name" required>
							</div>
							<span class="error_next_box"></span>
						</td>	
					</tr>
					
					<tr>
						<td><span>*</span> 성별</td>
						<td>
							<input type="radio" name="gender" id="gender" value="1" checked> 남자 
							<input type="radio" name="gender" id="gender" value="2"> 여자
						</td>
					</tr>
					
					<tr>
						<td><span>*</span> 생년월일</td>
						<td>
							<div class="box">
								<input type="text" name="year" id="year" placeholder="년(4자)" required>
								<select name="month" id="month" required>
									<option value="" selected>월</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								<input type="text" name="day" id="day" placeholder="일(2자)" required>
							</div>
							<span class="error_next_box"></span>
						</td>
					</tr>
	
					<tr>
						<td>&nbsp; &nbsp; 이메일</td>
						<td>
							<div class="box">
								<input type="text" name="email1" id="email1"> @ 
								<input type="text" name="email2" id="email2"> &nbsp;
								<select name="email2" id="email2" class="selectBox">
			                       <option value="" selected>직접입력</option>
			                       <option value="daum.net">daum.net</option>
			                       <option value="gmail.com">gmail.com</option>
			                       <option value="hanmail.net">hanmail.net</option>
			                       <option value="naver.com">naver.com</option>
			                       <option value="nate.com" >nate.com</option>                
			                   </select>
		                   </div>
		                   <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
						</td>
					</tr>
					
					<tr>
						<td><span>*</span> 전화번호</td>
						<td>
							<div class="box">
								<input type="text" name="phone" id="phone" placeholder="전화번호 '-'를 포함하여 입력">
							</div>
							<span class="error_next_box"></span>	
						</td>
					</tr>
					
					
					<tr>
						<th colspan="2">
							<input type="submit" value="회원가입" onclick="return joinCheck()"> &nbsp;
							<input type="reset" value="재입력">
						</th>
					</tr>
				</table>
			</div>	
		</form>
	</section>
	<script src="script/join.js"></script>
</body>
</html>