package in.student.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.student.connection.JdbcUtil;
import in.student.model.Student;
/**
 * This DAO class provides CRUD database operations for the
 * table student in the database.
 * 
 * @author Himanshu Kumar Singh
 *
 */
public class StudentDao {
	Connection connection=null;
	PreparedStatement pstm=null;
	ResultSet resultset=null;
	Student student=null;
	
	public String addStudent(Student student) {
		try {
			connection=connection=JdbcUtil.getConnection();
			if(connection!=null){
				String query="Insert into student (sid,`sname`,sage,`saddress`)values(?,?,?,?)";
				pstm=connection.prepareStatement(query);
			}
			if(pstm!=null){
				pstm.setInt(1,student.getId());
				pstm.setString(2,student.getName());
				pstm.setInt(3,student.getAge());
				pstm.setString(4,student.getAddress());
				
				int rowAffected=pstm.executeUpdate();
				if(rowAffected !=0)
				return "success";
			}
		  } catch (SQLException | IOException e) {
			e.printStackTrace();
		  }
		return "failure";	
	}

	public Student searchStudent(Integer id) {
		try {
			connection=connection=JdbcUtil.getConnection();
			if(connection!=null){
				String query="Select sid,sname,sage,saddress from student where sid=?";
				pstm=connection.prepareStatement(query);
			}
			if(pstm!=null){
				pstm.setInt(1, id);
				resultset=pstm.executeQuery();
			}
			if(resultset!=null)
				if(resultset.next()){
					student = new Student();
					
					student.setId(resultset.getInt(1));
					student.setName(resultset.getString(2));
					student.setAge(resultset.getInt(3));
					student.setAddress(resultset.getString(4));
					return student;
				}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return student;	
	}

	public String updateStudent(Student student) {
			try {
				String sqlUpdateQuery = "update student set sname=?,sage=?,saddress=? where sid=?";
				connection=connection=JdbcUtil.getConnection();

				if (connection != null)
					pstm = connection.prepareStatement(sqlUpdateQuery);
				
				if (pstm != null) {
					pstm.setString(1, student.getName());
					pstm.setInt(2, student.getAge());
					pstm.setString(3, student.getAddress());
					pstm.setInt(4, student.getId());

					int rowAffected = pstm.executeUpdate();
					if (rowAffected == 1) 
					return "success";
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return "failure";
	}

	public String deleteStudent(Integer id) {
		try {
			connection=connection=JdbcUtil.getConnection();
			if(connection!=null){
				String query="Delete from student where sid=?";
				pstm=connection.prepareStatement(query);
			}
			if(pstm!=null){
				pstm.setInt(1, id);
				int rowAffected=pstm.executeUpdate();
				if(rowAffected==1)
				return "success";
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}
}
