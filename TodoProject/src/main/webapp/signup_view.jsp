<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> TodoList 회원가입 </title>
</head>
<script type="text/javascript">
function checkPw()	{
		var form = document.signup
		var userPw = form.userPw.value
		var confirmPw = form.confirmPw.value
		
		if (userPw != confirmPw ) {
	    	alert("비밀번호가 일치하지 않습니다")
	    form.confirmPw.focus()
	    return;
		}
	    form.submit()
}
</script>

<body>
	
	<h1>환영합니다!</h1>
	<form action="signup.do" method="post" name="signup" >
		<table>
			<tr>
				<td> 아이디 </td> 
				<td> <input type = "text" name ="userId"> </td>
			</tr>
			<tr>
				<td> 비밀번호 </td>
				<td> <input type = "password" name ="userPw"> </td>
			</tr>
			<tr>
				<td> 비밀번호 확인을 위해 다시 한번 입력해주세요. </td>
			</tr>
			<tr>
				<td> 비밀번호 확인 </td>
				<td> <input type ="password" name = "confirmPw"> </td>
			</tr>
			<tr>
				<td> 닉네임 </td>
				<td> <input type ="text" name = "userName" > </td>
			</tr>
			<tr>
				<td> <input type ="button" value = "가입" onclick="checkPw()"> </td>
			</tr>
		</table>
	</form>
</body>
</html>