package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {
	public Connector(){}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://bibd.cw1fnax2ura3.ap-northeast-2.rds.amazonaws.com",
					"sodam", "12341234");

		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
		return con;
	}
	
	public String getDatas(String query) throws SQLException {
		Connection con = getConnection();
		java.sql.Statement st = null;
		ResultSet rs = null;
		
		st = con.createStatement();
		rs = st.executeQuery(query);

		if (st.execute(query)) {
			rs = st.getResultSet();
		}
		String str = null;
		
		while (rs.next()) {
			str = rs.getString("user_name");
			System.out.println(str);
		}
		
		return str;
	}
}
