<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
	<h1>Todo-List</h1>
	<tr>
		<td colspan="5"><input type="submit" name="listSelect" value="ALL">&nbsp;
		<input type="submit" name="listSelect" value="COMPLETE">&nbsp;
		<input type="submit" name="listSelect" value="INCOMPLETE">&nbsp;
	</tr>
		<input type="text" name="search">
		<table border="1">
			<tr>
				<th>LIST</th>
				<th>D-Day</th>
				<th>STATUS</th>
			</tr>
				<tr>
					<td>${dto.listCode }</td>
					<td><a href="content_view.do?listcode=${dto.todoContent}">${dto.todoContent }</a></td>
					<td>${dto.importance }</td>
					<td>${dto.dDay }</td>
				</tr>	
		</table>
		<tr>
			<td colspan="20"><input type="submit" value="+" formaction="write_view.jsp">
		</tr>
</body>
</html>