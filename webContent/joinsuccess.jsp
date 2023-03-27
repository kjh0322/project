<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 완료</title>
	<link rel="stylesheet" type="text/css" href="css/joinsuccessStyle.css">
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<section>
		<div class="contentWrap">
			<div class="top">
				<div class="content">
					<c:if test="${empty loginUser}">
						<p>올바로병원 홈페이지 <strong>회원가입이 완료</strong>되었습니다.</p>
						<span>올바로병원 홈페이지에 가입해 주셔서 감사합니다.</span>
					</c:if>
					
					<c:if test="${result==2}">
						<p>올바로병원 <strong>사원 등록이 완료</strong>되었습니다.</p>
						<span>사원 등록해 주셔서 감사합니다.</span>
					</c:if>	
				</div>
				
				<div class="img">
					<img alt="기타 그림" src="img/update.png">
				</div>		
			</div>
		</div>
		
		<div class="main">
			<img alt="회원가입 완료" src="img/join_end.png">
			<c:if test="${empty loginUser}">
				<strong>${member.name}[<span>${member.id}</span>]의 ${message}</strong>
				<p>올바로병원 홈페이지의 서비스를 로그인 후에 정상적으로 이용하실 수 있습니다.</p>
				<p>회원가입 내역 확인 및 수정은 마이페이지에서 가능합니다.</p>
				<a href="login.do"><input type="button" value="로그인"></a>
			</c:if>	
			
			<c:if test="${result==2}">
				<strong>관리자 ${member.name}[<span>${member.id}</span>]의 ${message}</strong>
				<p>관리자 ${member.name}님은 로그인 후에 정상적으로 홈페이지 사용이 가능합니다.</p>
				<p>사원등록 내역 확인 및 수정은 사원관리에서 가능합니다.</p>
				<a href="main.jsp"><input type="button" value="메인페이지로 이동" class="button"></a>
			</c:if>		
		</div>	
	</section>
</body>
</html>