<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 리스트</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
	
		<section>
			<p>관리자 리스트</p>
			
			<table class="list">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>전화번호</th>
					<th>상세 정보</th>
					<th>삭제</th>
				</tr>
				
				<c:forEach var="admin" items="${adminList}">
					<tr>
						<td>${admin.id}</td>					
						<td>${admin.name}</td>					
						<c:if test="${admin.gender==1}">
							<td>남자</td>
						</c:if>					
						
						<c:if test="${admin.gender==2}">
							<td>여자</td>
						</c:if>					
						<td>${admin.phone}</td>					
						<td><a href="adminDetail.do?id=${admin.id}">상세 정보 보기</a></td>					
						<td><a href="adminDelete.do?id=${admin.id}">삭제하기</a></td>					
					</tr>
				</c:forEach>
				
				<tr>
					<th colspan="6">
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
