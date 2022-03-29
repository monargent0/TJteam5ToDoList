package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoDT;

public class TWriteCommand implements TCommand {

	public void execute (HttpServletRequest request, HttpServletResponse response) {
		
		String todoContent = request.getParameter("todoContent");
		String dDay = request.getParameter("dDay");
		String importance = request.getParameter("important");
		String status = request.getParameter("status");
		
		TDaoDT dao = new TDaoDT();
		dao.write(todoContent, dDay, importance, status);
	}
}
