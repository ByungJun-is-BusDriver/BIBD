package TCP;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.*;

public class CalendarCRUD extends JFrame {

	CalendarController cc;
	CalendarView v;
	JButton btnInsert,btnDelete;
	JTextField txtMemo;
	JLabel lblday;
	JTextArea ta;
	
	CalendarCRUD(CalendarView v){
		
		this.v = v;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		lblday = new JLabel("★"+v.year+"년"+v.month+"월"+v.day+"일 일정 생성 및 삭제★");
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
		add(btnInsert);
		add(btnDelete);
		
		
		setSize(500,600);
		setVisible(true);
		
		
	}
}
