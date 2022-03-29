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
		<form action="write.do" method="get">
			<table border="1">
				<tr>
					<td>TODO</td>
					<td><input type="text" name="todoContent" size="50"></td>
				</tr>
				<tr>	
					<td>D-DAY</td>
					<td><input type="date" name="dDay"></td>
				</tr>
				<tr>	
					<td>IMPORTANCE</td>
					<td><input type="checkbox" name="importance" value="important">중요</td>
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
					<input type="submit" value="완료">
					</td>
				</tr>
			</table>
		</form><br>
		<form action="list.do" method="post">
			<input type="submit" value="Back to List">
		</form>
</body>
</html>