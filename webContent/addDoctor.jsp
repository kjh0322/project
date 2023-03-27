<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>의료진 정보 등록</title>
	<link rel="stylesheet" type="text/css" href="css/listStyle.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
		
		<section>
			<p>의료진 정보 등록</p>
			
			<form method="post" enctype="multipart/form-data" name="frm">
				<table class="add">
					<tr>
						<th>이름</th>
						<td><input type="text" name="name"></td>
					</tr>
					
					<tr>
						<th>직급</th>
						<td><input type="text" name="job"></td>
					</tr>

					<tr>
						<th rowspan="5">약력</th>
						<td><input type="text" name="profile1"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile2"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile3"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile4"></td>
					</tr>

					<tr>
						<td><input type="text" name="profile5"></td>
					</tr>

					<tr>
						<th rowspan="10">자격</th>
						<td><input type="text" name="spec1"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec2"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec3"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec4"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec5"></td>
					</tr>
					
					<tr>
						<td><input type="text" name="spec6"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec7"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec8"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec9"></td>
					</tr>

					<tr>
						<td><input type="text" name="spec10"></td>
					</tr>
					
					<tr>
						<th>사진</th>
						<td><input type="file" name="img"></td>
					</tr>
					
					<tr>
						<th colspan="3">
							<input type="submit" value="등록">
							<input type="reset" value="재입력">
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