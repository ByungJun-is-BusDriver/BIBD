package TCP;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class JoinController {

	private JoinDAO joinDAO;
	private JoinView joinView;
	private StartController startController;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_birth;
	private String user_sex;

	public JoinController() {
		joinDAO = new JoinDAO();
		joinView = new JoinView();
		joinView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Object obj = e.getSource();

				if (obj == joinView.joinButton) {
					user_id = joinView.idInput.getText();
					user_pw = new String(joinView.pwInput.getPassword());
					user_name = joinView.nameInput.getText();
					user_birth = joinView.birthInput.getText();
					if (joinView.male.isSelected()) {
						user_sex = "남";
					} else if (joinView.female.isSelected()) {
						user_sex = "여";
					}

					if (user_id.equals("") || user_pw.equals("") || user_name.equals("") || user_birth.equals("")
							|| user_sex == null) {
						JOptionPane.showMessageDialog(joinView, "입력하지 않은 항목이 있습니다", "실패 - 미입력",
								JOptionPane.WARNING_MESSAGE);
					} else if (joinDAO.selectUser(user_id)) {
						JOptionPane.showMessageDialog(joinView, "이미 존재하는 아이디입니다", "실패 - 중복",
								JOptionPane.WARNING_MESSAGE);
					} else if (!joinDAO.insertUser(user_id, user_pw, user_name, user_birth, user_sex)) {
						JOptionPane.showMessageDialog(joinView, "생일을 다시 입력해주세요", "실패 - 생일",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(joinView, "회원가입에 성공했습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
						startController = new StartController();
						joinView.dispose();
					}
				}

				else if (obj == joinView.backButton) {
					startController = new StartController();
					joinView.dispose();
				}
				
			}
		});
	}

}
