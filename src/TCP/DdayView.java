package TCP;

import java.awt.*;
import javax.swing.*;

public class DdayView extends JFrame{

	
	JLabel lblNameField,lbl100,lbl1,lbl300,lblyear,lbl500,lbl2year;
	
	DdayView() {
		
		setLayout(null);
		lblNameField = new JLabel("�Ŷ� �ź� ���̵�");
		lblNameField.setBounds(30,50,100,50);
		add(lblNameField);
		
		lbl1 = new JLabel("ó�� ���� ��");
		lbl1.setBounds(100,250,100,50);
		add(lbl1);
		
		lbl100 = new JLabel("100��");
		lbl100.setBounds(100,300,500,50);
		add(lbl100);
		
		lbl300 = new JLabel("300��");
		lbl300.setBounds(100,350,100,50);
		add(lbl300);
		
		lblyear = new JLabel("1��");
		lblyear.setBounds(100,400,100,50);
		add(lblyear);
		
		lbl500 = new JLabel("500��");
		lbl500.setBounds(100,450,100,50);
		add(lbl500);
		
		lbl2year = new JLabel("2��");
		lbl2year.setBounds(100,500,100,50);
		add(lbl2year);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,700);
    	setVisible(true); 
	}
	
	 //public static void main(String arg[]) {
		// new DdayView();
//}
	
	
}
