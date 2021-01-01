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
						JOptionPane.showMessageDialog(certifyView, "�ڽŰ��� Ŀ���� �� �� �����ϴ�", "Ŀ��",
								JOptionPane.WARNING_MESSAGE);
					} else if (!certifyDAO.selectUser(lover_id)) {
						JOptionPane.showMessageDialog(certifyView, "���� ���̵� �������� �ʽ��ϴ�", "Ŀ��",
								JOptionPane.WARNING_MESSAGE);
					} else if (certifyDAO.selectCouple(lover_id)) {
						JOptionPane.showMessageDialog(certifyView, "������ �̹� Ŀ���Դϴ�", "Ŀ��", JOptionPane.WARNING_MESSAGE);
					}

					else {
						certifyDAO.updateUserLover(lover_id, user_id);

						if (certifyDAO.selectUserLover(lover_id, user_id)) {
							certifyDAO.insertCouple(user_id, lover_id);
							JOptionPane.showMessageDialog(certifyView, "Ŀ�������� �����߽��ϴ�", "Ŀ��",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(certifyView, "Ŀ�������� ��û�߽��ϴ�\n���浵 Ŀ�������� �ϸ� ������ �Ϸ�˴ϴ�", "���� ��û",
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
