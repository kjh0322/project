<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>진료 상담 예약 정보 삭제</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
	
		<section>
			<p>진료 상담 예약 정보 삭제</p>
			
			<form method="post" name="frm">
			
				<input type="hidden" name="no" value="${reservation.no}">
				
				<table class="etc">
					<tr>
						<th>아이디</th>
						<td>${reservation.id}</td>
					</tr>
	
					<tr>
						<th>이름</th>
						<td>${reservation.name}</td>
					</tr>
					
					<tr>
						<th>성별</th>
						<c:if test="${reservation.gender==1}">
							<td>남자</td>
						</c:if>					
						
						<c:if test="${reservation.gender==2}">
							<td>여자</td>
						</c:if>			
					</tr>
					
					<tr>
						<th>생년월일</th>
						<td>${reservation.year}년 ${reservation.month}월 ${reservation.day}일</td>
					</tr>
					
					<tr>
						<th>전화번호</th>
						<td>${reservation.phone}</td>
					</tr>
					
					<tr>
						<th>의료진 선택</th>
						<td>${reservation.doctor}</td>	
					</tr>
					
					<tr>
						<th>예약 날짜</th>
						<td>${reservation.rsy}년 ${reservation.rsm}월 ${reservation.rsd}일</td>
					</tr>
					
					<tr>
						<th>예약 시간</th>
						<td>${reservation.rsh}시 ${reservation.rsmin}분</td>
					</tr>
					
					<tr>
						<th>예약 내용</th>
						<td>${reservation.content}</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input type="submit" value="삭제">
							<a href="reservationList.do"><input type="button" value="목록"></a>
						</th>
					</tr>
				</table>
			</form>
		</section>
	<div id="topBtn">
			<a href="#wrap"><img alt="top 버튼" src="img/topBtn.png"></a>
		</div>
	</div>	
</body>
</html>