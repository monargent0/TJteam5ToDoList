package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDao;
import com.javalec.tdl.dao.TDaoC;

public class TSignupCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		
		TDaoC dao = new TDaoC();
		dao.signup(userId, userPw, userName);
		
	}

}
