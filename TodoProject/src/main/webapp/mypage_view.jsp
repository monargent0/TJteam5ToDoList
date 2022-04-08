<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./style.css">
<title>My Page</title>
</head>
<body>
<% 
	//한글처리 
	request.setCharacterEncoding("UTF-8");
	String userId = (String)session.getAttribute("userId");
	//로그인 처리 > 로그인이 안되면 로그인페이지 이동 
	if(userId == null){
		response.sendRedirect("login_view.jsp");
	}
%>

	<div class="position">
	<table>
		<tr>
			<td colspan="2" align="right">
				<form action="list.do">
					<input type="text" name="userId" value="<%=session.getAttribute("userId") %>" hidden="">
					<input id="sub" type="submit" value="Back to List">
				</form>
			</td>
		</tr>
		<tr>
			<th colspan="4"><h1> My Page </h1></th>
		</tr>
		
		<c:forEach items="${myp}" var="dto" >
			<tr>
			<td> 아이디 &nbsp;: </td> 
			<td> <input id = "read" value="${dto.userId}" readonly="readonly" size="20"> </td>
			</tr>
			<tr>
			<td> 닉네임 &nbsp;: </td> 
			<td> <input id="read" value="${dto.userName }" readonly="readonly" size="20"> </td>
			</tr>
		</c:forEach>
		<tr><td> </td></tr>
		<tr>
			<form>
			<td > <input id="sub" type="button" value="회원탈퇴" class="btn" onclick="location='resign.jsp'"> </td>
			<td align="right"> <input id="sub" type="button" value="로그아웃" class="btn" onclick="location='logout.jsp'"> </td>
			</form>
		</tr>
	</table>
	</div>
	

</body>
</html>