
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JoinView extends JFrame {

	private JPanel panel, sexPanel;
	private JLabel idLabel, pwLabel, nameLabel, birthLabel, birthExLabel, firstLabel, firstExLabel, sexLabel;
	protected JTextField idInput, nameInput, birthInput, firstInput;
	protected JPasswordField pwInput;
	protected JRadioButton male, female;
	protected JButton joinButton, backButton;

	public JoinView() {
		this.setTitle("Ŀ�� ���� - ȸ������");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);

		idLabel = new JLabel("���̵�");
		idLabel.setBounds(100, 50, 100, 25);
		panel.add(idLabel);

		idInput = new JTextField();
		idInput.setBounds(200, 50, 100, 25);
		panel.add(idInput);

		pwLabel = new JLabel("�н�����");
		pwLabel.setBounds(100, 100, 100, 25);
		panel.add(pwLabel);

		pwInput = new JPasswordField();
		pwInput.setBounds(200, 100, 100, 25);
		panel.add(pwInput);

		nameLabel = new JLabel("�̸�");
		nameLabel.setBounds(100, 150, 100, 25);
		panel.add(nameLabel);

		nameInput = new JTextField();
		nameInput.setBounds(200, 150, 100, 25);
		panel.add(nameInput);

		birthLabel = new JLabel("����");
		birthLabel.setBounds(100, 200, 100, 25);
		panel.add(birthLabel);

		birthInput = new JTextField();
		birthInput.setBounds(200, 200, 100, 25);
		panel.add(birthInput);

		birthExLabel = new JLabel("ex) 2001-01-01");
		birthExLabel.setBounds(300, 200, 100, 25);
		panel.add(birthExLabel);

		sexLabel = new JLabel("����");
		sexLabel.setBounds(100, 250, 100, 25);
		panel.add(sexLabel);

		sexPanel = new JPanel();
		male = new JRadioButton("��");
		female = new JRadioButton("��");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(male);
		buttonGroup.add(female);
		sexPanel.add(male);
		sexPanel.add(female);
		sexPanel.setBounds(200, 250, 100, 25);
		panel.add(sexPanel);

		firstLabel = new JLabel("ó�� ���� ��");
		firstLabel.setBounds(100, 300, 100, 25);
		panel.add(firstLabel);

		firstInput = new JTextField();
		firstInput.setBounds(200, 300, 100, 25);
		panel.add(firstInput);

		firstExLabel = new JLabel("ex) 2021-01-01");
		firstExLabel.setBounds(300, 300, 100, 25);
		panel.add(firstExLabel);

		joinButton = new JButton("ȸ������");
		joinButton.setBounds(150, 350, 200, 50);
		panel.add(joinButton);

		backButton = new JButton("�ڷ�");
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
