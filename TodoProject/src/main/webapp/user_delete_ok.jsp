<%@page import="com.javalec.tdl.dao.TDaoC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userId = (String) session.getAttribute("userId");
	String userPw = request.getParameter("userPw");

	TDaoC dao =new TDaoC();
	int result = dao.userCheck(userId, userPw);
	
	if( result == 1) {		
		session.invalidate();
%>
		<script>
			alert("회원 탈퇴가 정상처리되었습니다.");
			location.href='/login_view.jsp';
		</script>
<%
	}else {
%>
		<script>
			alert("회원 탈퇴에 실패했습니다.");
			history.back();
		</script>
<%
	}
%>