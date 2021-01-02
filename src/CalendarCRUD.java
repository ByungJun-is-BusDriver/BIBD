
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class CalendarCRUD extends JFrame {

	CalendarController c;
	CalendarView v;
	JButton btnInsert,btnDelete;
	JTextField txtMemo;
	JLabel lblday;
	JTextArea ta;
	Calendar today;
	private btnListener BL;
	
	
	CalendarCRUD(CalendarController c){
		this.c = c;
		
		BL = new btnListener();
		
		setLayout(null);
		lblday = new JLabel("★"+c.year+"년"+c.month+"월"+c.day+"일 일정 생성 및 삭제★");
		lblday.setBounds(60,50,400,20);
		lblday.setFont(new Font("맑은 고딕",Font.BOLD,20));
		add(lblday);
		
		ta = new JTextArea("일정 List");
		ta.setBounds(50,100,380,300);
		add(ta);
		
		txtMemo = new JTextField(100);
		txtMemo.setBounds(50,450,380,20);
		add(txtMemo);
		
		btnInsert = new JButton("입력");
		btnDelete = new JButton("삭제");
		btnInsert.setBounds(100,500,100,30);
		btnDelete.setBounds(300,500,100,30);
		btnInsert.addActionListener(BL);
		btnDelete.addActionListener(BL);
		add(btnInsert);
		add(btnDelete);
		
		setSize(500,600);
		setVisible(true);
		
		
	}
	  private class btnListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==btnInsert) {
				String sql = "insert into calendar (memo,year,month,day,user_id,lover_id) values ("
						+"'"+txtMemo.getText()+"','"+c.year+"','"+c.month+"','"+c.day+"','"+
						LoginInfo.get().getID()+"','"+LoginInfo.get().getLoveid()+"');";
				System.out.println(sql);
				try {
					c.stmt.executeUpdate(sql);
				}catch(Exception ex) {System.out.println("insert 오류 :"+e); }
				
				
				c.showTable();
				
				
				
			}
			if(obj==btnDelete) {
				String sql = "delete from calendar where year="+c.year+" and month="
						+c.month+" and day="+c.day+" and memo=\""+txtMemo.getText()+"\";";
				System.out.println(sql);
				try {
					c.stmt.executeUpdate(sql);
					
				}catch(Exception ex ) { System.out.println("delete 오류 : "+e); }
				
				c.showTable();
			}
			
		}
		
	
		}
	
	
}
