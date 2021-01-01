
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame {

	private JPanel panel;
	protected JButton calenderButton, dayButton, imgGalleryButton, chatButton, certifyButton, logoutButton;
	
	ChatStartController chatStart = new ChatStartController();
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
		chatButton.addActionListener(new ActionListener() {
			// 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new newWindow(); // 클래스 newWindow를 새로 만들어낸다
				
				try {
					chatStart.Start();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		certifyButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
	}

}
