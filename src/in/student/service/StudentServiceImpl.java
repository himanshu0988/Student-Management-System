package in.student.service;

import in.student.dao.IStudentDao;
import in.student.daofectory.StudentDaofectory;
import in.student.dto.Student;
import in.student.servicefectory.StudentServiceFectory;

public class StudentServiceImpl implements IStudentService
{

	IStudentDao studentdao=null;
	@Override
	public String addStudent(Student student) {
		
			studentdao=StudentDaofectory.getStudentDao();
			return studentdao.addStudent(student);
		
	}

	@Override
	public Student searchStudent(Integer id) 
	{
		studentdao=StudentDaofectory.getStudentDao();
		return studentdao.searchStudent(id);
	}

	@Override
	public String updateStudent(Student student) {
		studentdao=StudentDaofectory.getStudentDao();
		return studentdao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer id) {
	if(studentdao==null)
	{
		studentdao=StudentDaofectory.getStudentDao();
	}
	return studentdao.deleteStudent(id);
	}

}
