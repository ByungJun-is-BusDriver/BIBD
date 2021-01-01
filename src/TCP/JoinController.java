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
						user_sex = "��";
					} else if (joinView.female.isSelected()) {
						user_sex = "��";
					}

					if (user_id.equals("") || user_pw.equals("") || user_name.equals("") || user_birth.equals("")
							|| user_sex == null) {
						JOptionPane.showMessageDialog(joinView, "�Է����� ���� �׸��� �ֽ��ϴ�", "���� - ���Է�",
								JOptionPane.WARNING_MESSAGE);
					} else if (joinDAO.selectUser(user_id)) {
						JOptionPane.showMessageDialog(joinView, "�̹� �����ϴ� ���̵��Դϴ�", "���� - �ߺ�",
								JOptionPane.WARNING_MESSAGE);
					} else if (!joinDAO.insertUser(user_id, user_pw, user_name, user_birth, user_sex)) {
						JOptionPane.showMessageDialog(joinView, "������ �ٽ� �Է����ּ���", "���� - ����",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(joinView, "ȸ�����Կ� �����߽��ϴ�", "����", JOptionPane.INFORMATION_MESSAGE);
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
