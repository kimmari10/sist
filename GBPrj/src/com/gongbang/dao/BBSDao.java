package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.BBS;

public interface BBSDao {
	public List<BBS> getBBSList(int page, String category, String field ,String query) throws SQLException, ClassNotFoundException;
	public int getTotalCount() throws ClassNotFoundException, SQLException;
	public int getNewBBSCount() throws ClassNotFoundException, SQLException;
	public BBS getBBS(String seq) throws ClassNotFoundException, SQLException; //�� ��������
	public int insert(BBS b) throws ClassNotFoundException, SQLException; //�� �ۼ�
	public int modify(BBS b, String seq) throws ClassNotFoundException, SQLException; //�� ����
	public int delete(String seq) throws ClassNotFoundException, SQLException; //�� ����
	public BBS getBBSLast3(String writer) throws ClassNotFoundException, SQLException; //�۾����� �ٸ� �ֽ� �� 3�� �����ֱ�
	public List<BBS> getEachBestCategory() throws ClassNotFoundException, SQLException;
}
