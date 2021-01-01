package TCP;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CalendarController {
	
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	//String jdbcServer = "com.microsoft.sqlerver.jdbc.SQLServerDriver";
	String jdbcUrl = "jdbc:mysql://bibd.cw1fnax2ura3.ap-northeast-2.rds.amazonaws.com/couple_bus?&serverTimezone=Asia/Seoul&useSSL=false";
	Connection conn;
	String id="sodam";
	String pw="12341234";
	CalendarController c=this;
	 int year ,month,day,todays,memoday=0;
	 int realday;
	Calendar cal;
	Calendar today;
	Statement stmt;
	ResultSet rs;
	String [] days = {"일","월","화","수","목","금","토"};
	

	
	
	 CalendarView v;
	public CalendarController(CalendarView v) {
		this.v=v;
		today = Calendar.getInstance();
    	year = today.get(Calendar.YEAR);
    	month = today.get(Calendar.MONTH)+1;
		realday = today.get(Calendar.DATE);
		cal = new GregorianCalendar();
		conDB();
		gridInit();
		v.ta.setText("");
		showTable();
		hidebtn();
		
		v.addButtonActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj==v.btnBefore) {
					v.centerPanel.removeAll();
					calInput(-1);
					gridInit();
					GridLayout gridLayout1 = new GridLayout(7,7);
					v.centerPanel.setLayout(gridLayout1);
					showTable();
					hidebtn();
					v.lblYear.setText(year+" 년 ");
					v.lblMonth.setText(month+" 월 ");
					
				}
				else if(obj==v.btnAfter) {
					v.centerPanel.removeAll();
					calInput(1);
					gridInit();
					GridLayout gridLayout1 = new GridLayout(7,7);
					v.centerPanel.setLayout(gridLayout1);
					showTable();
					hidebtn();
					v.lblYear.setText(year+" 년 ");
					v.lblMonth.setText(month+" 월 ");
				}
				
				else if(obj==v.btnBefore2) {
					v.centerPanel.removeAll();
					calInput(-2);
					gridInit();
					GridLayout gridLayout1 = new GridLayout(7,7);
					v.centerPanel.setLayout(gridLayout1);
					showTable();
					hidebtn();
					v.lblYear.setText(year+" 년 ");
					v.lblMonth.setText(month+" 월 ");
				}
				else if(obj==v.btnAfter2) {
					v.centerPanel.removeAll();
					calInput(2);
					gridInit();
					GridLayout gridLayout1 = new GridLayout(7,7);
					v.centerPanel.setLayout(gridLayout1);
					showTable();
					hidebtn();
					v.lblYear.setText(year+" 년 ");
					v.lblMonth.setText(month+" 월 ");
				}
				else if(Integer.parseInt(e.getActionCommand())>=1
						&&Integer.parseInt(e.getActionCommand()) <=31) {
					day = Integer.parseInt(e.getActionCommand());
					 new CalendarCRUD(c);
				}
				//else if(obj==)
			}
		});
	}
	
	public void gridInit() {
		for(int i =0;i<days.length;i++) {
    		v.centerPanel.add(v.calBtn[i] = new JButton(days[i]));
    		v.calBtn[i].setBackground(Color.white);
    	}
    	for(int i = days.length;i<49;i++) {
    		v.centerPanel.add(v.calBtn[i]= new JButton(""));
    		
    	}
	}
	
	 public void showTable() {
	    	cal.set(Calendar.YEAR, year);
	    	cal.set(Calendar.MONTH, (month-1));
	    	cal.set(Calendar.DATE,1);
	    	int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);
	    	
	    	
	    	int j = 0;
	    	int hopping = 0;
	    	v.calBtn[0].setForeground(Color.RED);  
	    	v.calBtn[6].setForeground(Color.blue);
	    	
	    	
	    	
	    	for(int i=cal.getFirstDayOfWeek();i<dayofWeek;i++) {j++;}
	    	// 일요일부터 그달의 첫시작 요일까지 빈칸으로 셋팅하기 위해서 
	    	
	    	hopping = j;
	    	for(int i=0;i<hopping;i++) {
	    		v.calBtn[i+7].setText("");
	    	}
	    	v.ta.setText("");
	    	for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);
	    			i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++) {
	    		cal.set(Calendar.DATE, i);
	    		if(cal.get(Calendar.MONTH)!=month-1) {
	    			break;
	    		}
	    		v.calBtn[i+hopping+6].setBackground(Color.white);
	    		todays = i;
	    		checkday();
	    		if((cal.MONTH-1)==month&&realday==i) {
	    			v.calBtn[i+6+hopping].setBackground(Color.green);
	    		}
	    		if(memoday==1) {
	    			v.calBtn[i+6+hopping].setForeground(Color.pink);
	    			
	    		}
	    		else {
	    			v.calBtn[i+6+hopping].setForeground(Color.black);
	    			if((i+hopping-1)%7==0){
	    				v.calBtn[i+6+hopping].setForeground(Color.red);
	    			}
	    			if((i+hopping)%7==0) {
	    				v.calBtn[i+6+hopping].setForeground(Color.blue);
	    			}
	    		}
	    		v.calBtn[i+6+hopping].setText((i)+"");
	    		
	    	}
	    	
	    	
	    }
	 
	 public void checkday() {
		 String sql="select * from calendar where year="+year+
				 " and month="+month+" and day="+todays+";";
		 String gettemp;
		 try {
			 rs=stmt.executeQuery(sql);
			 if(rs.next()) {
				 
				 memoday =1;
				 gettemp=rs.getString("month")+"월\t"+rs.getString("day")+"일\t"+rs.getString("memo")+"\n";
				 v.ta.append(gettemp);
				 while(rs.next()) {
					 gettemp=rs.getString("month")+"월\t"+rs.getString("day")+"일\t"+rs.getString("memo")+"\n";
					 v.ta.append(gettemp);
					 
				 } 
			 }
			 else memoday = 0;
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void hidebtn() {
		 for(int i=0;i<v.calBtn.length;i++) {
			 if((v.calBtn[i].getText()).equals(""))
				 v.calBtn[i].setEnabled(false);
		 }
	 }
	 
	 
	 
	 public void conDB() {
		 try {
		 Class.forName(jdbcDriver);
		 conn = DriverManager.getConnection(jdbcUrl,id,pw);
		 stmt = conn.createStatement();
		 }catch(Exception e) { e.printStackTrace(); }
	 }
	 public void calInput(int data) {
		 if(data ==-1||data ==1) {
			 month +=(data);
			 if(month<=0) {
				 month = 12;
				 year--;
			 }
			 else if(month>12) {
				 month =1;
				 year++;
			 }
		 }
		 else if(data == 2) {year ++;}
		 else if(data ==-2 ) {year--;}
			 
	 }
	 
	 
	 
	 
	 
	 
	 
	 public static void main(String arg[]) {
	    	new CalendarController(new CalendarView());
	    	
	    }
}
