<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
	  table {
        border-collapse: collapse;
        width: auto;
        height: auto;
      }
      
      table, th, td {
        padding: 5px;
       }
       th{
       border-bottom: 1px solid black;
       }
       
      .mymy{
        /* border: 10px solid lightblue; */
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
    
    </style>
</head>
<body>
<%--탈퇴, 탈퇴시 로그아웃 구현 --%>
<% 
	//한글처리 
	request.setCharacterEncoding("UTF-8");
	
	String userId = (String) session.getAttribute("userId");
	String userName = request.getParameter("userName");
	//로그인 처리 > 로그인이 안되면 로그인페이지 이동 
	if(userId == null){
		response.sendRedirect("login_view.jsp");
	}
	
%>
	<div class="mymy">
	<table>
		<tr>
		<th colspan="2"><h1>My Page</h1></th>
		</tr>
		<c:forEach items="${mypage }" var="dto" >
		<tr>
			<td> <h3>아이디 : </h3> </td> 
			<td> <h3> <input type="text" value="${dto.userId }" name="userId" readonly="readonly"></h3> </td>
		</tr>
		<tr>
			<td> <h3>닉네임 : </h3></td> 
			<td> <h3><input type="text" value="${dto.userName }" name="userName" readonly="readonly"> </h3> </td>
		</tr>
		</c:forEach>
		<tr>
			<form>
			<td> <input type="button" value="로그아웃" class="btn" onclick="location='logout.jsp'"> </td>
			<td> <input type="button" value="회원탈퇴" class="btn" onclick="location='resign.jsp'"> </td>
			</form>
		</tr>
	</table>
	</div>
	
	
	
	




</body>
</html>