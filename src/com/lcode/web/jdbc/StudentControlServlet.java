package com.lcode.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Servlet implementation class StudentControlServlet
 */
@WebServlet("/StudentControlServlet")
public class StudentControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	StudentDbUtil studentUtil;
// Constructor for class = init method for servlet	

	@Override
	public void init() throws ServletException {
		super.init();
		
		MysqlDataSource datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setPortNumber(3306);
		datasource.setDatabaseName("web_student_tracker");
		datasource.setUser("webstudent");
		datasource.setPassword("webstudent");
		
		try {
			studentUtil = new StudentDbUtil(datasource);
		}
		catch(Exception exc){
			throw new ServletException(exc);
		}	
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//reading response
			String command = request.getParameter("command");
			
			if(command == null) {
				command = "LIST";
			}
			
			switch(command) {
			case "LIST":
				listStudents(request,response);
				break;
				
			case "ADD":
				addStudent(request,response);
				break;
				
			case "LOAD":
				loadStudent(request,response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
				
			case "DELETE":
				deleteStudent(request,response);
				break;
			default:
				listStudents(request,response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String stdtID = request.getParameter("studentID");
		int studentID = Integer.parseInt(stdtID);
		
		StudentDbUtil.deleteStudent(studentID);
		
		listStudents(request,response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{

		String stdtID = request.getParameter("studentID");
		
		int studentID = Integer.parseInt(stdtID);
		
		String firstName = request.getParameter("firstName");
		
		String lastName = request.getParameter("lastName");
		
		String email = request.getParameter("email");
		
		String grad = request.getParameter("grad");
		
		boolean graduate = false;
		
		if(grad.equals("Yes")) {
			graduate = true;
		}else {
			graduate = false;
		}
		
		Student student = new Student(studentID,firstName,lastName,email,graduate);
		
		StudentDbUtil.updateStudent(student);
		
		listStudents(request,response);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String Id = request.getParameter("studentID");
				
		Student student = StudentDbUtil.loadStudent(Id);
		
		request.setAttribute("THE_STUDENT", student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update_list.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName = request.getParameter("firstName");
		
		String lastName = request.getParameter("lastName");
		
		String email = request.getParameter("email");
		
		String grad = request.getParameter("grad");
		
		boolean graduate = false;
		
		if(grad.equals("Yes")) {
			graduate = true;
		}else {
			graduate = false;
		}
		
		Student student = new Student(firstName,lastName,email,graduate);
		
		StudentDbUtil.addStudent(student);
		
		listStudents(request,response);
		
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Student> students = studentUtil.getStudent();

		request.setAttribute("STUDENT_LIST", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_student.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
