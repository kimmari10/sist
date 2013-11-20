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

public class NLNoticeDao implements NoticeDao{
	
	public Notice getNotice(String seq) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM NOTICES WHERE SEQ =?";

		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, seq);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		
		// 모델변수추가 (모델1)
		Notice n = new Notice();
		
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getString("regdate"));
		n.setHit(rs.getInt("hit"));
		
		rs.close();
		st.close();
		con.close();
		
		
		return n;
	}

	public int insert(Notice n) throws SQLException, ClassNotFoundException {
		
		
		String sql = "INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT)" + 
				" VALUES(?, ?, ?, 'JJONG', SYSDATE, 0) ";

		String sqlSeq = "SELECT MAX(TO_NUMBER(SEQ))+1 SEQ  FROM NOTICES";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		
		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sqlSeq);
		
		String seq = "1";  // seq가 검색되지 않을경우(게시글이 없을경우) 게시번호 값을 1로 세팅
		if(rsSeq.next()) //게시글이 있을경우 sql 값을 seq에 저장
			seq = rsSeq.getString("seq"); //sqlSeq의 SEQ컬럼을 넣음
	
		rsSeq.close();
		stSeq.close();
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, seq); // 1번째 '?'에 값 넣음
		st.setString(2, n.getTitle()); // 2번째에도
		st.setString(3, n.getContent()); // 3번째에도
		
		int af= st.executeUpdate(); //INSERT 쿼리 전용
		
		st.close();
		con.close();
		
		return af;
	}

	public int delete(String seq) throws SQLException, ClassNotFoundException {
		
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
	public List<Notice> getNotices(int page) throws SQLException, ClassNotFoundException 
	
	{
		int snum= 1+(page-1)*15;

		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICES ORDER BY REGDATE DESC) N)WHERE NUM BETWEEN ? AND ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, snum);
		st.setInt(2, snum+14);
		
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next())
		{
			Notice n = new Notice();
			
			n.setSeq(rs.getString("seq"));
			n.setContent(rs.getString("content"));
			n.setHit(rs.getInt("hit"));
			n.setRegdate(rs.getString("regdate"));
			n.setWriter(rs.getString("writer"));
			n.setTitle(rs.getString("title"));
					
			list.add(n);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public int getTotalCount() throws SQLException, ClassNotFoundException {
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
	};

}
