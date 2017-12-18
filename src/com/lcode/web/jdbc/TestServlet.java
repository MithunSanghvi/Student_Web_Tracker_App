package com.lcode.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


/**
 * Servlet implementation class TestServle
 */

@WebServlet("/studentList")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Define DataSource/Connection pool for resource injection, use resource name same as context.xml file
	//@Resource(name="web_student_db")
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set content type
		response.setContentType("text/html");
		
		MysqlDataSource datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setPortNumber(3306);
		datasource.setDatabaseName("web_student_tracker");
		datasource.setUser("webstudent");
		datasource.setPassword("webstudent");
		
		//Setup PrintWriter
		PrintWriter out = response.getWriter();
		
		out.println("Hello");
		//Getting DB connection and execution objects
		Connection myConn = null;
		java.sql.Statement myStmt = null;
		ResultSet myRs = null;
		
		
//		Try connection,query and result to DB
		try {
			
			myConn = datasource.getConnection();
			myStmt = myConn.createStatement();
			
			//SQL statement
			String sql = "select * from student";
			
			//Result
			myRs = myStmt.executeQuery(sql);
			
			//Processing result
			while(myRs.next()) {
				String email = myRs.getString("email");
				out.println(email);
			}
			
		}
		catch (Exception exc) {
			
			exc.printStackTrace();			
			
		}
	}

}
