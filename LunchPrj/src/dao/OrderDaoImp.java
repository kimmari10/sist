package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Order;

public class OrderDaoImp implements OrderDao{

	public boolean order(String name, String menu) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO ORDERS VALUES(?, SYSDATE, ?)";

		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, name);
		st.setString(2, menu);
		int a = st.executeUpdate();
		
		st.close();
		con.close();
		
		if(a>0)
			return true;
		
		return false;
	}

	public List<Order> getOrders() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM ORDERS";

		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
			
		List<Order> list = new ArrayList();
		while(rs.next())
		{
			Order o = new Order();
			o.setName(rs.getString("name"));
			o.setOrderday(rs.getString("orderday"));
			o.setOrdermenu(rs.getString("ordermenu"));
			
			list.add(o);
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		return list;
	}

}
