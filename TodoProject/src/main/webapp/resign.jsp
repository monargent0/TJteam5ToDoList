<%@page import="com.javalec.tdl.dao.TDaoC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>회원 탈퇴 페이지</h4>
<%
	request.setCharacterEncoding("utf-8");

	String userId = (String)session.getAttribute("userId");
	String userPw = request.getParameter("userPw");

%>
<% 
	TDaoC dao = new TDaoC();
	int result = dao.userCheck( userId,userPw ) ;
	if(result == 1) { 
		// 비밀번호가 같다 
		result = dao.resign(userId);
		
	%>
		<h4>(<%= userId %>)님 정말로 회원정보를 삭제하시겠습니까?</h4>
		
		<a href="/user_delete_ok.jsp">예</a>&nbsp;&nbsp;
		<a href="/mypage_view.jsp">아니오</a>
	
	<% } else { %>
		<script>
			alert("비밀번호를 다시 확인해주세요.")
			history.back()
		</script>
	<% } %>
</body>
</html>