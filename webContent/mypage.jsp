<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마이페이지</title>
	<link rel="stylesheet" type="text/css" href="css/mypageStyle.css">
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<section>
		<div class="contentWrap">
			<div class="top">
				<div class="content">
					<p><strong>회원 정보 확인 및 일부 수정</strong>을 하실 수 있습니다.</p>
					<span>※ 회원 구분, 아이디, 생년월일은 수정 불가합니다.</span>
				</div>
				
				<div class="img">
					<img alt="기타 그림" src="img/update.png">
				</div>		
			</div>
		</div>
			
		<form action="mypage.do" method="post">				
			<div class="main">
				<strong><img alt="기타 그림" src="img/mypage.png">내 정보관리</strong>
			
				<table>
					<tr>
						<td>회원구분</td>
						<td>
							<c:choose>
								<c:when test="${result==2}">
									<input type="radio" name="lev" value="A" checked onclick="return(false);"> 운영자 
									<input type="radio" name="lev" value="B" onclick="return(false);"> 일반회원 
								</c:when>
								
								<c:otherwise>
									<input type="radio" name="lev" value="A" onclick="return(false);"> 운영자 
									<input type="radio" name="lev" value="B" checked onclick="return(false);"> 일반회원
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
	
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" value="${loginUser.id}" readonly></td>
					</tr>
	
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw"></td>
					</tr>
					
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" value="${loginUser.name}"></td>
					</tr>
					
					<tr>
						<td>성별</td>
						<td>
							<c:choose>
								<c:when test="${loginUser.gender==1}">
									<input type="radio" name="gender" value="1" checked> 남자 
									<input type="radio" name="gender" value="2"> 여자
								</c:when>
								
								<c:otherwise>
									<input type="radio" name="gender" value="1"> 남자 
									<input type="radio" name="gender" value="2" checked> 여자
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
						<td>이메일</td>
						<td>
							<input type="text" name="email1" value="${loginUser.email1}"> @ 
							<input type="text" name="email2" value="${loginUser.email2}"> &nbsp;
							<select name="email2" class="selectBox">
		                       <option value="" selected>직접입력</option>
		                       <option value="daum.net">daum.net</option>
		                       <option value="gmail.com">gmail.com</option>
		                       <option value="hanmail.net">hanmail.net</option>
		                       <option value="naver.com">naver.com</option>
		                       <option value="nate.com" >nate.com</option>                
		                   </select>
						</td>
					</tr>
					
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phone" value="${loginUser.phone}"></td>
					</tr>
					
					
					<tr>
						<th colspan="2">
							<input type="submit" value="수정" onclick="return updateCheck()"> &nbsp;
							<input type="reset" value="재입력">
						</th>
					</tr>
				</table>
			</div>	
		</form>
	</section>
</body>
</html>