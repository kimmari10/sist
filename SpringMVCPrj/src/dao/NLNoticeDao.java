package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Notice;

public class NLNoticeDao implements NoticeDao {

	@Override
	public Notice getNotice(String seq) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM NOTICES WHERE SEQ=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, seq);

		ResultSet rs = st.executeQuery();
		rs.next();
		// 모델변수 추가 ------------------
		Notice n = new Notice();
		n.setSeq(seq);
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));

		rs.close();
		st.close();
		con.close();
		
		return n;
	}

	@Override
	public int insert(Notice n) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT) "+ 
				"VALUES(?,?,?,'newlec',SYSDATE,0)";

		String sqlSeq = "SELECT MAX(TO_NUMBER(SEQ))+1 SEQ FROM NOTICES";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");

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
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, seq);

		int af = st.executeUpdate();

		st.close();
		con.close();
		
		return af;
	}

	@Override
	public List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		int snum = 1 + (page-1)*15;
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.*  FROM (SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N )	WHERE NUM BETWEEN ? AND ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, query);
		st.setInt(2, snum);
		st.setInt(3,	snum+14);
		
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next())
		{
			Notice n = new Notice();
			n.setSeq(rs.getString("seq"));
			n.setContent(rs.getString("content"));
			n.setFile(rs.getString("file"));
			n.setHit(rs.getInt("hit"));
			n.setRegdate(rs.getDate("regdate"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));	
			
			list.add(n);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public int getTotalCount() throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT COUNT(SEQ) CNT FROM NOTICES";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		int cnt = 0;
		
		if(rs.next())
			cnt = rs.getInt("CNT");
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;
	}

}
