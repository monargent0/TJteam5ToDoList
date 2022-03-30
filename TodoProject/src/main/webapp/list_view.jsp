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
	
	<form method="get">
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
			<c:forEach items="${list }" var="dto" varStatus="status">
			<tr>
				<td align="center">
				<input type="text" value="${dto.todoContent }" name="todoContent" formaction="modify.do?listCode=${dto.listCode}">
				</td>
				<td align="center">
				<input type="text" value="${dto.dDay }" name="dDay" formaction="modify.do?listCode=${dto.listCode }">
				</td>
				<td align="center">
				<input type="text" value="${dto.todoStatus }" name="todoStatus" >
				</td>
				<td align="center">
				<a href="modify.do?listCode=${dto.listCode}">수정</a> <a href="delete.do?listCode=${dto.listCode}">삭제</a>
				</td>
			</tr>
			</c:forEach>

			<tr>
				<td colspan="4" align="right"><input type="submit" value="+" formaction="write_view.jsp"></td>
			</tr>
		</table>
	</form>
	
</div>
</body>
</html>