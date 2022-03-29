package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.tdl.dao.TDaoDT;

public class TWriteCommand implements TCommand {

	public void execute (HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String todoContent = request.getParameter("todoContent");
		String dDay = request.getParameter("dDay");
		String importance = request.getParameter("importance");
		String todoStatus = request.getParameter("todoStatus");
		String userId = (String)session.getAttribute("userId");
		
		TDaoDT dao = new TDaoDT();
		dao.write(todoContent, dDay, importance, todoStatus,userId);
		
	}
}
