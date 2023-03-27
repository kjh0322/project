<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약 상세 정보</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
	
		<section>
			<p>예약 상세 정보</p>
			
			<form method="get" name="frm">				
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
						<c:if test="${reservation.doctor=='권용신'}">
							<td>권용신</td>
						</c:if>					
						
						<c:if test="${reservation.doctor=='최상민'}">
							<td>최상민</td>
						</c:if>			
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