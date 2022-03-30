package com.javalec.tdl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.tdl.dto.TDtoM;

public class TDaoC {
	DataSource dataSource;
	
	public TDaoC() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/todolist");
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // Constructor
	// userId(*), userPw, userName, signupDate(datetime), resignDate(datetime)
	
	// login
	public String login(String userId, String userPw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String iD = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select userId from customer where userId = ? and userPw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				iD = resultSet.getString("userId");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
		} //finally
		return iD;
	} // login 
	
	// sign
	public void signup(String userId,String userPw,String userName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "insert into customer (userId, userPw, userName, signupDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			preparedStatement.setString(3, userName);
			
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
	} //sign up
	
	//my page
	public ArrayList<TDtoM> mypage(String loginId) {
		ArrayList<TDtoM> dtosM = new ArrayList<TDtoM>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
			
		try {
			connection = dataSource.getConnection();
			String query = "select userId, userName from customer where userId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, loginId);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String userId = resultSet.getString("userId");
				String userName = resultSet.getString("userName");
				
				TDtoM dtoM = new TDtoM(userId, userName);
				dtosM.add(dtoM);
			}
				
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			} 
		return dtosM;
		} 

	
	
		// resign
		public int resign(String userId) {
			int result = 0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				//DB연결메서드 불러오기
				connection = dataSource.getConnection(); 
				//pstmt 생성
				String query = "delete from customer where userId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userId);
				//실행 
				result = preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally { 
					try {
						if(preparedStatement !=null) preparedStatement.close();
						if(connection != null) connection.close();
	 			}catch (Exception e) {
					e.printStackTrace();
	 			}
			}
			return result;
		}//delete닫힘

	
}

			
			

