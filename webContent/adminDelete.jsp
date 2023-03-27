<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 정보 삭제</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
	
		<section>
			<p>관리자 정보 삭제</p>
			
			<form method="post" name="frm">
				<table class="etc">
					<tr>
						<th>아이디</th>
						<td>${admin.id}</td>
					</tr>
	
					<tr>
						<th>이름</th>
						<td>${admin.name}</td>
					</tr>
					
					<tr>
						<th>성별</th>
						<c:if test="${admin.gender==1}">
							<td>남자</td>
						</c:if>					
						
						<c:if test="${admin.gender==2}">
							<td>여자</td>
						</c:if>			
					</tr>
					
					<tr>
						<th>생년월일</th>
						<td>${admin.year}년 ${admin.month}월 ${admin.day}일</td>
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
						<td>${admin.phone}</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<input type="submit" value="삭제">
							<a href="adminList.do"><input type="button" value="목록"></a>
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