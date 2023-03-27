<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<link rel="stylesheet" type="text/css" href="css/headerStyle.css">

<header>
	<div class="contentWrap">
		<div class="logo">
			<ul>
				<li><a href="main.jsp"><img alt="올바로로고" src="img/logo1.PNG"></a></li>
			</ul>
		</div>
		
		<div class="nav">
			<div class="left">
				<ul>
					<c:if test="${empty loginUser || result==3}">
						<li><a href="doctor.do">의료진 소개</a></li>
						<li><a href="#">이용 안내</a></li>
						<li><a href="#">진료 안내</a></li>
						<li><a href="#">어디가 아프세요?</a></li>
						<li><a href="#">올바로 소통</a></li>
					</c:if>	

					<c:if test="${result==2}">
						<li><a href="doctorList.do">의료진 관리</a></li>
						<li><a href="adminList.do">사원 관리</a></li>
						<li><a href="reservationList.do">예약 관리</a></li>
						<li><a href="addAdmin.do">사원 등록</a></li>
						<li><a href="#">올바로 소통</a></li>
					</c:if>	
					
					
				</ul>
			</div>
			
			<div class="right">
				<ul>
					<c:if test="${empty loginUser}">
						<li><a href="login.do">로그인</a></li>
						<li><a href="join.do">회원가입</a></li>
					</c:if>		
										
					<c:if test="${!empty loginUser}">
						<c:choose>
							<c:when test="${result==3}">
								<li><a href="mypage.do?id=${loginUser.id}"><span>${loginUser.name}</span>님 마이페이지</a></li>
							</c:when>	

							<c:when test="${result==2}">
								<li><a href="mypage.do?id=${loginUser.id}">관리자 <span>${loginUser.name}</span>님 마이페이지</a></li>
							</c:when>	
						</c:choose>	
						<li><a href="logout.do">로그아웃</a></li>
					</c:if>							
				</ul>
			</div>
		</div>
	</div>		
</header>   