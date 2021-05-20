package com.services.web;

import java.util.List;

import javax.ws.rs.core.Response;



public interface StudentDao {

	List<Student> getAllStudents();
	List<Student> showpage(int limit,int offset);
	public void addStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudent(int student_id);
	public Student getStudent(int student_id);
//   List showPage(int currentPage, int numOfRecords);
}
