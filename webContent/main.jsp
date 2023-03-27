<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>올바로병원</title>
	<link rel="stylesheet" type="text/css" href="css/mainStyle.css">
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="script/jquery.scrollTo.js"></script>
	<script src="script/mainScript.js"></script>
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<div class="tab">
				<div class="picture">
					<div id="img1" class="pic">
						<img alt="이미지 1" src="img/thumb.png">
					</div>
					
					<div id="img2" class="pic">
						<img alt="이미지 2" src="img/thumb (1).png">
					</div>
					
					<div id="img3" class="pic">
						<img alt="이미지 3" src="img/thumb (2).png">
					</div>
				</div>
				
				<div class="tabBtn">
					<ul>
						<li><img alt="왼쪽버튼" src="img/leftBtn.png" onmouseover="this.src='img/leftBtn2.png'" onmouseout="this.src='img/leftBtn.png'" class="prevBtn"></li>
						<li><img alt="오른쪽버튼" src="img/rightBtn.png" onmouseover="this.src='img/rightBtn2.png'" onmouseout="this.src='img/rightBtn.png'" class="nextBtn"></li>
					</ul>
				</div>
				
				<div class="phone">
					<p>24시간 진료실 운영 <span>대표전화</span>(02)587-8875</p>
				</div>
				
				<div class="guide">
					<ul>
						<li class="book">
							<div class="half">
								<c:if test="${empty loginUser || result==3}">
									<h3>진료 상담 간편 예약</h3>
								</c:if>
								
								<c:if test="${result==2}">
									<h3>진료 상담 예약 관리</h3>
								</c:if>
								
								<c:if test="${empty loginUser}">
									<span>로그인 하신 후 상담 예약을 하실 수 있습니다.</span><br/>
								</c:if>
								
								<c:if test="${result==3}">
									<span>상담 예약을 요청하시면 간편하게 예약이 됩니다.</span><br/>
								</c:if>
								
								<c:if test="${result==2}">
									<span>상담 예약 관리 페이지입니다.</span><br/>
								</c:if>
								
								<p>
									긴급(응급)수술 경우, 365일 24시간 상담을 해야 합니다.<br/>
									일반 진료 상담의 경우, 평일 외래진료 시간에 합니다.
								</p>
							</div>
							
							<div class="half">
								<table>
									<tr>
										<c:if test="${empty loginUser}">
											<td><a href="login.do"><input type="button" value="로그인 하러 가기"></a></td>
										</c:if>
										
										<c:if test="${result==3}">
											<td><a href="reservation.do"><input type="button" value="상담 예약 요청"></a></td>
										</c:if>
										
										<c:if test="${result==2}">
											<td><a href="reservationList.do"><input type="button" value="상담 예약 관리"></a></td>
										</c:if>
									</tr>
								</table>
							</div>
						</li>
											
						<li class="ect">
							<div class="half">
								<ul>
									<li><a href="#">
										<div class="img">
											<img alt="증명서류 발급안내" src="img/1.png" class="first">
											<img alt="증명서류 발급안내" src="img/1-1.png" class="second">
										</div>
										<div class="text">증명서류 발급안내</div>
									</a></li>
									
									<li><a href="#">
										<div class="img">
											<img alt="비급여 목록" src="img/2.png" class="first">
											<img alt="비급여 목록" src="img/2-1.png" class="second">
										</div>										
										<div class="text">비급여 목록</div>
									</a></li>
								</ul>	
							</div>
							<div class="half">
								<ul>
									<li><a href="#">
										<div class="img">
											<img alt="자주하는 질문" src="img/3.png" class="first">
											<img alt="자주하는 질문" src="img/3-1.png" class="second">
										</div>
										<div class="text">자주하는 질문</div>
									</a></li>
									
									<li><a href="#">
										<div class="img">
											<img alt="병원 둘러보기" src="img/4.png" class="first">
											<img alt="병원 둘러보기" src="img/4-1.png" class="second">
										</div>
										<div class="text">병원 둘러보기</div>
									</a></li>
								</ul>	
							</div>
						</li>
											
						<li class="intro">
							<ul>
								<li>진료안내</li>
								<li><a href="#">의료진소개+</a></li>
							</ul>
								
							<ul>
								<li><a href="#">
									관절센터<br/>
									<span>인공관절/스포츠</span>
								</a></li>
								
								<li><a href="#">
									외상센터<br/>
									<span>수지접합/골절</span>
								</a></li>
							
								<li><a href="#">
									통증센터<br/>
									<span>척추신경치료/비수술</span>
								</a></li>
								
								<li><a href="#">
									검진센터<br/>
									<span>내과/건강검진</span>
								</a></li>
							</ul>
						</li>
					</ul>		
				</div>
			</div>
		</section>
		
		<div id="topBtn">
			<a href="#wrap"><img alt="top 버튼" src="img/topBtn.png"></a>
		</div>
	</div>	
</body>
</html>