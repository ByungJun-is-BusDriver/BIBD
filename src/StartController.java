
import java.awt.event.*;

public class StartController {

	private StartView startView;
	private LoginController loginController;
	private JoinController joinController;

	public StartController() {
		startView = new StartView();
		startView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Object obj = e.getSource();

				if (obj == startView.loginButton) {
					loginController = new LoginController();
				}

				else if (obj == startView.joinButton) {
					joinController = new JoinController();
				}

				startView.dispose();

			}
		});
	}

	public static void main(String[] args) {
		StartController startController = new StartController();
	}
	
}
