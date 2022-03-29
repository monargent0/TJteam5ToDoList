<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원가입 </title>
</head>
<script type="text/javascript">
function sendIt()	{
	if (document.f.userPw.value != document.f.sameuserPw.value) {
	    alert("비밀번호가 일치하지 않습니다")
	    document.f.sameuserPw.value = ""
	    document.f.sameuserPw.focus();
	    return false;
	
	    document.f.submit();}
}
</script>

<body>
	<h1>회원가입</h1>
	
	<form name="f" action="login_view.jsp" method="post" onsubmit="return sendIt();" >
	아이디<br> <input type = "text" name ="userId"> <br>
	비밀번호<br> <input type = "password" name ="usePw"> <br>
	비밀번호 확인<br> <input type ="password" name = "sameuserPw"> <br>
	비밀번호 확인을 위해 다시 한번 입력해주세요.
	닉네임<br> <input type ="text" name = "userName" > <br>
	<input type ="submit" value ="가입완료">
	</form>
</body>
</html>