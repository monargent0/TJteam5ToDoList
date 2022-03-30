package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoT;

public class TModifyCommand implements TCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int listCode = Integer.parseInt(request.getParameter("listCode"));
		String todoContent = request.getParameter("todoContent");
		String dDay = request.getParameter("dDay");
		String todoStatus = request.getParameter("todoStatus");
		
		TDaoT dao = new TDaoT();	
		dao.modify(listCode, todoContent, dDay, todoStatus);
		}
}
