package com.javalec.tdl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;

import com.javalec.tdl.dto.TDto;

public class TDaoDT {

	DataSource dataSource;
	
	public TDaoDT() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/todolist");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<TDto> list() {
		ArrayList<TDto> dtos = new ArrayList<TDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "select t.listCode, t.todoContent, t.importance, t.dDay, d.todoStatus from customer c, ";
			String queryB = "drawup d, todo t where d.customer_userId = c.userId and d.todo_listCode = t.listCode";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int listCode = resultSet.getInt("listCode");
				String todoContent = resultSet.getString("todoContent");
				String importance = resultSet.getString("importance");
				Date dDay = resultSet.getDate("dDay");
				String todoStatus = resultSet.getString("todoStatus");
				
				TDto dto = new TDto(listCode, todoContent, importance, dDay, todoStatus);
				dtos.add(dto);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} //finally
		return dtos;
	} // list
	
	public void write(String todoContent, String dDay, String importance, String todoStatus , String userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		// todo table
		try { 
			connection = dataSource.getConnection();
			String queryA = "insert into todo (todoContent, dDay, importance) values (?,?,?)";
			
			
			preparedStatement = connection.prepareStatement(queryA);
			preparedStatement.setString(1, todoContent);
			preparedStatement.setString(2, dDay);
			preparedStatement.setString(3, importance);
			
			preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} // finally DB 메모리 정리
		// drawup table
		try {
			connection = dataSource.getConnection();
			String queryB = "insert into drawup (modifyDate, todoStatus, customer_userId) values (now(),?,?)";
			
			
			preparedStatement = connection.prepareStatement(queryB);
			preparedStatement.setString(1, todoStatus);
			preparedStatement.setString(2, userId);
			
			preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} // fin
	} // write
	
	public void modify(int listCode, String todoContent, String dDay, String importance, String todoStatus) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "update todo set todoContent = ?, dDay = ?, importance = ?,  where listCode = ?;";
			String queryB = "update drawup set modifyDate = now(), status = ?,  where listCode = ?;";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			preparedStatement.setString(1, todoContent);
			preparedStatement.setString(2, dDay);
			preparedStatement.setString(3, importance);
			preparedStatement.setInt(4, listCode);
			preparedStatement.setString(5, todoStatus);
			preparedStatement.setInt(6, listCode);
			
			preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		// source가 분리되어 있기 때문에, 정리를 해줘야한다. 문제가 있든 없든 불러오기
		finally {
			try {
				// 각 data가 없을때..? 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
