<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoList Login</title>
</head>
<script type="text/javascript">

<%-- if (<%= request.getAttribute("id")%> == null){
	alert("아이디 비밀번호 입력정보를 확인하세요.")
} --%>

</script>
<body>

		<h1>Welcome to ToDoList</h1>	
		
		<table>
			<tr>
			<form action="login.do" method="post">
				<td> ID : </td>
				<td> <input type = "text" name = "userId"> </td>
			</tr>
			<tr>
				<td> password : </td>
				<td> <input type="password" name = "userPw"> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="로그인"> </td>
			</form>
			</tr>
	 	 	<tr>
 	 	 		<td><form action="signup_view.jsp">
 	 	 			<input type="submit" value="회원가입"> 
 	 	 		</form> 
 	 	 		</td>
	 	 	</tr>
		</table>
</body>

</html>