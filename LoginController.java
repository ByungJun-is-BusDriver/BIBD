import java.awt.event.*;

import javax.swing.JOptionPane;

public class LoginController {

	private LoginDAO loginDAO;
	private LoginView loginView;
	private MainController mainController;
	private StartController startController;
	private String user_id;
	private String user_pw;

	public LoginController() {
		loginDAO = new LoginDAO();
		loginView = new LoginView();
		loginView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Object obj = e.getSource();

				if (obj == loginView.loginButton) {
					user_id = loginView.idInput.getText();
					user_pw = new String(loginView.pwInput.getPassword());
					if (user_id.equals("") || user_pw.equals("")) {
						JOptionPane.showMessageDialog(loginView, "���̵�� �н����带 �Է����ּ���", "���� - ���Է�",
								JOptionPane.WARNING_MESSAGE);
					} else if (!loginDAO.selectUser(user_id, user_pw)) {
						JOptionPane.showMessageDialog(loginView, "��ġ�ϴ� ���̵�� ��й�ȣ�� �����ϴ�", "���� - ����ġ",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(loginView, "�α��ο� �����߽��ϴ�", "����", JOptionPane.INFORMATION_MESSAGE);
						mainController = new MainController(user_id, user_pw);
						loginView.dispose();
					}
				}

				else if (obj == loginView.backButton) {
					startController = new StartController();
					loginView.dispose();
				}
				
			}
		});
	}
	
}
