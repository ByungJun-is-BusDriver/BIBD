import java.awt.event.*;

import javax.swing.JOptionPane;

public class LoginController {

	private LoginDAO loginDAO;
	private LoginView loginView;
	private MainController mainController;
	private StartController startController;
	static String user_id;
	static String user_pw;

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
						JOptionPane.showMessageDialog(loginView, "아이디와 패스워드를 입력해주세요", "실패 - 미입력",
								JOptionPane.WARNING_MESSAGE);
					} else if (!loginDAO.selectUser(user_id, user_pw)) {
						JOptionPane.showMessageDialog(loginView, "일치하는 아이디와 비밀번호가 없습니다", "실패 - 불일치",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(loginView, "로그인에 성공했습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
						setId(user_id);
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
	public void setId(String user_id) {
		this.user_id = user_id;
	}
	
	public String getId() {
		return this.user_id;
	}
}
