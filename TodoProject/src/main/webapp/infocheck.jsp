<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("userId");
	if (id.isEmpty()){
		String error = "error";
		request.setAttribute("error", error);
		response.sendRedirect("login_view.jsp");
	}else{
		session.setAttribute("userId",id);
		response.sendRedirect("list_view.jsp?userId="+id);
	}
	
%>