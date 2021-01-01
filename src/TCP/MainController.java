package TCP;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class MainController {

	private MainDAO mainDAO;
	private MainView mainView;
	private LoginController loginController;
	private CertifyController certifyController;

	public MainController(String user_id, String user_pw) {
		mainDAO = new MainDAO();
		mainView = new MainView();
		mainView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Object obj = e.getSource();

				if (obj == mainView.calenderButton) {
					new CalendarController(new CalendarView());

				} else if (obj == mainView.dayButton) {
					 new DdayDAO(new DdayView());

				} else if (obj == mainView.imgGalleryButton) {

				} else if (obj == mainView.chatButton) {

				} else if (obj == mainView.certifyButton) {
					if (mainDAO.selectCouple(user_id)) {
						JOptionPane.showMessageDialog(mainView, "이미 인증했습니다", "커플인증", JOptionPane.INFORMATION_MESSAGE);
					} else {
						certifyController = new CertifyController(user_id);
					}
				} else if (obj == mainView.logoutButton) {
					loginController = new LoginController();
					mainView.dispose();
				}

			}
		});
	}

}
