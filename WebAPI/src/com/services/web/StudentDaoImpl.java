package com.services.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

public class StudentDaoImpl implements StudentDao {

	
	

	public List<Student> showpage(int limit,int offset) {
		List<Student> list = new ArrayList<>();
		
		try {
			Connection conn = GetConnection.GetConnection();
			String query = "SELECT * FROM student LIMIT "+limit+" OFFSET "+offset;
			Statement stmt3 = conn.createStatement();
			ResultSet res = stmt3.executeQuery(query);
			while (res.next()) {
				Student std = new Student();
				std.setStudent_id(res.getInt("student_id"));
				std.setFirst_name(res.getString("first_name"));
				std.setLast_name(res.getString("last_name"));

				std.setBatch_id(res.getInt("batch_id"));
				std.setGender(res.getString("gender"));

				list.add(std);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		
		try {
			Connection conn = GetConnection.GetConnection();
			String query = "SELECT * FROM student";
			Statement stmt3 = conn.createStatement();
			ResultSet res = stmt3.executeQuery(query);
			while (res.next()) {
				Student std = new Student();
				std.setStudent_id(res.getInt("student_id"));
				std.setFirst_name(res.getString("first_name"));
				std.setLast_name(res.getString("last_name"));

				std.setBatch_id(res.getInt("batch_id"));
				std.setGender(res.getString("gender"));

				list.add(std);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public void addStudent(Student student) {
		try {
			Connection conn = GetConnection.GetConnection();

			Statement stmt = conn.createStatement();
			String query1 = "INSERT INTO student VALUES(" + student.getStudent_id() + "," + "'"
					+ student.getFirst_name() + "'" + "," + "'" + student.getLast_name() + "'" + "," +
					+ student.getBatch_id()  + ","  +"'"+ student.getGender()  +"'"+ ")";

			
			PreparedStatement stmt1 = conn.prepareStatement(query1);
			//PreparedStatement stmt2 = conn.prepareStatement(query2);
			stmt1.executeUpdate();
			//stmt2.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			}

		}

	
	
public Student updateStudent(Student student) {
		
		try {
			Connection conn = GetConnection.GetConnection();
           
            String upd = "UPDATE student set first_name=" + "'" + student.getFirst_name() + "'"+"," +"last_name="+"'"+student.getLast_name()+"'"+","+"batch_id="+student.getBatch_id()+","			
            +"gender="+"'"+student.getGender()+"'"+" WHERE student_id="+student.getStudent_id();
            
            Statement statement = conn.prepareStatement(upd);
            statement.executeUpdate(upd);
            
            
            conn.commit();
		}catch ( SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

public void deleteStudent(int student_id) {
	
	try {
		Connection conn = GetConnection.GetConnection();
		String str3 = "DELETE FROM student where student_id ="+student_id;
        Statement stmt = conn.prepareStatement(str3);
      // stmt.setInt(1, student_id);
       stmt.executeUpdate(str3);
        /*int rowsDeleted = stmt.executeUpdate();
        if(rowsDeleted>0) {
       System.out.println("deleted successfully");
        }*/
        conn.commit();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

public Student getStudent(int student_id) {
	String student=" ";
	try {
		Connection conn = GetConnection.GetConnection();
		String query = "SELECT * FROM student where student_id="+student_id;
		Statement stmt3 = conn.createStatement();
		ResultSet res = stmt3.executeQuery(query);
		while (res.next()) {
			Student std = new Student();
			std.setStudent_id(res.getInt("student_id"));
			std.setFirst_name(res.getString("first_name"));
			std.setLast_name(res.getString("last_name"));

			std.setBatch_id(res.getInt("batch_id"));
			std.setGender(res.getString("gender"));

			return std;
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	
}






}
