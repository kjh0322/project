<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>진료 상담 예약 정보 수정</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<p>진료 상담 예약 정보 수정</p>
			
			<form method="post">
				
				<input type="hidden" name="no" value="${reservation.no}">
				
				<table class="rs">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id" value="${reservation.id}" readonly></td>
					</tr>
					
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${reservation.name}" readonly></td>
					</tr>
					
					<tr>
						<th>성별</th>
						<td>
							<c:choose>
								<c:when test="${reservation.gender==1}">
									<input type="radio" name="gender" value="1" checked onclick="return(false)"> 남자 
									<input type="radio" name="gender" value="2" onclick="return(false)"> 여자
								</c:when>
								
								<c:otherwise>
									<input type="radio" name="gender" value="1" onclick="return(false)"> 남자 
									<input type="radio" name="gender" value="2" checked onclick="return(false)"> 여자
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>
						<th>생년월일</th>
						<td>
							<input type="text" name="year" value="${reservation.year}" readonly> 년 &nbsp;
							<input type="text" name="month" value="${reservation.month}" readonly> 월 &nbsp;
							<input type="text" name="day" value="${reservation.day}" readonly> 일
						</td>
					</tr>
	
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="phone" value="${reservation.phone}" readonly></td>
					</tr>
	
					<tr>
						<th>의료진 선택</th>
						<td>
							<c:choose>
								<c:when test="${reservation.doctor=='권용신'}">
									<input type="radio" name="doctor" value="권용신" checked> 권용신 
									<input type="radio" name="doctor" value="최상민"> 최상민
								</c:when>
								
								<c:otherwise>
									<input type="radio" name="doctor" value="권용신"> 권용신 
									<input type="radio" name="doctor" value="최상민" checked> 최상민
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>
						<th>예약 날짜</th>
						<td>
							<input type="text" name="rsy" placeholder="년(4자)" value="${reservation.rsy}"  required> 년 &nbsp;
							<select name="rsm" required>
								<option value="${reservation.rsm}" selected>${reservation.rsy}</option>
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
							</select> 월 &nbsp;
							<input type="text" name="rsd" placeholder="일(2자)" value="${reservation.rsd}" required> 일
						</td>
					</tr>
					
					<tr>
						<th>예약 시간</th>
						<td>
							<select name="rsh" required class="selectBox">
		                       <option  value="${reservation.rsh}" selected>${reservation.rsh}</option>
		                       <option value="09">09</option>                
		                       <option value="10">10</option>                
		                       <option value="11">11</option>                
		                       <option value="12">12</option>                
		                       <option value="14">14</option>                
		                       <option value="15">15</option>                
		                       <option value="16">16</option>                
		                       <option value="17">17</option>                
		                       <option value="18">18</option>                
		                   </select> 시 &nbsp;

							<select name="rsmin" required class="selectBox">
		                       <option  value="${reservation.rsmin}" selected>${reservation.rsmin}</option>
		                       <option value="00">00</option>                
		                       <option value="10">10</option>                
		                       <option value="20">20</option>                
		                       <option value="30">30</option>                
		                       <option value="40">40</option>                
		                       <option value="50">50</option>                
		                   </select> 분 &nbsp;
						</td>
					</tr>
					
					<tr>
						<th>예약 내용</th>
						<td><textarea cols="95" rows="7" name="content" >"${reservation.content}"</textarea></td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input type="submit" value="수정">
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