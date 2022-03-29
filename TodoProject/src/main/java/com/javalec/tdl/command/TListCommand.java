package com.javalec.tdl.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.dao.TDaoDT;
import com.javalec.tdl.dto.TDto;

public class TListCommand implements TCommand {
	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		TDaoDT dao = new TDaoDT();
		ArrayList<TDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
