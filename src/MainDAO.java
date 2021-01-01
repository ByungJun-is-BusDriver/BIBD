
import java.sql.*;

public class MainDAO {
	
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

	public boolean selectCouple(String user_id) {
		connectDB();
		sql = "select * from couple where male_id = ? or female_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_id);
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
