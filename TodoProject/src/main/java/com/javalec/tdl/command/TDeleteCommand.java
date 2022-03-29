package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TDeleteCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String	userId = request.getParameter("userId");
		
		TDao dao = new Tdao();
		dao.delete(userId);
		
	}

}
