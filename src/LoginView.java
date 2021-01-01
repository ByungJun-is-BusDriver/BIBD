import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame {

	private JPanel panel;
	private JLabel idLabel, pwLabel;
	protected JTextField idInput;
	protected JPasswordField pwInput;
	protected JButton loginButton, backButton;

	public LoginView() {
		this.setTitle("Ŀ�� ���� - �α���");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);

		idLabel = new JLabel("���̵�");
		idLabel.setBounds(100, 50, 100, 50);
		panel.add(idLabel);

		idInput = new JTextField();
		idInput.setBounds(200, 50, 200, 50);
		panel.add(idInput);

		pwLabel = new JLabel("�н�����");
		pwLabel.setBounds(100, 150, 100, 50);
		panel.add(pwLabel);

		pwInput = new JPasswordField();
		pwInput.setBounds(200, 150, 200, 50);
		panel.add(pwInput);

		loginButton = new JButton("�α���");
		loginButton.setBounds(150, 250, 200, 50);
		panel.add(loginButton);
		
		backButton = new JButton("�ڷ�");
		backButton.setBounds(0, 0, 100, 25);
		panel.add(backButton);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addActionListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}

}
