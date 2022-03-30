<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./style.css">
<title> TodoList 회원가입 </title>
<style>
	  table {
        border-collapse: collapse;
        width: auto;
        height: auto;
      }
      
      table, th, td {
        padding: 5px;
       }
      
       
      .sign{
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
      #sub {
	    font-family: 'Nanum Brush Script', cursive;
	    font-weight: bold;
	    text-align: center;
	    background-color: white;
	    border-color: gray;
	    border-style: collapse; /* solid */
	    border-radius: 15px;
		}
    
    </style>
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
	<div class="sign">

	<h1>환영합니다!</h1>
	<form action="signup.do" method="post" name="signup" >
		<table>
			<tr>
				<td> 아이디 </td> 
				<td> <input id="todoC" type = "text" name ="userId"> </td>
			</tr>
			<tr>
				<td> 비밀번호 </td>
				<td> <input id="todoC" type = "password" name ="userPw"> </td>
			</tr>
			<tr>
				<td id = "notice" colspan="2" align="center"> &nbsp; 비밀번호 확인을 위해 다시 한번 입력해주세요. </td>
			</tr>
			<tr>
				<td> 비밀번호 확인 </td>
				<td> <input id="todoC" type ="password" name = "confirmPw"> </td>
			</tr>
			<tr>
				<td> 닉네임 </td>
				<td> <input id="todoC" type ="text" name = "userName" > </td>
			</tr>
			<tr>
				<td align="left"> <a href="login_view.jsp" >돌아가기</a></td>
				<td align="right"> <input id="sub" type ="button" value = "가입" onclick="checkPw()"> </td>
			</tr>
		</table>
	</form>
		</div>
</body>
</html>