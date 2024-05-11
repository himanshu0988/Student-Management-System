package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefectory.StudentServiceFectory;

@WebServlet("/controller/*")
public class JDBCCrudApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IStudentService stdService=StudentServiceFectory.getStudentService();
		
		System.out.println("Request URL:: "+request.getRequestURI());
		System.out.println("Path Info :: "+request.getPathInfo());
		
		if(request.getRequestURI().endsWith("addform"))
				{
					String id=request.getParameter("sid");
					String name=request.getParameter("sname");
					String age=request.getParameter("sage");
					String address=request.getParameter("saddress");
					
					Student s=new Student();
					s.setId(Integer.parseInt(id));
					s.setName(name);
					s.setAge(Integer.parseInt(age));
					s.setAddress(address);
			
					
					
					String status=stdService.addStudent(s);
					PrintWriter out = response.getWriter();

					if (status.equals("success")) {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
					} else {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
					}
					out.close();
					
				}
		
		if(request.getRequestURI().endsWith("searchform"))
		{
			String sid=request.getParameter("sid");
			Student s=stdService.searchStudent(Integer.parseInt(sid));
			
			PrintWriter out = response.getWriter();
			if (s != null) {
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>" + s.getId() + "</td></tr>");
				out.println("<tr><th>NAME</th><td>" + s.getName() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + s.getAge() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + s.getAddress() + "</td></tr>");
				
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
			String status = stdService.deleteStudent(Integer.parseInt(sid));

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

			Student s = stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (s != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='post' action='./controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + s.getId() + "</td></tr>");
				out.println("<input type='hidden' name='sid' value='" + s.getId() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + s.getName()+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + s.getAge()+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddress' value='" + s.getAddress()+ "'/></td></tr>");
				
						
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + sid
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		
		if (request.getRequestURI().endsWith("updateRecord")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress=request.getParameter("saddress");
			

			Student s= new Student();
			s.setId(Integer.parseInt(sid));
			s.setName(sname);
			s.setAge(Integer.parseInt(sage));
			s.setAddress(saddress);

			String status = stdService.updateStudent(s);
			PrintWriter out = response.getWriter();

			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATED SUCCESSFULLY</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATION FAILED</h1>");
			}
			out.close();

		}
	}

}
