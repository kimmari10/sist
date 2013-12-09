package dao;

import java.sql.SQLException;

import vo.Student;

public interface StudentDao {
	
	public Student getStudents(String sid) throws ClassNotFoundException, SQLException;

}
