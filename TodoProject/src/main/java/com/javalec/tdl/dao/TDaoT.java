package com.javalec.tdl.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TDaoT {

	DataSource dataSource;
	
	public TDaoT() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/192.168.150.230:3306/todolist");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
