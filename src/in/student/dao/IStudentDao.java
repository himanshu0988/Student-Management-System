package in.student.dao;

import in.student.dto.Student;

public interface IStudentDao 
{
	public String addStudent(Student student);
	public Student searchStudent(Integer id);
	public String deleteStudent(Integer id);
	public String updateStudent(Student student);

}
