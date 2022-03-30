<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./style.css">

<title>ToDoList Login</title>

</head>

<body>
	
	
		<div class="position">
		<center><h1>Welcome to ToDoList</h1></center>	
		<center>
			<table>
				<tr>
				<form action="login.do" method="post">
					<td align="right"> ID : </td>
					<td> <input id="todoC" type = "text" name = "userId"> </td>
				</tr>
				<tr>
					<td> password : </td>
					<td> <input id="todoC" type="password" name = "userPw"> </td>
				</tr>
				<tr>
					<td > <input id="log" type="submit" value="로그인"> </td>
				</form> 
	 	 	 		<td align="right">
	 	 	 			<form action="signup_view.jsp">
	 	 	 			<input id="log" type="submit" value="회원가입"> 
	 	 	 			</form> 
	 	 	 		</td>
	 	 	 		
	 	 	 		
		 	 	</tr>
			</table>
		</center>
		</div>
</body>

</html>