<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List Modify</title>
</head>
<body>
	<h2>Todo list 수정 및 삭제</h2>
	<table border="0">
		<form action="modify.do" method="post">
				<tr>
				<td><input type="text" name="listcode" size="5" value="${content_view.listcode }" readonly="readonly"></td>
				</tr>							
				<tr>
					<input type="text" name="todoContent" size="50">
				</tr>
				<tr>	
					<td>목표날짜</td>
					<td><input type="text" name="dDay" size="20" value="${content_view.dDay }"></td>
				</tr>
				<tr>	
					<td>중요도</td>
					<td><input type="checkbox" name="importance" size="20" value="${content_view.importance }"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정">&nbsp;<input type="submit" value="삭제" formaction="delete.do">&nbsp;&nbsp;&nbsp;
				<a href="list_view.do">목록보기</a>
				</tr>
		</form>
	</table>
</body>
</html>