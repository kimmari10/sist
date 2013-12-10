package com.gongbang.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.User;

public class GBUserDao implements UserDao {

	@Override
	public User getUser(String id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS WHERE ID=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		User u = new User();
		u.setId(id);
		u.setPw(rs.getString("pw"));
		u.setEmail(rs.getString("email"));
		u.setPhone(rs.getString("phone"));
		u.setImage(rs.getString("image"));				// ÇÁ·ÎÇÊ ÀÌ¹ÌÁö uri
		u.setName(rs.getString("name"));
		u.setNickname(rs.getString("nickname"));
		u.setContent(rs.getString("content"));
		u.setRegdate(rs.getString("regdate"));
		u.setHit(rs.getInt("hit"));
		u.setType(rs.getInt("type"));						// 0: Å»ÅðÈ¸¿ø 1:Á¤È¸¿ø (Å»ÅðÀÚ °ü¸®¸¦ À§ÇÑ ÄÃ·³)
		u.setNote(rs.getString("note"));					// Å»ÅðÀÌÀ¯
	
		rs.close();
		st.close();
		con.close();
		
		return u;
	}

	@Override
	public int registerUser(User u) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USERS (ID, PW, EMAIL, PHONE, IMAGE, NAME, NICKNAME, CONTENT, REGDATE, HIT, TYPE) "
				+ "VALUES (?,?,?,?,?,?,?,?,SYSDATE,1,1)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, u.getId());
		st.setString(2, u.getPw());
		st.setString(3, u.getEmail());
		st.setString(4, u.getPhone());
		st.setString(5, u.getImage());
		st.setString(6, u.getName());
		st.setString(7, u.getNickname());
		st.setString(8, u.getContent());
		
		int af = st.executeUpdate();
				
		st.close();
		con.close();
		
		return af;
	}
	
	@Override
	public int updateUser(User u) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE USERS USERS SET PW=?, EMAIL=?, PHONE=?, IMAGE=?, NAME=?, NICKNAME=?, CONTENT=? "
				+ "WHERE ID=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, u.getPw());
		st.setString(2, u.getEmail());
		st.setString(3, u.getPhone());
		st.setString(4, u.getImage());
		st.setString(5, u.getName());
		st.setString(6, u.getNickname());
		st.setString(7, u.getContent());
		st.setString(8, u.getId());
		
		int af = st.executeUpdate();
				
		st.close();
		con.close();
		
		return af;
	}
	
	@Override
	public int deleteUser(User u) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE USERS USERS SET TYPE=0 WHERE ID=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, u.getId());
		
		int af = st.executeUpdate();
				
		st.close();
		con.close();
		
		return af;		
	}

	@Override
	public User findUserId(String mail) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM USERS WHERE EMAIL=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, mail);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		User u = new User();
		u.setId(rs.getString("id"));
		u.setPw(rs.getString("pw"));
		u.setEmail(mail);
		u.setPhone(rs.getString("phone"));
		u.setImage(rs.getString("image"));				// ÇÁ·ÎÇÊ ÀÌ¹ÌÁö uri
		u.setName(rs.getString("name"));
		u.setNickname(rs.getString("nickname"));
		u.setContent(rs.getString("content"));
		u.setRegdate(rs.getString("regdate"));
		u.setHit(rs.getInt("hit"));
		u.setType(rs.getInt("type"));						// 0: Å»ÅðÈ¸¿ø 1:Á¤È¸¿ø (Å»ÅðÀÚ °ü¸®¸¦ À§ÇÑ ÄÃ·³)
		u.setNote(rs.getString("note"));					// Å»ÅðÀÌÀ¯
	
		rs.close();
		st.close();
		con.close();
		
		return u;
	}

	@Override
	public List<User> getUserList(int page, int type, String field,
			String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int snum = (page-1)*15 + 1;

		String sql = "SELECT * 	FROM"
				+ "(SELECT ROWNUM NUM, N.* FROM "	
				+ "(SELECT * FROM (SELECT * FROM USERS WHERE TYPE = ?)  N "
				+ "WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N ) "
				+ "WHERE NUM BETWEEN ? AND ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, type);
		st.setString(2, query);
		st.setInt(3, snum);
		st.setInt(4, snum+14);
		
		ResultSet rs = st.executeQuery();
		
		List<User> list = new ArrayList<User>();
		
		while(rs.next())
		{
			User u = new User();
			u.setId(rs.getString("id"));
			u.setPw(rs.getString("pw"));
			u.setEmail(rs.getString("email"));
			u.setPhone(rs.getString("phone"));
			u.setImage(rs.getString("image"));				// ÇÁ·ÎÇÊ ÀÌ¹ÌÁö uri
			u.setName(rs.getString("name"));
			u.setNickname(rs.getString("nickname"));
			u.setContent(rs.getString("content"));
			u.setRegdate(rs.getString("regdate"));
			u.setHit(rs.getInt("hit"));
			u.setType(rs.getInt("type"));						// 0: Å»ÅðÈ¸¿ø 1:Á¤È¸¿ø (Å»ÅðÀÚ °ü¸®¸¦ À§ÇÑ ÄÃ·³)
			u.setNote(rs.getString("note"));
			
			list.add(u);
		}
		
		rs.close();
		st.close();
		con.close();
		return list;
	}
	@Override
	public int getNewUserCount() throws ClassNotFoundException, SQLException {
		
		String newuser = "SELECT COUNT(REGDATE) NU FROM USERS WHERE SUBSTR(SYSDATE,1,10)=REGDATE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(newuser);
		
		int nu = 0;
		
		if(rs.next())
			nu = rs.getInt("NU");

		rs.close();
		st.close();
		con.close();
		
		return nu;
	}

	@Override
	public int getLeaveUserCount() throws ClassNotFoundException, SQLException{
		
		String leaveuser = "SELECT COUNT(TYPE) LU FROM USERS WHERE TYPE=0";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(leaveuser);
		
		int lu = 0;
		
		if(rs.next())
			lu = rs.getInt("LU");

		rs.close();
		st.close();
		con.close();
		
		return lu;
	}

	@Override
	public int getTotalUserCount() throws ClassNotFoundException, SQLException{
		String sqluser = "SELECT COUNT(ID) NID FROM USERS WHERE TYPE=1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sqluser);
		
		int nid = 0;
		
		if(rs.next())
			nid = rs.getInt("NID");

		rs.close();
		st.close();
		con.close();
		
		return nid;
	}

}
