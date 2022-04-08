 package com.javalec.tdl.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.tdl.dao.TDaoC;

public class TResignCommand implements TCommand {

	public void execute(HttpServletRequest request,HttpServletResponse response) {
		//세션, 파라미터 정보 가져오기
//		HttpSession session = request.getSession();
//		String userId = (String) session.getAttribute("userId");
		String userId = request.getParameter("userId");
		
		TDaoC daoC = new TDaoC();
		daoC.resign(userId);
	}
	

}