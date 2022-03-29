package com.javalec.tdl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TDaoT {
	DataSource dataSource;
	
	public TDaoT() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/todolist");
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // Constructor
	
	// listCode(*), todoContent, dDay(Date), importance, deleteTodo
	
	// delete
	public void delete(int listCode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

			try {
				connection = dataSource.getConnection(); // DB연결 끝
				String query = "delete from todo where listCode = ? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, listCode);
				
				preparedStatement.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}// finally 메모리 정리 ; 이상 있거나 없거나 무조건 거친다.
	} // delete
}
