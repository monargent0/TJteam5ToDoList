<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List ADD</title>
</head>
<body>
	<h2>ADD Todo List</h2>
		<form method="get">
			<table border="1">
				<tr hidden="">
					<td>userId</td>
					<td><input type="text" name="userId" value="<%=session.getAttribute("userId") %>"></td>
				</tr>
				<tr>
					<td>TODO</td>
					<td><input type="text" name="todoContent" size="50"></td>
				</tr>
				<tr>	
					<td>D-DAY</td>
					<td><input type="date" name="dDay" required="required"></td>
				</tr>
				<tr hidden="">
					<td>STATUS</td>
					<td>
						<select name="todoStatus">
							<option value="complete">complete</option>
							<option value="incomplete" selected="selected">incomplete</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="완료" formaction="write.do">
					</td>
				</tr>
			</table><br>
		</form>
		<form action="list.do">
			<input type="text" name="userId" value="<%=session.getAttribute("userId") %>" hidden="">
			<input type="submit" value="Back to List">
		</form>
</body>
</html>