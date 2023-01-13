package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.DbConnection;
import pojo.Subject;

public class SubjectUcpDaoImpl implements SubjectUcpDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SubjectUcpDaoImpl.class);
	
	private  Connection conn;
	private  PreparedStatement preparedStatement;
	private  ResultSet resultSet;
	

	
	public void getSubjectById(int rollNo) {
		
		Subject subject = new Subject();
		
		try {
			logger.info("Inside search subject by roll no");
			conn =  DbConnection.getPoolDataSource().getConnection();
			preparedStatement = conn.prepareStatement("select * from subject where rollno=?");
			preparedStatement.setInt(1,rollNo);
			resultSet = preparedStatement.executeQuery();
			
				
				
			if(resultSet.next()) {
								
				subject.setSubject1(resultSet.getString("Subject1"));
				subject.setSubject2(resultSet.getString("Subject2"));
			
						
				System.out.println(subject);
			}
			else {
				
				subject.setSubject1("No records found");
				subject.setSubject2("no records found");
				System.out.println(subject);
			}
					
				  
		}
		
		catch(Exception e)
		{
		String error = e.getMessage();
		System.out.println("Unexpected error");
		logger.error(error);
		}
		finally 
		{
			try {
				preparedStatement.close();
				conn.close();
				logger.info("Connection Closed");
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		}
	}

}
