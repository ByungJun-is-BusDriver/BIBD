import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CertifyView extends JFrame {

	private JPanel panel;
	protected JTextField maleInput, femaleInput;
	private JLabel loverLabel;
	protected JTextField loverInput;
	protected JButton certifyButton, backButton;;

	public CertifyView() {
		this.setTitle("Ŀ�� ���� - ����");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		loverLabel = new JLabel("���� ���̵� �Է����ּ���");
		loverLabel.setBounds(150, 100, 200, 50);
		panel.add(loverLabel);

		loverInput = new JTextField();
		loverInput.setBounds(150, 150, 200, 50);
		panel.add(loverInput);

		certifyButton = new JButton("����");
		certifyButton.setBounds(150, 250, 200, 50);
		panel.add(certifyButton);
		
		backButton = new JButton("�ڷ�");
		backButton.setBounds(0, 0, 100, 25);
		panel.add(backButton);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addActionListener(ActionListener listener) {
		certifyButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}

}
