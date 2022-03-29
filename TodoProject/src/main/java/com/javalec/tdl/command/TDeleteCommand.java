package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.javalec.tdl.dao.TDaoT;

public class TDeleteCommand implements TCommand {

	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int listCode = Integer.parseInt(request.getParameter("listCode"));
		
		TDaoT daoT = new TDaoT();
		daoT.delete(listCode);
	}
	
=======
public class TDeleteCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String	userId = request.getParameter("userId");
		
		TDao dao = new Tdao();
		dao.delete(userId);
		
	}

>>>>>>> main
}
