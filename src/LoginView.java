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
		this.setTitle("커플 버스 - 로그인");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);

		idLabel = new JLabel("아이디");
		idLabel.setBounds(100, 50, 100, 50);
		panel.add(idLabel);

		idInput = new JTextField();
		idInput.setBounds(200, 50, 200, 50);
		panel.add(idInput);

		pwLabel = new JLabel("패스워드");
		pwLabel.setBounds(100, 150, 100, 50);
		panel.add(pwLabel);

		pwInput = new JPasswordField();
		pwInput.setBounds(200, 150, 200, 50);
		panel.add(pwInput);

		loginButton = new JButton("로그인");
		loginButton.setBounds(150, 250, 200, 50);
		panel.add(loginButton);
		
		backButton = new JButton("뒤로");
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
