package TCP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JoinView extends JFrame {

	private JPanel panel, sexPanel;
	private JLabel idLabel, pwLabel, nameLabel, birthLabel, birthExLabel, sexLabel;
	protected JTextField idInput, nameInput, birthInput;
	protected JPasswordField pwInput;
	protected JRadioButton male, female;
	protected JButton joinButton, backButton;

	public JoinView() {
		this.setTitle("커플 버스 - 회원가입");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);

		idLabel = new JLabel("아이디");
		idLabel.setBounds(100, 50, 100, 25);
		panel.add(idLabel);

		idInput = new JTextField();
		idInput.setBounds(200, 50, 100, 25);
		panel.add(idInput);

		pwLabel = new JLabel("패스워드");
		pwLabel.setBounds(100, 100, 100, 25);
		panel.add(pwLabel);

		pwInput = new JPasswordField();
		pwInput.setBounds(200, 100, 100, 25);
		panel.add(pwInput);

		nameLabel = new JLabel("이름");
		nameLabel.setBounds(100, 150, 100, 25);
		panel.add(nameLabel);

		nameInput = new JTextField();
		nameInput.setBounds(200, 150, 100, 25);
		panel.add(nameInput);

		birthLabel = new JLabel("생일");
		birthLabel.setBounds(100, 200, 100, 25);
		panel.add(birthLabel);

		birthInput = new JTextField();
		birthInput.setBounds(200, 200, 100, 25);
		panel.add(birthInput);
		
		birthExLabel = new JLabel("ex) 2021-01-01");
		birthExLabel.setBounds(300, 200, 100, 25);
		panel.add(birthExLabel);

		sexLabel = new JLabel("성별");
		sexLabel.setBounds(100, 250, 100, 25);
		panel.add(sexLabel);

		sexPanel = new JPanel();
		male = new JRadioButton("남");
		female = new JRadioButton("여");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(male);
		buttonGroup.add(female);
		sexPanel.add(male);
		sexPanel.add(female);
		sexPanel.setBounds(200, 250, 100, 25);
		panel.add(sexPanel);

		joinButton = new JButton("회원가입");
		joinButton.setBounds(150, 300, 200, 50);
		panel.add(joinButton);
		
		backButton = new JButton("뒤로");
		backButton.setBounds(0, 0, 100, 25);
		panel.add(backButton);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addActionListener(ActionListener listener) {
		joinButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}

}
