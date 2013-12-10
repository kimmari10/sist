package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.QNA;

public class GBQnADao implements QnADao{

	@Override
	public List<QNA> getQNAS(int page, String field, String query)
			throws ClassNotFoundException, SQLException {
		int snum = 1+(page-1)*10;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.*FROM(SELECT *FROM QNAS WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N) WHERE NUM BETWEEN ? AND ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, query);
		st.setInt(2,snum);
		st.setInt(3,snum+9);
		
		ResultSet rs = st.executeQuery();
		
		List<QNA> list = new ArrayList<QNA>();
		
		while(rs.next())
		{
			QNA q = new QNA();
			q.setSeq(rs.getString("seq"));
			q.setTitle(rs.getString("title"));
			q.setWriter(rs.getString("writer"));
			q.setRegdate(rs.getString("regdate"));
			q.setContent(rs.getString("content"));
			list.add(q);
		}
		
		rs.close();
		st.close();
		con.close();
		return list;
	}

	@Override
	public QNA getQNA(String seq) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT *FROM QNAS WHERE SEQ=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, seq);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		QNA q = new QNA();
		q.setSeq(rs.getString("seq"));
		q.setTitle(rs.getString("title"));
		q.setWriter(rs.getString("writer"));
		q.setRegdate(rs.getString("regdate"));
		q.setContent(rs.getString("content"));
		
		rs.close();
		st.close();
		con.close();
		
		return q;
	}

	@Override
	public int insert(QNA q) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO QNAS(SEQ, TITLE, CONTENT, WRITER, REGDATE)VALUES(?,?,?,?,SYSDATE,0)";
		String sqlSeq = "SELECT MAX(TO_NUMBER(SEQ))+1 SEQ FROM QNAS";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sqlSeq);
		
		String seq = "1";
		
		if(rsSeq.next())
			seq = rsSeq.getString("seq");
		
		rsSeq.close();
		stSeq.close();
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, seq);
		st.setString(2, q.getTitle());
		st.setString(3, q.getWriter());
		st.setString(4, q.getContent());
		
		int qa = st.executeUpdate();
		
		st.close();
		con.close();
		
		return qa;
	}

	@Override
	public int delete(String seq) throws ClassNotFoundException, SQLException {
		String sql = "DELETE NOTICES WHERE SEQ=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, seq);
		
		
		int qa= st.executeUpdate();
		
		st.close();
		con.close();
		
		return qa;
	}

	@Override
	public int update(String seq, QNA q) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE QNAS SET TITLE=?, WRITER=?,CONTENT=? WHERE SEQ=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, q.getTitle());
		st.setString(2, q.getWriter());
		st.setString(3, q.getContent());
		st.setString(4, q.getSeq());
		
		int qa = st.executeUpdate();
		
		st.close();
		con.close();
		
		return qa;
	}

	@Override
	public int qnareply(QNA q) throws ClassNotFoundException,SQLException {
		String sql = "INSERT INTO QNAS(RE_WRITER, RE_CONTENT, RE_REGDATE)VALUES(Admin,?,SYSDATE)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		

		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, q.getRecontent());
		
		int qr = st.executeUpdate();
		
		st.close();
		con.close();
		return qr;
	}

	@Override
	public int getNewQNACount() throws ClassNotFoundException, SQLException {
		String newqna = "SELECT COUNT(REGDATE) NQ FROM QNAS WHERE SUBSTR(SYSDATE,1,10)=REGDATE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(newqna);
		
		int nq = 0;
		
		if(rs.next())
			nq = rs.getInt("NQ");

		rs.close();
		st.close();
		con.close();
		
		return nq;
	}
}
