<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
<link rel="stylesheet" href="./style.css">

</head>
<body>

<div class="position">

	<h1>Todo-List</h1>
		<table >
			<tr>
				<td colspan="4" align="right"> <a href="mypage.do">My Page</a> <a href="logout.jsp">Logout</a> </td>
			</tr>
			<tr>
				<th hidden="">userId</th>
				<th hidden="">listCode</th>
				<th>TODO</th>
				<th>D-Day</th>
				<th>STATUS</th>
				<th>ACTION</th>
			</tr>
			<c:forEach items="${list }" var="dto">
			<form method="get">
			<tr>
				<td align="center" hidden="">
				<input type="text" value="${dto.userId }" name="userId" size="10" readonly="readonly" style="text-align:center; ">
				</td>
				<td align="center" hidden="">
				<input type="text" value="${dto.listCode }" name="listCode" size="10" readonly="readonly" style="text-align:center; ">
				</td>
				<td align="center">
				<input id = "todo" type="text" value="${dto.todoContent }" name="todoContent">
				</td>
				<td align="center">
				<input id = "todo" type="date" value="${dto.dDay }" name="dDay">
				</td>
				<td align="center">
				<input type="checkbox" value="complete" name="todoStatus">complete
				</td>
				<td align="center">
				<input id="sub" type="submit" value="수정" formaction="modify.do">
				<input id="sub" type="submit" value="삭제" formaction="delete.do?listCode=${dto.listCode }">	
				</td>
			</tr>
			</form>
			</c:forEach>
			<tr>
				<td colspan="6" align="center">
				<form>
					<input type="text" name="userId" value="<%=session.getAttribute("userId") %>" hidden="">
					<input id="add" type="submit" value="+" formaction="write_view.jsp?userId">
				</form>
				</td>
			</tr>
		</table>
</div>
</body>
</html>