
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
		lblday = new JLabel("��"+c.year+"��"+c.month+"��"+c.day+"�� ���� ���� �� ������");
		lblday.setBounds(60,50,400,20);
		lblday.setFont(new Font("���� ���",Font.BOLD,20));
		add(lblday);
		
		ta = new JTextArea("���� List");
		ta.setBounds(50,100,380,300);
		add(ta);
		
		txtMemo = new JTextField(100);
		txtMemo.setBounds(50,450,380,20);
		add(txtMemo);
		
		btnInsert = new JButton("�Է�");
		btnDelete = new JButton("����");
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
				}catch(Exception ex) {System.out.println("insert ���� :"+e); }
				
				
				c.showTable();
				
				
				
			}
			if(obj==btnDelete) {
				String sql = "delete from calendar where year="+c.year+" and month="
						+c.month+" and day="+c.day+" and memo=\""+txtMemo.getText()+"\";";
				System.out.println(sql);
				try {
					c.stmt.executeUpdate(sql);
					
				}catch(Exception ex ) { System.out.println("delete ���� : "+e); }
				
				c.showTable();
			}
			
		}
		
	
		}
	
	
}
