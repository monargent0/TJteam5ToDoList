package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoC;

public class TMypageCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
	
		TDaoC dao =new TDaoC();
		dao.mypage(userId,userName);
	
		
	
	
	}

}
