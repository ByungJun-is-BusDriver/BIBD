import java.sql.*;

public class JoinDAO {
	
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

	public boolean selectUser(String user_id) {
		connectDB();
		sql = "select * from user where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			rsNext = rs.next();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return rsNext;
	}
	
	public boolean insertUser(String user_id, String user_pw, String user_name, String user_birth, String user_sex) {
		connectDB();
		sql = "insert into user(user_id, user_pw, user_name, user_birth, user_sex) values(?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			pstmt.setString(3, user_name);
			pstmt.setString(4, user_birth);
			pstmt.setString(5, user_sex);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return row != 0 ? true : false;
	}
	
}
