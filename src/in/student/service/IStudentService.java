package in.student.service;

import in.student.dto.Student;

public interface IStudentService
{ 

	public String addStudent(Student student);
	public Student searchStudent(Integer id);
	public String deleteStudent(Integer id);
	public String updateStudent(Student newStudent);


}
