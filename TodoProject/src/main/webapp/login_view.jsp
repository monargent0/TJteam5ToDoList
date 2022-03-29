<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome to ToDoList</title>
</head>
<body>
		<h1>Welcome to ToDoList</h1>	
	<form action="list_view.jsp" method="post">
 	 email : <input type = "text" name = "userId"><br>
 	 password : <input type="password" name = "userPw"><br>
 	 <input type="submit" value="로그인"><br>
 		 <table>
 	 	<tr>
 	 	  <a herf = "signup_view.jsp">회원가입</a>
 	 	</tr>
 		 </table>
	</form>
</body>

</html>