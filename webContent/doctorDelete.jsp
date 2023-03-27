<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>의료진 정보 삭제</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<p>의료진 정보 삭제</p>
			
			<form method="post" name="frm">
				
				<input type="hidden" name="code" value="${doctor.code}">
				
				<table class="update">
					<tr>
						<th rowspan="18" class="img"><img src="img/${doctor.img}"></th>
						<th>이름</th>
						<td>${doctor.name}</td>
					</tr>
					
					<tr>
						<th>직급</th>
						<td>${doctor.job}</td>
					</tr>

					<tr>
						<th rowspan="5">약력</th>
						<td>${doctor.profile1}</td>
					</tr>

					<tr>
						<td>${doctor.profile2}</td>
					</tr>

					<tr>
						<td>${doctor.profile3}</td>
					</tr>

					<tr>
						<td>${doctor.profile4}</td>
					</tr>

					<tr>
						<td>${doctor.profile5}</td>
					</tr>

					<tr>
						<th rowspan="10">자격</th>
						<td>${doctor.spec1}</td>
					</tr>

					<tr>
						<td>${doctor.spec2}</td>
					</tr>

					<tr>
						<td>${doctor.spec3}</td>
					</tr>

					<tr>
						<td>${doctor.spec4}</td>
					</tr>

					<tr>
						<td>${doctor.spec5}</td>
					</tr>
					
					<tr>
						<td>${doctor.spec6}</td>
					</tr>

					<tr>
						<td>${doctor.spec7}</td>
					</tr>

					<tr>
						<td>${doctor.spec8}</td>
					</tr>

					<tr>
						<td>${doctor.spec9}</td>
					</tr>

					<tr>
						<td>${doctor.spec10}</td>
					</tr>
					
					<tr>
						<th>사진</th>
						<td>${doctor.img}</td>
					</tr>
					
					<tr>
						<th colspan="3">
							<input type="submit" value="삭제">
							<a href="doctorList.do"><input type="button" value="목록"></a>
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