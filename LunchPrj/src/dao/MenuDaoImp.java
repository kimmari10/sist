package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Menu;

public class MenuDaoImp implements MenuDao{

	public boolean add (String item, String shop, String price) throws SQLException, ClassNotFoundException {
		
		String sql = "INSERT INTO MENUS VALUES(?, ?, ?)";

		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, item);
		st.setString(2, shop);
		st.setString(3, price);
		int a = st.executeUpdate();
		
		if(a>0)
			return true;
		return false;
	}

	public boolean delete() {
		
		return false;
	}

	public List<Menu> getMenus() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM MENUS";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@pub.newlecture.com:1521:orcl",
				"HR",
				"11111");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
			
		List<Menu> list = new ArrayList();
		while(rs.next())
		{
			Menu m =new Menu();
			m.setItem(rs.getString("item"));
			m.setShop(rs.getString("shop"));
			m.setPrice(rs.getString("price"));
			
			list.add(m);
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		return list;
	}

}
