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
		this.setTitle("커플 버스 - 인증");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		loverLabel = new JLabel("상대방 아이디를 입력해주세요");
		loverLabel.setBounds(150, 100, 200, 50);
		panel.add(loverLabel);

		loverInput = new JTextField();
		loverInput.setBounds(150, 150, 200, 50);
		panel.add(loverInput);

		certifyButton = new JButton("인증");
		certifyButton.setBounds(150, 250, 200, 50);
		panel.add(certifyButton);
		
		backButton = new JButton("뒤로");
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
