package Dao;

import pojo.Student;

public interface StudentDao {

	
	public void getAllStudents();
	public void addNewStudents(Student student);
	public void getStudentById(int rollNo);
}
