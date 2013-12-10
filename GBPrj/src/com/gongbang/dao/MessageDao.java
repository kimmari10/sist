package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Message;


public interface MessageDao {
	
	public int composeMessage(Message m) throws ClassNotFoundException, SQLException;//메시지 작성
	public int deleteMessage(int seq) throws ClassNotFoundException, SQLException;//메시지 삭제
	public List<Message> getRecvMessages(int page, String field, String target) throws SQLException, ClassNotFoundException;//받은 메시지 긁어오기
	public List<Message> getSendMessages(int page, String field, String target) throws ClassNotFoundException, SQLException;//보낸메시지 긁어오기
	public List<Message> getMessages(int page) throws SQLException, ClassNotFoundException;//전체메시지 긁어오기
	public int getNewMsgCount() throws ClassNotFoundException, SQLException;
}
