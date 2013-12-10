package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Notice;


public interface NoticeDao {
	public List <Notice> getNotices(int page, String field, String query) throws ClassNotFoundException,SQLException;
	public Notice getNotice(String seq) throws ClassNotFoundException,SQLException;
	public int insert (Notice n) throws ClassNotFoundException,SQLException;
	public int delete (String seq) throws ClassNotFoundException,SQLException;
	/*public int getTotalCount () throws SQLException, ClassNotFoundException;*/
	int update(String seq, Notice n) throws ClassNotFoundException, SQLException;
}
