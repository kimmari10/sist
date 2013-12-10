package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.BBS;

public interface BBSDao {
	public List<BBS> getBBSList(int page, String category, String field ,String query) throws SQLException, ClassNotFoundException;
	public int getTotalCount() throws ClassNotFoundException, SQLException;
	public int getNewBBSCount() throws ClassNotFoundException, SQLException;
	public BBS getBBS(String seq) throws ClassNotFoundException, SQLException; //글 가져오기
	public int insert(BBS b) throws ClassNotFoundException, SQLException; //글 작성
	public int modify(BBS b, String seq) throws ClassNotFoundException, SQLException; //글 수정
	public int delete(String seq) throws ClassNotFoundException, SQLException; //글 삭제
	public BBS getBBSLast3(String writer) throws ClassNotFoundException, SQLException; //글쓴이의 다른 최신 글 3개 보여주기
	public List<BBS> getEachBestCategory() throws ClassNotFoundException, SQLException;
}
