package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoT;

public class TWriteCommand implements TCommand {

	public void execute (HttpServletRequest request, HttpServletResponse response) {
		String customer_userId = request.getParameter("userId");
		String todoContent = request.getParameter("todoContent");
		String dDay = request.getParameter("dDay");
		String todoStatus = request.getParameter("todoStatus");
		
		TDaoT dao = new TDaoT();
		dao.write(customer_userId, todoContent, dDay, todoStatus);
	}
}
