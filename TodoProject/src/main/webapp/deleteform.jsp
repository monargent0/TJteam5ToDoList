<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	//비밀번호 미입력시 경고창
	function checkValue(){
   	 if(!document.deleteform.userPw.value){
      	  alert("비밀번호를 입력하지 않았습니다.");
	        return false;
   	 }
	} 
</script>
<body>
<%
// 로그인 처리 -> 로그인 x (로그인페이지 이동)
String userId = (String) session.getAttribute("userId");
if( userId == null ){
	 response.sendRedirect("./login.do");
}
// 회원 비밀번호만 입력받아서 deletePro.jsp페이지 이동후 삭제
// 비밀번호와 db 비밀번호 일치 -> 삭제하면안됨 비번이 같은 회원이 있을 수 있음
// 따라서 
%> 
<fieldset>
	<legend>회원탈퇴</legend>
	<form name="deleteform" action="/resign.do" method="post">
	<!-- input타입중 hidden은 화면에 있는 해당 input태그를 숨겨서 정보 전달   -->
	<table>
		<tr>
			<td bgcolor="skyblue">아이디</td>
			<td><input type="hidden" name="userId" value="<%=userId %>" readonly></td>
		</tr>
		 <tr>
		 	<td bgcolor="skyblue">비밀번호</td>
			<td><input type="password" name="userPw" maxlength="45"></td>	
		</tr>	
		<tr>
			<td colspan="2"><input type="button" class="btn" value="탈퇴하기"  ></td>
			<td colspan="2"><input type="button" class="btn" value="뒤로가기" onclick="location.href='./mypage_view.do'"></td>
		</tr>
	</table>
	</form>
</fieldset>
</body>
</html>
