package com.javalec.tdl.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TDaoD {
	DataSource dataSource;
	
	public TDaoD() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/todolist");
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // Constructor
	
}
