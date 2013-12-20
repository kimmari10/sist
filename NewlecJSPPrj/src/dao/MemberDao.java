package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Member;

public interface MemberDao {

	public List<Member> getMembers(int pnum, String field, String query, String eday,
			String sday) throws ClassNotFoundException, SQLException;
	public boolean activity(String uid, boolean inActivity) throws ClassNotFoundException, SQLException;
	/*public boolean inactivity(String uid)throws ClassNotFoundException, SQLException;*/
	public boolean leave(String uid)throws ClassNotFoundException, SQLException;
	public boolean roleChange(String uid,String role)throws ClassNotFoundException, SQLException;
	

	
}
