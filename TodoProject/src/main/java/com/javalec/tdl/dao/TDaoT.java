package com.javalec.tdl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.tdl.dto.TDto;

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
				String query = "delete from todos where listCode = ? ";
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
	
	public ArrayList<TDto> list(String customerId) {
		ArrayList<TDto> dtos = new ArrayList<TDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "select c.userId, t.listCode, t.todoContent, t.dDay, t.todoStatus from customer c, ";
			String queryB = "todos t where t.customer_userId = c.userId and t.customer_userId = ?";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			preparedStatement.setString(1, customerId);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String userId = resultSet.getString("userId");
				int listCode = resultSet.getInt("listCode");
				String todoContent = resultSet.getString("todoContent");
				String dDay = resultSet.getString("dDay");
				String todoStatus = resultSet.getString("todoStatus");
				
				TDto dto = new TDto(userId, listCode, todoContent, dDay, todoStatus);
				dtos.add(dto);
			}
			preparedStatement.executeUpdate();
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
		}
		return dtos;
	}
	
	public void write(String customer_userId, String todoContent, String dDay, String importance, String todoStatus) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "insert into todos (customer_userId, todoContent, dDay, importance, todoStatus) ";
			String queryB = "values (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			preparedStatement.setString(1, customer_userId);
			preparedStatement.setString(2, todoContent);
			preparedStatement.setString(3, dDay);
			preparedStatement.setString(4, importance);
			preparedStatement.setString(5, todoStatus);
			
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
	
	public void modify(int listCode, String todoContent, String dDay, String importance, String todoStatus) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update todos set todoContent = ?, dDay = ?, importance = ?, todoStatus = ?, modifyDate = now() where listCode = ?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, todoContent);
			preparedStatement.setString(2, dDay);
			preparedStatement.setString(3, importance);
			preparedStatement.setString(4, todoStatus);
			preparedStatement.setInt(5, listCode);
			
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
