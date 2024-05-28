package in.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.student.dao.StudentDao;
import in.student.model.Student;
/**
 * StudentManagementApp.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user. 
 */

@WebServlet("/controller/*")
public class StudentManagementApp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		StudentDao studentDao=new StudentDao();
		
		if(request.getRequestURI().endsWith("addform")){
			
					String id=request.getParameter("sid");
					String name=request.getParameter("sname");
					String age=request.getParameter("sage");
					String address=request.getParameter("saddress");
					
					Student student=new Student();
					student.setId(Integer.parseInt(id));
					student.setName(name);
					student.setAge(Integer.parseInt(age));
					student.setAddress(address);
			
					String status=studentDao.addStudent(student);
					PrintWriter out = response.getWriter();
				
					if (status.equals("success")) {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
					} else {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
					}
					out.close();	
				}
		
		if(request.getRequestURI().endsWith("searchform")){
			
			String sid=request.getParameter("sid");
			Student student=studentDao.searchStudent(Integer.parseInt(sid));
			
			PrintWriter out = response.getWriter();
			if (student != null) {
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>" + student.getId() + "</td></tr>");
				out.println("<tr><th>NAME</th><td>" + student.getName() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + student.getAge() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + student.getAddress() + "</td></tr>");
				
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID " + sid+ "</h1>");
			}
			out.close();	
		}
		
		if (request.getRequestURI().endsWith("deleteform")) {
			
			String sid = request.getParameter("sid");
			String status = studentDao.deleteStudent(Integer.parseInt(sid));

			PrintWriter out = response.getWriter();
			if (status.equals("success")) {
				out.println("<body>");
				out.println("<h1 style='color:green;text-align:center;'>RECORD DELETED SUCCESFULLY</h1>");
				out.println("</body>");
			} else if (status.equals("failure")) {
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>RECORD DELETION FAILED</h1>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<h1 style='color:green;text-align:center;'>RECORD NOT FOUND FOR DELETION</h1>");
				out.println("</body>");
			}
			out.close();
		}
		
		if (request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");

			Student student = studentDao.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='post' action='./controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + student.getId() + "</td></tr>");
				out.println("<input type='hidden' name='sid' value='" +student.getId() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getName()+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" +student.getAge()+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddress' value='" + student.getAddress()+ "'/></td></tr>");
				
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + sid+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		
		if (request.getRequestURI().endsWith("updateRecord")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress=request.getParameter("saddress");
			
			Student student= new Student();
			student.setId(Integer.parseInt(sid));
			student.setName(sname);
			student.setAge(Integer.parseInt(sage));
			student.setAddress(saddress);

			String status = studentDao.updateStudent(student);
			PrintWriter out = response.getWriter();
			
			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATION SUCESSFULL</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATION FAILED</h1>");
			}
			out.close();
		}
	}

}
