<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	Object id = request.getAttribute("userId");
	
	if (id == null){
		RequestDispatcher rd = request.getRequestDispatcher("login_view.jsp?error=error");
		rd.forward(request, response);
		
	}else{
		session.setAttribute("userId",id);
		response.sendRedirect("list_view.jsp");
	}
	
%>