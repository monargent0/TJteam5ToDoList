<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List ADD</title>
</head>
<body>
	<h2>Todo List 작성 form</h2>
		<table boder="0">
			<form action="write.do" method="post">
				<tr>
					<td>할일 작성하기</td>
					<td><input type="text" name="todoContent" size="50"></td>
				</tr>
				<tr>	
					<td>목표시간</td>
					<td><input type="text" name="dDay" size="20"></td>
				</tr>
				<tr>	
					<td>중요도</td>
					<td><input type="checkbox" name="importance" size="20"></td>
				</tr>
				<tr>
					<td colspan="20"><input type="submit" value="돌아가기" formaction="list_view.do">&nbsp;<input type="submit" value="완료" fomaction="list_view.do">
				</tr>
			</form>	
	</table>
</body>
</html>