package in.ineuron.servicefectory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

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
