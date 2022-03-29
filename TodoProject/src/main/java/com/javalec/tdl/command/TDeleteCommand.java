package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoT;


public class TDeleteCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int listCode = Integer.parseInt(request.getParameter("listCode"));
		
		TDaoT daoT = new TDaoT();
		daoT.delete(listCode);
			
	
	}
	
}
	