package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.Message;

public class GBMessageDao implements MessageDao {

	@Override
	public int composeMessage(Message m) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO MESSAGES(WRITER, RECEIVER, TITLE, CONTENT, REGDATE) VALUES(?, ?, ?, ?, SYSDATE)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl", "sist_leather",
				"!leather1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, m.getWriter());
		st.setString(2, m.getReceiver());
		st.setString(3, m.getTitle());
		st.setString(4, m.getContent());

		int af = st.executeUpdate();

		st.close();
		con.close();

		return af;
	}

	@Override
	public int deleteMessage(int seq) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM MESSAGES WHERE SEQ = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl", "sist_leather",
				"!leather1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, seq);

		int af = st.executeUpdate();

		st.close();
		con.close();

		return af;
	}

	@Override
	public List<Message> getRecvMessages(int page, String field, String target) throws SQLException,
			ClassNotFoundException {

		int snum = 1 + (page - 1) * 15;

		String sql = "SELECT * FROM (SELECT ROWNUM NUM, M.* FROM (SELECT * FROM MESSAGES WHERE "
				+ field
				+ "  LIKE ? ORDER BY REGDATE DESC) M) WHERE NUM BETWEEN ? AND ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl", "sist_leather",
				"!leather1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, target);
		st.setInt(2, snum);
		st.setInt(3, snum + 14);

		ResultSet rs = st.executeQuery();

		List<Message> list = new ArrayList<Message>();

		while (rs.next()) {
			Message m = new Message();

			m.setSeq(rs.getInt("seq"));
			m.setContent(rs.getString("content"));
			m.setRegdate(rs.getString("regdate"));
			m.setWriter(rs.getString("writer"));
			m.setReceiver(rs.getString("receiver"));
			m.setTitle(rs.getString("title"));
			
			list.add(m);
		}
		
		rs.close();
		st.close();
		con.close();

		return list;
	}

	public List<Message> getSendMessages(int page, String field, String target)
			throws ClassNotFoundException, SQLException {

		int snum = 1 + (page - 1) * 15;

		String sql = "SELECT * FROM (SELECT ROWNUM NUM, M.* FROM (SELECT * FROM MESSAGES WHERE "
				+ field
				+ "  LIKE ? ORDER BY REGDATE DESC) M) WHERE NUM BETWEEN ? AND ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl", "sist_leather",
				"!leather1234");

		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, target);
		st.setInt(2, snum);
		st.setInt(3, snum + 14);

		ResultSet rs = st.executeQuery();

		List<Message> list = new ArrayList<Message>();

		while (rs.next()) {
			Message m = new Message();

			m.setSeq(rs.getInt("seq"));
			m.setContent(rs.getString("content"));
			m.setRegdate(rs.getString("regdate"));
			m.setWriter(rs.getString("writer"));
			m.setReceiver(rs.getString("receiver"));
			m.setTitle(rs.getString("title"));

			list.add(m);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public List<Message> getMessages(int page) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNewMsgCount() throws ClassNotFoundException, SQLException{
		
		String newmsg = "SELECT COUNT(REGDATE) NM FROM MESSAGES WHERE SUBSTR(SYSDATE,1,10)=REGDATE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(newmsg);
		
		int nm = 0;
		
		if(rs.next())
			nm = rs.getInt("NM");

		rs.close();
		st.close();
		con.close();
		
		return nm;
	}
	
}
