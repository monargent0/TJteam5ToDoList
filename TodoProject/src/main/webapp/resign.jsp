<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 </title>
</head>


<body>
<h4>회원 탈퇴 </h4>
	<form action="user_delete.jsp" method="post">
	<p><strong>비밀번호를 입력하세요.</strong>
	<input type="password" id="check_pw" name="chkPw">
	<input type="submit" value="확인">
	<%--뒤로가기 --%>
	<div>
		<button onclick="history.back()">뒤로가기</button>
	</div>
</form>

</body>
</html>