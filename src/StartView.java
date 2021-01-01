import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartView extends JFrame {

	private JPanel panel;
	protected JButton loginButton, joinButton;

	public StartView() {
		this.setTitle("Ŀ�� ���� - ����");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);

		loginButton = new JButton("�α���");
		loginButton.setBounds(150, 150, 200, 50);
		panel.add(loginButton);

		joinButton = new JButton("ȸ������");
		joinButton.setBounds(150, 250, 200, 50);
		panel.add(joinButton);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addActionListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		joinButton.addActionListener(listener);
	}

}
