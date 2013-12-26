package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Order;

public interface OrderDao {
	
	public boolean order(String name, String menu) throws ClassNotFoundException, SQLException;
	public List<Order> getOrders() throws SQLException, ClassNotFoundException;

}
