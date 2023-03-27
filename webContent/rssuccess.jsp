<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>진료 상담 예약 완료</title>
	<link rel="stylesheet" type="text/css" href="css/joinsuccessStyle.css">
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<section>
		<div class="contentWrap">
			<div class="top">
				<div class="content">
					<p>올바로병원 <strong>진료 상담 예약이 완료</strong>되었습니다.</p>
					<span>올바로병원 진료 예약해 주셔서 감사합니다.</span>	
				</div>
				
				<div class="img">
					<img alt="기타 그림" src="img/update.png">
				</div>		
			</div>
		</div>
		
		<div class="main">
			<img alt="진료 상담 예약 완료" src="img/join_end.png">
			<strong>${reservation.name}님 ${reservation.rsy}년 ${reservation.rsm}월 ${reservation.rsd}일 (${reservation.rsh}:${reservation.rsmin}) 진료 상담 예약(${reservation.doctor})이 완료되었습니다.</strong>
			<p>예약 시간 10분 전까지 1층 원무과로 도착하시면 1층 접수에서 예약 확인 부탁드립니다.</p>
			<p>진료 상담 예약을 변경 및 쉬소하실 경우 대표전화로 연락 후 변경하시기 바랍니다.</p>
			<p>${message}</p>
			<a href="main.jsp"><input type="button" value="메인페이지로 이동" class="button"></a>		
		</div>	
	</section>
</body>
</html>