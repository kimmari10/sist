package com.gongbang.dao;

import java.sql.SQLException;
import java.util.List;

import com.gongbang.vo.Picture;

public interface PictureDao {
	public List<Picture> getPictureList(String seq) throws ClassNotFoundException, SQLException;
	public List<Picture> getFirstImgList() throws ClassNotFoundException, SQLException;
}
