package com.javalec.tdl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.tdl.dto.TDto;

public class TDaoDT {

	DataSource dataSource;
	
	public TDaoDT() {
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
	
	public ArrayList<TDto> list() {
		ArrayList<TDto> dtos = new ArrayList<TDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "select t.listCode, t.todoContent, t.importance, t.dDay from customer c, ";
			String queryB = "drawup d, todo t where d.userId = c.userid and d.listCode = t.listCode";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int listCode = resultSet.getInt("listCode");
				String todoContent = resultSet.getString("todoContent");
				String importance = resultSet.getString("importance");
				Date dDay = resultSet.getDate("dDay");
				
				TDto dto = new TDto(listCode, todoContent, importance, dDay);
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
		}
		return dtos;
	}
	
	public void write(String todoContent, String dDay, String importance, String status) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "insert into todo (todoContent, dDay, importance) values (?, ?, ?);";
			String queryB = "insert into drawup (modifyDate, status) values (now(), ?);";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			preparedStatement.setString(1, todoContent);
			preparedStatement.setString(2, dDay);
			preparedStatement.setString(3, importance);
			preparedStatement.setString(4, status);
			
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
