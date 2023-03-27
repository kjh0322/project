<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>의료진 정보 수정</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<p>의료진 정보 수정</p>
			
			<form method="post" enctype="multipart/form-data" name="frm">
				
				<input type="hidden" name="code" value="${doctor.code}">
				<input type="hidden" name="noImg" value="${doctor.img}">
				
				<table class="update">
					<tr>
						<th rowspan="18" class="img"><img src="img/${doctor.img}"></th>
						<th>이름</th>
						<td><input type="text" name="name" value="${doctor.name}"></td>
					</tr>
					
					<tr>
						<th>직급</th>
						<td><input type="text" name="job" value="${doctor.job}"></td>
					</tr>

					<tr>
						<th rowspan="5">약력</th>
						<td><input type="text" name="profile1" value="${doctor.profile1}"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile2" value="${doctor.profile2}"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile3" value="${doctor.profile3}"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile4" value="${doctor.profile4}"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile5" value="${doctor.profile5}"></td>
					</tr>

					<tr>
						<th rowspan="10">자격</th>
						<td><input type="text" name="spec1" value="${doctor.spec1}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec2" value="${doctor.spec2}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec3" value="${doctor.spec3}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec4" value="${doctor.spec4}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec5" value="${doctor.spec5}"></td>
					</tr>
					
					<tr>
						<td><input type="text" name="spec6" value="${doctor.spec6}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec7" value="${doctor.spec7}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec8" value="${doctor.spec8}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec9" value="${doctor.spec9}"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec10" value="${doctor.spec10}"></td>
					</tr>
					
					<tr>
						<th>사진</th>
						<td>
							<input type="file" name="img"><br/>
							<span>(주의사항 : 이미지를 변경하고자 할 때만 선택하세요)</span>
						</td>
					</tr>
					
					<tr>
						<th colspan="3">
							<input type="submit" value="수정">
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