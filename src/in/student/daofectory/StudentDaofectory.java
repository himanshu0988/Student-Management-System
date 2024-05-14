package in.student.daofectory;

import in.student.dao.IStudentDao;
import in.student.dao.StudentDaoImpl;

public class StudentDaofectory
{
	private StudentDaofectory(){}
	private static IStudentDao studentdao=null;
	public static IStudentDao getStudentDao()
	{
		if(studentdao==null)
		{
		studentdao=new StudentDaoImpl();
		}
		return studentdao;
		
	}

}
