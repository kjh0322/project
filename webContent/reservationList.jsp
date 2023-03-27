<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>진료 상담 예약 리스트</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<p>진료 상담 예약 리스트</p>
			
				
			<table class="list">
				<tr>
					<td colspan="8" class="right"><a href="addReservation.do">예약 등록</a></td>
				</tr>

				<tr>
					<td colspan="8" class="left">정형외과 1 권용신</td>
				</tr>
				
				<tr>
					<th>환자명</th>
					<th>성별</th>
					<th>예약 날짜</th>
					<th>예약 시간</th>
					<th>전화번호</th>
					<th>상세보기</th>
					<th>정보 수정</th>
					<th>정보 삭제</th>
				</tr>
				
				<c:forEach var="rs1" items="${reservationList1}">
					<input type="hidden" name="no" value="${rs1.no}">
					
					<tr>
						<td>${rs1.name}</td>					
						<c:if test="${rs1.gender==1}">
							<td>남자</td>
						</c:if>					
						
						<c:if test="${rs1.gender==2}">
							<td>여자</td>
						</c:if>			
						<td>${rs1.rsy}년 ${rs1.rsm}월 ${rs1.rsd}일</td>					
						<td>${rs1.rsh}시 ${rs1.rsmin}분</td>					
						<td>${rs1.phone}</td>					
						<td><a href="reservationDetail.do?no=${rs1.no}">예약 상세 보기</a></td>					
						<td><a href="reservationUpdate.do?no=${rs1.no}">예약 정보 수정</a></td>					
						<td><a href="reservationDelete.do?no=${rs1.no}">예약 정보 삭제</a></td>					
					</tr>
				</c:forEach>
				
				<tr class="sec">
					<td colspan="8" class="left">정형외과 2 최상민</td>
				</tr>
				
				<tr>
					<th>환자명</th>
					<th>성별</th>
					<th>예약 날짜</th>
					<th>예약 시간</th>
					<th>전화번호</th>
					<th>상세보기</th>
					<th>정보 수정</th>
					<th>정보 삭제</th>
				</tr>
				
				<c:forEach var="rs2" items="${reservationList2}">
					<input type="hidden" name="no" value="${rs2.no}">
					<tr>
						<td>${rs2.name}</td>					
						<c:if test="${rs2.gender==1}">
							<td>남자</td>
						</c:if>					
						
						<c:if test="${rs2.gender==2}">
							<td>여자</td>
						</c:if>			
						<td>${rs2.rsy}년 ${rs2.rsm}월 ${rs2.rsd}일</td>					
						<td>${rs2.rsh}시 ${rs2.rsmin}분</td>					
						<td>${rs2.phone}</td>					
						<td><a href="reservationDetail.do?no=${rs2.no}">예약 상세 보기</a></td>					
						<td><a href="reservationUpdate.do?no=${rs2.no}">예약 정보 수정</a></td>					
						<td><a href="reservationDelete.do?no=${rs2.no}">예약 정보 삭제</a></td>					
					</tr>
				</c:forEach>
				
				<tr>
					<th colspan="8">
						<a href="main.jsp"><input type="button" value="메인페이지로 이동"></a>
					</th>
				</tr>
			</table>
		</section>
		
		<div id="topBtn">
			<a href="#wrap"><img alt="top 버튼" src="img/topBtn.png"></a>
		</div>
	</div>	
</body>
</html>
