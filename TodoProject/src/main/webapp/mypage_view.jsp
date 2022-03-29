<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
<%--탈퇴, 탈퇴시 로그아웃 구현 --%>
<% 
	//한글처리 
	request.setCharacterEncoding("UTF-8");
	//로그인 처리 > 로그인이 안되면 로그인페이지 이동 
	String userId = (String) session.getAttribute("userId");
	if(userId == null){
		response.sendRedirect("/login.do");
	}
	
%>

	<h3>아이디 : <%=userId %></h3>
	
	<form action="">
		<input type="button" value="회원탈퇴" class="btn" onclick="location.href='.resign.do'">
	</form>





<%--내정보 구현 --%>
<%-- 로그아웃  --%>



<form action="">
</form>
</body>
</html>