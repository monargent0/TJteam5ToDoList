package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoT;

public class TDeleteCommand implements TCommand {

	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int listCode = Integer.parseInt(request.getParameter("listCode"));
		
		TDaoT daoT = new TDaoT();
		daoT.delete(listCode);
	}
	
}
