package com.lcode.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//Get datasource object from servlet and return database result back to servlet

public class StudentDbUtil {

	private static DataSource dataSource;

	public StudentDbUtil(DataSource thedatasource) {
		dataSource = thedatasource;
	}
	
	
private static void close(Connection myConn, Statement myStmt, ResultSet RS) {
		
		try {
			
			if(myConn != null) {
			myConn.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(RS != null) {
				RS.close();
			}	
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	
	
	public List<Student> getStudent() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet RS = null;
		
		try {

			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			
			String sql = "select * from student";
			
			RS = myStmt.executeQuery(sql);
			
			while(RS.next()) {
				int id = RS.getInt("id");
				String firstName = RS.getString("first_name");
				String lastName = RS.getString("last_name");
				String email = RS.getString("email");
				boolean grad = RS.getBoolean("graduate");
				
				Student tempstudent = new Student(id,firstName,lastName,email,grad);
				
				students.add(tempstudent);

			}
			
			return students;
		}
		finally {
			
			//closing JDBC objects
			close(myConn, myStmt, RS);
		}
	}


	public static void addStudent(Student student) throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "insert into student"+
			"(first_name,last_name,email,graduate)"+
			"values (?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());
			myStmt.setBoolean(4, student.isGrad());
			
			myStmt.execute();
		}
		finally {
			
			close(myConn, myStmt, null);
			
		}
		
		
	}


	public static Student loadStudent(String id) throws Exception{

			
			Student tempstudent = null;;
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet RS = null;
			int studentID;
			
			try {
				
				studentID = Integer.parseInt(id);
	
				myConn = dataSource.getConnection();
								
				String sql = "select * from student where id=?";
				
				myStmt = myConn.prepareStatement(sql);
				
				myStmt.setInt(1, studentID);
				
				RS = myStmt.executeQuery();
				
				if(RS.next()) {
					String firstName = RS.getString("first_name");
					String lastName = RS.getString("last_name");
					String email = RS.getString("email");
					boolean grad = RS.getBoolean("graduate");
						
					tempstudent = new Student(studentID,firstName,lastName,email,grad);
					
				}else {
					throw new Exception ("Could not find Student ID: "+ studentID);
				}
				
				return tempstudent;
			}
			finally {
				
				//closing JDBC objects
				close(myConn, myStmt, RS);
			}
			
		
	}


	public static void updateStudent(Student student) throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			
		
		myConn = dataSource.getConnection();
		
		String sql = "update student " + "set first_name=?, last_name=?, email=?, graduate=? "
						+"where id=?";
		
		myStmt = myConn.prepareStatement(sql);
		
		myStmt.setString(1, student.firstName);
		myStmt.setString(2, student.lastName);
		myStmt.setString(3, student.email);
		myStmt.setBoolean(4, student.grad);
		myStmt.setInt(5, student.id);
		
		myStmt.execute();
		}
		finally {
		close(myConn, myStmt, null);
		}
		
	}


	public static void deleteStudent(int studentID) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
		myConn = dataSource.getConnection();
		
		String sql = "delete from student where id=?";
		
		myStmt = myConn.prepareStatement(sql);
		
		myStmt.setInt(1, studentID);
		
		myStmt.execute();
		}
		finally {
		close(myConn, myStmt, null);
		}
		
		
	}
	
	
}
