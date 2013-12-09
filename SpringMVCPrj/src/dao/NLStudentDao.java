package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Student;

public class NLStudentDao implements StudentDao{

	public Student getStudents(String sid) throws ClassNotFoundException, SQLException 
	{
		String sql = "SELECT * FROM STUDENTS WHERE SID =?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, sid);
		
		
		ResultSet rs = st.executeQuery();

		Student s = null;
		
		if(rs.next()) 
		{
			s = new Student();
			
			s.setSid(rs.getString("sid"));
			s.setPwd(rs.getString("pwd"));
			s.setName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setAge(rs.getInt("age"));
			s.setBirthday(rs.getString("birthday"));
			s.setMajor(rs.getString("major"));
			s.setAddress(rs.getString("address"));
			s.setPhone(rs.getString("phone"));
			s.setSsn(rs.getString("ssn"));
			s.setIp(rs.getString("ip"));
			s.setRegdate(rs.getString("regdate"));
			s.setBoss(rs.getString("boss"));

		}

		rs.close();
		st.close();
		con.close();

		return s;
	}

}
