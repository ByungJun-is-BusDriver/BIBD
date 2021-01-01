
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame {

	private JPanel panel;
	protected JButton calenderButton, dayButton, imgGalleryButton, chatButton, certifyButton, logoutButton;

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
		chatButton.addActionListener(listener);
		certifyButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
	}

}
