package com.javalec.tdl.command;




import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.tdl.dao.TDaoC;

public class TResignCommand implements TCommand {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//세션, 파라미터 정보 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userPw = request.getParameter("userPw");
		
		TDaoC dao = new TDaoC();
		dao.resign(userId,userPw);
		int result = dao.resign(userId, userPw);
			
			//자바스크립트사용하여 alert()창띄우기
						
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
	
			if(result == 0){ //로그인 비번오류
				out.print("<script>");
				out.print("alert('비밀번호오류');");
				out.print("history.back();");
				out.print("</script>");
				//자원해제(필수! 까먹지마!)
				out.close();
			}else if(result == -1){
				out.print("<script>");
				out.print("alert('존재하지 않는 아이디입니다');");
				out.print("history.back();");
				out.print("</script>");
				//자원해제(필수! 까먹지마!)
				out.close();
			}
			
			//if(result == 1) //아이디와 비번이 같을때 
			session.invalidate();
			out.print("<script>");
			out.print("alert('정상적으로 회원탈퇴되었습니다');");
			out.print("location.href='./login.do';");
			out.print("</script>");
			//자원해제
			out.close();
		}
		
		
	}
	

	

