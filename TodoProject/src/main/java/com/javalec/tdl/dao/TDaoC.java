package com.javalec.tdl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	
	//mypage
	public void mypage(String userId, String userName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
			
		try {
			connection = dataSource.getConnection();
			String query = "select userId from customer where userId = ? and userName = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userName);
			resultSet = preparedStatement.executeQuery();
				
				
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

	public int userCheck(String id, String pw) {
		int resultNum = 0;
	
		String sql = "SELECT userPw FROM customer WHERE userId=?";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
	
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				String dbPw = rs.getString("user_pw");
				if(dbPw.equals(pw)) { //로그인에 성공한 경우
					resultNum = 1;
				} else { //비밀번호가 틀렸을 경우
					resultNum = 0;
				}				
			} else { //아이디가 존재하지 않는 경우
				resultNum = -1;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				if( pstmt!=null)  pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
		}
			return resultNum;
	
	}

}

			
			

