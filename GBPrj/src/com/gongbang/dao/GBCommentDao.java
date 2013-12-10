package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.Comment;

public class GBCommentDao implements CommentDao {

	public List<Comment> getComments(String seq) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT ROWNUM, COMMENTS. * FROM (SELECT * FROM COMMENTS WHERE BBS_SEQ=? ORDER BY REGDATE DESC)"; //15°³¾¿ »Ì±â
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		List<Comment> list = new ArrayList<Comment>();
		
		while(rs.next()) {
			
			Comment c = new Comment();

			c.setSeq(rs.getString("seq"));
			c.setTitle(rs.getString("title"));
			c.setWriter(rs.getString("writer"));
			c.setContents(rs.getString("contents"));
			
			list.add(c);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public int commentInsert(Comment c) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO COMMENTS(SEQ, WRITER, CONTENTS, REGDATE, NUM) VALUES(?,?,?,SYSDATE,?)";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sql);
		
		String seq = "1";
		
		if(rsSeq.next())
			seq = rsSeq.getString("seq");
		
		rsSeq.close();
		stSeq.close();
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, seq);
		st.setString(2, c.getWriter());
		st.setString(3, c.getContents());
		st.setInt(4, c.getNum());
		
		int af= st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}

	@Override
	public int commentModify(Comment c, String commentSeq) throws ClassNotFoundException, SQLException {
		

		String sql = "UPDATE COMMENTS SET CONTENTS='?', REGDATE=SYSDATE WHERE SEQ='?'";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sql);
		
		String seq = "1";
		
		if(rsSeq.next())
			seq = rsSeq.getString("seq");
		
		rsSeq.close();
		stSeq.close();
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, c.getContents());
		st.setString(2, seq);

		int af= st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}
	
	@Override
	public int commentInsert(Comment c, String commentSeq) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO COMMENTS(SEQ, WRITER, CONTENTS, REGDATE) VALUES(?,?,?,SYSDATE) WHERE BBS_SEQ=?";
		 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sql);
		
		String seq = "1";
		
		if(rsSeq.next())
			seq = rsSeq.getString("seq");
		
		rsSeq.close();
		stSeq.close();
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, c.getWriter());
		st.setString(2, c.getContents());
		
		int af= st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;

	}

	@Override
	public int commentDelete(String commentSeq) throws ClassNotFoundException, SQLException {

		String sql = "DELETE BBS WHERE SEQ=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, commentSeq);	
		
		int af= st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}
	
	@Override
	public List<Comment> getComments(int page, String field)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM COMMENTS WHERE NUM = ? ORDER BY REGDATE DESC";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, Integer.parseInt(field));

		ResultSet rs = st.executeQuery();

		List<Comment> list = new ArrayList<Comment>();

		while (rs.next()) {
			Comment c = new Comment();

			c.setContents(rs.getString("contents"));
			c.setRegdate(rs.getString("regdate"));
			c.setWriter(rs.getString("writer"));

			list.add(c);
		}

		return list;
	}
	
	public int compose(Comment c) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO COMMENTS(SEQ, NUM, WRITER, CONTENTS, REGDATE) VALUES(?, ?, ?, ?, SYSDATE)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl", "sist_leather",
				"!leather1234");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, c.getSeq());
		st.setInt(2, c.getNum());
		st.setString(3, c.getWriter());
		st.setString(4, c.getContents());
		
		int af = st.executeUpdate();

		st.close();
		con.close();

		return af;
	}
	
	public int delete(int seq) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM COMMENTS WHERE SEQ = ?";

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

}
