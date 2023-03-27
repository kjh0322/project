<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>의료진 소개</title>
	<link rel="stylesheet" type="text/css" href="css/doctorStyle.css">
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="script/jquery.scrollTo.js"></script>
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<div class="intro_main">
				<p class="intro">의료진 소개</p>
				
				<img src="img/bar.png" class="img">
		
				<c:forEach var="doctor" items="${doctorList}">
					<div class="intro_all">
						<div class="intro_left">
							<img src="img/${doctor.img}">
						</div>
					
						<div class="intro_right">
							<strong>${doctor.name}</strong> <span>${doctor.job}</span>
							<p>경력 및 논문</p>
						
							<ul class="first">
								<li>[약력]</li>
								<li>${doctor.profile1}</li>
								<li>${doctor.profile2}</li>
								<li>${doctor.profile3}</li>
								<li>${doctor.profile4}</li>
								<li>${doctor.profile5}</li>
							</ul>
							
							<ul class="second">
								<li>[자격]</li>
								<li>${doctor.spec1}</li>
								<li>${doctor.spec2}</li>
								<li>${doctor.spec3}</li>
								<li>${doctor.spec4}</li>
								<li>${doctor.spec5}</li>
								<li>${doctor.spec6}</li>
								<li>${doctor.spec7}</li>
								<li>${doctor.spec8}</li>
								<li>${doctor.spec9}</li>
								<li>${doctor.spec10}</li>
							</ul>
						</div>
					</div>
				</c:forEach>			
			</div>
		</section>
		
		<div id="topBtn">
			<a href="#wrap"><img alt="top 버튼" src="img/topBtn.png"></a>
		</div>
	</div>	
</body>
</html>