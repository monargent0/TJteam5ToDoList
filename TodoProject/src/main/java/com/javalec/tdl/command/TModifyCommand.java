package com.javalec.tdl.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDao;

public class TModifyCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String todoContent = request.getParameter("todoContent");
		Date dDay = new Date();
		String dDays = dDay.toString();
		String importance = request.getParameter("importance");
		
		TDao dao = new TDao();
		TDto dto = new TDto();
		
		dto = dao.modify(todoContent,dDays,importance);
		
	}

}
