
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame {

	private JPanel panel;
	protected JButton calenderButton, dayButton, imgGalleryButton, chatButton, certifyButton, logoutButton;

	public MainView() {
		this.setTitle("커플 버스 - 메인");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		calenderButton = new JButton("캘린더");
		calenderButton.setBounds(150, 80, 200, 50);
		panel.add(calenderButton);
		
		dayButton = new JButton("D-Day");
		dayButton.setBounds(150, 160, 200, 50);
		panel.add(dayButton);
		
		imgGalleryButton = new JButton("앨범게시판");
		imgGalleryButton.setBounds(150, 240, 200, 50);
		panel.add(imgGalleryButton);
		
		chatButton = new JButton("채팅");
		chatButton.setBounds(150, 320, 200, 50);
		panel.add(chatButton);
		
		certifyButton = new JButton("커플인증");
		certifyButton.setBounds(400, 0, 100, 25);
		panel.add(certifyButton);
		
		logoutButton = new JButton("로그아웃");
		logoutButton.setBounds(0, 0, 100, 25);
		panel.add(logoutButton);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addActionListener(ActionListener listener) {
		calenderButton.addActionListener(listener);
		dayButton.addActionListener(listener);
		imgGalleryButton.addActionListener(listener);
		chatButton.addActionListener(listener);
		certifyButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
	}

}
