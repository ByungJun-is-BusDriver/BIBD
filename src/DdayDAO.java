import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class DdayDAO {

	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	//String jdbcServer = "com.microsoft.sqlerver.jdbc.SQLServerDriver";
	String jdbcUrl = "jdbc:mysql://bibd.cw1fnax2ura3.ap-northeast-2.rds.amazonaws.com/couple_bus?&serverTimezone=Asia/Seoul&useSSL=false";
	Connection conn;
	String id="sodam";
	String pw="12341234";
	Statement stmt;
	LoginInfo LI;
	Calendar cal;
	
	DdayView v;
	
	
	DdayDAO(DdayView v){
		this.v = v;
		cal = null;
		conDB();
		showID();
		ShowDay();
		
	}
	
	 public void conDB() {
		 try {
		 Class.forName(jdbcDriver);
		 conn = DriverManager.getConnection(jdbcUrl,id,pw);
		 stmt = conn.createStatement();
		 }catch(Exception e) { e.printStackTrace(); }
	 }
	 
	 public void showID() {
		 v.lblNameField.setText(LoginInfo.get().getID()+"님 ♥ "+LoginInfo.get().getLoveid()+"님");
	 }
	 
	 public void ShowDay() {
		 cal=Calendar.getInstance();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = null;
		 v.lbl1.setText("처음 만난 날: "+LoginInfo.get().getFirst_day());
		
		 
		 
		cal.setTime(LoginInfo.get().getFirst_day());
		cal.add(Calendar.DATE, 100);
		v.lbl100.setText("100일 :"+df.format(cal.getTime()));
		cal.add(Calendar.DATE, 200);
		v.lbl300.setText("300일 :"+df.format(cal.getTime()));
		cal.add(Calendar.DATE,65);
		v.lblyear.setText("1년 : "+df.format(cal.getTime()));
		cal.add(Calendar.DATE, 135);
		v.lbl500.setText("500일 : "+df.format(cal.getTime()));
		cal.add(Calendar.DATE, 230);
		v.lbl2year.setText("2년 : "+df.format(cal.getTime()));
		
		
	 }
	 
}
