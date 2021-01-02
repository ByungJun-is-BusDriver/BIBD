package TCP;

import java.awt.*;
import javax.swing.*;

public class DdayView extends JFrame{

	
	JLabel lblNameField,lbl100,lbl1,lbl300,lblyear,lbl500,lbl2year;
	JLabel lblBackground;
	public Image background;
	public Image changeImg;
	DdayView() {
		this.setBackground(Color.WHITE);
		Image background = new ImageIcon(getClass().getResource("img/Ddaybackimg2.jpg")).getImage();
		Image changeImg = background.getScaledInstance(600,700,Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		//setBackground(changeIcon);
		//background = new ImageIcon(getClass().getResource("img/Ddaybackimg.jpg")).getImage();
		//changeImg = background.getScaledInstance(600,700,Image.SCALE_SMOOTH);
		lblBackground = new JLabel(changeIcon);
		lblBackground.setBounds(0,0 , 600, 700);
		
	

		
		Font f = new Font("휴먼편지체",Font.BOLD,30);
		setLayout(null);
		
		lblNameField = new JLabel("신랑 신부 아이디");
		lblNameField.setBounds(100,50,200,100);
		lblNameField.setFont(f);
		lblNameField.setBackground(Color.white);
		add(lblNameField);
		
		
		lbl1 = new JLabel("처음 만난 날");
		lbl1.setBounds(100,250,400,100);
		lbl1.setFont(f);
		add(lbl1);
		
		lbl100 = new JLabel("100일");
		lbl100.setBounds(100,300,300,100);
		lbl100.setFont(f);
		add(lbl100);
		
		lbl300 = new JLabel("300일");
		lbl300.setBounds(100,350,300,100);
		lbl300.setFont(f);
		add(lbl300);
		
		lblyear = new JLabel("1년");
		lblyear.setBounds(100,400,300,100);
		lblyear.setFont(f);
		add(lblyear);
		
		lbl500 = new JLabel("500일");
		lbl500.setBounds(100,450,300,100);
		lbl500.setFont(f);
		add(lbl500);
		
		lbl2year = new JLabel("2년");
		lbl2year.setBounds(100,500,300,100);
		lbl2year.setFont(f);
		add(lbl2year);
		
		
		
		add(lblBackground);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600,700);
    	setVisible(true); 
	}
	
	 //public static void main(String arg[]) {
		// new DdayView();
//}
	
	
}
