package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDao;

public class TLoginCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	TDao dao =new TDao();
	dao.login(userId,userPw);
	
	}

}
