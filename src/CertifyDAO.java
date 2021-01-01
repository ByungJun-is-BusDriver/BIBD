
import java.sql.*;

public class CertifyDAO {
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

	public boolean updateUserLover(String lover_id, String user_id) {
		connectDB();
		sql = "update user set lover_id = ? where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lover_id);
			pstmt.setString(2, user_id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return row != 0 ? true : false;
	}

	public boolean selectUserLover(String lover_id, String user_id) {
		connectDB();
		sql = "select * from user where user_id = ? and lover_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lover_id);
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

	public boolean insertCouple(String user_id, String lover_id) {
		connectDB();
		String male_id = null;
		String female_id = null;
		sql = "select user_sex from user where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			rs.next();
			if (rs.getString(1).equals("³²")) {
				male_id = new String(user_id);
				female_id = new String(lover_id);
			} else {
				male_id = new String(lover_id);
				female_id = new String(user_id);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sql = "insert into couple(male_id, female_id) values(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, male_id);
			pstmt.setString(2, female_id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return row != 0 ? true : false;
	}

}
