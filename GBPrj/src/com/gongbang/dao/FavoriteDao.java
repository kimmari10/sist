package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Favorite;


public interface FavoriteDao {

	public List<Favorite> getFavoriteList(String id, String category, int page) throws SQLException, ClassNotFoundException;
	
	public int getTotalCount(String type) throws SQLException, ClassNotFoundException;
	
}
