package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Comment;

public interface CommentDao {

	public List<Comment> getComments(String seq) throws ClassNotFoundException, SQLException; //��� �����ֱ�
	public int commentInsert(Comment c) throws ClassNotFoundException, SQLException; //��� �ۼ�
	public int commentInsert(Comment c, String commentSeq) throws ClassNotFoundException, SQLException; //����� ����ۼ�
	public int commentModify(Comment c, String commentSeq) throws ClassNotFoundException, SQLException; //��� ����
	public int commentDelete(String commentSeq) throws ClassNotFoundException, SQLException; //��� ����
	
	public List<Comment> getComments(int page, String field) throws SQLException, ClassNotFoundException;//���
	public int compose(Comment c) throws ClassNotFoundException, SQLException;
	public int delete(int seq) throws ClassNotFoundException, SQLException;
}
