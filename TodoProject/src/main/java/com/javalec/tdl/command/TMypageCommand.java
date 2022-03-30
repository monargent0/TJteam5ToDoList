package com.javalec.tdl.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.tdl.dao.TDaoC;
import com.javalec.tdl.dto.TDtoM;

public class TMypageCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		String loginId = request.getParameter("userId");
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("userId");
		
		TDaoC daoC = new TDaoC();
		ArrayList<TDtoM> dtosM = daoC.mypage(loginId);
		request.setAttribute("myp", dtosM);
	
		
	}

}
