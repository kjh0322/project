<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
	<script src="script/member.js"></script> 
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<section>
		<div class="contentWrap">
			<div class="top">
				<div class="content">
					<p>올바로병원 <strong>로그인</strong></p>
					<span>
						로그인이 필요한 서비스입니다.<br/>
						올바로병원 회원 아이디와 비밀번호를 이용하여 로그인하여 주세요.
					</span>
				</div>
				
				<div class="img">
					<img alt="의사 이미지" src="img/doctor.PNG">
				</div>
			</div>
			
			<form action="login.do" method="post" name="frm">				
				<div class="main">
					<p>
						<input type="radio" name="lev" value="A"> 관리자 &nbsp; &nbsp; &nbsp;
						<input type="radio" name="lev" value="B" checked> 일반회원	
					</p>
				
					<div class="login">
						<div class="left">
							<input type="text" name="id" placeholder="회원아이디">
							<input type="password" name="pw" placeholder="비밀번호">
						</div>
						
						<div class="right">
							<input type="submit" value="로그인" onclick="return loginCheck();">
						</div>	
					</div>
					
					<div class="ect">
						<ul>
							<li><a href="join.do">회원가입</a></li>
							<li><a href="main.jsp">메인페이지로 이동</a></li>						
						</ul>
					</div>
				</div>	
			</form>
		</div>	
	</section>
</body>
</html>