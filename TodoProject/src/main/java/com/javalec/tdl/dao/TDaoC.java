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
		String userID = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select userId from customer where userId = ? , userPw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userID = resultSet.getString("userId");
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
		return userID;
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
	

	// resign
	public int resign(String userId,String userPw) {
		int result = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			//DB연결메서드 불러오기
			connection = dataSource.getConnection(); // DB연결 끝
			
			//SQL & pstmt 생성
			String query = "select userPw from customer where userId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			//실행 >rs 저장
			ResultSet rs = null;
			rs = preparedStatement.executeQuery();
			//7-4. 데이터처리 : DB에 있는 회원인 경우 삭제, 아닌 경우 에러
			if(rs.next()){
				if(userPw.equals(rs.getString("userPw"))){
					//비번일치하면 정보삭제 작업
					// SQL 구문작성 & pstmt 생성
					String query2 = "delete from itwill_member where id=?";
					preparedStatement = connection.prepareStatement(query2);
					preparedStatement.setString(1, userId);
					preparedStatement.executeUpdate();
					result = 1;
					System.out.println("회원탈퇴에 성공하였습니다.");
				}else{
					result = 0;
					System.out.println("입력 정보를 다시 확인해주세요.");
				}
			}else{
				result = -1;
				System.out.println("입력 정보를 다시 확인해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //자원해제 
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

			
			

