package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class NLMemberDao implements MemberDao {

	@Override
	public List<Member> getMembers(int pnum ,String field, String query ,String eday,String sday ) throws ClassNotFoundException, SQLException {

		int snum = 1 + (pnum - 1) * 15;
		
		String sql="SELECT * FROM" +
				"(" +
				"SELECT(ROW_NUMBER() OVER (ORDER BY REGDATE DESC)) NUM, " +
				"* FROM Members " +
				"WHERE "+field+" LIKE ? AND  REGDATE BETWEEN ? AND ?) M " +
				"WHERE M.NUM BETWEEN ? AND ?";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://pub.newlecture.com:1433;database=class6", "class6",
				"sist");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1,"%"+query+"%" );
		st.setString(2,sday );
		st.setString(3,eday );
		st.setInt(4,snum );
		st.setInt(5,snum+14 );

		ResultSet rs = st.executeQuery();
		
		//////////
		List<Member> list = new ArrayList();
		
		while(rs.next())
		{
			Member m = new Member();
			m.setUid(rs.getString("uid"));
			m.setAddress(rs.getString("address"));
			m.setName(rs.getString("name"));
			m.setPwd(rs.getString("pwd"));
			m.setNicName(rs.getString("nicName"));
			m.setPhoto(rs.getString("Photo"));
			m.setGender(rs.getString("gender"));
			m.setBirth(rs.getString("birth"));
			m.setIsLunar(rs.getInt("isLunar"));
			m.setCellPhone(rs.getString("cellPhone"));
			m.setPhone(rs.getString("phone"));
			m.setEmail(rs.getString("email"));
			m.setZipCode(rs.getString("zipCode"));
			m.setZipSeq(rs.getString("zipSeq"));
			m.setRegDate(rs.getDate("regDate"));
			m.setRegIP(rs.getString("regIP"));
			m.setRegEnv(rs.getString("regEnv"));
			m.setDefaultRole(rs.getString("defaultRole"));
			m.setPwdModifyKey(rs.getString("pwdModifyKey"));
			m.setRegAdmin(rs.getString("regAdmin"));
			m.setGuid(rs.getString("guid"));
			m.setInActivity(rs.getBoolean("inActivity"));
			m.setInActivityReason(rs.getString("inActivityReason"));
			m.setLoginIP(rs.getString("loginIP"));
			m.setLoginComputer(rs.getString("loginComputer"));
			m.setLoginTime(rs.getDate("loginTime"));
			m.setAnotherIP(rs.getString("anotherIP"));
			m.setAnotherComputer(rs.getString("anotherComputer"));
			m.setAnotherTime(rs.getDate("anotherTime"));
			m.setMultiLoginCnt(rs.getInt("multiLoginCnt"));
			
			list.add(m);
		}
	
		rs.close();
		st.close();
		con.close();
		
		
		return list;
	}

	@Override
	public boolean activity(String uid,boolean inActivity)throws ClassNotFoundException, SQLException {

		String sql = "UPDATE Members SET inactivity =? WHERE Uid=?";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://pub.newlecture.com:1433;database=class6", "class6",
				"sist");
		PreparedStatement st = con.prepareStatement(sql);

		st.setBoolean(1, inActivity);
		st.setString(2,uid );

		int result = st.executeUpdate();
		

		st.close();
		con.close();
		
		if(result >0)
			return true;
		
		return false;
	}
	
/*	@Override
	public boolean inactivity(String uid)throws ClassNotFoundException, SQLException {

		String sql = "UPDATE Members SET inactivity =1 WHERE Uid=?";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://pub.newlecture.com:1433;database=class6", "class6",
				"sist");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1,uid );


		
		int result = st.executeUpdate();
		

		st.close();
		con.close();
		
		if(result >0)
			return true;
		
		return false;
	}
	*/

	@Override
	public boolean leave(String id) {

		String sql = "DELETE FROM Members WHERE Uid=?";

		return false;
	}

	@Override
	public boolean roleChange(String id, String role) {

		String sql = "UPDATE Members SET DefaultRole=? WHERE Uid=?";
	
		return false;
	}




}
