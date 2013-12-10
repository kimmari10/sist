package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.User;

public interface UserDao {
	public User getUser(String id) throws SQLException, ClassNotFoundException;
	public int registerUser(User n) throws SQLException, ClassNotFoundException;
	public int updateUser(User n) throws ClassNotFoundException, SQLException;
	public int deleteUser(User n) throws ClassNotFoundException, SQLException;
	public User findUserId(String mail) throws SQLException, ClassNotFoundException;
	public List<User> getUserList(int page, int type, String category, String query) throws ClassNotFoundException, SQLException;
	public int getNewUserCount() throws ClassNotFoundException, SQLException;
	public int getLeaveUserCount() throws ClassNotFoundException, SQLException;
	public int getTotalUserCount() throws ClassNotFoundException, SQLException;

}
