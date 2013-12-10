package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.*;

public interface QnADao {
	public List<QNA> getQNAS(int page, String field, String query) throws ClassNotFoundException,SQLException;
	public QNA getQNA(String seq) throws ClassNotFoundException,SQLException;
	public int insert (QNA q) throws ClassNotFoundException,SQLException;
	public int delete (String seq) throws ClassNotFoundException,SQLException;
	public int update (String seq, QNA q) throws ClassNotFoundException,SQLException;
	public int qnareply (QNA q) throws ClassNotFoundException, SQLException;
	public int getNewQNACount() throws ClassNotFoundException, SQLException;
}
