//package com.javalec.tdl.command;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.javalec.tdl.dao.TDaoC;
//import com.javalec.tdl.dto.TDtoM;
//
//public class TMypageCommand implements TCommand {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		String userId = request.getParameter("userId");
//		
//		
//		TDaoC dao =new TDaoC();
//		ArrayList<TDtoM> dtos = dao.mypage(userId);
//		request.setAttribute("mypage", dtos);
//	
//		
//	
//	
//	}
//
//}
