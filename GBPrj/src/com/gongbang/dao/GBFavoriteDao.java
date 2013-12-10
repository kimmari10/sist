package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.Favorite;

public class GBFavoriteDao implements FavoriteDao{


	public List<Favorite> getFavoriteList(String id, String category, int page) throws SQLException, ClassNotFoundException 
	{
		int snum= 1+(page-1)*8;
		
		//∆‰¿Ã¡ˆ ƒı∏Æ
		String sql = "SELECT * FROM(SELECT ROWNUM NUM, A.* FROM(SELECT * FROM FAVORITES WHERE TYPE = ? ORDER BY ROWNUM) A "
				+ "WHERE ROWNUM BETWEEN ? AND ?)WHERE BBS_WRITER = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather",
				"!leather1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,category);
		st.setInt(2, snum);
		st.setInt(3, snum+9);
		st.setString(4, id);
		
		ResultSet rs = st.executeQuery();
		
		List<Favorite> list = new ArrayList<Favorite>();
		
		while(rs.next())
		{
			Favorite f = new Favorite();
			
			f.setHit(rs.getInt("hit"));
			f.setRegdate(rs.getString("regdate"));
			f.setSeq(rs.getString("bbs_seq"));
			f.setType(rs.getString("type"));
			f.setWriter(rs.getString("bbs_writer"));
			
			list.add(f);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public int getTotalCount(String type) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT COUNT(BBS_SEQ) CNT FROM FAVORITES WHERE TYPE = '"+type+"'";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather",
				"!leather1234");
		
	
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
