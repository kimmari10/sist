package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Message;


public interface MessageDao {
	
	public int composeMessage(Message m) throws ClassNotFoundException, SQLException;//�޽��� �ۼ�
	public int deleteMessage(int seq) throws ClassNotFoundException, SQLException;//�޽��� ����
	public List<Message> getRecvMessages(int page, String field, String target) throws SQLException, ClassNotFoundException;//���� �޽��� �ܾ����
	public List<Message> getSendMessages(int page, String field, String target) throws ClassNotFoundException, SQLException;//�����޽��� �ܾ����
	public List<Message> getMessages(int page) throws SQLException, ClassNotFoundException;//��ü�޽��� �ܾ����
	public int getNewMsgCount() throws ClassNotFoundException, SQLException;
}
