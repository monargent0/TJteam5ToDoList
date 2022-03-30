<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List Search form</title>
</head>
<body>
	<h2>Todo List 검색 form</h2>
	<table border="0">
		<form action="search.do" method="post">
		<tr>
			<select name='searchCategory'>
  				<option value='list' selected>전체 일정</option>
  				<option value='complete'>완료된 일정</option>
  				<option value='incomplete'>진행 중인 일정</option>
			</select>
		</tr>
	<table border="1">	
		<tr>
			<td colsapn="5">검색<input type="text" name="searchList"></td>
			<input type="submit" value="search" />
		</tr>	
		</form>
	</table>
</body>
</html>