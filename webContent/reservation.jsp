<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상담 예약 요청</title>
	<link rel="stylesheet" type="text/css" href="css/mypageStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<div class="contentWrap">
				<div class="top">
					<div class="content">
						<p><strong>진료 상담</strong>을 간편하게 예약하실 수 있습니다.</p>
						<span>※ 진료 상담 예약을 변경 및 쉬소하실 경우 대표전화로 연락 후 변경하시기 바랍니다.</span>
					</div>
					
					<div class="img">
						<img alt="기타 그림" src="img/update.png">
					</div>		
				</div>
			</div>
				
			<form method="post">				
				<div class="main">
					<strong><img alt="기타 그림" src="img/mypage.png">진료 상담 예약</strong>
				
					<table>					
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" value="${loginUser.id}" readonly></td>
						</tr>
		
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" value="${loginUser.name}" readonly></td>
						</tr>
						
						<tr>
							<td>성별</td>
							<td>
								<c:choose>
									<c:when test="${loginUser.gender==1}">
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
							<td>생년월일</td>
							<td>
								<input type="text" name="year" value="${loginUser.year}" readonly> 년 &nbsp;
								<input type="text" name="month" value="${loginUser.month}" readonly> 월 &nbsp;
								<input type="text" name="day" value="${loginUser.day}" readonly> 일
							</td>
						</tr>
		
						<tr>
							<td>전화번호</td>
							<td><input type="text" name="phone" value="${loginUser.phone}" readonly></td>
						</tr>
		
						<tr>
							<td>의료진 선택</td>
							<td>
								<input type="radio" name="doctor" value="권용신" checked> 권용신 
								<input type="radio" name="doctor" value="최상민"> 최상민
							</td>
						</tr>
						
						<tr>
							<td>예약 날짜</td>
							<td>
								<input type="text" name="rsy" placeholder="년(4자)" required> 년 &nbsp;
								<select name="rsm" required>
									<option value="" selected>선택하기</option>
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
								<input type="text" name="rsd" placeholder="일(2자)" required> 일
							</td>
						</tr>
						
						<tr>
							<td>예약 시간</td>
							<td>
								<select name="rsh" required class="selectBox">
			                       <option value="" selected>선택하기</option>
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
			                       <option value="" selected>선택하기</option>
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
							<td>예약내용</td>
							<td><textarea cols="95" rows="7" name="content"></textarea></td>
						</tr>
						
						<tr>
							<th colspan="2">
								<input type="submit" value="예약하기"> &nbsp;
								<input type="reset" value="재입력">
							</th>
						</tr>
					</table>
				</div>	
			</form>	
		</section>
		
		<div id="topBtn">
			<a href="#wrap"><img alt="top 버튼" src="img/topBtn.png"></a>
		</div>
	</div>
</body>
</html>