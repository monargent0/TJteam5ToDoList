<%@page import="com.javalec.tdl.dao.TDaoC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<link rel="stylesheet" href="./style.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="position">
	<h4>회원 탈퇴 페이지</h4>
<%-- <%
	request.setCharacterEncoding("utf-8");

	String userId = (String)session.getAttribute("userId");

%> --%>

		<h4>(<%=session.getAttribute("userId") %>)님 정말로 회원정보를 삭제하시겠습니까?</h4>
		
		<form action="resign.do">
		<input type="hidden" name="userId" value="<%=session.getAttribute("userId")%>">
		<input id="sub" type="submit" value="예"> </form>
		
		<a href="/resign.do">예</a>&nbsp;&nbsp;
		<a href="/mypage_view.jsp">아니오</a>
	
</div>
	
</body>
</html>