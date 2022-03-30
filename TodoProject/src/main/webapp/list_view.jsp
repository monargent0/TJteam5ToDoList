<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
<style>
	  table {
        border-collapse: collapse;
        width: auto;
        height: auto;
      }
      
      table, th, td {
        padding: 5px;
       }
       th{
       border-top : 1px solid black;
       border-bottom: 1px solid black;
       }
       
      .list{
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
     
    
    </style>
</head>
<body>

<div class="list">

	<h1>Todo-List</h1>
		<table >
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
				<input type="text" value="${dto.todoContent }" name="todoContent">
				</td>
				<td align="center">
				<input type="date" value="${dto.dDay }" name="dDay">
				</td>
				<td align="center">
				<input type="text" value="${dto.todoStatus }" name="todoStatus">
				</td>
				<td align="center">
				<input type="submit" value="수정" formaction="modify.do">
				<input type="submit" value="삭제" formaction="delete.do?listCode=${dto.listCode }">	
				</td>
			</tr>
			</form>
			</c:forEach>
		</table>
		<form>
			<input type="text" name="userId" value="<%=session.getAttribute("userId") %>" hidden="">
			<input type="submit" value="+" formaction="write_view.jsp?userId">
		</form>
</div>
</body>
</html>