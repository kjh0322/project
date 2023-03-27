<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정 완료</title>
	<link rel="stylesheet" type="text/css" href="css/clearStyle.css">
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<section>
		<div class="contentWrap">
			<div class="top">
				<div class="content">
					<p><strong>회원정보가 정상적으로 수정</strong>되었습니다.</p>
					<span>올바로 병원과 함께 건강한 생활을 즐기시길 바랍니다.</span>
				</div>
				
				<div class="img">
					<img alt="기타 그림" src="img/update.png">
				</div>		
			</div>
		</div>
						
		<div class="main">
			<strong><img alt="기타 그림" src="img/mypage.png">나의 정보</strong>
		
			<table>
				<tr>
					<th>회원구분</th>
					<td>
						<c:choose>
							<c:when test="${member.lev=='A'}">
								<input type="radio" checked readonly> 운영자 
								<input type="radio" readonly> 일반회원 
							</c:when>
							
							<c:otherwise>
								<input type="radio" readonly> 운영자 
								<input type="radio" checked readonly> 일반회원 
							</c:otherwise>
						</c:choose>
					</td>
				</tr>

				<tr>
					<th>아이디</th>
					<td>${member.id}</td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td>${member.pw}</td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td>${member.name}</td>
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<c:choose>
							<c:when test="${member.gender=='1'}">
								<input type="radio" checked readonly> 남자 
								<input type="radio" readonly> 여자 
							</c:when>
							
							<c:otherwise>
								<input type="radio" readonly> 남자 
								<input type="radio" checked readonly> 여자 
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				
				<tr>
					<th>생년월일</th>
					<td><td>${admin.year}년 ${admin.month}월 ${admin.day}일</td>
				</tr>

				<tr>
					<th>이메일</th>
					<c:if test="${empty admin.email1 && empty admin.email2}">
						<td></td>
					</c:if>
					
					<c:if test="${!empty admin.email1 && !empty admin.email2}">
						<td>${admin.email1}@${admin.email2}</td>
					</c:if>	
				</tr>
				
				<tr>
					<th>전화번호</th>
					<td>${member.phone}</td>
				</tr>
				
				
				<tr>
					<th colspan="2">
						<a href="main.jsp"><input type="button" value="메인페이지로 이동"></a>

					</th>
				</tr>
			</table>
		</div>
	</section>
</body>
</html>