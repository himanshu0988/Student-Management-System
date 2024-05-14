package in.student.servicefectory;

import in.student.service.IStudentService;
import in.student.service.StudentServiceImpl;

public class StudentServiceFectory {

	private StudentServiceFectory() {}
	
	private static IStudentService studentService=null;
	
	public static IStudentService getStudentService()
	{
		if(studentService==null)
		{
		studentService= new StudentServiceImpl();
		
		}
		return studentService;
	}

}
