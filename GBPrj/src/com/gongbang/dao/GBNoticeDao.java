package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.Notice;

public class GBNoticeDao implements NoticeDao{

	@Override
	public List<Notice> getNotices(int page, String field, String query)
			throws ClassNotFoundException, SQLException {
		int snum = 1+(page-1)*10;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.*FROM(SELECT *FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N) WHERE NUM BETWEEN ? AND ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, query);
		st.setInt(2, snum);
		st.setInt(3, snum+9);
		
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next())
		{
			Notice n = new Notice();
			n.setSeq(rs.getString("seq"));
			n.setWriter(rs.getString("writer"));
			n.setTitle(rs.getString("title"));
			n.setRegdate(rs.getString("redate"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));
			/*n.setFile(rs.getString("file"));*/
			list.add(n);
		}
		
		rs.close();
		st.close();
		con.close();
		return list;
	}

	@Override
	public Notice getNotice(String seq) throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT *FROM NOTICES WHERE SEQ=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,seq);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setRegdate(rs.getString("regdate"));
		n.setHit(rs.getInt("hit"));
		n.setContent(rs.getString("content"));
		/*n.setFile(rs.getString("file"));*/
		
		rs.close();
		st.close();
		con.close();
		
		return n;
	}

	@Override
	public int insert(Notice n) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT )VALUES(?,?,?,'Admin',SYSDATE,0)";
		String sqlSeq = "SELECT MAX(TO_NUMBER(SEQ))+1 SEQ FROM NOTICES";
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
		st.setString(2, n.getTitle());
		st.setString(3, n.getContent());
		
		int af = st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}

	@Override
	public int delete(String seq) throws ClassNotFoundException, SQLException {
		String sql = "DELETE NOTICES WHERE SEQ=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, seq);
		
		
		int af= st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}

	/*@Override
	public int getTotalCount() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT COUNT(SEQ) CNT FROM NOTICES";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		int cnt = 0;
		
		if(rs.next())
			cnt = rs.getInt("CNT");

		rs.close();
		st.close();
		con.close();
		
		return cnt;
	}*/

	@Override
	public int update(String seq, Notice n) throws ClassNotFoundException,SQLException {
			String sql = "UPDATE NOTICES SET TITLE=?, CONTENT=? WHERE SEQ=?";
					
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@pub.newlecture.com:1521:orcl","sist_leather","!leather1234");
			
			PreparedStatement  st = con.prepareStatement(sql);
			
			st.setString(1, n.getTitle());
			st.setString(2, n.getContent());
			st.setString(3, n.getSeq());
			
			int af = st.executeUpdate();
			
			st.close();
			con.close();
			
			
			return af;
		}
}
