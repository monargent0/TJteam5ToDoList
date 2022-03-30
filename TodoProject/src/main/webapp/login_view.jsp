<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoList Login</title>
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
       bor
       }
       
      .logIn{
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
     
    
    </style>
</head>

<body>
	
	
		<div class="logIn">
		<center><h1>Welcome to ToDoList</h1></center>	
		<center>
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
					<td > <input type="submit" value="로그인"> </td>
				</form> 
	 	 	 		<td align="right">
	 	 	 			<form action="signup_view.jsp">
	 	 	 			<input type="submit" value="회원가입"> 
	 	 	 			</form> 
	 	 	 		</td>
	 	 	 		
	 	 	 		
		 	 	</tr>
			</table>
		</center>
		</div>
</body>

</html>