package client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Dao.StudentDaoImplementation;
import Dao.SubjectUcpDaoImpl;
import database.DbConnection;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import pojo.Student;



public class Ucpconnection {

	public static void main(String[] args) {
		
		final Logger logger = LoggerFactory.getLogger(Ucpconnection.class);
		
		System.out.println("************Welcome*********************");
		int choice;
		Scanner scan = new Scanner(System.in);
		
			Student student = new Student();
			StudentDaoImplementation studentDao = new StudentDaoImplementation();
			SubjectUcpDaoImpl subjectDao = new SubjectUcpDaoImpl();
			
			
		do {
			
			System.out.println("1)Add a new Student to the database");
			System.out.println("2)Get All Records Of Student");
			System.out.println("3)Get student record with marks");
			System.out.println("4)Exit");
			
			System.out.println("\nEnter your choice:");
			String mChoice = scan.next();
			
			try {
				choice = Integer.parseInt(mChoice);
			}catch (NumberFormatException ex) {
				System.out.println("Please Enter Number only");
				choice = 0;
			}
			
			switch(choice) {
			
			case 1 :
				logger.info("Selected for Adding new Book");
				int studentRollNo;
				String StudentName, studentAddress;
				
				System.out.print("Enter Student Roll No:");
				studentRollNo = scan.nextInt();
				
				System.out.print("Enter Student Name:");
				scan.nextLine();
				StudentName = scan.nextLine();
				
				System.out.print("Enter Student Address:");
				studentAddress = scan.nextLine();
				
				student.setRollNumber(studentRollNo);
				student.setName(StudentName);
				student.setAddress(studentAddress);
				
				studentDao.addNewStudents(student);
				
				break;
				
			case 2:
				logger.info("Selected to get all records of student");
				
				
				studentDao.getAllStudents();
				break;
				
			case 3:
				int rollNo;
				System.out.print("Enter Student Roll No:");
				rollNo = scan.nextInt();
				
				studentDao.getStudentById(rollNo);
				
				break;
				 			
			case 4 :
				
				break;
				
			default :
				
				System.out.println("Please Enter a proper Value");
				logger.error("User Entered wrong value");
				
			}
			
			
		}while(choice != 4);
		
		logger.info("Application closed");
		System.out.println("************Thank You*********************");
	}
	

}
