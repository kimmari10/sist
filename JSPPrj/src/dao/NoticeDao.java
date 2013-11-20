package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Notice;

public interface NoticeDao {
	
	public List<Notice> getNotices(int page, String field, String query)throws SQLException, ClassNotFoundException;
	public Notice getNotice(String seq) throws SQLException, ClassNotFoundException;
	public int insert(Notice n) throws SQLException, ClassNotFoundException;
	public int delete(String seq) throws SQLException, ClassNotFoundException;
	public int getTotalCount() throws SQLException, ClassNotFoundException;

}
