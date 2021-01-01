import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CertifyView extends JFrame {

	private JPanel panel;
	private JLabel maleLabel, femaleLabel;
	protected JTextField maleInput, femaleInput;
	private JLabel loverLabel;
	protected JTextField loverInput;
	protected JButton certifyButton;

	public CertifyView() {
		this.setTitle("커플 버스 - 인증");
		this.setSize(500, 500);

		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);

//		maleLabel = new JLabel("남자친구");
//		maleLabel.setBounds(100, 50, 100, 50);
//		panel.add(maleLabel);
//
//		maleInput = new JTextField();
//		maleInput.setBounds(200, 50, 200, 50);
//		panel.add(maleInput);
//
//		femaleLabel = new JLabel("여자친구");
//		femaleLabel.setBounds(100, 150, 100, 50);
//		panel.add(femaleLabel);
//
//		femaleInput = new JTextField();
//		femaleInput.setBounds(200, 150, 200, 50);
//		panel.add(femaleInput);
		
		loverLabel = new JLabel("상대방 아이디를 입력해주세요");
		loverLabel.setBounds(150, 100, 200, 50);
		panel.add(loverLabel);

		loverInput = new JTextField();
		loverInput.setBounds(150, 150, 200, 50);
		panel.add(loverInput);

		certifyButton = new JButton("인증");
		certifyButton.setBounds(150, 250, 200, 50);
		panel.add(certifyButton);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addActionListener(ActionListener listener) {
		certifyButton.addActionListener(listener);
	}

}
