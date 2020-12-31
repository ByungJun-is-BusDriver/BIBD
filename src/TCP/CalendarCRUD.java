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
		lblday = new JLabel("��"+v.year+"��"+v.month+"��"+v.day+"�� ���� ���� �� ������");
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
		add(btnInsert);
		add(btnDelete);
		
		
		setSize(500,600);
		setVisible(true);
		
		
	}
}
