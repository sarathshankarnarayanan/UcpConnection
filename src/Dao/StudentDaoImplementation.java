package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.DbConnection;
import pojo.Student;

public class StudentDaoImplementation implements StudentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImplementation.class);
	private Connection conn;
	private PreparedStatement preparedStatement;
	private  Statement statement;
	private  ResultSet resultSet;
	
	
	
	
	public void getAllStudents() {
	Student student = new Student();
		
		
		try {
			logger.info("Inside get all student");
			conn =  DbConnection.getPoolDataSource().getConnection();
			String query ="Select * from student";
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			
			
			
			if(!resultSet.next()) {
				
				System.out.println("No records Found");
				
			}else {
				
						do {
								student.setRollNumber(resultSet.getInt("RollNo"));
								student.setName(resultSet.getString("Name"));
								student.setAddress(resultSet.getString("Address"));
						
								System.out.println(student);
						}while(resultSet.next());
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
				statement.close();
				conn.close();
				logger.info("Connection Closed");
			} catch (SQLException e) {
				
				logger.error(e.getMessage());
			}
		}
	}
	public void addNewStudents(Student student) {
		
		try {
			  logger.info("Inside addnewBook");
			  conn = DbConnection.getPoolDataSource().getConnection();
			  preparedStatement =conn.prepareStatement("insert into student values (?,?,?)"); 
			  preparedStatement.setInt(1, student.getRollNumber()); 
			  preparedStatement.setString(2, student.getName()); 
			  preparedStatement.setString(3,student.getAddress()); 
			  int count= preparedStatement.executeUpdate(); 
			  System.out.println("Book added Successfully");
			  logger.info(count +" rows effected" );
			  
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
	
	public void getStudentById(int rollNo) {
		
			Student student = new Student();
			SubjectUcpDaoImpl subjectDao = new SubjectUcpDaoImpl();
		
		
		try {
			logger.info("Inside get all student");
			conn =  DbConnection.getPoolDataSource().getConnection();
			preparedStatement = conn.prepareStatement("Select * from Student where RollNo = ?");
			preparedStatement.setInt(1, rollNo);
			resultSet = preparedStatement.executeQuery();
			
			
			
			if(resultSet.next()) {
				
				student.setRollNumber(resultSet.getInt("RollNo"));
				student.setName(resultSet.getString("Name"));
				student.setAddress(resultSet.getString("Address"));
				
				System.out.println(student);
				subjectDao.getSubjectById(rollNo);
				
			}else {
						
						System.out.println("No records Found");
					
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
