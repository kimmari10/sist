package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Menu;

public interface MenuDao {

	public boolean add(String item, String shop, String price) throws SQLException, ClassNotFoundException;
	public boolean delete();
	public List<Menu> getMenus() throws SQLException, ClassNotFoundException;
	
	
}
