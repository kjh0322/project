<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 체크</title>
	<link rel="stylesheet" type="text/css" href="css/idcheckStyle.css">
	<script src="script/member.js"></script>
</head>

<body>
	<h3>아이디 중복확인</h3>
	<form method="get" action="idCheck.do" name="frm">
		<p>아이디는 영문(대∙소문자), 숫자, 특수문자(-, _)로 3~20자 이내로 입력해 주세요.</p>
		<input type="text" name="id" value="${id}">
		<input type="submit" value="중복 확인"><br/>
		
		<c:if test="${result==1}">
			<script>
				opener.document.frm.id.value=="";
			</script>
			<span><strong>${id}</strong>는 이미 사용 중인 아이디입니다.</span>
		</c:if>
		
		<c:if test="${result==-1}">
			<span><strong class="green">${id}</strong>는 사용 가능한 아이디입니다.</span>
			<input type="button" value="사용" onclick="return idok('${id}')">
		</c:if>
	</form>
</body>
</html>