package com.gongbang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gongbang.vo.Picture;

public class GBPictureDao implements PictureDao {

	@Override
	public List<Picture> getPictureList(String bbs_seq) throws ClassNotFoundException, SQLException {
		
		//bbs_seq 가 게시물 번호, seq 는 사진번호로 별개임
		
		String sql = "SELECT * FROM PICTURES WHERE BBS_SEQ=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"sist_leather", "!leather1234");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bbs_seq);
		ResultSet rs = st.executeQuery();
		
		List<Picture> list = new ArrayList<Picture>();

		while (rs.next()) {
			Picture p = new Picture();
			p.setBbs_seq(bbs_seq);
			p.setPic_seq(rs.getString("pic_seq"));
			p.setPath(rs.getString("path"));
			
			list.add(p);
		}
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public List<Picture> getFirstImgList() throws ClassNotFoundException, SQLException
	{
		
			String sql = "SELECT BBS_SEQ, MIN(PIC_SEQ) SEQ FROM PICTURES GROUP BY BBS_SEQ";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
					"sist_leather",
					"!leather1234");
			Statement st = con.createStatement();
			
			
			ResultSet rs = st.executeQuery(sql);
			
			List<Picture> list = new ArrayList<Picture>();
			
			//그룹바이로 min(pic_seq)만 가져옴 아래는 잘못된거
			while(rs.next())
			{
				Picture p= new Picture();
				
				
				p.setBbs_seq(rs.getString("bbs_seq"));
				p.setPic_seq(rs.getString("seq"));
//				p.setPath(rs.getString("path"));
						
				list.add(p);
			}
			
			rs.close();
			st.close();
			con.close();
			
			return list;
		
	}
}
