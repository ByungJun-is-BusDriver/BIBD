
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
		this.setTitle("Ŀ�� ���� - ����");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		calenderButton = new JButton("Ķ����");
		calenderButton.setBounds(150, 80, 200, 50);
		panel.add(calenderButton);
		
		dayButton = new JButton("D-Day");
		dayButton.setBounds(150, 160, 200, 50);
		panel.add(dayButton);
		
		imgGalleryButton = new JButton("�ٹ��Խ���");
		imgGalleryButton.setBounds(150, 240, 200, 50);
		panel.add(imgGalleryButton);
		
		chatButton = new JButton("ä��");
		chatButton.setBounds(150, 320, 200, 50);
		panel.add(chatButton);
		
		certifyButton = new JButton("Ŀ������");
		certifyButton.setBounds(400, 0, 100, 25);
		panel.add(certifyButton);
		
		logoutButton = new JButton("�α׾ƿ�");
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
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new newWindow(); // Ŭ���� newWindow�� ���� ������
				
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
