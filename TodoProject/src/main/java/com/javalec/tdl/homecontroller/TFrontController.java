package com.javalec.tdl.homecontroller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.tdl.command.TCommand;
import com.javalec.tdl.command.TDeleteCommand;
import com.javalec.tdl.command.TListCommand;
import com.javalec.tdl.command.TLoginCommand;
import com.javalec.tdl.command.TSignupCommand;
import com.javalec.tdl.command.TWriteCommand;

/**
 * Servlet implementation class TFrontController
 */
@WebServlet("*.do")
public class TFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		TCommand command = null;
		String uri = request.getRequestURI();
		String comPath = request.getContextPath();
		String domain = uri.substring(comPath.length());
		
		switch (domain) {
			// list
			case("/list.do"):
				command = new TListCommand();
				command.execute(request, response);
				viewPage = "list_view.jsp";
				break;
			// 가입하기
//			case("/signup.do") :
//				command = new TSignupCommand();
//				command.execute(request, response);
//				viewPage = "login_view.jsp";
//				break;
//			//login
//			case ("/login.do"):
//				command = new TLoginCommand();
//				command.execute(request, response);
//				viewPage = "infocheck.jsp";
//				break;
			// write
			case("/write.do"):
				command = new TWriteCommand();
				command.execute(request, response);
				viewPage = "list.do";
				break;
//			// 삭제하기
//			case("/delete.do"):
//				command = new TDeleteCommand();
//				command.execute(request, response);
//				viewPage = "list.do";
//				break;	
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	

}
