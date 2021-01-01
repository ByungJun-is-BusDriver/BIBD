package TCP;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class CertifyController {

	private CertifyView certifyView;
	private CertifyDAO certifyDAO;
	private String lover_id;

	public CertifyController(String user_id) {
		certifyDAO = new CertifyDAO();
		certifyView = new CertifyView();
		certifyView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Object obj = e.getSource();

				if (obj == certifyView.certifyButton) {
					lover_id = certifyView.loverInput.getText();

					if (lover_id.equals(user_id)) {
						JOptionPane.showMessageDialog(certifyView, "자신과는 커플이 될 수 없습니다", "커플",
								JOptionPane.WARNING_MESSAGE);
					} else if (!certifyDAO.selectUser(lover_id)) {
						JOptionPane.showMessageDialog(certifyView, "상대방 아이디가 존재하지 않습니다", "커플",
								JOptionPane.WARNING_MESSAGE);
					} else if (certifyDAO.selectCouple(lover_id)) {
						JOptionPane.showMessageDialog(certifyView, "상대방은 이미 커플입니다", "커플", JOptionPane.WARNING_MESSAGE);
					}

					else {
						certifyDAO.updateUserLover(lover_id, user_id);

						if (certifyDAO.selectUserLover(lover_id, user_id)) {
							certifyDAO.insertCouple(user_id, lover_id);
							JOptionPane.showMessageDialog(certifyView, "커플인증에 성공했습니다", "커플",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(certifyView, "커플인증을 신청했습니다\n상대방도 커플인증을 하면 인증이 완료됩니다", "인증 신청",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
					certifyView.dispose();
				}

				else if (obj == certifyView.backButton) {
					certifyView.dispose();
				}

			}
		});
	}

}
