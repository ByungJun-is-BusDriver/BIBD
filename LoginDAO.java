import java.sql.*;

public class LoginDAO {
	
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://bibd.cw1fnax2ura3.ap-northeast-2.rds.amazonaws.com:3306/couple_bus";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	boolean rsNext;
	int row;
	String sql;

	public void connectDB() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "sodam", "12341234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDB() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean selectUser(String user_id, String user_pw) {
		connectDB();
		sql = "select * from user where user_id = ? and user_pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs = pstmt.executeQuery();
			rsNext = rs.next();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return rsNext;
	}
	
}
