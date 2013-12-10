package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.BBS;

public class GBBBSDao implements BBSDao {

	@Override
	public List<BBS> getBBSList(int page, String category, String field,
			String query) throws SQLException, ClassNotFoundException {

		/*
		 * String category = "%%"; //콘트롤러에서 해야할 부분 String field = "TITLE";
		 * String query = "%%";
		 * 
		 * if (c != null) category = c;
		 * 
		 * if (f != null) field = f;
		 * 
		 * if (q != null) query = "%" + q + "%";
		 */

		int snum = (page - 1) * 12 + 1;

		String sql = "SELECT * 	FROM (SELECT ROWNUM NUM, N.* FROM "
				+ "(SELECT * FROM (SELECT * FROM BBS WHERE CATENUM LIKE ?) N "
				+ "WHERE "
				+ field
				+ " LIKE ? ORDER BY REGDATE DESC) N ) WHERE NUM BETWEEN ? AND ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, category);
		st.setString(2, query);
		st.setInt(3, snum);
		st.setInt(4, snum + 11);

		ResultSet rs = st.executeQuery();

		List<BBS> list = new ArrayList<BBS>();

		while (rs.next()) {
			BBS b = new BBS();
			b.setSeq(rs.getString("seq"));
			b.setTitle(rs.getString("title"));
			b.setContent(rs.getString("content"));
			b.setSell(rs.getInt("sell"));
			b.setWriter(rs.getString("writer"));
			b.setRegdate(rs.getString("regdate"));
			b.setHit(rs.getInt("hit"));
			b.setCatenum(rs.getString("catenum"));
			// picture 가 없음

			list.add(b);
		}

		rs.close();
		st.close();
		con.close();
		return list;
	}

	@Override
	public int getTotalCount() throws ClassNotFoundException, SQLException {
		String sql = "SELECT COUNT(SEQ) CNT FROM BBS";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sql);

		int count = 0;

		if (rsSeq.next())
			count = rsSeq.getInt("CNT");

		rsSeq.close();
		stSeq.close();
		con.close();

		return count;
	}

	@Override
	public int getNewBBSCount() throws ClassNotFoundException, SQLException {

		String newbbs = "SELECT COUNT(REGDATE) NB FROM BBS WHERE SUBSTR(SYSDATE,1,10)=REGDATE";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(newbbs);

		int nb = 0;

		if (rs.next())
			nb = rs.getInt("NB");

		rs.close();
		st.close();
		con.close();

		return nb;
	}

	@Override
	public BBS getBBS(String seq) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM BBS WHERE SEQ=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		Statement st = con.createStatement();
		// st.setString(1, seq);
		ResultSet rs = st.executeQuery(sql);
		rs.next();

		// 모델 변수 추가--------------
		BBS b = new BBS();
		b.setSeq(rs.getString("seq"));
		b.setTitle(rs.getString("title"));
		b.setCatenum(rs.getString("catenum"));
		b.setSell(rs.getInt("sell"));
		b.setWriter(rs.getString("writer"));
		b.setContent(rs.getString("content"));
		b.setRegdate(rs.getString("regdate"));
		b.setHit(rs.getInt("hit"));

		rs.close();
		st.close();
		con.close();

		return b;
	}

	@Override
	public int insert(BBS b) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO BBS(SEQ, CATENUM, TITLE, SELL, WRITER, CONTENT, REGDATE, HIT) VALUES(?,?,?,?,?,?,SYSDATE,0)";
		String sqlSeq = "SELECT MAX(TO_NUMBER(SEQ))+1 SEQ FROM BBS";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		Statement stSeq = con.createStatement();
		ResultSet rsSeq = stSeq.executeQuery(sqlSeq);

		String seq = "1";

		if (rsSeq.next())
			seq = rsSeq.getString("seq");

		rsSeq.close();
		stSeq.close();

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, seq);
		st.setString(2, b.getCatenum());
		st.setString(3, b.getTitle());
		st.setInt(4, b.getSell());
		st.setString(5, b.getWriter());
		st.setString(6, b.getContent());

		int af = st.executeUpdate();

		st.close();
		con.close();

		return af;
	}

	@Override
	public int modify(BBS b, String seq) throws ClassNotFoundException,
			SQLException {

		String sql = "UPDATE BBS SET TITLE='?', WRITER='?', SELL=?, CONTENT='?', REGDATE=SYSDATE WHERE SEQ='?' ";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		PreparedStatement stSeq = con.prepareStatement(sql);
		ResultSet rsSeq = stSeq.executeQuery();

		if (rsSeq.next())
			seq = rsSeq.getString("seq");

		PreparedStatement st = con.prepareStatement(sql);

		rsSeq.close();
		stSeq.close();

		/* st.setString(1,seq); */
		st.setString(1, b.getTitle());
		st.setInt(2, b.getSell());
		st.setString(3, b.getWriter());
		st.setString(4, b.getContent());

		int af = st.executeUpdate();

		st.close();
		con.close();

		return af;
	}

	@Override
	public int delete(String seq) throws ClassNotFoundException, SQLException {

		String sql = "DELETE BBS WHERE SEQ=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, seq);

		int af = st.executeUpdate();

		st.close();
		con.close();

		return af;
	}

	@Override
	public BBS getBBSLast3(String writer) throws ClassNotFoundException,
			SQLException {

		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N. * FROM (SELECT * FROM BBS WHERE WRITER LIKE ? ORDER BY REGDATE DESC) N) WHERE NUM BETWEEN 1 AND 3";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		rs.next();

		// 모델 변수 추가--------------
		BBS b = new BBS();
		b.setTitle(rs.getString("title"));
		b.setWriter(rs.getString("writer"));
		b.setSell(rs.getInt("sell"));

		rs.close();
		st.close();
		con.close();

		return b;
	}

	public List<BBS> getEachBestCategory() throws ClassNotFoundException,
			SQLException {

		String sql = "SELECT * FROM(SELECT MAX(HIT) M FROM BBS GROUP BY CATENUM)A INNER JOIN BBS B ON A.M = B.HIT ORDER BY B.CATENUM";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		List<BBS> list = new ArrayList<BBS>();

		while (rs.next()) {
			BBS b = new BBS();

			b.setCatenum(rs.getString("catenum"));
			b.setContent(rs.getString("content"));
			b.setHit(rs.getInt("hit"));
			b.setRegdate(rs.getString("regdate"));
			b.setSell(rs.getInt("sell"));
			b.setSeq(rs.getString("seq"));
			b.setTitle(rs.getString("title"));
			b.setWriter(rs.getString("writer"));

			list.add(b);

		}

		rs.close();
		st.close();
		con.close();

		return list;

	}
}
