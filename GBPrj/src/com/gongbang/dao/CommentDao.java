package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Comment;

public interface CommentDao {

	public List<Comment> getComments(String seq) throws ClassNotFoundException, SQLException; //¥Ò±€ ∫∏ø©¡÷±‚
	public int commentInsert(Comment c) throws ClassNotFoundException, SQLException; //¥Ò±€ ¿€º∫
	public int commentInsert(Comment c, String commentSeq) throws ClassNotFoundException, SQLException; //¥Ò±€¿« ¥Ò±€¿€º∫
	public int commentModify(Comment c, String commentSeq) throws ClassNotFoundException, SQLException; //¥Ò±€ ºˆ¡§
	public int commentDelete(String commentSeq) throws ClassNotFoundException, SQLException; //¥Ò±€ ªË¡¶
	
	public List<Comment> getComments(int page, String field) throws SQLException, ClassNotFoundException;//¥Ò±€
	public int compose(Comment c) throws ClassNotFoundException, SQLException;
	public int delete(int seq) throws ClassNotFoundException, SQLException;
}
