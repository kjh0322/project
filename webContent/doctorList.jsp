<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>의료진 리스트</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<p>의료진 리스트</p>
	
			<table class="list">
				<tr>
					<td colspan="5" class="right">
						<a href="addDoctor.do">정보 등록</a>
					</td>
				</tr>
				
				<tr>
					<th>이름</th>
					<th>직급</th>
					<th>상세 정보</th>
					<th>정보 수정</th>
					<th>정보 삭제</th>
				</tr>
				
				<c:forEach var="doctor" items="${doctorList}">
					<tr>
						<td>${doctor.name}</td>					
						<td>${doctor.job}</td>					
						<td><a href="doctorDetail.do?code=${doctor.code}">상세 정보 보기</a></td>					
						<td><a href="doctorUpdate.do?code=${doctor.code}">정보 수정</a></td>					
						<td><a href="doctorDelete.do?code=${doctor.code}">정보 삭제</a></td>					
					</tr>
				</c:forEach>
				
				<tr>
					<th colspan="5">
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
