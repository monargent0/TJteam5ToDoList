package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.javalec.tdl.dao.TDao;
import com.javalec.tdl.dao.TDaoC;

public class TLoginCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
	
		TDaoC dao =new TDaoC();
		String id = dao.login(userId, userPw);
		
		request.setAttribute("userId", id);
		
	
	}

}
