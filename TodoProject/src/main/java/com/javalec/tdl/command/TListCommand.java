package com.javalec.tdl.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoT;
import com.javalec.tdl.dto.TDto;

public class TListCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String loginId = request.getParameter("userId");
		
		TDaoT dao = new TDaoT();
		ArrayList<TDto> dtos = dao.list(loginId);
		request.setAttribute("list", dtos);
	}
}
